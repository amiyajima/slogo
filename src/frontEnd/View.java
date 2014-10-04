package frontEnd;

import java.util.Observable;
import java.util.Observer;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import backEnd.Controller;


public class View implements Observer {
	
	private static final double WIDTH = 900;
	private static final double HEIGHT = 700; 
	
	private BorderPane myBorderPane;
	private String myLanguage;
	private Controller myController;
	
	public View(Stage stage, String language) {
		myLanguage = language;
		
		setupBorderPane();
		setupGuiElements();	
		Scene scene = new Scene(myBorderPane);
		stage.setScene(scene);	
	}
	
	/**
	 * Done by Main.java at initiation
	 */
	public void addController(Controller controller) {
		myController = controller;
	}

	/**
	 * Update the view whenever (observed) data changes in the model
	 * @param  arg  The data that has been changed
	 */
	@Override
	public void update(Observable o, Object arg) {
		
	}
	
	private void setupGuiElements() {
		setupMenuBar();
		setupScriptPanel();
		/*
		 * More GUI setups here -- will probably make a GUI factory
		 */
	}
	
	private void setupBorderPane() {
		myBorderPane = new BorderPane();
		myBorderPane.setPrefSize(WIDTH, HEIGHT);
	}
	
	private void setupMenuBar() {
	}
	
	private void setupScriptPanel() {
		HBox hbox = new HBox();
		
		TextField scriptTextField = new TextField("Enter commands here");
		Button runScriptButton = new Button("RUN");
		
		runScriptButton.setOnAction(event -> myController.runScript(scriptTextField.getText()));
		scriptTextField.setOnAction(event -> myController.runScript(scriptTextField.getText()));
		
		hbox.getChildren().addAll(scriptTextField, runScriptButton);
		
		myBorderPane.setBottom(hbox);
	}

}
