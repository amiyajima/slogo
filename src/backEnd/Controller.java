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
			myView.addToHistory(script);
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

	// private EventHandler<KeyEvent> keyReleaseListener = new
	// EventHandler<KeyEvent>() {
	// @Override
	// public void handle(KeyEvent event) {
	// if (event.getCode() == KeyCode.UP) {
	// playerSprite.aUp = false;
	// }
	// if (event.getCode() == KeyCode.DOWN) {
	// playerSprite.aDown = false;
	// }
	// if (event.getCode() == KeyCode.LEFT) {
	// playerSprite.aLeft = false;
	// }
	// if (event.getCode() == KeyCode.RIGHT) {
	// playerSprite.aRight = false;
	// }
	// if (event.getCode() == KeyCode.SPACE) {
	// playerSprite.isFiring = false;
	// }
	// if (event.getCode() == KeyCode.Z) {
	// playerSprite.bombReady = true;
	// }
	// }
	// };

}
