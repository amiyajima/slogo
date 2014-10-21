package frontEnd;

import java.io.File;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import panels.PanelFactory;
import panels.ParameterPanel;
import backEnd.AbstractTurtle;
import backEnd.Controller;

public class View implements Observer {

	private static final double WIDTH = 900;
	private static final double HEIGHT = 700;
	private static final double PADDING = 20;

	public TurtleCanvas myCanvas; //should NOT be public

	private Stage myStage;
	
	private Controller myController; //on here after merge conflict, not sure how used
	private String myLanguage; //on here after merge conflict, not sure how used
	private TabPane myTabPane; //on here after merge conflict, not sure how used
	private Tab myRootTab; //on here after merge conflict, not sure how used

	private BorderPane myBorderPane;
	private PanelFactory myPanelFactory;
	private ParameterPanel myParameterPanel;
	
	public View(String language, Stage stage) {
		myLanguage = language;
		myStage = stage;
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

		myStage.setTitle("SLogo");
		myRootTab = new Tab("Workspace 1");
		myTabPane = new TabPane();
		myTabPane.getTabs().add(myRootTab);
		
		setupBorderPane();
		setupCanvas();
		setupMenuBar();
		setupGuiElements();

		Scene scene = new Scene(myTabPane);
		myStage.setScene(scene);
		myStage.show();
	}
	
	private void setupBorderPane() {
		myBorderPane = new BorderPane();
		myBorderPane.setPrefSize(WIDTH, HEIGHT);
		myRootTab.setContent(myBorderPane);
	}
	
	private void setupCanvas() {
		myCanvas = new TurtleCanvas(WIDTH, HEIGHT, PADDING, myController);
		myBorderPane.setCenter(myCanvas);
	}

	private void setupMenuBar() {
		MenuBar menubar = new MenuBar();

		Menu menufile = new Menu("File");
		Menu menuedit = new Menu("Edit");
		Menu menuview = new Menu("View");

		menufile.getItems().add(makeNewWorkspaceMenuItem());
		menuedit.getItems().add(makeImageChooserMenuItem());

		menubar.getMenus().addAll(menufile, menuedit, menuview);
		myBorderPane.setTop(menubar);
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

	private MenuItem makeImageChooserMenuItem() {

		MenuItem menu = new MenuItem("Change Turtle Image");

		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Upload Image");
		fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("All Images", "*.*"),
                new FileChooser.ExtensionFilter("JPG", "*.jpg"),
                new FileChooser.ExtensionFilter("PNG", "*.png")
            );

		menu.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				File file = fileChooser.showOpenDialog(myStage);
				if (file != null) {
					myController.changeTurtleImage(file);
				}
			};
		});

		return menu;
	}
	
	private MenuItem makeNewWorkspaceMenuItem() {

		MenuItem menu = new MenuItem("New Workspace");

		menu.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				Tab tab = new Tab("Workspace 2");
				myTabPane.getTabs().add(tab);
			};
		});

		return menu;
	}
	
	public void addToHistory(String script) {
		myParameterPanel.addToHistory(script);
	}
	
	public void setupVariableMap(Map<String, Double> varMap) {
		myParameterPanel.setupVariableMap(varMap);
	}

}
