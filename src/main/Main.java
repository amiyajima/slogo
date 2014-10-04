package main;

import javafx.application.Application;
import javafx.stage.Stage;
import backEnd.Controller;
import backEnd.Model;
import frontEnd.View;

/**
 * Creates the model, view, and controller to launch the IDE.
 * 
 * @author Brian Bolze
 * @author Ethan Chang
 * @author Eli Lichtenberg
 * @author Anna Miyajima
 * 
 */
public class Main extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		Model model = new Model();
		View view = new View("English");	
		Controller controller = new Controller(model, view);
		view.addController(controller);
		
		view.setupGui(stage);	
		stage.show();
	}

}
