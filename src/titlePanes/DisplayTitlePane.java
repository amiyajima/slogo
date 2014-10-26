package titlePanes;

import java.io.File;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.TitledPane;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import backEnd.Controller;

public class DisplayTitlePane extends TitledPane {

	public DisplayTitlePane(Controller contr) {

		setText("Display");

		VBox root = new VBox();

		root.getChildren().add(makeBackgroundColorBox(contr));
		root.getChildren().add(makeGridLinesBox(contr));
		root.getChildren().add(makeTurtleImageChooser(contr));

		setContent(root);

	}

	private Node makeBackgroundColorBox(Controller contr) {
		VBox vbox = new VBox();

		Label label = new Label("Background color: ");
		vbox.getChildren().add(label);

		ColorPicker colorPicker = new ColorPicker();
		colorPicker.setValue(Color.WHITE);
		vbox.getChildren().add(colorPicker);

		colorPicker.setOnAction(event -> contr
				.changeBackgroundColor(colorPicker.getValue()));

		return vbox;
	}

	private Node makeGridLinesBox(Controller contr) {
		VBox container = new VBox();

		Label label = new Label("Grid lines (on/off): ");

		ToggleButton tb = new ToggleButton();

		tb.setOnAction(event -> contr.toggleGridLines());

		container.getChildren().addAll(label, tb);

		return container;
	}

	private Node makeTurtleImageChooser(Controller contr) {
		VBox container = new VBox();

		Label label = new Label("Change Turtle Image: ");

		Button button = new Button("Open File");
		button.setOnAction(event -> openFile(contr));

		container.getChildren().addAll(label, button);

		return container;
	}

	private void openFile(Controller contr) {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Upload Image");
		fileChooser.getExtensionFilters().addAll(
				new FileChooser.ExtensionFilter("All Images", "*.*"),
				new FileChooser.ExtensionFilter("JPG", "*.jpg"),
				new FileChooser.ExtensionFilter("PNG", "*.png"));

		Stage fileStage = new Stage();
		File file = fileChooser.showOpenDialog(fileStage);
		if (file != null)
			contr.changeTurtleImage(file);

	}

}
