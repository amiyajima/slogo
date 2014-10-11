package titlePanes;

import java.util.Map;
import java.util.Set;

import backEnd.Controller;
import javafx.scene.control.Label;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.VBox;

public class VariableTitlePane extends TitledPane {
	
	private VBox myRoot;
	private Map<String,Double> varMap; //ACTUAL MAP from model, might be bad design
									   //need to address this later
	
	public VariableTitlePane(Controller contr) {
		setText("Variables");
		myRoot = new VBox();
		setContent(myRoot);
	}
	
	public void setupVariableMap(Map<String, Double> varMap) {
		Set<String> variables = varMap.keySet();
		for(String varName : variables) {
			Label variable = new Label(varName + ": " + varMap.get(varName));
		}
	}
	
//	private void addListeners() {
//		varMap.addL
//	}
}
