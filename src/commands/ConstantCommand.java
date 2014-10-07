package commands;

public class ConstantCommand extends Command {
    private double myValue;

    public ConstantCommand (int value) {
        myValue = value;
    }

    @Override
    public Double execute () {
        return myValue;
    }

}
