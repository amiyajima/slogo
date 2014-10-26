package titlePanes;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javafx.scene.control.Hyperlink;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.VBox;
import backEnd.Controller;

public class HelpTitlePane extends TitledPane {
	
	private VBox myRoot;
	private final String myURLString = "http://www.cs.duke.edu/courses/compsci308/current/assign/03_slogo/index.php";
	
	public HelpTitlePane(Controller contr) {
		setText("Help");
		myRoot = new VBox();
		setContent(myRoot);
		setupHyperlink(contr);
	}

	private void setupHyperlink(Controller contr) {
		Hyperlink link = new Hyperlink();
		link.setText("Command References");
		link.setOnAction(event -> launchBrowser());
		myRoot.getChildren().add(link);
   
	}
	
	private void launchBrowser() {
		
		URI url;
		try {
			url = new URI(myURLString);
			Desktop.getDesktop().browse(url);
		} catch (URISyntaxException | IOException e) {
			System.out.println(e.toString());
		}
	}
}
