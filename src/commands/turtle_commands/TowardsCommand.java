package commands.turtle_commands;

import java.util.Map;
import javafx.geometry.Point2D;
import backEnd.AbstractTurtle;
import commands.Command;
import commands.TurtleCommand;


public class TowardsCommand extends TurtleCommand {

    public static final int NUM_CHILDREN = 2;

    public TowardsCommand (Map<String, Double> variableMap) {
        super(variableMap);
        setNumChildren(NUM_CHILDREN);
    }

    @Override
    public double execute () {
        executeTurtleCommand(getMyTurtle());
        return getValue();
    }

    @Override
    public void executeTurtleCommand (AbstractTurtle t) {
        setValue(t.turnTowards(getMyChildren().get(0).execute(), getMyChildren().get(1).execute()));
    }

    @Override
    public String toString () {
        return "Turned: " + getValue();
    }

}
