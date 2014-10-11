package commands;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import backEnd.Model;


public abstract class Command {

    private List<Command> myChildren;
    private int myNumChildren;
    private double myValue;
    private Map<String, Double> myVarsMap;

    public Command (Map<String, Double> variableMap) {
        myChildren = new ArrayList<>();
        System.out.println(this.getClass().getName() + " created");
        myVarsMap = variableMap;
    }

    public abstract double execute ();

    public abstract String toString ();

    protected List<Command> getMyChildren () {
        return myChildren;
    }

    protected void setNumChildren (int numChildren) {
        myNumChildren = numChildren;
    }

    protected void setValue (Double value) {
        myValue = value;
    }

    protected double getValue () {
        return myValue;
    }

    public void addChild (Command c) {
        myChildren.add(c);
    }

    public int getNumChildrenNeeded () {
        return myNumChildren - myChildren.size();
    }

    public abstract void initializeCommand (Model m);

}
