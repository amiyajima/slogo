package titlePanes;

import javafx.scene.Node;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.TitledPane;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import backEnd.Controller;

public class DisplayTitlePane extends TitledPane {

	public DisplayTitlePane(Controller contr) {

		setText("Display");

		VBox root = new VBox();

		root.getChildren().add(makeBackgroundColorBox(contr));
		root.getChildren().add(makePenColorBox(contr));
		root.getChildren().add(makeGridLinesBox(contr));

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

	private Node makePenColorBox(Controller contr) {
		VBox vbox = new VBox();

		Label label = new Label("Pen color: ");
		vbox.getChildren().add(label);

		ColorPicker colorPicker = new ColorPicker();
		colorPicker.setValue(Color.BLACK);
		vbox.getChildren().add(colorPicker);

		colorPicker.setOnAction(event -> contr.changePenColor(colorPicker
				.getValue()));

		return vbox;
	}
	
	private Node makeGridLinesBox(Controller contr) {
		VBox vbox = new VBox();

		Label label = new Label("Grid lines (on/off): ");
		
		ToggleButton tb = new ToggleButton();
		
		tb.setOnAction(event -> contr.toggleGridLines());
		
		vbox.getChildren().addAll(label, tb);
		
		return vbox;
	}

}
