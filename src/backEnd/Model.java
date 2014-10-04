package backEnd;

import java.util.List;
import java.util.Queue;
import javafx.geometry.Point2D;

import commands.Command;
import frontEnd.View;

/**
 * A model that performs all of the logic on user input. Creates a parser,
 * script manager, and turtle that work sequentially to translate the input into
 * visual changes that need to be made on the front end.
 * 
 * @author Brian Bolze
 * @author Ethan Chang
 * @author Eli Lichtenberg
 * @author Anna Miyajima
 * 
 */
public class Model {

    private Parser myParser;
    private ScriptManager myScriptManager;
    private Turtle myTurtle;

    /**
     * Create a new Model to control back end logic.
     */
    public Model () {
        myParser = new Parser();
        myScriptManager = new ScriptManager("");
        myTurtle = new Turtle(new Point2D(0,0));
    }

    /**
     * Called by the Controller when the Run button has been pressed by the
     * user. Privacy level is Package because the Controller is in the backEnd
     * package also
     * 
     * @param script
     *            The input string of syntax from the text-field
     * 
     * @return Returns 0 if the input is valid. Returns 1 if there is a syntax
     *         error. Can be extended to return different integers for different
     *         types of syntax errors.
     * 
     */
    int runScript (String script) {
        int errorStatus = myParser.checkScript(script);
        if (errorStatus != 0) {
            return errorStatus;
        }

        List<Command> commands = myParser.parseScript(script);
        Queue<Command> executables = myScriptManager.compileScript(commands);
        myTurtle.executeCommands(executables);

        return 0;
    }

    /**
     * Sets an observer on the model's turtle object to allow immediate update
     * of the view for changes in the turtle
     * @param view     The program's view
     *     
     */
    public void setTurtleObserver(View view) {
        myTurtle.addObserver(view);
    }
}
