package panels;

import javafx.scene.control.Accordion;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.BorderPane;
import titlePanes.CommandTitlePane;
import titlePanes.ControlTitlePane;
import titlePanes.DisplayTitlePane;
import titlePanes.HistoryTitlePane;
import titlePanes.TitlePaneFactory;
import backEnd.Controller;

public class ParameterPanel extends Panel {
	
	private DisplayTitlePane myDisplayTitlePane;
	private HistoryTitlePane myHistoryTitlePane;
	private ControlTitlePane myControlTitlePane;
	private CommandTitlePane myCommandTitlePane;

	ParameterPanel(BorderPane borderPane, Controller controller) {
		
		super(borderPane, controller);
		
		Accordion root = new Accordion();
		root.setPrefWidth(borderPane.getPrefWidth()/4);
		
		TitlePaneFactory factory = new TitlePaneFactory();
		
		//Pen color
		//Background color
		//Turtle image		
		try {
		myDisplayTitlePane = (DisplayTitlePane)factory.buildTitleFrame("DisplayTitlePane", controller);
		myHistoryTitlePane = (HistoryTitlePane)factory.buildTitleFrame("HistoryTitlePane", controller);
		myControlTitlePane = (ControlTitlePane)factory.buildTitleFrame("ControlTitlePane", controller);
		myCommandTitlePane = (CommandTitlePane)factory.buildTitleFrame("CommandTitlePane", controller);
		root.getPanes().addAll(myDisplayTitlePane, myHistoryTitlePane, myControlTitlePane, myCommandTitlePane);
		} catch (Exception e) {
			e.printStackTrace();
			//other stuff?
		}
//		for (TitledPane tp : factory.buildAllTitleFrames(controller)) {		
//			root.getPanes().add(tp);
//		}
		
		borderPane.setRight(root);
	}
	
	public void addToHistory(String script) {
		myHistoryTitlePane.addToHistory(script);
	}

}
