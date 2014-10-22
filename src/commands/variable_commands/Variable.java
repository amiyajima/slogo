package commands.variable_commands;

import backEnd.Model;
import commands.templates.Command;


public class Variable extends Command {
    private String myValue;

    public Variable () {
        this("");
    }

    public Variable (String value) {
        myValue = value;
    }

    @Override
    public double execute () {
        System.out.println("execute variable called");
        return 0;
    }

    @Override
    public String toString () {
        return myValue;
    }

    @Override
    public void initializeCommand (Model m) {
    }

}
