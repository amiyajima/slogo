package backEnd;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
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
        InputStream fileInput = getClass().getResourceAsStream("/resources/Variables.properties");
        
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
