package panels;

import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import backEnd.Controller;

public class ScriptPanel extends Pane {
	
	private TextArea myTextArea;

	public ScriptPanel(double width, double height, Controller controller) {
		HBox hbox = new HBox();
		hbox.setMinWidth(width);
		hbox.setMinHeight(height);
		myTextArea = new TextArea();
		myTextArea.setPromptText("Enter commands here");
		Button runButton = new Button("RUN");
		runButton.setOnAction(event -> runScript(controller, myTextArea));
		myTextArea.setPrefSize(3.*width/4., height);
		runButton.setPrefSize(width/4., height);
		hbox.getChildren().addAll(myTextArea, runButton);
		getChildren().add(hbox);
	}
	public void printException(Exception e) {
		myTextArea.setText(e.toString());
	}
	public void addTextToScript(String command) {
		String text = myTextArea.getText();
		text += " " + command;
		myTextArea.setText(text);
	}
	private void runScript(Controller c, TextArea t) {
		try {
			String text = t.getText();
			t.clear();
			c.runScript(text);
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
}
