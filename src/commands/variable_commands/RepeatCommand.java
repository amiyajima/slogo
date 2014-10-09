package commands.variable_commands;

import backEnd.Model;
import commands.Command;


public class RepeatCommand extends Command {

    public RepeatCommand () {
        super();
        setNumChildren(2);
    }

    @Override
    public Double execute () {
        Double result = 0.0;
        for (int i = 0; i < getMyChildren().get(0).execute(); i++) {
            result += getMyChildren().get(1).execute();
        }
        return result;
    }

    @Override
    public String toString () {
        return "repeat" + getMyChildren().get(1).execute() + " " + getMyChildren().get(0).execute() + " times." ;
    }

    @Override
    public void initializeCommand (Model m) {
        // TODO Auto-generated method stub
        
    }

}
