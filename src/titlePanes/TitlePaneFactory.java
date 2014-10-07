package titlePanes;

import java.lang.reflect.Constructor;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import javafx.scene.control.TitledPane;
import backEnd.Controller;


public class TitlePaneFactory {

	private Map<String, Class<?>> implementedTitlePanes;

	public TitlePaneFactory() {
		implementedTitlePanes = new HashMap<String, Class<?>>();
		implementTitlePane("BackgroundTitlePane", BackgroundTitlePane.class);
	}

	void implementTitlePane(String type, Class<?> panelClass) {
		implementedTitlePanes.put(type, panelClass);
	}

	public TitledPane buildTitleFrame(String type, Controller contr)
			throws Exception {
		if (!implementedTitlePanes.containsKey(type)) {
			throw new Exception("TitleFrame not implemented!");
		} else {
			Class<?> c = Class.forName("Panels." + type);
			Constructor<?>[] constr = c.getDeclaredConstructors();
			return (TitledPane)constr[0].newInstance(contr);
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
