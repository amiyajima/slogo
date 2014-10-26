package backEnd;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;
import java.util.Stack;
import exceptions.InvalidPropertyFileException;

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
            throw new InvalidPropertyFileException("Invalid property file loaded");
        }
    }

    private void setInitialVarProperties () throws IOException {
        InputStream fileInput = getClass().getResourceAsStream("/resources/Variables.properties");
        myVariables.load(fileInput);
    }
    
    public void setVarProperties (File f) {
        FileInputStream fileInput = null;
        try {
            fileInput = new FileInputStream(f);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            myVariables.load(fileInput);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(myVariables);
    }

    public void pushVarProperties (Map<String, String> variableMap) throws IOException {
        System.out.println("entered pushvarproperties. myVariables are " + myVariables);
        System.out.println("stack before push is: " + myStoredVariables);
        Properties addToStack = new Properties();
        for (Object s : myVariables.keySet()) {
            addToStack.setProperty((String)s, (String)myVariables.get(s));
        }
        myStoredVariables.push(addToStack);
        myVariables.clear();
        myVariables.putAll(variableMap);
        writeVarsToFile();
    }

    public double getVar (String var) {
        return Double.parseDouble(myVariables.getProperty(var));
    }


    public void popVarProperties () throws IOException {
        System.out.println("stack before pop is: " + myStoredVariables);
        myVariables = myStoredVariables.pop();
        writeVarsToFile();
    }

    public void addVar (String var, String value) throws IOException {
        myVariables.setProperty(var, value);
        writeVarsToFile();
    }

    private void writeVarsToFile () throws IOException {
        FileOutputStream myFileOutput = new FileOutputStream("src/resources/Variables.properties");
        myVariables.store(myFileOutput, "adding vars");
    }

    public boolean checkVarExists (String var) {
        return myVariables.containsKey(var);
    }
}
