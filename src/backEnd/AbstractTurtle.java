package backEnd;

import java.util.Observable;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.geometry.Point2D;
import frontEnd.View;

public abstract class AbstractTurtle extends Observable {

    private boolean isPenDown;
    private Point2D myPosition;
    protected DoubleProperty myOrientation;
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
        isPenDown = true;
    }

    public abstract void bindProperties(View view);

    public abstract void moveTurtle (double distance);

    public abstract void turnTurtle (double change);

    public Double getX() {
        return myPosition.getX() - myCanvasWidth /2;
    }
    
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

    public Point2D getPosition () {
        return myPosition;
    }

    public void setPosition (Point2D newPosition) {
        myPosition = newPosition;
        setChanged();
        notifyObservers(myPosition);
    }

    //TODO May not need this
    public double getOrientation() {
        return myOrientation.get();
    }

    public void setOrientation(Double newOrientation) {
        myOrientation.set(newOrientation);
        setChanged();
        notifyObservers(myOrientation);
    }

    protected boolean isInBounds(double x, double y) {
        Point2D currentPosition = myPosition;
        return !(currentPosition.getX() -x<0 || currentPosition.getX() +x > myCanvasWidth
                || currentPosition.getY() -y <0 || currentPosition.getY() + y > myCanvasHeight);
    }

    public double turnTowards(double x, double y) {
        
        double angle1 = Math.toDegrees(Math.atan2(myPosition.getY() - myHome.getY(), myPosition.getX() - myHome.getX()));
        double angle2 = Math.toDegrees(Math.atan2(((y + myHome.getY()) - myHome.getY()), (x + myHome.getX()) - myHome.getX()));
        
        double angle =  angle2 - angle1; 
        setOrientation(angle2);
        System.out.println(angle);
        return angle;
    }
}
