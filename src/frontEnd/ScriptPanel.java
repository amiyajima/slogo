package frontEnd;

//import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import backEnd.Controller;

class ScriptPanel extends Pane {

	ScriptPanel(BorderPane borderPane, Controller controller) {
		HBox hbox = new HBox();
		
		TextArea textArea = new TextArea("Enter commands here");
		Button runButton = new Button("RUN");
		textArea.setPrefSize(3*borderPane.getPrefWidth()/4, borderPane.getPrefHeight()/5);
//		textArea.setAlignment(Pos.TOP_LEFT);
		runButton.setPrefSize(borderPane.getPrefWidth()/4, borderPane.getPrefHeight()/5);
		
		runButton.setOnAction(event -> controller.runScript(textArea.getText()));
//		textField.setOnAction(event -> controller.runScript(textField.getText()));
		
		hbox.getChildren().addAll(textArea, runButton);
		
		borderPane.setBottom(hbox);
	}

}
