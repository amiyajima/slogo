package titlePanes;

import javafx.scene.control.Hyperlink;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.VBox;
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
