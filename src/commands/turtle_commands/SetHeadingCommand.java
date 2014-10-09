package commands.turtle_commands;

import backEnd.AbstractTurtle;
import backEnd.Turtle;
import commands.TurtleCommand;


public class SetHeadingCommand extends TurtleCommand {

    private double myNewOrientation;

    public SetHeadingCommand () {
        super();
        setNumChildren(1);
    }

    @Override
    public Double execute () {
        AbstractTurtle myTurtle = getMyTurtle();
        double value = getMyChildren().get(0).execute() - myTurtle.getOrientation();
        System.out.println("set heading return value: " + value);
        setValue(value);
        executeTurtleCommand(getMyTurtle());
        return value;
    }

    @Override
    public void executeTurtleCommand (AbstractTurtle t) {
        // TODO Auto-generated method stub
        myNewOrientation = getMyChildren().get(0).execute();
        t.setOrientation(myNewOrientation);
    }

    @Override
    public String toString () {
        return "New Orientation: " + getMyChildren().get(0).execute();
    }

}
