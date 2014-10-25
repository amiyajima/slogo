package main;

import java.io.File;

import commands.CommandFactory;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import frontEnd.Workspace;
import backEnd.Parser;

public class MasterWindow extends Application {
	
	public Workspace currentWorkspace;
	
	private Stage stage;
	private Scene scene;
	private Pane root = new VBox();
	private TabPane tabs = new TabPane();
	private MenuBar menubar;
	private CommandFactory myCommandFactory;
	private Parser myParser;

	static public void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
	
		buildMenuBar();
		root.getChildren().addAll(menubar, tabs);
		scene = new Scene(root);
		myCommandFactory = new CommandFactory("english");
        myParser = new Parser(myCommandFactory);

		
		buildWorkspace();
		
		stage = primaryStage;
		stage.setScene(scene);
		stage.setTitle("SLogo");
		stage.show();
	}

	private void buildWorkspace() {
		
		currentWorkspace = new Workspace(myParser);
		setKeyListener();
		setMouseListener();
		
		Tab tab = new Tab("Workspace " + (tabs.getTabs().size() + 1));
		tab.setContent(currentWorkspace);
		tab.getContent().setFocusTraversable(true);
		tab.setOnSelectionChanged(event -> tabChanged(tab));
		
		tabs.getTabs().add(tab);
		tabs.getSelectionModel().select(tab);

	}
	
	private void tabChanged(Tab tab) {
		if (tab.isSelected()) {
			tab.getContent().requestFocus();
			currentWorkspace = (Workspace) tab.getContent();
			setKeyListener();
		}
	}
	
	private void setKeyListener() {
		scene.setOnKeyReleased(currentWorkspace.getKeyListener());
	}
	
	private void setMouseListener() {
		scene.setOnMouseClicked(currentWorkspace.getMouseListener());
	}

/////////////////////// MENU STUFF ////////////////////////
	/*
	 * TODO EXTRACT out all of this MenuBar stuff into its own class
	 */
	private void buildMenuBar() {
		menubar = new MenuBar();

		Menu fileMenu = buildFileMenu();
		Menu editMenu = buildEditMenu();

		menubar.getMenus().addAll(fileMenu, editMenu);
	}

	private Menu buildFileMenu() {
		Menu menu = new Menu("File");
		menu.getItems().add(buildNewWorkspaceMenuItem());
		return menu;
	}

	private Menu buildEditMenu() {
		Menu menu = new Menu("Edit");
		menu.getItems().add(buildImageChooserMenuItem());
		return menu;
	}

	private MenuItem buildNewWorkspaceMenuItem() {
		MenuItem menu = new MenuItem("New Workspace");
		menu.setOnAction(event -> buildWorkspace());
		return menu;
	}

	private MenuItem buildImageChooserMenuItem() {

		MenuItem menu = new MenuItem("Change Turtle Image");

		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Upload Image");
		fileChooser.getExtensionFilters().addAll(
				new FileChooser.ExtensionFilter("All Images", "*.*"),
				new FileChooser.ExtensionFilter("JPG", "*.jpg"),
				new FileChooser.ExtensionFilter("PNG", "*.png"));

		menu.setOnAction(event -> turtleImageFileChooser(fileChooser));

		return menu;
	}
	
	private void turtleImageFileChooser(FileChooser fileChooser) {
		File file = fileChooser.showOpenDialog(stage);
		if (file != null) {
			//myController.changeTurtleImage(file);
		}
	}

}
