package backEnd;

import java.util.Collection;

import commands.Command;
import commands.TurtleCommand;

public class Model {

	private Parser myParser;
	private ScriptManager myScriptManager;
	private Turtle myTurtle;

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
	 *         
	 */
	public int runScript(String script) {
		int errorStatus = myParser.checkScript(script);
		if (errorStatus != 0) return errorStatus;
		
		Collection<Command> commands = myParser.parseScript(script);
		Collection<TurtleCommand> executables = myScriptManager.compileScript(commands);
		myTurtle.executeCommands(executables);
		
		return 0;
	}
	
	public Turtle getTurtle() {
	    return myTurtle;
	}

}
