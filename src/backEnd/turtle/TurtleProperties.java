package backEnd.turtle;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.DoubleProperty;
import javafx.geometry.Point2D;

/**
 * Data object used to hold properties about Turtle that later are bound to 
 * TurtleView. Has no behavior on its own. Was created to replace need for 
 * map to pass properties from model to view. User-created data structure 
 * to replace already made data structure (i.e., map)
 * 
 * @author Eli Lichtenberg
 *
 */
public class TurtleProperties {
	
	private TurtlePoint myPosition;
	private DoubleProperty myOrientation;
	private BooleanProperty isPenDown;
	private BooleanProperty linesCleared;
	
	public TurtleProperties(TurtlePoint myPosition, DoubleProperty myOrientation, BooleanProperty isPenDown, BooleanProperty linesCleared) {
		this.myPosition = myPosition;
		this.myOrientation = myOrientation;
		this.isPenDown = isPenDown;
		this.linesCleared = linesCleared;
	}
	
	public DoubleProperty getXPosition() {
		return myPosition.getBindableX();
	}
	
	public DoubleProperty getYPosition() {
		return myPosition.getBindableY();
	}
	
	public DoubleProperty getOrientation() {
		return myOrientation;
	}
	
	public BooleanProperty getIsPenDown() {
		return isPenDown;
	}
	
	public BooleanProperty getLinesCleared() {
		return linesCleared;
	}
}
