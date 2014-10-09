package commands;

import backEnd.Model;
import backEnd.AbstractTurtle;


public abstract class TurtleCommand extends Command {
    private AbstractTurtle myTurtle;

    public abstract void executeTurtleCommand (AbstractTurtle t);

    protected AbstractTurtle getMyTurtle () {
        return myTurtle;
    }

    protected void setTurtle (AbstractTurtle t) {
        myTurtle = t;
    }

    @Override
    public void initializeCommand (Model model) {
        myTurtle = model.getTurtle();
    }

}
