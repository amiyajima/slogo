package backEnd;

import java.util.List;
import java.util.Queue;

import commands.Command;

import frontEnd.View;

public class Model {

    private Parser myParser;
    private ScriptManager myScriptManager;
    private AbstractTurtle myTurtle;

    public Model () {
        myParser = new Parser(this);
        myScriptManager = new ScriptManager();
    }
    
    public void setupTurtle(View view) {
    	myTurtle = new Turtle(view.getCanvasWidth(), view.getCanvasHeight());
    	myTurtle.addObserver(view);
    	myTurtle.bindProperties(view);
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
    int runScript (String script) throws Exception {
        int errorStatus = myParser.checkScript(script);
        if (errorStatus != 0) {
            return errorStatus;
        }

        List<Command> rootCommands = myParser.parseScript(script);
        Queue<Command> executables = myScriptManager.compileScript(rootCommands);

        return 0;
    }
    
    public AbstractTurtle getTurtle() {
        return myTurtle;
    }

}
