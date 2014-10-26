package commands.onechild;

import backEnd.Model;
import backEnd.VariableManager;
import commands.templates.OneChildCommand;

public class SetBackgroundCommand extends OneChildCommand {
    
    private Model myModel;

    public SetBackgroundCommand (VariableManager manager) {
        super(manager);
    }

    @Override
    public double execute () {
        setValue(getMyChildren().get(0).execute());
        myModel.setBackgroundIndex(getValue());
        return getValue();
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
