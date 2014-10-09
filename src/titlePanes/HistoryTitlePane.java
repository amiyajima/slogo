package titlePanes;

import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.VBox;
import backEnd.Controller;

class HistoryTitlePane extends TitledPane {

	public HistoryTitlePane(Controller contr) {
		
		setText("History");
		
		VBox root = new VBox();
		
		root.getChildren().add(makeXPosBox(contr));
		
		setContent(root);
	}

	private Node makeXPosBox(Controller contr) {
		VBox vbox = new VBox();
		
		Label xlabel = new Label("X Loc: ");
		
		TextField tf = new TextField();
		tf.setOnAction(event -> contr.changeXPos(Double.parseDouble(tf.getText())));
		
		vbox.getChildren().addAll(xlabel, tf);
		
		
		return vbox;
	}
	
	

}
