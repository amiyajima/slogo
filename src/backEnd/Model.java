package backEnd;

import java.awt.Dimension;
import java.util.List;
import java.util.Queue;

import javafx.geometry.Point2D;
import commands.Command;
import frontEnd.View;


public class Model {

    private Parser myParser;
    private ScriptManager myScriptManager;
    private AbstractTurtle myTurtle;
    public static final Dimension CANVAS_DIMENSIONS = new Dimension(657, 524);

    public Model () {
        myParser = new Parser(this);
        myScriptManager = new ScriptManager();
        setUpTurtle(CANVAS_DIMENSIONS.getWidth(), CANVAS_DIMENSIONS.getHeight());
    }

    public void setUpTurtle (double x, double y) {
        myTurtle = new Turtle(x, y);
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
     *         error. Can be extended to return different integers for different
     *         types of syntax errors.
     * 
     */
    int runScript (String script) throws Exception {
        int errorStatus = myParser.checkScript(script);
        if (errorStatus != 0) { return errorStatus; }

        List<Command> rootCommands = myParser.parseScript(script);
        Queue<Command> executables = myScriptManager.compileScript(rootCommands);

        return 0;
    }

    public void setTurtleObserver (View view) {
        myTurtle.addObserver(view);
    }

    public AbstractTurtle getTurtle () {
        return myTurtle;
    }

}
