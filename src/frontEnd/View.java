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
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import panels.PanelFactory;
import panels.ParameterPanel;
import panels.ScriptPanel;
import backEnd.AbstractTurtle;
import backEnd.Controller;

public class View implements Observer {

	private static final double WIDTH = 900;
	private static final double HEIGHT = 700;
	private static final double PADDING = 20;

	public TurtleCanvas myCanvas;
	public Stage myStage;
	
	private BorderPane myBorderPane;
	private PanelFactory myPanelFactory;
	private String myLanguage;
	private Controller myController;
	private ScriptPanel myScriptPanel;
	private ParameterPanel myParameterPanel;
	
	public View(String language) {
		myLanguage = language;
	}

	/**
	 * Done by Main at initiation
	 */
	public void addController(Controller controller) {
		myController = controller;
	}

	/**
	 * Called by Main after the controller is attached
	 */
	public void setupGui(Stage stage) {

		myStage = stage;
		myStage.setTitle("SLogo");
		setupBorderPane();
		setupCanvas();
		setupMenuBar();
		setupGuiElements();

		Scene scene = new Scene(myBorderPane);
		makeKeyListeners(scene);
		myStage.setScene(scene);
	}
	
	public void setupTurtleView(AbstractTurtle turtle) {
		myCanvas.addTurtle(turtle);
	}
	
	public double getCanvasWidth() {
		return myCanvas.boundingWidth;
	}
	
	public double getCanvasHeight() {
		return myCanvas.boundingHeight;
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

	private void setupMenuBar() {
		MenuBar menubar = new MenuBar();

		Menu menufile = new Menu("File");
		Menu menuedit = new Menu("Edit");
		Menu menuview = new Menu("View");

		menuedit.getItems().add(makeImageChooserMenuItem());

		menubar.getMenus().addAll(menufile, menuedit, menuview);
		myBorderPane.setTop(menubar);
	}

	private void setupGuiElements() {
		myPanelFactory = new PanelFactory();
		try {
		myScriptPanel = (ScriptPanel)myPanelFactory.buildPanel("ScriptPanel", myBorderPane, myController);
		myParameterPanel = (ParameterPanel)myPanelFactory.buildPanel("ParameterPanel", myBorderPane, myController);
		} catch (Exception e) {
			e.printStackTrace();
			//other stuff
		}
		//myPanelFactory.buildAllPanels(myBorderPane, myController);
	}
	
	

	private void setupBorderPane() {
		myBorderPane = new BorderPane();
		myBorderPane.setPrefSize(WIDTH, HEIGHT);
	}

	private void setupCanvas() {
		myCanvas = new TurtleCanvas(WIDTH, HEIGHT, PADDING, myController);
		myBorderPane.setCenter(myCanvas);
	}
	
	private void makeKeyListeners(Scene scene) {
		EventHandler<KeyEvent> keyPressListener = new EventHandler<KeyEvent>() {
			
			@Override
			public void handle(KeyEvent event) {
				System.out.println("key pressed");
				if (event.getCode() == KeyCode.UP) {
					try {
						myController.runScript("forward 10");
					} catch (Exception e) {
						System.out.println(e.toString());
					}
				}
				if (event.getCode() == KeyCode.DOWN) {
					try {
						myController.runScript("back 10");
					} catch (Exception e) {
						System.out.println(e.toString());
					}
				}
				if (event.getCode() == KeyCode.RIGHT) {
					try {
						myController.runScript("right 10");
					} catch (Exception e) {
						System.out.println(e.toString());
					}
				}
				if (event.getCode() == KeyCode.LEFT) {
					try {
						myController.runScript("left 10");
					} catch (Exception e) {
						System.out.println(e.toString());
					}
				}
			}
		};
		
		scene.setOnKeyPressed(keyPressListener);
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
	
	public void addToHistory(String script) {
		myParameterPanel.addToHistory(script);
	}
	
	public void setupVariableMap(Map<String, Double> varMap) {
		myParameterPanel.setupVariableMap(varMap);
	}

}
