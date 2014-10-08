package backEnd;

import javafx.scene.paint.Color;
import frontEnd.View;

public class Controller {
	
	private Model myModel;
	private View myView;

	public Controller(Model model, View view) {
		myModel = model;
		myView = view;
		myModel.setTurtleObserver(view);
	}
	
	public void runScript(String script) throws Exception {
		if (script != null) {
			myModel.runScript(script);
		}
	}
	
	public void changeBackgroundColor(Color c) {
		myView.myCanvas.changeBackgroundColor(c);
	}
	
}
