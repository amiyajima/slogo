package frontEnd;

import java.util.prefs.Preferences;

import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import backEnd.Controller;
import backEnd.Model;

public class Workspace extends VBox {

	public Preferences displayPreferences;

	private Model myModel;
	private View myView;
	private Controller myController;
	private EventHandler<KeyEvent> keyListener;
	private EventHandler<MouseEvent> mouseListener;
	
	private double WIDTH = 900;
	private double HEIGHT = 600;

	private static final Preferences DEFAULT_DISPLAY_PREFERENCES = new DisplayPreferences();

	public Workspace() {
		this(DEFAULT_DISPLAY_PREFERENCES);
	}

	public Workspace(Preferences preferences) {

		displayPreferences = preferences;

		setMinWidth(WIDTH);
		setMinWidth(HEIGHT);

		myModel = new Model();
		myView = new View(WIDTH, HEIGHT, "English");
		myController = new Controller(myModel, myView);

		buildKeyListener();
		buildMouseListener();

		getChildren().add(myView);

	}

	public EventHandler<KeyEvent> getKeyListener() {
		return keyListener;
	}

	public EventHandler<MouseEvent> getMouseListener() {
		return mouseListener;
	}
	
	private void buildKeyListener() {
		keyListener = new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent keyEvent) {
				KeyCode key = keyEvent.getCode();
				try {
					if (key.equals(KeyCode.W)) {
						myController.runScript("fd 10");
					} else if (key.equals(KeyCode.S)) {
						myController.runScript("bk 10");
					} else if (key.equals(KeyCode.D)) {
						myController.runScript("rt 15");
					} else if (key.equals(KeyCode.A)) {
						myController.runScript("lt 15");
					}
				} catch (Exception e) {
					System.out.println(e.toString());
				}
			}
		};
	}
	
	private void buildMouseListener() {
		mouseListener = new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				double x = event.getX();
				double y = event.getY();
				if (onCanvas(x,y)) {
					// Make sure that the arrow keys do not switch the tab
					setOnKeyReleased(keyListener);
				}
			}
		};
	}
	
	private boolean onCanvas(double x, double y) {
		return true;
	}
}
