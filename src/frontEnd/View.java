package frontEnd;

import java.util.Observable;
import java.util.Observer;

import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import panels.PanelFactory;
import backEnd.Controller;


public class View implements Observer {
	
	private static final double WIDTH = 900;
	private static final double HEIGHT = 700;
	
	public TurtleCanvas myCanvas;
	
	private BorderPane myBorderPane;
	private PanelFactory myPanelFactory;
	private String myLanguage;
	private Controller myController;
	
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
		
		stage.setTitle("SLogo");
		setupBorderPane();
		setupCanvas();
		setupMenuBar();
		setupGuiElements();	
		
		Scene scene = new Scene(myBorderPane);
		stage.setScene(scene);
	}

	/**
	 * Update the view whenever (observed) data changes in the model
	 * @param  arg  The data that has been changed
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
		
		menubar.getMenus().addAll(menufile, menuedit, menuview);
		myBorderPane.setTop(menubar);
	}
	
	private void setupGuiElements() {	
		myPanelFactory = new PanelFactory();
		myPanelFactory.buildAllPanels(myBorderPane, myController);
	}
	
	private void setupBorderPane() {
		myBorderPane = new BorderPane();
		myBorderPane.setPrefSize(WIDTH, HEIGHT);
	}
	
	private void setupCanvas() {
		myCanvas = new TurtleCanvas(WIDTH, HEIGHT, myController);
		myBorderPane.setCenter(myCanvas);
	}

}
