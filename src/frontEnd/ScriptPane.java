package frontEnd;

//import javafx.geometry.Pos;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import backEnd.Controller;

class ScriptPane extends Pane {

    ScriptPane(BorderPane borderPane, Controller controller) {
        HBox hbox = new HBox();
        
        TextArea textArea = new TextArea("Enter commands here");
        Button runButton = new Button("RUN");
        textArea.setPrefSize(3*borderPane.getPrefWidth()/4, borderPane.getPrefHeight()/5);
        runButton.setPrefSize(borderPane.getPrefWidth()/4, borderPane.getPrefHeight()/5);
        
        runButton.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				try {
					String text = textArea.getText();
					
					controller.runScript(text);
				} catch (Exception e) {
					// TODO Implement more error handling
					System.out.println(e.toString());
				}
			}
        	
        });
        
        hbox.getChildren().addAll(textArea, runButton);
        
        borderPane.setBottom(hbox);
    }

}