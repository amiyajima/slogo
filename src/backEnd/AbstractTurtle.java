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
    private double canvasWidth, canvasHeight;
    
    public static final double INITIAL_ORIENTATION = 0;
    
    
	public AbstractTurtle(double canvasWidth, double canvasHeight) {
		
		this.canvasWidth = canvasWidth;
		this.canvasHeight = canvasHeight;
		
	    myPosition = new Point2D(canvasWidth/2,canvasHeight/2);
	    myOrientation = new SimpleDoubleProperty(INITIAL_ORIENTATION);
	}
	
	public abstract void bindProperties(View view);
	
    public abstract void moveTurtle (double distance);

    public abstract void turnTurtle (double change);

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
    
    protected double getCanvasWidth() {
        return canvasWidth;
    }
    
    protected double getCanvasHeight() {
        return canvasHeight;
    }
}
