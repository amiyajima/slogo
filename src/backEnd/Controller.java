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
	}
	
	public void runScript(String script) throws Exception {
		if (script != null) {
			myModel.runScript(script);
		}
	}
	
	public void changeBackgroundColor(Color c) {
		myView.myCanvas.changeBackgroundColor(c);
	}
	
	public void changePenColor(Color c) {
		myView.myCanvas.changePenColor(c);
	}
	
	public void changeTurtleImage(File f) {
		myView.myCanvas.changeTurtleImage(f);
	}
	
	public void toggleGridLines() {
		myView.myCanvas.toggleGridLines();
	}
	
	/*
	 * TEMPORARY - For view.canvas testing
	 */
	public void changeXPos(double x) {
		myView.myCanvas.setTurtleX(x);
	}
	
}
