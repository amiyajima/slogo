package commands;

import backEnd.Model;
import backEnd.Turtle;

public abstract class TurtleCommand extends Command {
    private Turtle myTurtle;


    public abstract void executeTurtleCommand(Turtle t);

    protected Turtle getMyTurtle() {
        return myTurtle;
    }

    protected void setTurtle(Turtle t) {
        myTurtle = t;
    }

    @Override
    public void initializeCommand(Model model) {
        myTurtle = model.getTurtle();
    }
}

