package backEnd;

import java.util.Observable;
import java.util.Queue;
import javafx.geometry.Point2D;
import commands.*;


public class Turtle extends Observable {
    
    private boolean isPenDown;
    private Point2D myPosition;
    
    
	public Turtle(double x, double y) {
	    myPosition = new Point2D(x,y);
	}
}
