package titlePanes;

import javafx.scene.control.Button;
import javafx.scene.control.TitledPane;
import backEnd.Controller;

class BackgroundTitlePane extends TitledPane {

	public BackgroundTitlePane(Controller contr) {
		
		setText("Background");
		
		Button b = new Button("Click me!");
		
	}

}
