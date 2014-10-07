package titlePanes;

import javafx.scene.Node;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import backEnd.Controller;

class BackgroundTitlePane extends TitledPane {

	public BackgroundTitlePane(Controller contr) {
		
		setText("Background");
		
		VBox root = new VBox();
		
		root.getChildren().add(makeBackgroundColorBox(contr));
		
		setContent(root);
		
	}
	
	Node makeBackgroundColorBox(Controller contr) {
		VBox vbox = new VBox();
		
		Label label = new Label("Background color: ");
		vbox.getChildren().add(label);

		ColorPicker colorPicker = new ColorPicker();
		colorPicker.setValue(Color.CORAL);
		vbox.getChildren().add(colorPicker);
		
		colorPicker.setOnAction(event -> contr.changeBackgroundColor(colorPicker.getValue()));
		
		return vbox;
	}

}
