package commands;

/**
 * This factory is part of the command pattern implementation.
 * It contains a method called buildCommand which takes in a
 * String type and uses this String to create the type of command
 * requested.
 *
 */
public class NodeFactory {

    public NodeFactory () {
    }

    public void checkLanguages () {
        // for each language in the list, language.getString("command in english")
    }

    /**
     * 
     * @param type
     * @return
     */
    public Command buildCommand (String type) {
        if (type.equals("forward")) {
            return  new ForwardCommand();
        }
        if (type.equals("50")) {
            
            return null;
        }
        else return null;
    }

}
