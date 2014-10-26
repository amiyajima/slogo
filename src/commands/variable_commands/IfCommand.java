package commands.variable_commands;

import backEnd.Model;
import backEnd.VariableManager;
import commands.templates.TwoChildCommand;


/**
 * An if statement command
 * 
 * Input format: IF expr [ commands ]
 * Runs commands if if expr is not 0
 * 
 * @author annamiyajima
 *
 */
public class IfCommand extends TwoChildCommand {

    public IfCommand (VariableManager manager) {
        super(manager);
    }

    @Override
    public double execute () {
        if (getMyChildren().get(0).execute() != 0) {
            return getMyChildren().get(1).execute();
        }
        else {
            return 0;
        }
    }

    @Override
    public String toString () {
        return "If " + getMyChildren().get(0).execute() + " != 0, execute "
               + getMyChildren().get(1);
    }

    @Override
    public void initializeCommand (Model model) {

    }

}
