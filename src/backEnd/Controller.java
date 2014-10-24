package backEnd;

import java.io.File;

import javafx.scene.paint.Color;
import frontEnd.View;

public class Controller {
	
	private Model myModel;
	private View myView;

	public Controller(Model model, View view) {
		myModel = model;
		myView = view;
		
		myView.addControllerAndSetupGui(this);
		
		model.setupTurtleManager(view);
		//view.setupTurtleView(model.getTurtle()); //not needed?
	}

	public void runScript(String script) throws Exception {
		if (script != null) {
			myModel.runScript(script);
			myView.addToHistory(script);
		}
	}

	public void changeBackgroundColor(Color c) {
		myView.changeBackgroundColor(c);
	}

	public void changePenColor(Color c) {
		myView.changePenColor(c);
	}

	public void changeTurtleImage(File f) {
		myView.changeTurtleImage(f);
	}

	public void toggleGridLines() {
		myView.toggleGridLines();
	}
	
	public void changeLanguage() {
		//TODO
	}

}
