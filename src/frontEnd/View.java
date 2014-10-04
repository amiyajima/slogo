package frontEnd;

import java.util.Observable;
import java.util.Observer;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import backEnd.Controller;


public class View implements Observer {
	
	private static final double WIDTH = 900;
	private static final double HEIGHT = 700; 
	
	private BorderPane myBorderPane;
	private String myLanguage;
	private Controller myController;
	
	public View(String language) {
		myLanguage = language;
	}
	
	/**
	 * Done by Main at initiation
	 */
	public void addController(Controller controller) {
		myController = controller;
	}
	
	/**
	 * Called by Main after the controller is attached
	 */
	public void setupGui(Stage stage) {
		
		setupBorderPane();
		setupGuiElements();	
		
		Scene scene = new Scene(myBorderPane);
		stage.setScene(scene);
	}

	/**
	 * Update the view whenever (observed) data changes in the model
	 * @param  arg  The data that has been changed
	 */
	@Override
	public void update(Observable o, Object arg) {
		
	}
	
	private void setupGuiElements() {
		new ScriptPanel(myBorderPane, myController);
		//setupMenuBar();
		/*
		 * More GUI setups here -- will move to PanelFactory later
		 */
	}
	
	private void setupBorderPane() {
		myBorderPane = new BorderPane();
		myBorderPane.setPrefSize(WIDTH, HEIGHT);
	}

}
