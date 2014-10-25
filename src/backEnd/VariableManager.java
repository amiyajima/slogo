package backEnd;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;
import java.util.Stack;


public class VariableManager {

    private Properties myVariables;
    private Stack<Properties> myStoredVariables;

    public VariableManager () {
        myVariables = new Properties();
        try {
            setInitialVarProperties();
        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private void setInitialVarProperties () throws IOException {
        InputStream fileInput = getClass().getResourceAsStream("/resources/Variables.properties");

    }

    public void pushVarProperties (Map<String, Double> variableMap) {
        myStoredVariables.push(myVariables);
        myVariables.clear();
        myVariables.putAll(variableMap);
        System.out.println(myVariables);
    }

    public void popVarProperties () {
        myVariables = myStoredVariables.pop();
        System.out.println(myVariables);
    }

    public double getVar (String var) {
        return Double.parseDouble(myVariables.getProperty(var));
    }

    public void addVar (String var, String value) throws IOException {
        System.out.println("var added in manager " + var + value);
        myVariables.setProperty(var, value);
        FileOutputStream myFileOutput = new FileOutputStream("src/resources/Variables.properties");
        myVariables.store(myFileOutput, "adding vars");
    }

    public boolean checkVarExists (String var) {
        return myVariables.containsKey(var);
    }
}
