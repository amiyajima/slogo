package titlePanes;

import java.lang.reflect.Constructor;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import javafx.scene.control.TitledPane;
import javafx.scene.shape.Rectangle;
import backEnd.Controller;

/*
 * DEPRECIATED!!!!!
 */
public class TitlePaneFactory {

	private Map<String, Class<?>> implementedTitlePanes;
	private double MAX_HEIGHT;

	public TitlePaneFactory(double maxHeight) {
		MAX_HEIGHT = maxHeight;
		implementedTitlePanes = new HashMap<String, Class<?>>();
		implementTitlePane("DisplayTitlePane", DisplayTitlePane.class);
		implementTitlePane("HistoryTitlePane", HistoryTitlePane.class);
		implementTitlePane("ControlTitlePane", ControlTitlePane.class);
		implementTitlePane("CommandTitlePane", CommandTitlePane.class);
		implementTitlePane("TurtleInfoTitlePane", TurtleInfoTitlePane.class);
		implementTitlePane("VariableTitlePane", VariableTitlePane.class);
	}

	void implementTitlePane(String type, Class<?> panelClass) {
		implementedTitlePanes.put(type, panelClass);
	}

	public TitledPane buildTitleFrame(String type, Controller contr)
			throws Exception {
		if (!implementedTitlePanes.containsKey(type)) {
			throw new Exception("TitleFrame not implemented!");
		} else {
			Class<?> c = Class.forName("titlePanes." + type);
			Constructor<?>[] constr = c.getDeclaredConstructors();
			TitledPane pane = (TitledPane)constr[0].newInstance(contr);
			pane.getContent().setClip(new Rectangle(MAX_HEIGHT, MAX_HEIGHT));
			pane.getContent().maxHeight(MAX_HEIGHT);
			return pane;
		}
	}

	public Collection<TitledPane> buildAllTitleFrames(Controller contr) {
		
		Collection<TitledPane> titledPanes = new Stack<TitledPane>();
		for (String type : implementedTitlePanes.keySet()) {
			try {
				titledPanes.add(buildTitleFrame(type, contr));
			} catch (Exception e) {
				System.out.println("Error building TitleFrames");
			}
		}
		return titledPanes;
	}

}
