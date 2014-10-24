package commands.templates;

import java.util.Map;

import backEnd.Model;
import backEnd.VariableManager;
import backEnd.turtle.AbstractTurtle;
import backEnd.turtle.Turtle;
import backEnd.turtle.TurtleManager;

/**
 * Turtle commands have an additional method, executeTurtleCommand.
 * Using a turtle which is added from the initialize method, 
 * the command is able to modify properties of the turtle. 
 * 
 * @author Ethan Chang
 * @author Anna Miyajima
 *
 */
public abstract class TurtleCommand extends Command {
    
    public TurtleCommand (VariableManager manager) {
        super(manager);
        // TODO Auto-generated constructor stub
    }

//    private AbstractTurtle myTurtle;
    private TurtleManager myTurtleManager;

    /**
     * Updates the turtle based on the result of the execution
     * of the command's children.
     * @param t
     */
    public abstract void executeTurtleCommand (AbstractTurtle t);

    /**
     * Retrive the turtle saved in the command
     * @return Turtle object
     */
    protected AbstractTurtle getMyTurtle () {
        return myTurtle;
    }

    /**
     * Sets the command's turtle
     * @param t turtle
     */
    protected void setTurtle (Turtle t) {
        myTurtle = t;
    }

    /**
     * Sets the command's turtle based on the model.
     */
    @Override
    public void initializeCommand (Model model) {
//        myTurtle = model.getTurtle();
    	myTurtleManager = model.getTurtleManager();
    }

}
