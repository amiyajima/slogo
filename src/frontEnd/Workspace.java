package frontEnd;

import java.util.prefs.Preferences;

import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import backEnd.Controller;
import backEnd.Model;

public class Workspace extends VBox {

	public Preferences displayPreferences;

	// brianbolze - Does this need to have all three??
	private Model myModel;
	private View myView;
	private Controller myController;
	private EventHandler<KeyEvent> keyListener;
	private double WIDTH = 900;
	private double HEIGHT = 600;

	private static final Preferences DEFAULT_DISPLAY_PREFERENCES = new DisplayPreferences();

	public Workspace(Model model) {
		this(DEFAULT_DISPLAY_PREFERENCES, model);
	}

	public Workspace(Preferences preferences, Model model) {

		myModel = model;
		displayPreferences = preferences;

		setMinWidth(WIDTH);
		setMinWidth(HEIGHT);

		myView = new View(WIDTH, HEIGHT, "English");
		myController = new Controller(myModel, myView);

		buildKeyListener();

		getChildren().add(myView);

	}

	public EventHandler<KeyEvent> getKeyListener() {
		return keyListener;
	}

	private void buildKeyListener() {
		keyListener = new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent keyEvent) {
				KeyCode key = keyEvent.getCode();
				try {
					if (key.equals(KeyCode.UP)) {
						myController.runScript("fd 10");
					} else if (key.equals(KeyCode.DOWN)) {
						myController.runScript("bk 10");
					} else if (key.equals(KeyCode.RIGHT)) {
						myController.runScript("rt 15");
					} else if (key.equals(KeyCode.LEFT)) {
						myController.runScript("lt 15");
					}
				} catch (Exception e) {
					System.out.println(e.toString());
				}
			}
		};
	}
}
