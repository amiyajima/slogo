package backEnd.turtle;


/**
 * Turtle class for slogo. Extends abstractTurtle and implements
 * the move turtle and turn turtle commands.
 * 
 * @author Ethan Chang
 *
 */
public class Turtle extends AbstractTurtle {

    public Turtle (String id, double canvasWidth, double canvasHeight) {
        super(id, canvasWidth, canvasHeight);
    }


    @Override
    public void moveTurtle (double distance) {
        int penState = isPenDown() ? 1 : 0;
        double direction = distance<0 ? -1 : 1;
        for(int i = 0; i < Math.abs(distance); i++) {
            System.out.println(distance);

            movementHelper(direction, penState);
        }
        
        direction = distance - (int) distance;
        movementHelper(direction, penState);
        
    }
    
    private void movementHelper(double direction, int penState) {
        double deltaX = Math.sin(Math.toRadians(-getOrientation())) * direction;
        double deltaY = Math.cos(Math.toRadians(-getOrientation())) * direction;
        toroidalMovement(deltaX, deltaY);
        togglePen(penState);
    }

    @Override
    public void turnTurtle (double change) {
        setOrientation(getOrientation() + change);
    }

}
