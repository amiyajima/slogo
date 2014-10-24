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

//    public static final String PEN_STRING = "pen";
//    public static final String ORIENTATION_STRING = "orientation";
//    public static final String CLEAR_STRING = "clear lines";
//    public static final String X_STRING = "xPosition";
//    public static final String Y_STRING = "yPosition";
    private static final boolean INITIAL_PEN = true;
    private static final boolean INITIAL_CLEAR = false;
    private BooleanProperty isPenDown;
    private Point2D myPosition;
//    private DoubleProperty myXPosition;
//    private DoubleProperty myYPosition;
    private DoubleProperty myOrientation;
    private double myCanvasWidth, myCanvasHeight;
    private BooleanProperty linesCleared;
    private String myId;

    public static final double INITIAL_ORIENTATION = 0;

    private Point2D myHome;

    private boolean isVisible;

    public AbstractTurtle (String id, double canvasWidth, double canvasHeight) {
        myPosition = new Point2D(canvasWidth / 2, canvasHeight / 2);
        myHome = new Point2D(myPosition.getX(), myPosition.getY());
//        myXPosition = new SimpleDoubleProperty(myPosition.getX());
//        myYPosition = new SimpleDoubleProperty(myPosition.getY());
        myOrientation = new SimpleDoubleProperty(INITIAL_ORIENTATION);
        myCanvasWidth = canvasWidth;
        myCanvasHeight = canvasHeight;
        isVisible = true;
        isPenDown = new SimpleBooleanProperty(INITIAL_PEN);
        linesCleared = new SimpleBooleanProperty(INITIAL_CLEAR);
        myId = id;
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
        myPosition = new Point2D(myHome.getX(), myHome.getY());
        setChanged();
        notifyObservers(myPosition);
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
        Point2D newPosition = new Point2D(myHome.getX() + x, myHome.getY() + y);
        double distance = myPosition.distance(newPosition);
        myPosition = newPosition;
        setChanged();
        notifyObservers(myPosition);
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

    public Point2D getPosition () {
        return myPosition;
    }

    public void setPosition (Point2D newPosition) {
        myPosition = newPosition;
        setChanged();
        notifyObservers(myPosition);
    }

    public double getOrientation () {
        return myOrientation.get();
    }

    public void setOrientation (Double newOrientation) {
        myOrientation.set(newOrientation);
    }

    protected boolean isInBounds (double x, double y) {
        // works on right bottom, not on left top
        Point2D currentPosition = myPosition;
        System.out.println("current distance from top edge is " + (currentPosition.getY() - y));
        return !(currentPosition.getX() - x < 0 || currentPosition.getX() + x > myCanvasWidth
                 || currentPosition.getY() - y < 0 || currentPosition.getY() + y > myCanvasHeight);
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
        System.out.println(angle);
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
}
