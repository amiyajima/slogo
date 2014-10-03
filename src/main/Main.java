package main;

import javafx.application.Application;
import javafx.stage.Stage;
import backEnd.Model;
import frontEnd.View;

public class Main extends Application {

	public static void main(String[] args) {
		
		Model model = new Model();
		View view = new View(model, "English");
		
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.show();
	}

}
