package titlePanes;

import javafx.scene.Node;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.VBox;
import backEnd.Controller;

class HistoryTitlePane extends TitledPane {

	public HistoryTitlePane(Controller contr) {
		setText("History");
		
		VBox root = new VBox();
		
		//root.getChildren().add(makeXPosBox(contr));
		
		setContent(root);
	}

	private Node makeXPosBox(Controller contr) {
		VBox vbox = new VBox();
		
		
		
		return vbox;
	}
	
	

}
