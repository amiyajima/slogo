package backEnd;

import java.util.List;
import commands.Command;

public class CommandTree {
    private Command root;
    List<Command> children;
    private Command current;

    public CommandTree () {
        root = null;
        //create null command object?
    }
    
    public void addNode(Command c){
       
    }
    
}
