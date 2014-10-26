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
import exceptions.UndefinedVariableException;


/**
 * A variable manager that reads in variable values from properties files or maps for use by
 * commands
 * Also allows variable commands to set values in the properties object.
 * Writes variable values to the properties file.
 * 
 * @author annamiyajima
 *
 */
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
            throw new UndefinedVariableException("variable properties file invalid");
        }
        try {
            myVariables.load(fileInput);
        }
        catch (IOException e) {
            throw new UndefinedVariableException("variable properties file cannot load");
        }
        System.out.println(myVariables);
    }

    public void pushVarProperties (Map<String, String> variableMap) throws IOException {
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
