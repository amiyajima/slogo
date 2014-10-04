package backEnd;

import java.util.Collection;
import java.util.Observable;

public class Model extends Observable {

	Parser myParser;
	ScriptManager myScriptManager;
	Turtle myTurtle;

	public Model() {
		myParser = new Parser();
		myScriptManager = new ScriptManager();
		myTurtle = new Turtle();
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
	 */
	int runScript(String script) {
		int errorStatus = myParser.checkScript(script);
		if (errorStatus != 0) return errorStatus;
		
		Collection<Command> commands = myParser.parseScript(script);
		Collection<TurtleCommand> executables = myScriptManager.compileScript(commands);
		myTurtle.executeCommands(executables);
		
		return 0;
	}

}
