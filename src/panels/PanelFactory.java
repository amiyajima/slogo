package panels;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

import javafx.scene.layout.BorderPane;
import backEnd.Controller;

/**
 * 
 * @author brianbolze
 * 
 * NOTE: Made design decision to specify the implemented Panels within the
 * PanelFactory constructor as opposed to in the static section of main for
 * performance reasons.
 *
 */
public class PanelFactory {

	private Map<String, Class<?>> implementedPanels;

	public PanelFactory() {
		implementedPanels = new HashMap<String, Class<?>>();
		implementPanel("ScriptPanel", ScriptPanel.class);
		implementPanel("ParameterPanel", ParameterPanel.class);
	}

	void implementPanel(String type, Class<?> panelClass) {
		implementedPanels.put(type, panelClass);
	}

	public Panel buildPanel(String type, BorderPane pane, Controller contr)
			throws Exception {
		if (!implementedPanels.containsKey(type)) {
			throw new Exception("Panel not implemented!");
		} else {
			Class<?> c = Class.forName("panels." + type);
			Constructor<?>[] constr = c.getDeclaredConstructors();
			return (Panel)constr[0].newInstance(pane, contr);
		}
	}

	public void buildAllPanels(BorderPane pane, Controller contr) {
		for (String type : implementedPanels.keySet()) {
			try {
				buildPanel(type, pane, contr);
			} catch (Exception e) {
				System.out.println("Error building panels");
			}
		}
	}

}
