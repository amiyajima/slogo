package backEnd.turtle;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.geometry.Point2D;
import frontEnd.View;


public class Turtle extends Observable {

    public static final double INITIAL_ORIENTATION = 0;
    public static final boolean INITIAL_PEN = true;
    public static final boolean INITIAL_CLEAR = false;
    public static final int INITIAL_IMAGE_INDEX = 1;
    private BooleanProperty isPenDown;
    private TurtlePoint myPosition;
    private DoubleProperty myOrientation;
    private double myCanvasWidth, myCanvasHeight;
    private BooleanProperty linesCleared;
    private String myId;
    private DoubleProperty myImageIndex;

    private Point2D myHome;

    private boolean isVisible;
    private Pen myPen;

    public Turtle (String id, double canvasWidth, double canvasHeight) {
        myPosition = new TurtlePoint(canvasWidth / 2, canvasHeight / 2);
        myHome = new Point2D(myPosition.getX(), myPosition.getY());
        myOrientation = new SimpleDoubleProperty(INITIAL_ORIENTATION);
        myCanvasWidth = canvasWidth;
        myCanvasHeight = canvasHeight;
        isVisible = true;
        isPenDown = new SimpleBooleanProperty(INITIAL_PEN);
        linesCleared = new SimpleBooleanProperty(INITIAL_CLEAR);
        myImageIndex = new SimpleDoubleProperty(INITIAL_IMAGE_INDEX);
        myId = id;
        myPen = new Pen();
    }

    public void moveTurtle (double distance) {
        int penState = isPenDown() ? 1 : 0;
        double direction = distance<0 ? -1 : 1;
        for(int i = 0; i < Math.abs(distance); i++) {
            System.out.println(distance);

            movementHelper(direction, penState);
        }
        
        direction = distance - (int) distance;
        movementHelper(direction, penState);
        
    }
    
    private void movementHelper(double direction, int penState) {
        double deltaX = Math.sin(Math.toRadians(-getOrientation())) * direction;
        double deltaY = Math.cos(Math.toRadians(-getOrientation())) * direction;
        toroidalMovement(deltaX, deltaY);
        togglePen(penState);
    }

    public void turnTurtle (double change) {
        setOrientation(getOrientation() + change);
    }

    public Double getMyX () {
        return myPosition.getX() - myCanvasWidth / 2;
    }

    public Double getMyY () {
        return -(myPosition.getY() - myCanvasHeight / 2);
    }

    public Double goHome () {
        double distance = myPosition.distance(myHome);
        myPosition.set(myHome.getX(), myHome.getY());
        return distance;
    }

    // TODO improve design?
    // sets true to clear lines, sets back to false after lines cleared
    // linesCleared is binded to BooleanProperty in front-end that causes
    // lines stored on front-end to clear
    public void clearMyLines () {
    	linesCleared.set(true);
    	linesCleared.set(false);
    }

    // TODO IMPLEMENT THESE
    public void setStamp() {
        
    }
    
    public void clearStamp() {
        
    }
    
    public double goTo (double x, double y) {
        double distance = myPosition.distance(x, y);
        myPosition.set(x, y);

        return distance;
    }

    public void togglePen (double d) {
        if (d == 1) {
            isPenDown.set(true);
        }
        else {
            isPenDown.set(false);
        }
    }

    public void toggleVisibility (double d) {
        if (d == 1) {
            isVisible = true;
        }
        else {
            isVisible = false;
        }
        setChanged();
        notifyObservers(isVisible);
    }

    public TurtlePoint getPosition () {
        return myPosition;
    }

    public void setPosition (Point2D newPosition) {
        myPosition.set(newPosition);
    }

    public double getOrientation () {
        return myOrientation.get();
    }

    public void setOrientation (Double newOrientation) {
        myOrientation.set(newOrientation);
    }

    
    protected void toroidalMovement (double deltaX, double deltaY ) {
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
        
        if (myPosition.getY()<0) {
            togglePen(0);
            newY = myCanvasHeight;
        }
        else if(myPosition.getY() > myCanvasHeight) {
            togglePen(0);
            newY = 0;
        }
        setPosition(new Point2D(newX, newY));
    }

    public double turnTowards (double x, double y) {

        double angle1 =
                Math.toDegrees(Math.atan2(myPosition.getY() - myHome.getY(), myPosition.getX() -
                                                                             myHome.getX()));
        double angle2 =
                Math.toDegrees(Math.atan2(((y + myHome.getY()) - myHome.getY()),
                                          (x + myHome.getX()) - myHome.getX()));

        double angle = angle2 - angle1;
        setOrientation(angle2);
        return angle;
    }

    public boolean isPenDown () {
        return isPenDown.get();
    }

    public boolean isVisible () {
        return isVisible;
    }
    
    public TurtleProperties getTurtleProperties() {
    	TurtleProperties tProps = new TurtleProperties(myPosition, myOrientation, isPenDown, linesCleared);
    	return tProps;
    }
    
    public String getId() {
        return myId;
    }
    
    public Pen getPen() {
        return myPen;
    }
    
    public void setImageIndex(double index) {
        myImageIndex.set(index);
    }
    
    public DoubleProperty getImageIndex() {
        return myImageIndex;
    }
}
