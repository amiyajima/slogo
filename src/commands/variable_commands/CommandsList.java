package commands.variable_commands;

import backEnd.Model;
import backEnd.VariableManager;

import commands.templates.Command;

public class CommandsList extends Command {
    /**
     * This command adds all commands within brackets [ ] as children and executes all of these
     * children
     * 
     * @param manager
     */
    public CommandsList (VariableManager manager) {
        super(manager);
    }

    /**
     * Executes every command in commandsList. returns the value of this whole
     * branch.
     */
    @Override
    public double execute () {
        double value = 0;
        for (int i = 0; i < getMyChildren().size(); i++) {
            value += getMyChildren().get(i).execute();
        }
        return value;
    }

    @Override
    public String toString () {
        // return getMyChildren().toString();
        return "tostring of commandslist";
    }

    public Command getChild (int index) {
        return getMyChildren().get(index);
    }

    public int getNumChildren () {
        return getMyChildren().size();
    }

    @Override
    public void initializeCommand (Model model) {
    }

}
