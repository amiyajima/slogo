package commands;

import backEnd.Model;
import backEnd.VariableManager;
import commands.templates.Command;

public class SetBackgroundCommand extends Command {
    private Model myModel;
    
    public SetBackgroundCommand (VariableManager manager) {
        super(manager);
    }

    @Override
    public double execute () {
        setValue(getMyChildren().get(0).execute());
        
        return 0;
    }

    @Override
    public String toString () {
        return null;
    }

    @Override
    public void initializeCommand (Model model) {
        myModel = model;        
    }

}
