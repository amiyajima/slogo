package panels;

import java.io.IOException;
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
import titlePanes.LoadVariablesTitlePane;
import titlePanes.VariableTitlePane;
import titlePanes.decorators.VScrollableDecorator;
import backEnd.Controller;


public class ParameterPanel extends Pane {

    private DisplayTitlePane myDisplayTitlePane;
    private HistoryTitlePane myHistoryTitlePane;
    private ControlTitlePane myControlTitlePane;
    private CommandTitlePane myCommandTitlePane;
    private VariableTitlePane myVariableTitlePane;
    private HelpTitlePane myHelpTitlePane;
    private LoadVariablesTitlePane myLoadPropertiesTitlePane;

    public ParameterPanel (double width, double height, Controller controller) throws IOException {

        setMinWidth(width);
        setMinHeight(height);

        Accordion accordion = new Accordion();
        setupTitledPanes(controller);
        addDecorations();

        accordion.getPanes().addAll(myDisplayTitlePane, myHistoryTitlePane,
                                    myControlTitlePane, myCommandTitlePane, myVariableTitlePane,
                                    myHelpTitlePane, myLoadPropertiesTitlePane);

        ScrollPane sp = new ScrollPane();
        sp.setContent(accordion);
        sp.setVbarPolicy(ScrollBarPolicy.ALWAYS);
        sp.setMaxHeight(height);

        getChildren().add(sp);

    }

    public void addToHistory (String script) {
        myHistoryTitlePane.addToHistory(script);
    }

//    public void setupVariableMap (Map<String, Double> varMap) {
//        myVariableTitlePane.setupVariableMap(varMap);
//    }

    private void setupTitledPanes (Controller controller) throws IOException {
        myDisplayTitlePane = new DisplayTitlePane(controller);
        myHistoryTitlePane = new HistoryTitlePane(controller);
        myControlTitlePane = new ControlTitlePane(controller);
        myCommandTitlePane = new CommandTitlePane(controller);
        myVariableTitlePane = new VariableTitlePane(controller);
        myHelpTitlePane = new HelpTitlePane(controller);
        myLoadPropertiesTitlePane = new LoadVariablesTitlePane(controller);
    }

    private void addDecorations () {
        double maxHeight = getMinHeight() - 200;
        new VScrollableDecorator(myHistoryTitlePane, maxHeight);
        new VScrollableDecorator(myVariableTitlePane, maxHeight);
        new VScrollableDecorator(myCommandTitlePane, maxHeight);
    }

	public void updateVariables() throws IOException {
		myVariableTitlePane.updateVariables();
	}

}
