package backEnd;

import java.util.Observable;
import javafx.geometry.Point2D;


public abstract class AbstractTurtle extends Observable {

    private boolean isPenDown;
    private Point2D myPosition;
    private double myOrientation;
    public static final double INITIAL_ORIENTATION = 0;
    private Point2D myHome;
    private double myCanvasWidth;
    private double myCanvasHeight;

    public AbstractTurtle (double canvasWidth, double canvasHeight) {
        myPosition = new Point2D(canvasWidth / 2, canvasHeight / 2);
        myHome = myPosition;
        myOrientation = INITIAL_ORIENTATION;
        myCanvasWidth = canvasWidth;
        myCanvasHeight = canvasHeight;
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
    
    protected double getCanvasWidth() {
        return myCanvasWidth;
    }
    
    protected double getCanvasHeight() {
        return myCanvasHeight;
    }
}
