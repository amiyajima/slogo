package frontEnd;

import java.util.prefs.Preferences;

import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import backEnd.Controller;
import backEnd.Model;
import backEnd.Parser;

public class Workspace extends VBox {

	public Preferences displayPreferences;

	private Model myModel;
	private View myView;
	private Controller myController;
	
	private double WIDTH = 900;
	private double HEIGHT = 600;

	private static final Preferences DEFAULT_DISPLAY_PREFERENCES = new DisplayPreferences();

	public Workspace(Parser parser) {
		this(DEFAULT_DISPLAY_PREFERENCES, parser);
	}

	public Workspace(Preferences preferences, Parser parser) {

		displayPreferences = preferences;

		setMinWidth(WIDTH);
		setMinWidth(HEIGHT);

		myModel = new Model(parser);
		myView = new View(WIDTH, HEIGHT, "English");
		myController = new Controller(myModel, myView);

		getChildren().add(myView);

	}

	public EventHandler<KeyEvent> getKeyListener() {
		return myController.myKeyListener;
	}

	public EventHandler<MouseEvent> getMouseListener() {
		return myController.myMouseListener;
	}
	
}
