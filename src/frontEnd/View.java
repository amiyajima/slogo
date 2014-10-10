package frontEnd;

import java.io.File;
import java.util.Observable;
import java.util.Observer;

import javafx.application.HostServices;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import panels.PanelFactory;
import backEnd.Controller;

public class View implements Observer {

	private static final double WIDTH = 900;
	private static final double HEIGHT = 700;
	private static final double PADDING = 20;

	public TurtleCanvas myCanvas;

	private Stage myStage;
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

		myStage = stage;
		myStage.setTitle("SLogo");
		setupBorderPane();
		setupCanvas();
		setupMenuBar();
		setupGuiElements();

		Scene scene = new Scene(myBorderPane);
		myStage.setScene(scene);
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
		Menu menuhelp = new Menu("Help");

		menuedit.getItems().add(makeImageChooserMenuItem());
		menuhelp.getItems().add(makeCommandsPage());

		menubar.getMenus().addAll(menufile, menuedit, menuview, menuhelp);
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
		myCanvas = new TurtleCanvas(WIDTH, HEIGHT, PADDING, myController);
		myBorderPane.setCenter(myCanvas);
	}

	private MenuItem makeCommandsPage () {
//        MenuItem commands = new MenuItem("Possible commands");
//        HostServices hostService = getHostServices();
//        getHostServices().showDocument("http://www.yahoo.com");
        return null;
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

}
