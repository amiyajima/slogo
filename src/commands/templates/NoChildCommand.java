package commands.templates;

import backEnd.Model;
import backEnd.VariableManager;

public abstract class NoChildCommand extends Command {

    public NoChildCommand (VariableManager manager) {
        super(manager);
        // TODO Auto-generated constructor stub
    }

    @Override
    public double execute () {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public String toString () {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void initializeCommand (Model m) {
        // TODO Auto-generated method stub

    }

}
