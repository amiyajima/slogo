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
        Double newX = Math.sin(Math.toRadians(getOrientation())) * distance;
        Double newY = Math.cos(Math.toRadians(getOrientation())) * distance;
        if(isInBounds(newX, newY)) {
            Point2D newPosition = new Point2D(currentPosition.getX() +newX, currentPosition.getY() +newY);
            setPosition(newPosition);
        }
    }

    @Override
    public void turnTurtle (double change) {
        setOrientation(getOrientation() + change); 
        //System.out.println("turtle turned by " + change);
    }

    

}
