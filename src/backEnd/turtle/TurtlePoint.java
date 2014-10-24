package backEnd.turtle;

import java.lang.reflect.Method;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.geometry.Point2D;

/**
 * Similar to Point2D, but also holds DoubleProperties to enable binding 
 * between front-end and back-end. Unlike Point2D, can set new x and y 
 * of TurtlePoint without needing to construct TurtlePoint
 * 
 * @author Eli Lichtenberg
 *
 */
public class TurtlePoint {
	
	private Point2D myPosition;
	private DoubleProperty myXPosition;
	private DoubleProperty myYPosition;
	
	public TurtlePoint(double x, double y) {
		myPosition = new Point2D(x, y);
		myXPosition = new SimpleDoubleProperty(x);
		myYPosition = new SimpleDoubleProperty(y);
		
		//hoped to create methods from Point2D using
//		Method[] pointMethods = Point2D.class.getMethods();
	}
	
	public double getX() {
		return myXPosition.get();
	}

	public double getY() {
		return myYPosition.get();
	}
	
	public DoubleProperty getBindableX() {
		return myXPosition;
	}
	
	public DoubleProperty getBindableY() {
		return myYPosition;
	}
	
	
	public void setX(double x) {
		myPosition = new Point2D(x, myPosition.getY());
		myXPosition.set(x);
	}
	
	public void setY(double y) {
		myPosition = new Point2D(myPosition.getX(), y);
		myYPosition.set(y);
	}
	
	public void set(double x, double y) {
		myPosition = new Point2D(x, y);
		myXPosition.set(x);
		myYPosition.set(y);
	}
	
	public void set(Point2D p) {
		myPosition = p;
		myXPosition.set(p.getX());
		myYPosition.set(p.getY());
	}
	
	public void set(TurtlePoint tp) {
		myPosition = new Point2D(tp.getX(), tp.getY());
		myXPosition.set(tp.getX());
		myYPosition.set(tp.getY());
	}
	
	
	public double distance(double x1, double y1) {
		return myPosition.distance(x1, y1);
	}
	
	public double distance(Point2D p) {
		return myPosition.distance(p);
	}
	
	//could change to just distance, but more readable this way
	public double distance(TurtlePoint tp) {
		return myPosition.distance(tp.getX(), tp.getY());
	}
	
	
	
}
