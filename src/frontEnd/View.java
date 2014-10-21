package frontEnd;

import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import javafx.scene.layout.BorderPane;
import panels.PanelFactory;
import panels.ParameterPanel;
import backEnd.AbstractTurtle;
import backEnd.Controller;

public class View implements Observer {

	private static final double WIDTH = 900;
	private static final double HEIGHT = 700;
	private static final double PADDING = 20;

	public TurtleCanvas myCanvas; //should NOT be public
	
	private Controller myController; //on here after merge conflict, not sure how used
	private String myLanguage; //on here after merge conflict, not sure how used

	private BorderPane myBorderPane;
	private PanelFactory myPanelFactory;
	private ParameterPanel myParameterPanel;
	
	public View(String language) {
		myLanguage = language;
	}

	/**
	 * Called by Controller constructor
	 */
	public void addControllerAndSetupGui(Controller controller) {
		myController = controller;
		setupGui();
	}
	
	/**
	 * Called by Controller constructor
	 */
	public void setupTurtleView(AbstractTurtle turtle) {
		myCanvas.addTurtle(turtle);
	}
	
	/**
	 * Called by Model when it sets up its turtle
	 */
	public double getCanvasWidth() {
		return myCanvas.getBoundingWidth();
	}
	
	public double getCanvasHeight() {
		return myCanvas.getBoundingHeight();
	}

	/**
	 * Update the view whenever (observed) data changes in the model
	 * 
	 * @param arg
	 *            The data that has been changed
	 */
	@Override
	public void update(Observable o, Object arg) {
		myCanvas.update(o, arg);
	}
	
	private void setupGui() {
		
		setupBorderPane();
		setupCanvas();
		setupGuiElements();

	}
	
	private void setupBorderPane() {
		myBorderPane = new BorderPane();
		myBorderPane.setPrefSize(WIDTH, HEIGHT);
	}
	
	private void setupCanvas() {
		myCanvas = new TurtleCanvas(WIDTH, HEIGHT, PADDING, myController);
		myBorderPane.setCenter(myCanvas);
	}

	private void setupGuiElements() {
		myPanelFactory = new PanelFactory();
		try {
			myPanelFactory.buildPanel("ScriptPanel", myBorderPane, myController); // built and not stored
			myParameterPanel = (ParameterPanel)myPanelFactory.buildPanel("ParameterPanel", myBorderPane, myController);
		} catch (Exception e) {
			e.printStackTrace();
			//other stuff
		}
		//myPanelFactory.buildAllPanels(myBorderPane, myController);
	}
	
	public void addToHistory(String script) {
		myParameterPanel.addToHistory(script);
	}
	
	public void setupVariableMap(Map<String, Double> varMap) {
		myParameterPanel.setupVariableMap(varMap);
	}

}
