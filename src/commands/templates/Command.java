package commands.templates;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import backEnd.Model;
import backEnd.VariableManager;
import backEnd.turtle.TurtleManager;


/**
 * Superclass for commands. Each sets the number of children that it can hold. i.e. sum can take
 * two children, so its numchildren is set to 0. Commands can then be executed, which returns
 * a double.
 * 
 * @author Ethan Chang
 * @author Anna Miyajima
 */
public abstract class Command {

    private List<Command> myChildren;
    private int myNumChildren;
    private double myValue;
    protected VariableManager myVariableManager;

    /**
     * 
     * 
     */
    public Command (VariableManager manager) {
        myChildren = new ArrayList<>();
        System.out.println(this.getClass().getName() + " created");
        myVariableManager = manager;
    }

    /**
     * Executes the command by executing each of its children.
     * 
     * @return the double result of the command
     */
    public abstract double execute ();

    public abstract String toString ();

    /**
     * Returns the list of children for this command (its arguments)
     * 
     * @return
     */
    protected List<Command> getMyChildren () {
        return myChildren;
    }

    /**
     * Sets the number of children/arguments the command will take
     * 
     * @param numChildren number of arguments command will take
     */
    protected void setNumChildren (int numChildren) {
        myNumChildren = numChildren;
    }

    /**
     * Stores the value the command returns
     * 
     * @param value value command returns
     */
    protected void setValue (Double value) {
        myValue = value;
    }

    /**
     * Retrieve value returned by the command
     * 
     * @return value returned by command
     */
    protected double getValue () {
        return myValue;
    }

    /**
     * Add child to the command
     * 
     * @param c command to be added
     */
    public void addChild (Command c) {
        myChildren.add(c);
    }

    /**
     * Get the number of children that can still be added
     * 
     * @return children missing
     */
    public int getNumChildrenNeeded () {
        return myNumChildren - myChildren.size();
    }

    /**
     * Adds anything that the command might need from the model
     * i.e. turtles for turtle commands
     * 
     * @param m
     */
    public abstract void initializeCommand (TurtleManager turtleManager);

}
