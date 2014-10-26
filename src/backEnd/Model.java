package backEnd;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import backEnd.turtle.Turtle;
import backEnd.turtle.TurtleManager;
import commands.templates.Command;
import frontEnd.View;


/**
 * Model for SLogo. The model holds a turtle manager which holds the
 * turtles for the workspace.
 * 
 * @author Brian Bolze
 * @author Ethan Chang
 * @author Eli Lichtenberg
 * @author Anna Miyajima
 *
 */
public class Model {

    public static final int INITIAL_BACKGROUND_INDEX = 0;
    private Parser myParser;
    private Turtle myTurtle;
    private VariableManager myVariableManager;
    private TurtleManager myTurtleManager;
    private HashMap<String, Command> myCommandsList;
    private DoubleProperty myBackgroundIndex = new SimpleDoubleProperty();
    private StringProperty myPalette;

    /**
     * Constructor for model. Initializes the variable manager, commandList,
     * and the initial background index for the workspace
     * 
     * @param parser Parser which can be used in the workspace
     */
    public Model (Parser parser) {
        myVariableManager = new VariableManager();
        myParser = parser;
        myCommandsList = new HashMap<String, Command>();
        myBackgroundIndex = new SimpleDoubleProperty(INITIAL_BACKGROUND_INDEX);
        myPalette = new SimpleStringProperty("");
    }

    /**
     * Sets up the turtleManager by adding an observer to it so it can be tracked
     * by the front end
     * 
     * @param view View for the workspace
     */
    public void setupTurtleManager (View view) {
        myTurtleManager = new TurtleManager(view.getCanvasWidth(), view.getCanvasHeight());
        myTurtleManager.addObserver(view);
        myTurtleManager.updateActiveTurtleList(Arrays.asList(1.0));
    }

    /**
     * Called by the Controller when the Run button has been pressed by the
     * user. Privacy level is Package because the Controller is in the backEnd
     * package also
     * 
     * @param script
     *        The input string of syntax from the text-field
     * 
     * @return Returns 0 if the input is valid. Returns 1 if there is a syntax
     *         error. Can be extended to return different Doubles for different
     *         types of syntax errors.
     * 
     */
    int runScript (String script) {

        List<Command> rootCommands = myParser.parseScript(script, this,
                                                          myVariableManager);

        for (Command c : rootCommands) {
            c.execute();
        }
        System.out.println("root commands are " + rootCommands);
        return 0;
    }

    /**
     * Adds turtle observer to the view
     * 
     * @param view view for the workspace
     */
    public void setTurtleObserver (View view) {
        myTurtle.addObserver(view);
    }

    /**
     * Returns the model's turtle manager
     * 
     * @return turtleManager
     */
    public TurtleManager getTurtleManager () {
        return myTurtleManager;
    }

    /**
     * Return a map mapping string and commands
     * 
     * @return
     */
    public Map<String, Command> getCommandsMap () {
        return myCommandsList;
    }

    /**
     * Returns the background index for the workspace
     * 
     * @return background index
     */
    public DoubleProperty getBackgroundIndex () {
        return myBackgroundIndex;
    }

    /**
     * Set the index for the background
     * 
     * @param index index for the background index
     */
    public void setBackgroundIndex (double index) {
        myBackgroundIndex.setValue(index);
    }

    public void setPaletteArguments (int index, int red, int green, int blue) {
        String color = index + ": rgb(" + red + "," + green + "," + blue + ")";
        myPalette.set(color);
    }

    public StringProperty getPaletteArguments () {
        return myPalette;
    }

    public void setVariableProperties (File f) {
        myVariableManager.setVarProperties(f);
    }
}
