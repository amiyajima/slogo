package backEnd;

import java.io.File;
import java.util.ResourceBundle;

import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import main.ResourceFinder;
import frontEnd.View;

/**
 * 
 * @author Brian Bolze
 *
 */
public class Controller {
	
	public EventHandler<MouseEvent> myMouseListener;
	public EventHandler<KeyEvent> myKeyListener;
	
	private Model myModel;
	private View myView;

	public Controller (Model model, View view) {
		myModel = model;
		myView = view;
		
		myView.addControllerAndSetupGui(this);
		myModel.setupTurtleManager(view);
		
		buildMouseListener();
		buildKeyListener();

		myView.bindToModelProperties(myModel.getBackgroundIndex());
	}

	public void runScript (String script) {
		if (script != null) {
			try {
			    myModel.runScript(script);
			}
			catch (Exception e) {
				myView.printException(e);
			}
			myView.addToHistory(script);
		}
	}
	
	/**
	 * Called by keys and buttons
	 * 
	 * @param The base command that is being executed
	 */
	public void move10 (String direction) {
		ResourceBundle commands = ResourceFinder.getMyLanguageResources();
		String temp = commands.getString(direction);
		String[] command = temp.split(",");
		runScript(command[0] +" 10");
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
	
	public void setVariableProperties(File f){
	    myModel.setVariableProperties(f);
	}
	
	private void buildMouseListener() {
		myMouseListener = new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
//				double x = event.getX();
//				double y = event.getY();
				

			}
		};
	}
	
	private void buildKeyListener() {
		myKeyListener = new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent keyEvent) {
				
				KeyCode key = keyEvent.getCode();
				
				try {
					if (key.equals(KeyCode.W)) {
						move10("Forward");
					} else if (key.equals(KeyCode.S)) {
						move10("Backward");
					} else if (key.equals(KeyCode.D)) {
						move10("Right");
					} else if (key.equals(KeyCode.A)) {
						move10("Left");
					}
				} catch (Exception e) {
					System.out.println(e.toString());
				}
			}
		};
	}

	public void addTextToScript(String translatedCommand) {
		myView.addTextToScript(translatedCommand);
	}

}
