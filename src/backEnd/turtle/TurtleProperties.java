package backEnd.turtle;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.DoubleProperty;

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
	private BooleanProperty myPenState;
	private BooleanProperty myLinesCleared;
	
	public TurtleProperties (TurtlePoint position, DoubleProperty orientation, 
	        BooleanProperty isPenDown, BooleanProperty linesCleared) {
		myPosition = position;
		myOrientation = orientation;
		myPenState = isPenDown;
		myLinesCleared = linesCleared;
	}
	
	public DoubleProperty getXPosition () {
		return myPosition.getBindableX();
	}
	
	public DoubleProperty getYPosition () {
		return myPosition.getBindableY();
	}
	
	public DoubleProperty getOrientation () {
		return myOrientation;
	}
	
	public BooleanProperty getIsPenDown () {
		return myPenState;
	}
	
	public BooleanProperty getLinesCleared () {
		return myLinesCleared;
	}
}
