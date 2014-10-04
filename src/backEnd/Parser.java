package backEnd;

import java.util.List;

import commands.Command;

class Parser {

	public Parser() {
	}

	/**
	 * Called by the model via the controller every time a user runs a new
	 * script. The Parser will begin by checking the syntax to make sure there
	 * are no errors, and will return an integer for different error messages to
	 * be handled by the view.
	 * 
	 * @param script
	 *            Raw input from the user
	 * @return
	 * 
	 */
	public int checkScript(String script) {
		return 0;
	}

	/**
	 * Called by the model if the input script is valid. At this point, the
	 * parser will split the script up into different lines and individual
	 * commands. The Parser will then call the CommandFactory to build all of
	 * the commands and add them to the returned list
	 * 
	 * @param script
	 *            Raw input from the user (always error free)
	 * @return A list of commands to be sent to the ScriptManager
	 */
	List<Command> parseScript(String script) {
		System.out.println(script);
		return null;
	}

}
