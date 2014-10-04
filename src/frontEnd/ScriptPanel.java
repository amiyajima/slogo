package frontEnd;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import backEnd.Controller;

class ScriptPanel extends Pane {

	public ScriptPanel(BorderPane borderPane, Controller controller) {
		HBox hbox = new HBox();
		
		TextField scriptTextField = new TextField("Enter commands here");
		Button runScriptButton = new Button("RUN");
		
		runScriptButton.setOnAction(event -> controller.runScript(scriptTextField.getText()));
		scriptTextField.setOnAction(event -> controller.runScript(scriptTextField.getText()));
		
		hbox.getChildren().addAll(scriptTextField, runScriptButton);
		
		borderPane.setBottom(hbox);
	}

}
