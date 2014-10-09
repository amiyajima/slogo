package commands;

import backEnd.Model;

public class ConstantCommand extends Command {
    private String myValue;

    public ConstantCommand (String value) {
        myValue = value;
    }

    @Override
    public double execute () {
        return Double.parseDouble(myValue);
    }

    @Override
    public String toString () {
        return myValue;
    }

    @Override
    public void initializeCommand (Model m) {
    }

}
