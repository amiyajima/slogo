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
import titlePanes.VariableTitlePane;
import titlePanes.decorators.ScrollableDecorator;
import backEnd.Controller;

public class ParameterPanel extends Pane {

	private DisplayTitlePane myDisplayTitlePane;
	private HistoryTitlePane myHistoryTitlePane;
	private ControlTitlePane myControlTitlePane;
	private CommandTitlePane myCommandTitlePane;
	private VariableTitlePane myVariableTitlePane;
	private HelpTitlePane myHelpTitlePane;

	public ParameterPanel(double width, double height, Controller controller) {

		setMinWidth(width);
		setMinHeight(height);

		Accordion accordion = new Accordion();

		setupTitledPanes(controller);
		addDecorations();

		accordion.getPanes().addAll(myDisplayTitlePane, myHistoryTitlePane,
				myControlTitlePane, myCommandTitlePane, myVariableTitlePane,
				myHelpTitlePane);

		ScrollPane sp = new ScrollPane();
		sp.setContent(accordion);
		sp.setVbarPolicy(ScrollBarPolicy.ALWAYS);
		sp.setMaxHeight(height);

		getChildren().add(sp);

	}

	public void addToHistory(String script) {
		myHistoryTitlePane.addToHistory(script);
	}

	public void setupVariableMap(Map<String, Double> varMap) {
		myVariableTitlePane.setupVariableMap(varMap);
	}

	private void setupTitledPanes(Controller controller) {
		myDisplayTitlePane = new DisplayTitlePane(controller);
		myHistoryTitlePane = new HistoryTitlePane(controller);
		myControlTitlePane = new ControlTitlePane(controller);
		myCommandTitlePane = new CommandTitlePane(controller);
		myVariableTitlePane = new VariableTitlePane(controller);
		myHelpTitlePane = new HelpTitlePane(controller);
	}

	private void addDecorations() {
		double maxHeight = getMinHeight() - 200;
		new ScrollableDecorator(myHistoryTitlePane, maxHeight);
		new ScrollableDecorator(myVariableTitlePane, maxHeight);
		new ScrollableDecorator(myCommandTitlePane, maxHeight);
	}

}
