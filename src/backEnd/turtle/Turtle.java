package backEnd.turtle;


import java.util.Observable;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.geometry.Point2D;

/**
 * Hold all information and behaviors for the turtle in SLogo. The turtle
 * is capable of turning and moving, as well as hiding. It hold a pen which
 * it can raise and lower, altering when lines are drawn. It always begins at the
 * origin and can return home.
 * @author Ethan Chang
 * @author Eli Lichtenberg
 *
 */
public class Turtle extends Observable {


    public static final boolean INITIAL_VISIBILITY = true;
	public static final double INITIAL_ORIENTATION = 0;
    public static final boolean INITIAL_PEN = true;
    public static final boolean INITIAL_CLEAR = false;
    public static final boolean INITIAL_ACTIVITY = true;
    public static final double INITIAL_STAMP_COUNT = 0;
    public static final int INITIAL_SHAPE_INDEX = 0;
    public static final int DEGREES_IN_A_CIRCLE = 360;
    private BooleanProperty myPenDown;
    private TurtlePoint myPosition;
    private DoubleProperty myOrientation;
    private double myCanvasWidth; 
    private double myCanvasHeight;
    private BooleanProperty myClearLines;
    private String myId;
    private DoubleProperty myShapeIndex;
    private DoubleProperty myStampCount;
    private BooleanProperty myActivity;

    private Point2D myHome;

    private BooleanProperty myVisibility;
    private Pen myPen;

    /**
     * Constructor, takes an id name, as well as the dimensions of the canvas
     * the turtle will appear on.
     * 
     * @param id the turtle's name
     * @param canvasWidth width of the canvas
     * @param canvasHeight height of the canvas
     */
    public Turtle (String id, double canvasWidth, double canvasHeight) {
        myPosition = new TurtlePoint(canvasWidth / 2, canvasHeight / 2);
        myHome = new Point2D(myPosition.getX(), myPosition.getY());
        myOrientation = new SimpleDoubleProperty(INITIAL_ORIENTATION);
        myCanvasWidth = canvasWidth;
        myCanvasHeight = canvasHeight;
        myVisibility = new SimpleBooleanProperty(INITIAL_VISIBILITY);
        myPenDown = new SimpleBooleanProperty(INITIAL_PEN);
        myClearLines = new SimpleBooleanProperty(INITIAL_CLEAR);
        myShapeIndex = new SimpleDoubleProperty(INITIAL_SHAPE_INDEX);
        myStampCount = new SimpleDoubleProperty(INITIAL_STAMP_COUNT);
        myActivity = new SimpleBooleanProperty(INITIAL_ACTIVITY);
        myId = id;
        myPen = new Pen();
    }

    /**
     * Moves the turtle unit by unit.
     * @param distance how far the turtle needs to move.
     */
    public void moveTurtle (double distance) {
        int penState = isPenDown() ? 1 : 0;
        double direction = distance < 0 ? -1 : 1;
        
        for (int i = 0; i < Math.abs(distance); i++) {
            movementHelper(direction, penState);
        }
        
        direction = distance - (int)distance;
        movementHelper(direction, penState);
        
    }
    
    /**
     * Calculates the change in x and y for each incremental move. 
     * @param direction whether going forward or backwards
     * @param penState whether the pen is up or down
     */
    private void movementHelper (double direction, int penState) {
        double deltaX = Math.sin(Math.toRadians(-getOrientation())) * direction;
        double deltaY = Math.cos(Math.toRadians(-getOrientation())) * direction;
        toroidalMovement(deltaX, deltaY);
        togglePen(penState);
    }

    /**
     * Rotates the turtle's orientation by chang
     * @param change factor the orientation changes
     */
    public void turnTurtle (double change) {
        setOrientation((getOrientation() + change) % DEGREES_IN_A_CIRCLE);
    }
    
    /**
     * Retrieves the turtle's X value
     * @return turtle's x-value
     */
    public Double getMyX () {
        return myPosition.getX() - myCanvasWidth / 2;
    }

    /**
     * Retrieves the turtle's Y value
     * @return turtle's y-value
     */
    public Double getMyY () {
        return -(myPosition.getY() - myCanvasHeight / 2);
    }

    /**
     * Returns the turtle home (0,0)
     * @return distance travelled to go ome
     */
    public Double goHome () {
        double distance = myPosition.distance(myHome);
        myPosition.set(myHome.getX(), myHome.getY());
        return distance;
    }

    /**
     * Clears the lines the turtle has drawn
     */
    public void clearMyLines () {
    	myClearLines.set(true);
    	myClearLines.set(false);
    }


    /**
     * Sets a stamp of the turtle on the canvas
     */
    public void setStamp () {
        myStampCount.set(myStampCount.getValue() + 1);
    }
    
    /**
     * Remomves all stamps the turtle has drawn.
     */
    public void clearStamp () {
        myStampCount.set(INITIAL_STAMP_COUNT);
    }
    
    /**
     * Goes to a specific location on the canvas
     * @param x x-coordinate of the location
     * @param y y-coordinate of the location
     * @return
     */
    public double goTo (double x, double y) {
        double distance = myPosition.distance(x, y);
        myPosition.set(x, y);

        return distance;
    }

    /**
     * Toggles if the pen is up or down. If the pen
     * is down the turtle can draw. If it isn't, it cannot.
     * @param d
     */
    public void togglePen (double d) {
        if (d == 1) {
            myPenDown.set(true);
        }
        else {
            myPenDown.set(false);
        }
    }

    /**
     * Changes if the turtle is visible on the  canvas
     * @param d whether turtle should be visible
     */
    public void toggleVisibility (double d) {
        if (d == 1) {
            myVisibility.set(true);
        }
        else {
            myVisibility.set(false);
        }
    }

    /**
     * return the turtle's current position
     * @return
     */
    public TurtlePoint getPosition () {
        return myPosition;
    }

    /**
     * Sets the position for the turtle
     * @param newPosition new position on canvs
     */
    public void setPosition (Point2D newPosition) {
        myPosition.set(newPosition);
    }

    /**
     * Get turtle's orientation
     * @return the turtle's orientation
     */
    public double getOrientation () {
        return myOrientation.get();
    }

    /**
     * Set the turtle's orientation
     * @param newOrientation new orientation
     */
    public void setOrientation (Double newOrientation) {
        myOrientation.set(newOrientation);
    }

    
    /**
     * Deals with edge cases when moving your turtle. If you go over the top
     * you'll continue from the bottom and if you go pass the left bounds, you'll
     * come out from the right
     * @param deltaX Change in the turtle's x value
     * @param deltaY Change in the turtle's y value
     */
    protected void toroidalMovement (double deltaX, double deltaY) {
        double newX = myPosition.getX() + deltaX;
        double newY = myPosition.getY() + deltaY;
         
        if (myPosition.getX() < 0) {
            togglePen(0);
            newX = myCanvasWidth;
        }
        else if (myPosition.getX() > myCanvasWidth) {
            togglePen(0);
            newX = 0;
        }
        
        if (myPosition.getY() < 0) {
            togglePen(0);
            newY = myCanvasHeight;
        }
        else if (myPosition.getY() > myCanvasHeight) {
            togglePen(0);
            newY = 0;
        }
        setPosition(new Point2D(newX, newY));
    }

    /**
     * turn towards a specific point on the canvas
     * @param x x-coordinate of point
     * @param y y-coordinate of point
     * @return degrees turned to face the point
     */
    public double turnTowards (double x, double y) {

        double angle1 =
                Math.toDegrees(Math.atan2(myPosition.getY() - myHome.getY(), myPosition.getX() -
                                                                             myHome.getX()));
        double angle2 =
                Math.toDegrees(Math.atan2((y + myHome.getY()) - myHome.getY(),
                                          (x + myHome.getX()) - myHome.getX()));

        double angle = angle2 - angle1;
        setOrientation(angle2);
        return angle;
    }

    /**
     * Checks if the pen is currently down
     * @return pen's current state
     */
    public boolean isPenDown () {
        return myPenDown.get();
    }

    /**
     * Check if the turtle is visible
     * @return the turtle's visibility
     */
    public boolean isVisible () {
        return myVisibility.get();
    }
    
    /**
     * Packages the properties needed in the front end to track the turtle
     * @return TurtleProperties containing the necessary properties
     */
    public TurtleProperties getTurtleProperties () {
    	TurtleProperties tProps = new 
    	        TurtleProperties(myPosition, myOrientation, myPenDown, 
    	        		myClearLines, myVisibility, myStampCount, myPen, 
    	        		myShapeIndex);
    	return tProps;
    }
    
    /**
     * Get the turtle's name
     * @return turtle's name
     */
    public String getId () {
        return myId;
    }
    
    /**
     * Get the turtle's pen
     * @return
     */
    public Pen getPen () {
        return myPen;
    }
    
    /**
     * Set the index of the shape the turtle will be using
     * @param index index to be used
     */
    public void setShapeIndex (double index) {
        myShapeIndex.set(index);
    }
    
    /**
     * Return the index the turtle is using as an image
     * @return index used
     */
    public DoubleProperty getShapeIndex () {
        return myShapeIndex;
    }
    
    public void setIsActive(boolean alive) {
        myActivity.set(alive);
    }
    
    public BooleanProperty getIsActive() {
        return myActivity;
    }
}
