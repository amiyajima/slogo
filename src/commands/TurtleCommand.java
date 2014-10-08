
package commands;

import backEnd.Turtle;

public abstract class TurtleCommand extends Command {
    public TurtleCommand () {
        super();
    }
    
    public abstract void executeTurtleCommand(Turtle t);
}