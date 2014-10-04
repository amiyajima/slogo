package frontEnd;

import java.util.Observable;
import java.util.Observer;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import backEnd.Controller;

/**
 * A view that sets up the visual representation of our IDE. Sets up the GUI and
 * its elements.
 * 
 * @author Brian Bolze
 * @author Ethan Chang
 * @author Eli Lichtenberg
 * @author Anna Miyajima
 * 
 */
public class View implements Observer {

    private static final double WIDTH = 900;
    private static final double HEIGHT = 700;

    private BorderPane myBorderPane;
    private String myLanguage;
    private Controller myController;

    /**
     * Construct the View and set the language it is in.
     * 
     * @param language
     */
    public View (String language) {
        myLanguage = language;
    }

    /**
     * Done by Main at initiation
     */
    public void addController (Controller controller) {
        myController = controller;
    }

    /**
     * Called by Main after the controller is attached
     */
    public void setupGui (Stage stage) {

        setupBorderPane();
        setupGuiElements();

        Scene scene = new Scene(myBorderPane);
        stage.setScene(scene);
    }

    /**
     * Update the view whenever (observed) data changes in the model
     * 
     * @param arg
     *            The data that has been changed
     */
    @Override
    public void update (Observable o, Object arg) {

    }

    /**
     * Add panels to the scene
     */
    private void setupGuiElements () {
        // setupMenuBar();
        /*
         * More GUI setups here -- will move to PanelFactory later
         */
    }

    /**
     * Set up the border pane for the scene. 
     */
    private void setupBorderPane () {
        myBorderPane = new BorderPane();
        myBorderPane.setPrefSize(WIDTH, HEIGHT);
    }

}
