// This entire file is part of my masterpiece.
// Eli Lichtenberg

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
 * TitledPane responsible for displaying variables to user. Display is done
 * within GUI's side panel
 * 
 * @author Brian Bolze
 * @author Ethan Chang
 * @author Eli Lichtenberg
 * @author Anna Miyajima
 *
 */
public class VariableTitlePane extends TitledPane {
	
	private static final String TITLE = "Variables";
	private static final String VAR_PROPS_FILE_NAME = "/resources/Variables.properties";
	private VBox myRoot;
	private Properties myVarProps;
	private Map<String, String> myVarMap;
	
	/**
	 * Constructor for VariableTitlePane. Takes in the Workspace's Controller 
	 * to allow for further interaction with user to be implemented
	 * 
	 * @param contr Controller of workspace
	 * @throws IOException
	 */
	public VariableTitlePane (Controller contr) throws IOException {
		setText(TITLE);
		myRoot = new VBox();
		setContent(myRoot);
		myVarProps = makeNewProperties(VAR_PROPS_FILE_NAME);
		myVarMap = new HashMap<String, String>();
	}
	
	private Properties makeNewProperties (String resourceFileName) throws IOException {
		Properties props = new Properties();
		InputStream fileInput = getClass().getResourceAsStream(resourceFileName);
		props.load(fileInput);
		return props;
	}
	
	/**
	 * Checks if there is a difference between variables properties file 
	 * and a map containing the most recently updated variables. If there is 
	 * a difference, the list of variables is rewritten in the TitledPane 
	 * in the GUI.
	 * 
	 * @throws IOException
	 */
	public void updateVariables () throws IOException {
		myVarProps = makeNewProperties(VAR_PROPS_FILE_NAME);
		Set<Object> keys = myVarProps.keySet();
		if (myVarMap.keySet().size() != keys.size()) {
			writeVariablesToScreen(keys);
		}
		else {
			for (Object o : keys) {
				String key = (String)o;
				String val = myVarProps.getProperty(key);
				if (!myVarMap.get(key).equals(val)) {
					writeVariablesToScreen(keys);
					break;
				}
			}
		}
	}

	private void writeVariablesToScreen (Set<Object> keys) {
		myRoot.getChildren().clear();
		myVarMap.clear();
		for (Object o : keys) {
			String key = (String)o;
			String val = myVarProps.getProperty(key);
			Label varLabel = new Label(key + " = " + val);
			myRoot.getChildren().add(varLabel);
			myVarMap.put(key, val);
		}
	}
}
