package commands;

import java.util.ArrayList;
import java.util.List;


public abstract class Command {

    private List<Command> myChildren;
    private int myMaxNumChildren;
    private int myCurrentNumChildren;
    private Command myParent;

    public Command () {
        myChildren = new ArrayList<>();
        myCurrentNumChildren = 0;
    }

    public abstract Double execute ();

    public abstract String toString ();

    protected List<Command> getMyChildren () {
        return myChildren;
    }

    protected void setNumChildren (int numChildren) {
        myMaxNumChildren = numChildren;
    }

    public void addChild (Command c) {
        myChildren.add(c);
        myCurrentNumChildren++;
    }

    public int getMaxNumChildren () {
        return myMaxNumChildren;
    }

    public int getCurrentNumChildren () {
        return myCurrentNumChildren;
    }

    public void setParent (Command current) {
        // TODO Auto-generated method stub
        myParent = current;
    }

    public Command getParent () {
        return myParent;
    }

}
