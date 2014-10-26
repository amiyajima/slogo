package panels;

import java.util.Map;
import javafx.scene.control.Accordion;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.layout.Pane;
import titlePanes.CommandTitlePane;
import titlePanes.ControlTitlePane;
import titlePanes.DisplayTitlePane;
import titlePanes.HelpTitlePane;
import titlePanes.HistoryTitlePane;
import titlePanes.LoadPropertiesTitlePane;
import titlePanes.VariableTitlePane;
import backEnd.Controller;

public class ParameterPanel extends Pane {
	
	private DisplayTitlePane myDisplayTitlePane;
	private HistoryTitlePane myHistoryTitlePane;
	private ControlTitlePane myControlTitlePane;
	private CommandTitlePane myCommandTitlePane;
	private VariableTitlePane myVariableTitlePane;
	//private LanguageTitlePane myLanguageTitlePane;
	private HelpTitlePane myHelpTitlePane;
	private LoadPropertiesTitlePane myLoadPropertiesTitlePane;

	public ParameterPanel(double width, double height, Controller controller) {
				
		setMinWidth(width);
		setMinHeight(height);
		
		double maxTitlePaneHeight = height-200;
		
		Accordion accordion = new Accordion();
		myDisplayTitlePane = new DisplayTitlePane(controller);
		myHistoryTitlePane = new HistoryTitlePane(controller, maxTitlePaneHeight);
		myControlTitlePane = new ControlTitlePane(controller);
		myCommandTitlePane = new CommandTitlePane(controller);
		myVariableTitlePane = new VariableTitlePane(controller);
		myHelpTitlePane = new HelpTitlePane(controller);
		myLoadPropertiesTitlePane = new LoadPropertiesTitlePane(controller);
		accordion.getPanes().addAll(myDisplayTitlePane, myHistoryTitlePane, myControlTitlePane, 
				myCommandTitlePane, myVariableTitlePane, myHelpTitlePane, myLoadPropertiesTitlePane);
		
		ScrollPane sp = new ScrollPane();
		sp.setContent(accordion);
		sp.setVbarPolicy(ScrollBarPolicy.ALWAYS);
		sp.setMaxHeight(height);
		
		getChildren().add(sp);
		
//		TitlePaneFactory factory = new TitlePaneFactory(maxTitlePaneHeight);
//			
//		try {
//		myDisplayTitlePane = (DisplayTitlePane)factory.buildTitleFrame("DisplayTitlePane", controller);
//		myHistoryTitlePane = (HistoryTitlePane)factory.buildTitleFrame("HistoryTitlePane", controller);
//		myControlTitlePane = (ControlTitlePane)factory.buildTitleFrame("ControlTitlePane", controller);
//		myCommandTitlePane = (CommandTitlePane)factory.buildTitleFrame("CommandTitlePane", controller);
//		myVariableTitlePane = (VariableTitlePane)factory.buildTitleFrame("VariableTitlePane", controller);
//		accordion.getPanes().addAll(myDisplayTitlePane, myHistoryTitlePane, myControlTitlePane, myCommandTitlePane, myVariableTitlePane);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//		getChildren().add(accordion);
		
	}
	
	public void addToHistory(String script) {
		myHistoryTitlePane.addToHistory(script);
	}
	
	public void setupVariableMap(Map<String, Double> varMap) {
		myVariableTitlePane.setupVariableMap(varMap);
	}

}
