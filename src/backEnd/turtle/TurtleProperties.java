package backEnd.turtle;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.DoubleProperty;

/**
 * Passive data object used to hold properties about Turtle that later are bound 
 * to TurtleView. Has no behavior on its own. Was created to replace need for 
 * list or map to pass properties from model to view. User-created data 
 * structure to replace already made data structure (e.g., list, map)
 * 
 * @author Eli Lichtenberg
 *
 */
public class TurtleProperties {
	
	private TurtlePoint myPosition;
	private DoubleProperty myOrientation;
	private BooleanProperty myPenState;
	private BooleanProperty myLinesCleared;
	private BooleanProperty myVisibility;
	private DoubleProperty myStampCount;
	private DoubleProperty myPenColorIndex;
	private DoubleProperty myPenSize;
	private DoubleProperty myShapeIndex;
	private BooleanProperty myActivity;
	
	public TurtleProperties (TurtlePoint position, DoubleProperty orientation, 
	        BooleanProperty isPenDown, BooleanProperty linesCleared, 
	        BooleanProperty isVisible, DoubleProperty stampCount, Pen pen, 
	        DoubleProperty shapeIndex, BooleanProperty activity) {
		myPosition = position;
		myOrientation = orientation;
		myPenState = isPenDown;
		myLinesCleared = linesCleared;
		myVisibility = isVisible;
		myStampCount = stampCount;
		myPenColorIndex = pen.getMyPenColorProperty();
		myPenSize = pen.getMyPenSize();
		myShapeIndex = shapeIndex;
		myActivity = activity;
	}
	
	public DoubleProperty getXPosition () {
		return myPosition.getBindableX();
	}
	
	public DoubleProperty getYPosition () {
		return myPosition.getBindableY();
	}
	
//	public void setPosition (TurtlePoint position) {
//		myPosition = position;
//	}
	
	public DoubleProperty getOrientation () {
		return myOrientation;
	}
	
//	public void setOrientation (DoubleProperty orientation) {
//		myOrientation = orientation;
//	}
	
	public BooleanProperty getIsPenDown () {
		return myPenState;
	}
	
	public BooleanProperty getLinesCleared () {
		return myLinesCleared;
	}
	
	public BooleanProperty getVisibility () {
		return myVisibility;
	}
	
	public DoubleProperty getStampCount () {
		return myStampCount;
	}
	
	public DoubleProperty getPenColorIndex () {
		return myPenColorIndex;
	}
	
	public DoubleProperty getPenSize () {
		return myPenSize;
	}
	
	public DoubleProperty getShapeIndex () {
		return myShapeIndex;
	}
	
	public BooleanProperty getActivity () {
		return myActivity;
	}
}
