package backEnd;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class VariableManager {

    private Properties myVariables;

    public VariableManager () {
        myVariables = new Properties();
        try {
            setVarProperties();
        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private void setVarProperties () throws IOException {
        File file = new File("/resources/Variables.properties");
        FileInputStream fileInput = new FileInputStream(file);
        myVariables.load(fileInput);
        fileInput.close();
    }

    public double getVar (String var) {
        
        return (double) myVariables.get(var);
    }

    public void addVar (String var, String value) {
        myVariables.setProperty(var, value);
    }

    public boolean checkVarExists (String var) {
        return (myVariables.containsKey(var));
    }
}
