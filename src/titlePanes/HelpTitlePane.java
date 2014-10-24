package titlePanes;

import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import backEnd.Controller;

public class HelpTitlePane extends TitledPane {
	
	private VBox myRoot;
	private final String url = "http://www.cs.duke.edu/courses/compsci308/current/assign/03_slogo/part3.php";
	
	public HelpTitlePane(Controller contr) {
		setText("Help");
		myRoot = new VBox();
		setContent(myRoot);
		setupHyperlink(contr);
	}

	private void setupHyperlink(Controller contr) {
		// TODO Auto-generated method stub
		Hyperlink link = new Hyperlink();
//		WebView browser = new WebView();
//		WebEngine webEngine = new WebEngine();
		link.setText("Command References");
		link.setOnAction(event -> System.out.println("link pressed"));
//		link.setOnAction(event -> webEngine.load(url));
		myRoot.getChildren().add(link);
		
		
//		HBox hbox = new HBox();
// 
//        myRoot.getChildren().addAll(hbox, browser);
//        VBox.setVgrow(browser, Priority.ALWAYS);
//        
//        Stage stage = new Stage();
//        Scene scene = new Scene(myRoot);
//        stage.setScene(scene);
//        stage.show();
		
	}
}
