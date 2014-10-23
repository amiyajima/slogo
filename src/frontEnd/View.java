package frontEnd;

import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import javafx.scene.Node;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import panels.ParameterPanel;
import panels.ScriptPanel;
import backEnd.AbstractTurtle;
import backEnd.Controller;

public class View extends VBox implements Observer {
	
	public TurtleCanvas myCanvas; //MAKE THIS PRIVATE (look at controller)

	@SuppressWarnings("unused")
	private String myLanguage;
	private Controller myController;
	
	private double WIDTH, HEIGHT;
	private static final double PADDING = 20;
	private ParameterPanel mySidePanel;
	
	public View(double width, double height, String language) {
		super();
		
		myLanguage = language;
		
		WIDTH = width;
		HEIGHT = height;
		
		setMinWidth(WIDTH);
		setMinHeight(HEIGHT);
		setMaxWidth(WIDTH);
		setMaxHeight(HEIGHT);
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
	
	public void addToHistory(String script) {
		mySidePanel.addToHistory(script);
	}
	
	public void setupVariableMap(Map<String, Double> varMap) {
		mySidePanel.setupVariableMap(varMap);
	}
	
/////////////////  GUI SETUP  //////////////////
	private void setupGui() {
		
		HBox hbox = new HBox();
		hbox.setMinHeight(3.*HEIGHT/4.);
		hbox.setMinWidth(WIDTH);
		hbox.getChildren().addAll(buildCanvas(), buildSidePanel());
		
		getChildren().addAll(hbox, buildScriptPanel());
	}
	
	private Node buildCanvas() {
		myCanvas = new TurtleCanvas(3.*WIDTH/4., 3.*HEIGHT/4., PADDING, myController);
		return myCanvas;
	}
	
	private Node buildSidePanel() {
		mySidePanel = new ParameterPanel(WIDTH/4., 3.*HEIGHT/4., myController);
		return mySidePanel;
	}
	
	private Node buildScriptPanel() {
		return new ScriptPanel(WIDTH, HEIGHT/4., myController);
	}
	
}
