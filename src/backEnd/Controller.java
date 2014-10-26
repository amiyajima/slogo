package backEnd;

import java.io.File;

import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import frontEnd.View;

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
	
//	public void moveForward() {
//		try {
//			//myModel.moveForward();
//			//myModel.runScript(commandList.getBaseBundleName("Foward"));
//		} catch (Exception e) {
//			System.out.println(e.toString());
//		}
//	}

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
						runScript("fd 10");
					} else if (key.equals(KeyCode.S)) {
						runScript("bk 10");
					} else if (key.equals(KeyCode.D)) {
						runScript("rt 15");
					} else if (key.equals(KeyCode.A)) {
						runScript("lt 15");
					}
				} catch (Exception e) {
					System.out.println(e.toString());
				}
			}
		};
	}

}
