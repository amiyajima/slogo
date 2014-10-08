package commands;

import java.util.ArrayList;
import java.util.List;


public abstract class Command {

    private List<Command> myChildren;
    private int myNumChildren;
    private Command myParent;

    public Command () {
        myChildren = new ArrayList<>();
    }

    public abstract Double execute ();

    public abstract String toString ();

    protected List<Command> getMyChildren () {
        return myChildren;
    }

    protected void setNumChildren (int numChildren) {
        myNumChildren = numChildren;
    }

    public void addChild (Command c) {
        myChildren.add(c);
    }

    public int getNumChildren () {
        return myNumChildren;
    }

    public void setParent (Command current) {
        // TODO Auto-generated method stub
        myParent = current;
    }

    public Command getParent () {
        return myParent;
    }

}
