package backEnd;

import java.util.List;
import commands.Command;


public class CommandTree {
    private Command root;
    List<Command> children;
    Command current;

    public CommandTree () {
        root = null;
        // create null command object?
    }

    public void addNode (Command c) {
        if (root == null) {
            root = c;
        }
        else {
            addNode(current, c);
        }
    }

    private void addNode (Command current, Command c) {
        if (current.getCurrentNumChildren() < current.getMaxNumChildren()) {
            c.setParent(current);
            current.addChild(c);
            current = c;
        }
        else {
            addNode(current.getParent(), c);
        }
    }
}
