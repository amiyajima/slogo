package panels;

import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import backEnd.Controller;

public class ScriptPanel extends Pane {

	public ScriptPanel(double width, double height, Controller controller) {
		
		HBox hbox = new HBox();
		hbox.setMinWidth(width);
		hbox.setMinHeight(height);
		
		TextArea textArea = new TextArea();
		textArea.setPromptText("Enter commands here");
		Button runButton = new Button("RUN");
		
		runButton.setOnAction(event -> handler(controller, textArea));
		
		textArea.setPrefSize(3.*width/4., height);
		runButton.setPrefSize(width/4., height);
		
		hbox.getChildren().addAll(textArea, runButton);
		getChildren().add(hbox);

	}
	
	private void handler(Controller c, TextArea t) {
		try {
			c.runScript(t.getText());
			t.clear();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

}
