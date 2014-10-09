package commands.variable_commands;

import java.util.ArrayList;
import backEnd.Model;
import commands.Command;


public class Variable extends Command {
    private String myValue;

    public Variable (String value) {
        myValue = value;
        setNumChildren(1);
    }

    @Override
    public double execute () {
        return getMyChildren().get(0).execute();
    }

    @Override
    public String toString () {
        return myValue;
    }

    @Override
    public void initializeCommand (Model m) {
    }

}
