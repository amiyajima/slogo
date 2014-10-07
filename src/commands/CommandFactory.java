package commands;


import java.util.ResourceBundle;


/**
 * This factory is part of the command pattern implementation.
 * It contains a method called buildCommand which takes in a 
 * String type and uses this String to create the type of command
 * requested.
 *
 */
public class CommandFactory {
    public static final String DEFAULT_RESOURCE_PACKAGE = "resources/";
    public static final ResourceBundle myCommandResources = 
            ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + "Commands");
    public static final String doubleRegex = "[-+]?[0-9]*\\.?[0-9]+([eE][-+]?[0-9]+)?";
    private ResourceBundle myLanguageResources;
    private String classKey;



    public CommandFactory (String language) {
        myLanguageResources = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE 
                + "languages/" + language);

    }

    
    private String checkLanguage(String type) {
        for(String s : myLanguageResources.keySet()) {
            String[] possibilities = myLanguageResources.getString(s).split(",");
            for(String possibility : possibilities) {
                if(type.equals(possibility)) {
                    classKey=s;
                    return possibility;
                }
            }
        }
        return null;
    }

    /**
     * 
     * @param type
     * @return
     */
    public Command buildCommand (String type) {
        if(checkLanguage(type) != null){
            try {
                Command newCommand = (Command) Class.forName
                        (myCommandResources.getString(classKey)).newInstance();
                System.out.println("hello");

                return newCommand;
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        
        else {
            try {
                Double constant = Double.parseDouble(type);
                return new ConstantCommand(type);

            } catch (NumberFormatException e2) {
                System.out.println("Not a double");
                return null;
            }
        }

        return null;
    }

}
