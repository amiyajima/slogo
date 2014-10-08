package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.LinkedList;

import backEnd.Model;
import backEnd.Parser;
import commands.Command;
import commands.CommandFactory;


public class ParserTest {
    @Test
    public void testTreeCreation () {
        Model myModel = new Model();
        CommandFactory factory = new CommandFactory("English", myModel);
        Parser parser = new Parser(myModel);
        LinkedList<String> testList = new LinkedList();
        testList.add("forward");
        testList.add("50");
        Command root = parser.makeTree(testList);
        //assertEquals(root.getNumChildren(), 1);
    }
}
