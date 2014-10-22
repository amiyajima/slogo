package panels;

import java.util.Map;

import javafx.scene.control.Accordion;
import javafx.scene.layout.Pane;
import titlePanes.CommandTitlePane;
import titlePanes.ControlTitlePane;
import titlePanes.DisplayTitlePane;
import titlePanes.HistoryTitlePane;
import titlePanes.TitlePaneFactory;
import titlePanes.VariableTitlePane;
import backEnd.Controller;

public class ParameterPanel extends Pane {
	
	private DisplayTitlePane myDisplayTitlePane;
	private HistoryTitlePane myHistoryTitlePane;
	private ControlTitlePane myControlTitlePane;
	private CommandTitlePane myCommandTitlePane;
	private VariableTitlePane myVariableTitlePane;

	public ParameterPanel(double width, double height, Controller controller) {
				
		setMinWidth(width);
		setMinHeight(height);
		
		double maxTitlePaneHeight = height-100;
		
		Accordion accordion = new Accordion();
		
		TitlePaneFactory factory = new TitlePaneFactory(maxTitlePaneHeight);
			
		try {
		myDisplayTitlePane = (DisplayTitlePane)factory.buildTitleFrame("DisplayTitlePane", controller);
		myHistoryTitlePane = (HistoryTitlePane)factory.buildTitleFrame("HistoryTitlePane", controller);
		myControlTitlePane = (ControlTitlePane)factory.buildTitleFrame("ControlTitlePane", controller);
		myCommandTitlePane = (CommandTitlePane)factory.buildTitleFrame("CommandTitlePane", controller);
		myVariableTitlePane = (VariableTitlePane)factory.buildTitleFrame("VariableTitlePane", controller);
		accordion.getPanes().addAll(myDisplayTitlePane, myHistoryTitlePane, myControlTitlePane, myCommandTitlePane, myVariableTitlePane);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		getChildren().add(accordion);
		
	}
	
	public void addToHistory(String script) {
		myHistoryTitlePane.addToHistory(script);
	}
	
	public void setupVariableMap(Map<String, Double> varMap) {
		myVariableTitlePane.setupVariableMap(varMap);
	}

}
