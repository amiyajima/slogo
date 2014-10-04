package backEnd;

import frontEnd.View;

public class Controller {
	
	private Model myModel;
	private View myView;

	public Controller(Model model, View view) {
		myModel = model;
		myView = view;
		myModel.setTurtleObserver(view);
	}
	
	public void runScript(String script) {
		if (script != null) {
			myModel.runScript(script);
		}
	}
	
}
