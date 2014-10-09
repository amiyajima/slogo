package tests;

import static org.junit.Assert.*;
import org.junit.Test;
import backEnd.Model;
import commands.Command;
import commands.CommandFactory;
import commands.ConstantCommand;


public class FactoryTest {
    private Model myModel = new Model();

    @Test
    public void constantCreation () {
        CommandFactory commandFactory = new CommandFactory("English", myModel);
        Command command = commandFactory.buildCommand("52");
        assertEquals(command.toString(), "52");
    }

    @Test
    public void forwardCommand () {
        CommandFactory commandFactory = new CommandFactory("English", myModel);
        Command command = commandFactory.buildCommand("forward");
        command.addChild(commandFactory.buildCommand("5"));
        assertEquals(String.valueOf(command.execute()), "5.0");
    }

    @Test
    public void testCaps () {
        CommandFactory commandFactory = new CommandFactory("English", myModel);
        String lowerCase = commandFactory.checkCaps("EnGlIsh");
        assertEquals(lowerCase, "english");        
    }
}
