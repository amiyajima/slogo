package backEnd;

import frontEnd.View;

public class Controller {
	
	Model myModel;
	View myView;

	public Controller(Model model, View view) {
		myModel = model;
		myView = view;
	}
	
}
