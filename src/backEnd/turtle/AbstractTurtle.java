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


public abstract class AbstractTurtle extends Observable {

    private static final boolean INITIAL_PEN = true;
    private static final boolean INITIAL_CLEAR = false;
    private BooleanProperty isPenDown;
    private TurtlePoint myPosition;
    private DoubleProperty myOrientation;
    private double myCanvasWidth, myCanvasHeight;
    private BooleanProperty linesCleared;
    private String myId;

    public static final double INITIAL_ORIENTATION = 0;

    private Point2D myHome;

    private boolean isVisible;
    private Pen myPen;

    public AbstractTurtle (String id, double canvasWidth, double canvasHeight) {
        myPosition = new TurtlePoint(canvasWidth / 2, canvasHeight / 2);
        myHome = new Point2D(myPosition.getX(), myPosition.getY());
        myOrientation = new SimpleDoubleProperty(INITIAL_ORIENTATION);
        myCanvasWidth = canvasWidth;
        myCanvasHeight = canvasHeight;
        isVisible = true;
        isPenDown = new SimpleBooleanProperty(INITIAL_PEN);
        linesCleared = new SimpleBooleanProperty(INITIAL_CLEAR);
        myId = id;
        myPen = new Pen();
    }

    public abstract void moveTurtle (double distance);

    public abstract void turnTurtle (double change);

    public Double getMyX () {
        return myPosition.getX() - myCanvasWidth / 2;
    }

    public Double getMyY () {
        return -(myPosition.getY() - myCanvasHeight / 2);
    }

    public Double goHome () {
        double distance = myPosition.distance(myHome);
//        myPosition = new Point2D(myHome.getX(), myHome.getY());
        myPosition.set(myHome.getX(), myHome.getY());
//        setChanged();
//        notifyObservers(myPosition);
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

    public double goTo (double x, double y) {
//        Point2D newPosition = new Point2D(myHome.getX() + x, myHome.getY() + y);
        double distance = myPosition.distance(x, y);
//        myPosition = newPosition;
        myPosition.set(x, y);
//        setChanged();
//        notifyObservers(myPosition);
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
//        setChanged();
//        notifyObservers(myPosition);
    }

    public double getOrientation () {
        return myOrientation.get();
    }

    public void setOrientation (Double newOrientation) {
        myOrientation.set(newOrientation);
    }

    //necessary?
    protected boolean isInBounds (double x, double y) {
        // works on right bottom, not on left top
//        Point2D currentPosition = myPosition;
        System.out.println("current distance from top edge is " + (myPosition.getY() + y));
        return !(myPosition.getX() + x < 0 || myPosition.getX() + x > myCanvasWidth
                 || myPosition.getY() + y < 0 || myPosition.getY() + y > myCanvasHeight);
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
}
