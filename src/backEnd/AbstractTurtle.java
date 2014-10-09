package backEnd;

import java.util.Observable;
import javafx.geometry.Point2D;


public abstract class AbstractTurtle extends Observable {

    private boolean isPenDown;
    private Point2D myPosition;
    private double myOrientation;
    public static final double INITIAL_ORIENTATION = 90;

    public AbstractTurtle (double x, double y) {
        myPosition = new Point2D(x, y);
        myOrientation = INITIAL_ORIENTATION;
    }

    public abstract void moveTurtle (double distance);

    public abstract void turnTurtle (double change);

    protected Point2D getPosition () {
        return myPosition;
    }

    protected void setPosition (Point2D newPosition) {
        myPosition = newPosition;
        setChanged();
        notifyObservers(myPosition);
    }

    public void setOrientation (Double newOrientation) {
        myOrientation = newOrientation;
        setChanged();
        notifyObservers(myOrientation);
    }

    public double getOrientation () {
        return myOrientation;
    }

}
