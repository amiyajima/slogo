package panels;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
		
		runButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				try {
					controller.runScript(textArea.getText());
					textArea.clear();
				} catch (Exception e) {
					// TODO Add Error Handling
					e.printStackTrace();
				}
				
			}
			
		});
		
		hbox.getChildren().addAll(textArea, runButton);
		getChildren().add(hbox);

	}

}
