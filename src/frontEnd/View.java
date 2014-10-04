package frontEnd;

import java.util.Observable;
import java.util.Observer;

import javafx.stage.Stage;
import backEnd.Controller;


public class View implements Observer {
	
	private Stage myStage;
	private String myLanguage;
	private Controller myController;
	
	public View(Stage stage, String language) {
		myStage = stage;
		myLanguage = language;
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

}
