// This entire file is part of my masterpiece.
// Brian Bolze

package titlePanes;

import java.lang.reflect.Constructor;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import javafx.scene.control.TitledPane;
import backEnd.Controller;

/**
 * Factory used for the creation of all of the TitlePanes used in the Accordion
 * in ParameterPanel. Reflection is used to lookup classes and their constructors. 
 * 
 * @author Brian Bolze
 *
 */
public class TitlePaneFactory {

	private Map<String, Class<?>> myImplementedTitlePanes;
	private Controller myController;

	public TitlePaneFactory(Controller controller) {
		myController = controller;
		myImplementedTitlePanes = new HashMap<String, Class<?>>();
		implementTitlePane("DisplayTitlePane", DisplayTitlePane.class);
		implementTitlePane("HistoryTitlePane", HistoryTitlePane.class);
		implementTitlePane("ControlTitlePane", ControlTitlePane.class);
		implementTitlePane("CommandTitlePane", CommandTitlePane.class);
		implementTitlePane("TurtleInfoTitlePane", TurtleInfoTitlePane.class);
		implementTitlePane("LoadVariablesTitlePane",
				LoadVariablesTitlePane.class);
		implementTitlePane("HelpTitlePane", HelpTitlePane.class);
		implementTitlePane("VariableTitlePane", VariableTitlePane.class);
	}

	void implementTitlePane(String type, Class<?> panelClass) {
		myImplementedTitlePanes.put(type, panelClass);
	}

	public TitledPane buildTitleFrame(String type) throws Exception {
		if (!myImplementedTitlePanes.containsKey(type)) {
			throw new Exception("TitleFrame not implemented!");
		} else {
			Class<?> c = Class.forName("titlePanes." + type);
			Constructor<?>[] constr = c.getDeclaredConstructors();
			TitledPane pane = (TitledPane) constr[0].newInstance(myController);
			return pane;
		}
	}

	public Collection<TitledPane> buildAllTitleFrames() {

		Collection<TitledPane> titledPanes = new Stack<TitledPane>();
		for (String type : myImplementedTitlePanes.keySet()) {
			try {
				titledPanes.add(buildTitleFrame(type));
			} catch (Exception e) {
				System.out.println("Error building TitleFrames");
			}
		}
		return titledPanes;
	}

}
