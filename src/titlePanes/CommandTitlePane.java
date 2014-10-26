package titlePanes;

import java.util.ResourceBundle;

import javafx.scene.control.Label;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import main.ResourceFinder;
import backEnd.Controller;

public class CommandTitlePane extends TitledPane {

	public CommandTitlePane(Controller contr) {
		setText("Commands");

		VBox root = new VBox();
		root.setSpacing(5);
		
		ResourceBundle resourceFile = ResourceFinder.getMyLanguageResources();
		
		for (String s : resourceFile.keySet()) {
			Label command = new Label(s);
			command.setFont(Font.font("Verdana", FontWeight.BOLD, 10));
			
			String translatedCommand = resourceFile.getString(s);
			String executableCommand = translatedCommand.split(",")[0];
			
			command.setOnMouseReleased(event -> contr.addTextToScript(executableCommand));
			root.getChildren().add(command);
		}

		setContent(root);
	}
}
