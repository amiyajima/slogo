package titlePanes;

import javafx.scene.control.Label;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.VBox;
import backEnd.Controller;

public class HistoryTitlePane extends TitledPane {
	
	private VBox myRoot;

	public HistoryTitlePane(Controller contr) {
		setText("History");
		myRoot = new VBox();		
		setContent(myRoot);
	}
	
	public void addToHistory(String script) {
		Label history = new Label(script);
		myRoot.getChildren().add(history);
	}

}
