package commands.variable_commands;

import java.util.Map;
import backEnd.Model;
import commands.Command;


public class UserCommand extends Command {

    public UserCommand (Map<String, Double> variableMap) {
        super(variableMap);
    }

    @Override
    public double execute () {
        return 0;
    }

    @Override
    public String toString () {
        return null;
    }

    @Override
    public void initializeCommand (Model m) {

    }

}
