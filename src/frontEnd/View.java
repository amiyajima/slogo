package frontEnd;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.scene.Node;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import panels.ParameterPanel;
import panels.ScriptPanel;
import backEnd.Controller;

public class View extends VBox implements Observer {
	
	@SuppressWarnings("unused")
	private String myLanguage;
	private Controller myController;
	private TurtleCanvas myCanvas;
	
	private double myWidth, myHeight;
	private static final double PADDING = 20;
	private ParameterPanel mySidePanel;
	private ScriptPanel myScriptPanel;
	
	public View(double width, double height, String language) {
		super();
		
		myLanguage = language;	
		myWidth = width;
		myHeight = height;

	}

	/**
	 * Called by Controller constructor
	 */
	public void addControllerAndSetupGui(Controller controller) {
		myController = controller;
		setupGui();
	}
	
	public void printException(Exception e) {
		myScriptPanel.printException(e);
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
		hbox.setMinHeight(3.*myHeight/4.);
		hbox.setMinWidth(myWidth);
		hbox.getChildren().addAll(buildCanvas(), buildSidePanel());
		
		getChildren().addAll(hbox, buildScriptPanel());
	}
	
	private Node buildCanvas() {
		myCanvas = new TurtleCanvas(3.*myWidth/4., 3.*myHeight/4., PADDING, myController);
		return myCanvas;
	}
	
	private Node buildSidePanel() {
		mySidePanel = new ParameterPanel(myWidth/4., 3.*myHeight/4., myController);
		return mySidePanel;
	}
	
	private Node buildScriptPanel() {
		myScriptPanel = new ScriptPanel(myWidth, myHeight/4., myController);
		return myScriptPanel;
	}

	public void changeBackgroundColor(Color c) {
		myCanvas.changeBackgroundColor(c);
	}

	public void changePenColor(Color c) {
		myCanvas.changePenColor(c);
	}

	public void changeTurtleImage(File f) {
		myCanvas.changeTurtleImage(f);
	}

	public void toggleGridLines() {
		myCanvas.toggleGridLines();
	}
	
	public void bindToModelProperties (DoubleProperty backgroundIndex) {
		myCanvas.bindToModelProperties(backgroundIndex);
	}
}
