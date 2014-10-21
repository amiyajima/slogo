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
	public View myView;
	public Controller myController;
	
	private Model myModel;
	private final double WIDTH = 900;
	private final double HEIGHT = 600;

	public Workspace(Preferences preferences, Model model) {
		
		myModel = model;
		displayPreferences = preferences;
		
		setMinWidth(WIDTH);
		setMinWidth(HEIGHT);

		myView = new View(WIDTH, HEIGHT, "English");
		myController = new Controller(myModel, myView);
		
		getChildren().add(myView);
		
	}
	
	public EventHandler<KeyEvent> getKeyListener() {
		return buildUpListener();
	}
	
	private EventHandler<KeyEvent> buildUpListener() {
		EventHandler<KeyEvent> listener = new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent key) {
				if (key.getCode().equals(KeyCode.UP)){
					//Do nothing
				}
			}
		};
		return listener;
	}

}
