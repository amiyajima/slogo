package commands;

import java.util.ArrayList;
import java.util.List;

import backEnd.Model;


public abstract class Command {

    private List<Command> myChildren;
    private int myNumChildren;

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
    
    
    public abstract void initializeCommand(Model m);

}
