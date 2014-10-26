package commands.onechild;

import backEnd.Model;
import backEnd.VariableManager;
import commands.templates.OneChildCommand;

/**
 * Command to set the background color of the workspace
 * @author Ethan Chang
 *
 */
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
