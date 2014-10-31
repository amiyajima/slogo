package titlePanes;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javafx.scene.control.Label;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.VBox;
import backEnd.Controller;

/**
 * @author Eli Lichtenberg
 */
public class VariableTitlePane extends TitledPane {
	
	private VBox myRoot;
	private Properties myVarProps;
	private Map<String, String> myVarMap;
	
	public VariableTitlePane(Controller contr) throws IOException {
		setText("Variables");
		myRoot = new VBox();
		setContent(myRoot);
		
		myVarProps = new Properties();
		InputStream fileInput = getClass().getResourceAsStream("/resources/Variables.properties");
		myVarProps.load(fileInput);
		myVarMap = new HashMap<String, String>();
	}

	public void updateVariables() throws IOException {
		myVarProps = new Properties();
		InputStream fileInput = getClass().getResourceAsStream("/resources/Variables.properties");
		myVarProps.load(fileInput);
		Set<Object> keys = myVarProps.keySet();
		for(Object o : keys) {
			String key = (String)o;
			String val = myVarProps.getProperty(key);
			if(!myVarMap.containsKey(key) || !myVarMap.get(key).equals(val) 
					|| myVarMap.keySet().size()!=keys.size()) {
				writeVariables(keys);
				break;
			}
		}
	}

	private void writeVariables(Set<Object> keys) {
		myRoot.getChildren().clear();
		myVarMap.clear();
		for(Object o : keys) {
			String key = (String)o;
			String val = myVarProps.getProperty(key);
			Label variable = new Label(key + " = " + val);
			myRoot.getChildren().add(variable);
			myVarMap.put(key, val);
		}
	}
	
}
