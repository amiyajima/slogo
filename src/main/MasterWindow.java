package main;

import java.io.File;

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
import backEnd.Model;
import frontEnd.Workspace;

public class MasterWindow extends Application {
	
	public Model model; // ONLY ONE MODEL FOR THE WHOLE APPLICATION   (maybe...)
	public Workspace currentWorkspace;
	
	private Stage stage;
	private Scene scene;
	private Pane root = new VBox();
	private TabPane tabs = new TabPane();
	private MenuBar menubar;

	static public void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		stage = primaryStage;	
		buildMenuBar();
		root.getChildren().addAll(menubar, tabs);
		scene = new Scene(root);
		
		model = new Model();
		System.out.println(tabs.getOnKeyPressed());
		buildWorkspace();
		
		stage.setScene(scene);
		stage.setTitle("SLogo");
		stage.show();
	}

	private void buildWorkspace() {
		
		currentWorkspace = new Workspace(model);
		setKeyListener();
		
		Tab tab = new Tab("Workspace " + (tabs.getTabs().size() + 1));
		tab.setContent(currentWorkspace);
		tab.getContent().setFocusTraversable(true);
		tab.setOnSelectionChanged(event -> tabChanged(tab));
		
		tabs.getTabs().add(tab);

	}
	
	private void tabChanged(Tab tab) {
		if (tab.isSelected()) {
			System.out.println("Tab changed");
			tab.getContent().requestFocus();
			currentWorkspace = (Workspace) tab.getContent();
			setKeyListener();
		}
		
		// Change the model/view preferences + connections
		/* 
		 * Pseudocode:
		 * 
		 * model.updateState(currentWorkspace.getState());
		 * bindProperties(currentWorkspace, model);
		 */
		
	}
	
	private void setKeyListener() {
		scene.setOnKeyReleased(currentWorkspace.getKeyListener());
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
