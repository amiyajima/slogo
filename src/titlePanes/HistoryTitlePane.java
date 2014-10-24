package titlePanes;

import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.VBox;
import backEnd.Controller;

public class HistoryTitlePane extends TitledPane {
	
	private ScrollPane myScrollPane;
	private VBox myRoot;

	public HistoryTitlePane(Controller contr, double height) {
		setText("History");
		myScrollPane = new ScrollPane();
		myRoot = new VBox();
		myScrollPane.setContent(myRoot);
		setContent(myScrollPane);
		myScrollPane.setMaxHeight(height);
	}
	
	public void addToHistory(String script) {
		Label history = new Label(script);
		myRoot.getChildren().add(history);
	}

}
