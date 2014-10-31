package tests;

import static org.junit.Assert.*;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import org.junit.Test;
import backEnd.VariableManager;


/**
 * A Tester class used to test the functionalities of VariableManager.
 * 
 * the Variable.properties file has been set to x=5 and y=2 before running this class
 * 
 * @author Anna Miyajima
 *
 */
public class VariableManagerTester {

    private VariableManager testVariableManager;
    private Properties testProperties;

    public void setUp () {
        testProperties.setProperty("one", "1");
        testProperties.setProperty("two", "2");
        testProperties.setProperty("three", "3");
        testProperties.setProperty("four", "4");
        testProperties.setProperty("five", "5");
    }

    /**
     * Test to see if file was read in properly
     */
    @Test
    public void testManagerReadsFile () {
        testVariableManager = new VariableManager();
        assertTrue(testVariableManager.checkVarExists("y"));
    }

    /**
     * Test to see if a patch is created at each PatchGrid location
     */
    @Test
    public void testManagerContainsCorrectVars () {
        testVariableManager = new VariableManager();
        assertEquals("checking if manager value is correct", 5.0, testVariableManager.getVar("x"),
                     .01);
    }
    
    /**
     * Test to see if adding a variable to the manager works
     */
    @Test
    public void testAddVar () {
        testVariableManager = new VariableManager();
        try {
            testVariableManager.addVar("newvar", "42");
        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        assertTrue(testVariableManager.checkVarExists("newvar"));
    }
    
    /**
     * Add new map of variables, see if values exist and are usable. 
     */
    public void addNewFrame(){
        testVariableManager = new VariableManager();
        Map<String, String> testMap = new HashMap();
        testMap.put("DD", "7");
        testMap.put("CDC", "23");
        try {
            testVariableManager.pushVarProperties(testMap);
        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        assertTrue(testVariableManager.checkVarExists("DD"));
    }
}
