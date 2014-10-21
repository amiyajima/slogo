package frontEnd;

import java.util.prefs.Preferences;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class Workspace extends Pane {
	
	private final double WIDTH = 900;
	private final double HEIGHT = 600;
	
	private Label label;

	public Workspace(Preferences preferences) {

		VBox vbox = new VBox();
		HBox hbox = new HBox();
		
		vbox.fillWidthProperty().set(false);
		vbox.setMinWidth(WIDTH);
		vbox.setMinHeight(HEIGHT);
	
		addTestUI(vbox);
		
		getChildren().add(vbox);
	}
	
	public EventHandler<KeyEvent> getKeyListener() {
		return buildUpListener();
	}
	
	private void addTestUI(Pane root) {
		Button button = new Button("Click me");
		label = new Label("Hello World!");
		
		button.setOnAction(event -> blinkLabel(label));
		
		root.getChildren().addAll(button, label);
	}
	
	private void blinkLabel(Label label) {
		label.setVisible(!label.isVisible());
	}
	
	private EventHandler<KeyEvent> buildUpListener() {
		EventHandler<KeyEvent> listener = new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent key) {
				if (key.getCode().equals(KeyCode.UP)){
					blinkLabel(label);
				}
			}
		};
		return listener;
	}

}
