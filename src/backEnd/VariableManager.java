package backEnd;

import java.io.FileNotFoundException;
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
        myStoredVariables = new Stack<Properties>();
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

    public void pushVarProperties (Map<String, String> variableMap) throws FileNotFoundException, IOException {
        System.out.println("entered pushvarproperties");
        myStoredVariables.push(myVariables);
        myVariables.clear();
        myVariables.putAll(variableMap);
        writeVarsToFile();
    }

    public void popVarProperties () throws FileNotFoundException, IOException {
        myVariables = myStoredVariables.pop();
        System.out.println(myVariables);
        writeVarsToFile();
    }

    public double getVar (String var) {
        System.out.println("getVar called in manager for " + var);
        System.out.println(myVariables);
        System.out.println(myVariables.keySet());
        System.out.println(myVariables.getProperty(var));
        return Double.parseDouble(myVariables.getProperty(var));
    }

    public void addVar (String var, String value) throws IOException {
        System.out.println("var added in manager " + var + value);
        myVariables.setProperty(var, value);
        writeVarsToFile();
    }

    private void writeVarsToFile () throws FileNotFoundException, IOException {
        FileOutputStream myFileOutput = new FileOutputStream("src/resources/Variables.properties");
        myVariables.store(myFileOutput, "adding vars");
    }

    public boolean checkVarExists (String var) {
        return myVariables.containsKey(var);
    }
}
