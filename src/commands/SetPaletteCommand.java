package commands;

import backEnd.Model;
import backEnd.VariableManager;
import commands.templates.Command;

public class SetPaletteCommand extends Command {
    public static int NUM_CHILDREN = 4;
    Model myModel;

    public SetPaletteCommand (VariableManager manager) {
        super(manager);
        setNumChildren(NUM_CHILDREN);
    }

    @Override
    public double execute () {
        double index = getMyChildren().get(0).execute();
        double red = getMyChildren().get(1).execute();
        double green = getMyChildren().get(2).execute();
        double blue = getMyChildren().get(4).execute();
        myModel.setPaletteArguments((int)index, (int)red, (int)green, (int)blue);
        return index;
    }

    @Override
    public String toString () {
        return null;
    }

    @Override
    public void initializeCommand (Model model) {
        myModel = model;
    }

}
