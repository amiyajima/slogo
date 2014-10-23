package backEnd;

import java.util.List;
import commands.templates.Command;
import frontEnd.View;


public class Model {

    private Parser myParser;
    private AbstractTurtle myTurtle;
    private VariableManager myVariableManager;

    // public static final Dimension CANVAS_DIMENSIONS = new Dimension(657, 524);

    public Model () {

        myVariableManager = new VariableManager();
        myParser = new Parser(this, myVariableManager);

    }

    public void setupTurtle (View view) {
        myTurtle = new Turtle(view.getCanvasWidth(), view.getCanvasHeight());
        myTurtle.addObserver(view);
        // myTurtle.bindProperties(view);
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
    int runScript (String script) throws Exception {

        List<Command> rootCommands = myParser.parseScript(script);

        // System.out.println("beginning execution " + rootCommands);

        for (Command c : rootCommands) {
            c.execute();
        }
        // print root commands here AKA the compiled tree
        System.out.println(rootCommands);
        return 0;
    }

    public void setTurtleObserver (View view) {
        myTurtle.addObserver(view);
    }

    public AbstractTurtle getTurtle () {
        return myTurtle;
    }

}
