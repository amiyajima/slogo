package backEnd;

import java.util.Collection;

import commands.Command;
import commands.TurtleCommand;

class ScriptManager {

	ScriptManager() {
	}

	/**
	 * Takes in a list of commands and evaluates expressions, expands loops, and
	 * breaks it down into atomic TurtleCommands that will be passed to the
	 * Turtle to execute
	 * 
	 * @param commands
	 *            List of commands to be evaluated and broken down
	 * @return
	 * 			  List of executable TurtleCommands to be passed to the Turtle
	 */
	Collection<TurtleCommand> compileScript(Collection<Command> commands) {
		return null;
	}

}
