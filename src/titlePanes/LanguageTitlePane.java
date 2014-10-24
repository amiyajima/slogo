package titlePanes;

import backEnd.Controller;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.VBox;

public class LanguageTitlePane extends TitledPane {
	
	private VBox myRoot;
	private String[] languages = {"Chinese", "English", "French", "Italian", "Portuguese", "Russian"};
		//extract languages somewhere
	
	public LanguageTitlePane(Controller contr) {
		setText("Language");
		myRoot = new VBox();
		setContent(myRoot);
		setupChoiceBox(contr);
	}

	private void setupChoiceBox(Controller contr) {
		// TODO Auto-generated method stub
		Label lang = new Label("Language: ");
		myRoot.getChildren().add(lang);
		
		ChoiceBox cb = new ChoiceBox(FXCollections.observableArrayList(languages));
		myRoot.getChildren().add(cb);
		cb.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
			public void changed(ObservableValue ov, Number value, Number new_value) {
				System.out.println("old selection: " + value + "  new selection: " + new_value);
				contr.changeLanguage();
			}
		});
	}
}
