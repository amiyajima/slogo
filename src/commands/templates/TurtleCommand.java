package commands.templates;

import backEnd.Model;
import backEnd.VariableManager;
import backEnd.turtle.TurtleManager;

/**
 * Turtle commands have an additional method, executeTurtleCommand. Using a
 * turtle which is added from the initialize method, the command is able to
 * modify properties of the turtle.
 *
 * @author Ethan Chang
 * @author Anna Miyajima
 *
 */
public abstract class TurtleCommand extends Command {
    
    private Model myModel;

    public TurtleCommand (VariableManager manager) {
        super(manager);
    }

    /**
     * Updates the turtle based on the result of the execution of the command's
     * children.
     * 
     * @param t
     */
    public abstract void executeTurtleCommand (TurtleManager turtleManager);

    /**
     * Retrive the turtle saved in the command
     * 
     * @return Turtle object
     */
    protected TurtleManager getMyTurtleManager () {
        return myModel.getTurtleManager();
    }


    /**
     * Sets the command's turtle based on the model.
     */
    @Override
    public void initializeCommand (Model model) {
        myModel = model;
    }

}
