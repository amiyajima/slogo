package backEnd;

import frontEnd.View;

public class Controller {
	
	Model myModel;
	View myView;

	public Controller(Model model, View view) {
		myModel = model;
		myView = view;
	}
	
	public void runScript(String script) {
		if (script != null) {
			myModel.runScript(script);
		}
	}
	
}
