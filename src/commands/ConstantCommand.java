package commands;

public class ConstantCommand extends Command {
    private String myValue;

    public ConstantCommand (String value) {
        myValue = value;
    }

    @Override
    public Double execute () {
        return Double.parseDouble(myValue);
    }

    @Override
    public String toString () {
        return myValue;
    }

}
