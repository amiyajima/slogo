package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import commands.Command;
import commands.CommandFactory;
import commands.ConstantCommand;

public class FactoryTest {

    @Test
    public void constantCreation () {
        CommandFactory commandFactory = new CommandFactory("English");
        Command command = commandFactory.buildCommand("52");
        assertEquals(command.toString(), "52");
    }
    
    @Test
    public void forwardCommand() {
        CommandFactory commandFactory = new CommandFactory("English");
        Command command = commandFactory.buildCommand("forward");
        command.addChild(new ConstantCommand("5"));
        assertEquals(String.valueOf(command.execute()), "5.0");
    }

}
