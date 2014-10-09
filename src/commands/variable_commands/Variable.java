package commands.variable_commands;

import backEnd.Model;
import commands.Command;


public class Variable extends Command {
    private String myValue;

    public Variable (String value) {
       myValue = value;
    }

    @Override
    public Double execute () {
        return 0.0;
    }

    @Override
    public String toString () {
        return myValue;
    }

    @Override
    public void initializeCommand (Model m) {
    }

}
