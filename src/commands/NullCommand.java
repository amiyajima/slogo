package commands;

import backEnd.Model;


public class NullCommand extends Command {

    @Override
    public double execute () {
        // TODO Auto-generated method stub
        return 0.0;
    }

    @Override
    public String toString () {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void initializeCommand (Model m) {
        // TODO Auto-generated method stub

    }

    public int getNumChildrenNeeded () {
        return 0;
    }

}
