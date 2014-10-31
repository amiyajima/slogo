// This entire file is part of my masterpiece.
// Brian Bolze

package panels;

import java.io.IOException;

import javafx.scene.control.Accordion;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.Pane;
import titlePanes.HistoryTitlePane;
import titlePanes.TitlePaneFactory;
import titlePanes.VariableTitlePane;
import titlePanes.decorators.VScrollableDecorator;
import backEnd.Controller;

/**
 * Panel on the right hand side of the view that manages all of the important
 * display information. All data is stored in a JavaFX Accordion object, which
 * has TitledPanes as children. Different subclasses of TitledPane were created
 * and are contained within the titlePanes package.
 * 
 * @author Brian Bolze
 */
public class ParameterPanel extends Pane {

	private static final double ACCORDION_HEIGHT = 200;

	private static final String DISPLAY_TITLE_PANE = "DisplayTitlePane";
	private static final String HISTORY_TITLE_PANE = "HistoryTitlePane";
	private static final String CONTROL_TITLE_PANE = "ControlTitlePane";
	private static final String COMMAND_TITLE_PANE = "CommandTitlePane";
	private static final String VARIABLE_TITLE_PANE = "VariableTitlePane";
	private static final String HELP_TITLE_PANE = "HelpTitlePane";
	private static final String LOAD_VARIABLES_TITLE_PANE = "LoadVariablesTitlePane";

	private Accordion myAccordion;
	private TitledPane myDisplayTitlePane, myHistoryTitlePane,
			myControlTitlePane, myCommandTitlePane, myVariableTitlePane,
			myHelpTitlePane, myLoadVariablesTitlePane;

	public ParameterPanel(double width, double height, Controller controller)
			throws IOException {

		setMinWidth(width);
		setMinHeight(height);

		myAccordion = new Accordion();
		setupTitledPanes(controller);
		addDecorations();

		myAccordion.getPanes().addAll(myDisplayTitlePane, myHistoryTitlePane,
				myControlTitlePane, myCommandTitlePane, myVariableTitlePane,
				myHelpTitlePane, myLoadVariablesTitlePane);

		ScrollPane sp = new ScrollPane();
		sp.setContent(myAccordion);
		sp.setVbarPolicy(ScrollBarPolicy.ALWAYS);
		sp.setMaxHeight(height);

		getChildren().add(sp);

	}

	public void addToHistory(String script) {
		((HistoryTitlePane) myHistoryTitlePane).addToHistory(script);
	}

	/**
	 * 
	 * @throws IOException
	 */
	public void updateVariables() throws IOException {
		((VariableTitlePane) myVariableTitlePane).updateVariables();
	}

	private void setupTitledPanes(Controller controller) throws IOException {
		TitlePaneFactory factory = new TitlePaneFactory(controller);
		try {
			myDisplayTitlePane = factory.buildTitleFrame(DISPLAY_TITLE_PANE);
			myHistoryTitlePane = factory.buildTitleFrame(HISTORY_TITLE_PANE);
			myControlTitlePane = factory.buildTitleFrame(CONTROL_TITLE_PANE);
			myCommandTitlePane = factory.buildTitleFrame(COMMAND_TITLE_PANE);
			myVariableTitlePane = factory.buildTitleFrame(VARIABLE_TITLE_PANE);
			myHelpTitlePane = factory.buildTitleFrame(HELP_TITLE_PANE);
			myLoadVariablesTitlePane = factory
					.buildTitleFrame(LOAD_VARIABLES_TITLE_PANE);
		} catch (Exception e) {
			System.out.println("Error building TitledPanes!");
		}
	}

	private void addDecorations() {
		double maxHeight = getMinHeight() - ACCORDION_HEIGHT;
		new VScrollableDecorator(myHistoryTitlePane, maxHeight);
		new VScrollableDecorator(myVariableTitlePane, maxHeight);
		new VScrollableDecorator(myCommandTitlePane, maxHeight);
	}

}
