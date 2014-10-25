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

    public void pushVarProperties (Map<String, String> variableMap) throws FileNotFoundException,
                                                                   IOException {
        System.out.println("entered pushvarproperties. myVariables are " + myVariables);
        System.out.println("stack before push is: " + myStoredVariables);
        Properties addToStack = new Properties();
        for (Object s : myVariables.keySet()) {
            addToStack.setProperty((String) s, (String) myVariables.get(s));
        }
        System.out.println(addToStack);
        myStoredVariables.push(addToStack);
        myVariables.clear();
        myVariables.putAll(variableMap);
        writeVarsToFile();
        System.out.println("variables after push is: " + myVariables);
        System.out.println("stack after push is: " + myStoredVariables);
    }

    public double getVar (String var) {
        System.out.println("getVar called in manager for " + var);
        System.out.println(myVariables);
        System.out.println(myVariables.keySet());
        System.out.println(myVariables.getProperty(var));
        return Double.parseDouble(myVariables.getProperty(var));
    }

    public void popVarProperties () throws FileNotFoundException, IOException {
        System.out.println("stack before pop is: " + myStoredVariables);
        myVariables = myStoredVariables.pop();
        System.out.println("stack after pop is: " + myStoredVariables);
        writeVarsToFile();
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
