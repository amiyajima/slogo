package panels;

import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import backEnd.Controller;

class ScriptPanel extends Panel {

	ScriptPanel(BorderPane borderPane, Controller controller) {
		
		super(borderPane, controller);
		
		HBox hbox = new HBox();
		
		TextArea textArea = new TextArea("Enter commands here");
		Button runButton = new Button("RUN");
		
		textArea.setPrefSize(3*borderPane.getPrefWidth()/4, borderPane.getPrefHeight()/5);
		runButton.setPrefSize(borderPane.getPrefWidth()/4, borderPane.getPrefHeight()/5);
		
		textArea.setMinWidth(Control.USE_PREF_SIZE);
		runButton.setMinWidth(Control.USE_PREF_SIZE);
		textArea.setMinHeight(Control.USE_PREF_SIZE);
		runButton.setMinHeight(Control.USE_PREF_SIZE);
		
		textArea.setMinHeight(30);
		textArea.setMinHeight(30);
		
		runButton.setOnAction(event -> controller.runScript(textArea.getText()));
		
		hbox.getChildren().addAll(textArea, runButton);
		
		borderPane.setBottom(hbox);
	}

}
