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
    private boolean isVisible;

    public AbstractTurtle (double canvasWidth, double canvasHeight) {
        myPosition = new Point2D(canvasWidth / 2, canvasHeight / 2);
        myHome = new Point2D(myPosition.getX(), myPosition.getY());
        myOrientation = INITIAL_ORIENTATION;
        myCanvasWidth = canvasWidth;
        myCanvasHeight = canvasHeight;
        isVisible = true;
        isPenDown = true;
    }

    public abstract void moveTurtle (double distance);

    public abstract void turnTurtle (double change);
    
    public Double goHome() {
        double distance = myPosition.distance(myHome);
        myPosition = new Point2D(myHome.getX(), myHome.getY());
        setChanged();
        notifyObservers(myPosition);
        return distance;
    }
    
    public double goTo(double x, double y) {
        Point2D newPosition = new Point2D(myHome.getX() + x, myHome.getY() + y);
        double distance = myPosition.distance(newPosition);
        myPosition = newPosition;
        setChanged();
        notifyObservers(myPosition);
        return distance;
    }
//    
//    public double turnTowards(double x, double y) {
//        double deltaX = myPosition.getX() -  
//    }
    
    public void togglePen (double d) {
        if(d==1) {
            isPenDown = true;
        }
        else {
            isPenDown = false;
        }
        setChanged();
        notifyObservers(isPenDown);
    }
    
    public void toggleVisibility(double d) {
        if(d ==1 ) {
            isVisible = true;
        }
        else {
            isVisible = false;
        }
        setChanged();
        notifyObservers(isVisible);
    }

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
