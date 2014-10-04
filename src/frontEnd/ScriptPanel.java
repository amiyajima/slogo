package frontEnd;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import backEnd.Controller;

class ScriptPanel extends Pane {

	ScriptPanel(BorderPane borderPane, Controller controller) {
		HBox hbox = new HBox();
		
		TextField textField = new TextField("Enter commands here");
		Button runButton = new Button("RUN");
		textField.setPrefSize(3*borderPane.getPrefWidth()/4, borderPane.getPrefHeight()/5);
		textField.setAlignment(Pos.TOP_LEFT);
		runButton.setPrefSize(borderPane.getPrefWidth()/4, borderPane.getPrefHeight()/5);
		
		runButton.setOnAction(event -> controller.runScript(textField.getText()));
		textField.setOnAction(event -> controller.runScript(textField.getText()));
		
		hbox.getChildren().addAll(textField, runButton);
		
		borderPane.setBottom(hbox);
	}

}
