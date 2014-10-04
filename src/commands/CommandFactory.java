package commands;

public class CommandFactory {

    public CommandFactory () {
    }
    
    public void checkLanguages(){
        //for each language in the list, language.getString("command in english")
    }

    /**
     * 
     * @param type
     * @return
     */
    public Command buildCommand (String type) {
        Command newCommand = new ForwardCommand();
        return null;
    }

}
