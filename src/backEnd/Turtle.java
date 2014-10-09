package backEnd;
import javafx.geometry.Point2D;

public class Turtle extends AbstractTurtle {

    public Turtle (double x, double y) {
        super(x, y);
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
    }
    
    

}
