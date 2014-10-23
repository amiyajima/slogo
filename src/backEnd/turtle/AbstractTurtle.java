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

    public static final String PEN_STRING = "pen";
    public static final String ORIENTATION_STRING = "orientation";
    private static final boolean INITIAL_PEN = true;
    private BooleanProperty isPenDown;
    private Point2D myPosition;
    private DoubleProperty myOrientation;
    private double myCanvasWidth, myCanvasHeight;

    public static final double INITIAL_ORIENTATION = 0;

    private Point2D myHome;

    private boolean isVisible;

    public AbstractTurtle (double canvasWidth, double canvasHeight) {
        myPosition = new Point2D(canvasWidth / 2, canvasHeight / 2);
        myHome = new Point2D(myPosition.getX(), myPosition.getY());
        myOrientation = new SimpleDoubleProperty(INITIAL_ORIENTATION);
        myCanvasWidth = canvasWidth;
        myCanvasHeight = canvasHeight;
        isVisible = true;
        isPenDown = new SimpleBooleanProperty(INITIAL_PEN);
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

    // TODO implement this method
    public void clearMyLines () {

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

    public Map<String, Property> getTurtleProperties () {
        Map<String, Property> tProps = new HashMap<String, Property>();
        tProps.put(ORIENTATION_STRING, myOrientation);
        tProps.put(PEN_STRING, isPenDown);
        return tProps;
    }
}
