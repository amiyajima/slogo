package backEnd;

import java.util.Collection;
import java.util.Observable;

import commands.TurtleCommand;

public class Turtle extends Observable {

	public Turtle() {
	}

	/**
	 * Called by the model to execute a list of turtle commands that may or may
	 * not alter the View. A lot of the data in Turtle will be observable by the
	 * view, so when it changes the view will update the GUI accordingly via its
	 * update(Observable o, Object arg) method
	 * 
	 * @param commands Most likely a stack of executable Turtle Commands
	 */
	void executeCommands(Collection<TurtleCommand> commands) {
		return;
	}
}
