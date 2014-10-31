// This entire file is part of my masterpiece.
// Ethan Chang


package tests;

import static org.junit.Assert.*;


import java.util.List;

import main.ResourceFinder;

import org.junit.Test;

import commands.CommandFactory;
import commands.templates.Command;
import backEnd.Model;
import backEnd.Parser;
import backEnd.VariableManager;
import backEnd.turtle.Turtle;
import backEnd.turtle.TurtleManager;

public class MasterpieceTest {
    private CommandFactory myCommandFactory = new CommandFactory();
    private Parser myParser = new Parser(myCommandFactory);
    private Model myModel = new Model(myParser);
    private TurtleManager myTurtleManager;
    private VariableManager myVariableManager = new VariableManager();
    private ResourceFinder myResourceFinder = new ResourceFinder();
    
    @Test
    public void testTell () {
        myTurtleManager = new TurtleManager(800,800);
        myModel.setTurtleManager(myTurtleManager);
        List<Command> roots = myParser.parseScript("tell [ 1 2 3 ]", myModel, myVariableManager);
        for(Command root : roots ) {
            root.execute();
        }
        List<Turtle> turtles = myTurtleManager.getTurtleList(); 
        assertEquals(3, turtles.size());
        
        assertEquals("1.0", turtles.get(0).getId());
        assertEquals("2.0", turtles.get(1).getId());
        assertEquals("3.0", turtles.get(2).getId());

    }
    
}
