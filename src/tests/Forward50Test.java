package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

import org.junit.Test;
import javafx.geometry.Point2D;

import commands.Command;
import commands.CommandFactory;
import backEnd.ScriptManager;
import backEnd.Turtle;

public class Forward50Test {

    @Test
    public void testScriptCompiled(){
        ScriptManager myScriptManager = new ScriptManager("forward 5+45");
        List<Command> myCommands = new ArrayList<Command>();
        Queue<Command> turtleCommands = myScriptManager.compileScript(myCommands);

        while(turtleCommands.size()>0){
            assertEquals(turtleCommands.poll(),"forward 50");
        }
    }

    @Test
    public void testCommandsProcessed(){
        Queue<Command> myCommands = new PriorityQueue<Command>();
        CommandFactory commandFactory = new CommandFactory();
      
        myCommands.add(commandFactory.buildCommand("forward 50"));
        Turtle myTurtle = new Turtle(new Point2D(0,0));
        myTurtle.executeCommands(myCommands);
        assertEquals(myTurtle.getTurtlePosition(),new Point2D(0,50));
    }
}
