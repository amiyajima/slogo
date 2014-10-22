package commands.variable_commands;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import backEnd.Model;
import commands.templates.Command;


public class CommandsList extends Command {

    public CommandsList () {
        super();
    }

    /**
     * Executes every command in commandsList.
     * returns the value of this whole branch.
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
        return getMyChildren().toString();
    }

    @Override
    public void initializeCommand (Model m) {
        // TODO Auto-generated method stub

    }

    public Command getChild (int index) {
        return getMyChildren().get(index);
    }
    
    public int getNumChildren(){
        return getMyChildren().size();
    }

}
