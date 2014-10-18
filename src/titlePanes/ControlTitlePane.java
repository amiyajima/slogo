package titlePanes;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import backEnd.Controller;

public class ControlTitlePane extends TitledPane {

	public ControlTitlePane(Controller contr) {
		
		setText("Controls");
		
		VBox root = new VBox();
		root.setSpacing(20);
		
		makeButtons(root, contr);
		
		makeLocationFields(root, contr);
		
		setContent(root);
		
	}

	private void makeButtons(VBox root, Controller contr) {
		
		VBox vbox = new VBox();
		HBox hbox = new HBox();
		
		Button upButton = new Button(">");
		upButton.setRotate(-90);
		upButton.setTranslateX(40);
		Button leftButton = new Button("<");
		Button rightButton = new Button(">");
		Button downButton = new Button(">");
		downButton.setRotate(90);
		
		setSize(upButton);
		setSize(leftButton);
		setSize(rightButton);
		setSize(downButton);
		
		upButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				try {
					contr.runScript("back 10");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					System.out.println(e.toString());
				}
			}
			
		});
		
		downButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				try {
					contr.runScript("forward 10");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					System.out.println(e.toString());
				}
			}
			
		});
		
		hbox.getChildren().addAll(leftButton, downButton, rightButton);
		
		vbox.getChildren().addAll(upButton, hbox);
		
		root.getChildren().add(vbox);
		
	}
	
	private void makeLocationFields(VBox root, Controller contr) {
		
		HBox hbox = new HBox();
		
		Label xlabel = new Label("X Loc: ");
		
		TextField tf = new TextField();
		tf.setOnAction(event -> contr.changeXPos(Double.parseDouble(tf.getText())));
		
		hbox.getChildren().addAll(xlabel, tf);
		
		root.getChildren().add(hbox);
	}
	
	private void setSize(Button b) {
		b.setPrefSize(40, 40);
	}

}
