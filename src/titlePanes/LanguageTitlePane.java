package titlePanes;

import backEnd.Controller;
import javafx.collections.FXCollections;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.VBox;

public class LanguageTitlePane extends TitledPane {
	
	private VBox myRoot;
	
	public LanguageTitlePane(Controller contr) {
		setText("Language");
		myRoot = new VBox();
		setContent(myRoot);
		setupChoiceBox();
	}

	private void setupChoiceBox() {
		// TODO Auto-generated method stub
		Label lang = new Label("Language: ");
		myRoot.getChildren().add(lang);
		
		ChoiceBox cb = new ChoiceBox(FXCollections.observableArrayList(
				"Chinese", "English", "French", "Italian", "Portuguese", "Russian"));
		myRoot.getChildren().add(cb);
	}
}
