package backEnd;
import javafx.geometry.Point2D;
import frontEnd.View;

public class Turtle extends AbstractTurtle {

    public Turtle (double canvasWidth, double canvasHeight) {
        super(canvasWidth, canvasHeight);
    }

    @Override
	public void bindProperties(View view) {
		myOrientation.bindBidirectional(view.myCanvas.turtleOrientation);
	}
    
    @Override
    public void moveTurtle (double distance) {
        Point2D currentPosition = getPosition();
        Point2D newPosition = currentPosition.add(0,distance);
        setPosition(newPosition);
    }

    @Override
    public void turnTurtle (double change) {
        setOrientation(getOrientation() + change); 
        //System.out.println("turtle turned by " + change);
    }
    
    

}
