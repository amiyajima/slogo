package frontEnd;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.Node;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import panels.ParameterPanel;
import panels.ScriptPanel;
import backEnd.Controller;

/**
 * View for SLogo. Holds a canvas for the graphical representations of turtles
 * and other GUI elements.
 * 
 * @author Brian Bolze
 * @author Ethan Chang
 * @author Eli Lichtenberg
 * @author Anna Miyajima
 *
 */
public class View extends VBox implements Observer {
	
	private static final double GUI_CONSTANT = .75;
	private static final double PADDING = 20;
	@SuppressWarnings("unused")
	private String myLanguage;
	private Controller myController;
	private TurtleCanvas myCanvas;
	
	private double myWidth;
	private double myHeight;
	
	private ParameterPanel mySidePanel;
	private ScriptPanel myScriptPanel;
	
	/**
	 * Constructor for view. Sets the language, height, and width of the GUI.
	 * @param width Width of GUI
	 * @param height Height of GUI
	 * @param language Langugage in which commands will be read
	 */
	public View (double width, double height, String language) {
		super();
		
		myLanguage = language;	
		myWidth = width;
		myHeight = height;

	}

	/**
	 * Called by Controller constructor
	 */
	public void addControllerAndSetupGui (Controller controller) {
		myController = controller;
		setupGui();
	}
	
	/**
	 * Prints exception to GUI.
	 * @param e Exception
	 */
	public void printException (Exception e) {
		myScriptPanel.printException(e);
	}
	
	/**
	 * Returns width of the view's canvas.
	 * @return Width of canvas
	 */
	public double getCanvasWidth () {
		return myCanvas.getBoundingWidth();
	}
	
	/**
	 * Returns height of the view's canvas.
	 * @return Height of canvas
	 */
	public double getCanvasHeight () {
		return myCanvas.getBoundingHeight();
	}

	/**
	 * Update the view whenever (observed) data changes in the model.
	 * 
	 * @param arg
	 *            The data that has been changed
	 */
	@Override
	public void update (Observable o, Object arg) {
		try {
			myCanvas.update(o, arg);
		} 
		catch (IOException e) {
			printException(e);
		}
	}
	
	/**
	 * Adds the most recently run script to the view's log of past commands.
	 * @param script Most recently run script
	 */
	public void addToHistory (String script) {
		mySidePanel.addToHistory(script);
	}
	
	/**
	 * Adds text to the view's script panel.
	 * @param command Command to add to script panel
	 */
	public void addTextToScript (String command) {
		myScriptPanel.addTextToScript(command);
	}
	
/////////////////  GUI SETUP  //////////////////
	private void setupGui () {
		
		HBox hbox = new HBox();
		hbox.setMinHeight(myHeight * GUI_CONSTANT);
		hbox.setMinWidth(myWidth);
		hbox.getChildren().addAll(buildCanvas(), buildSidePanel());
		
		getChildren().addAll(hbox, buildScriptPanel());
	}
	
	private Node buildCanvas () {
		try {
			myCanvas = new TurtleCanvas(myWidth * GUI_CONSTANT, 
					myHeight * GUI_CONSTANT, PADDING);
		} 
		catch (IOException e) {
			printException(e);
		}
		return myCanvas;
	}
	
	private Node buildSidePanel () {
		try {
			mySidePanel = new ParameterPanel(myWidth / 4., 
					myHeight * GUI_CONSTANT, myController);
		} 
		catch (IOException e) {
			printException(e);
		}
		return mySidePanel;
	}
	
	private Node buildScriptPanel () {
		myScriptPanel = new ScriptPanel(myWidth, myHeight / 4., myController);
		return myScriptPanel;
	}

	/**
	 * Changes background color of canvas.
	 * @param c Color to change background of canvas
	 */
	public void changeBackgroundColor (Color c) {
		myCanvas.changeBackgroundColor(c);
	}

	/**
	 * Changes color of pen.
	 * @param c Color by which to change pen
	 */
	public void changePenColor (Color c) {
		myCanvas.changePenColor(c);
	}
	
	/**
	 * Changes image of turtle on canvas.
	 * @param f File holding image of turtle
	 */
	public void changeTurtleImage (File f) {
		myCanvas.changeTurtleImage(f);
	}

	/**
	 * Turns on grid lines if previously off, turns off if previously on.
	 */
	public void toggleGridLines () {
		myCanvas.toggleGridLines();
	}
	
	/**
	 * Binds properties between model and view needed to properly display view.
	 * @param backgroundIndex Number representing background color from list of colors
	 * @param palette Wrapped String representing user inputted color
	 */
	public void bindToModelProperties (DoubleProperty backgroundIndex, StringProperty palette) {
		myCanvas.bindToModelProperties(backgroundIndex, palette);
	}
	
	/**
	 * Updates the variables being displayed by the variables pane in the side bar.
	 */
	public void updateVariables () {
		try {
			mySidePanel.updateVariables();
		} 
		catch (IOException e) {
			printException(e);
		}
	}

	/**
	 * Returns background color of canvas represented as String.
	 * @return Background color of canvas
	 */
	public String getBackgroundColor () {
		return myCanvas.getBackgroundColor();
	}
}
