package backEnd;

import frontEnd.View;

/**
 * A controller that instantiates the model and view and serves as a bridge
 * between the front end and back end. Also sends script inputs from the view to
 * the model.
 * 
 * The controller also adds the view as an observer for the turtle so that
 * turtle location values are updated in the view.
 * 
 * 
 * @author Brian Bolze
 * @author Ethan Chang
 * @author Eli Lichtenberg
 * @author Anna Miyajima
 * 
 */
public class Controller {

    private Model myModel;
    private View myView;

    /**
     * Creates the model and view and makes the view observe the turtle.
     */
    public Controller (Model model, View view) {
        myModel = model;
        myView = view;
        myModel.setTurtleObserver(view);
    }

    /**
     * Sends input from the view to the model if it is not null
     */
    public void runScript (String script) {
        if (script != null) {
            myModel.runScript(script);
        }
    }

}
