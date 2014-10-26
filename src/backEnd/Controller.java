package backEnd;

import java.io.File;

import javafx.scene.paint.Color;
import exceptions.SLogoException;
import frontEnd.View;

public class Controller {
	
	private Model myModel;
	private View myView;

	public Controller (Model model, View view) {
		myModel = model;
		myView = view;
		
		myView.addControllerAndSetupGui(this);
		
		myModel.setupTurtleManager(view);
//		myView.bindToModelProperties(myModel.getBackgroundIndex()); //to set up later
	}

	public void runScript (String script) {
		if (script != null) {
			try {
			    myModel.runScript(script);
			}
			catch (SLogoException e) {
			    System.out.println(e.getMessage());
			}
			myView.addToHistory(script);
		}
	}

	public void changeBackgroundColor (Color c) {
		myView.changeBackgroundColor(c);
	}

	public void changePenColor (Color c) {
		myView.changePenColor(c);
	}

	public void changeTurtleImage (File f) {
		myView.changeTurtleImage(f);
	}

	public void toggleGridLines () {
		myView.toggleGridLines();
	}
	
	public void changeLanguage (String language) {
		myModel.changeLanguage(language);
	}

}
