package commands;

public interface TurtleCommand extends Command {
    public void execute ();

    public void execute (int arg0);

    public void execute (int arg0, int arg1);
}
