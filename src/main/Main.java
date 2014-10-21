package main;

import javafx.application.Application;
import javafx.stage.Stage;
import backEnd.Controller;
import backEnd.Model;
import frontEnd.View;

public class Main extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		Model model = new Model();
		View view = new View("English", stage);
		new Controller(model, view);
	}

}