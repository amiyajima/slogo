package frontEnd;

import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class Workspace extends Pane {
	
	private final double WIDTH = 900;
	private final double HEIGHT = 600;

	public Workspace() {
		VBox vbox = new VBox();
		HBox hbox = new HBox();
		
		vbox.fillWidthProperty().set(false);
		vbox.setMinWidth(WIDTH);
		vbox.setMinHeight(HEIGHT);
		
		getChildren().add(vbox);
	}

}
