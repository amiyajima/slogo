package titlePanes;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javafx.scene.control.TitledPane;
import javafx.scene.layout.VBox;
import backEnd.Controller;

public class VariableTitlePane extends TitledPane {
	
	private VBox myRoot;
	private Properties myVarProps;
	
	public VariableTitlePane(Controller contr) throws IOException {
		setText("Variables");
		myRoot = new VBox();
		setContent(myRoot);
		
		myVarProps = new Properties();
		InputStream fileInput = getClass().getResourceAsStream("/resources/Variables.properties");
		myVarProps.load(fileInput);
	}
	
	
	
//	public void setupVariableMap(Map<String, Double> varMap) {
//		Set<String> variables = varMap.keySet();
//		for(String varName : variables) {
//			Label variable = new Label(varName + ": " + varMap.get(varName));
//			myRoot.getChildren().add(variable);
//		}
//	}
	
//	private void addListeners() {
//		varMap.addL
//	}
}
