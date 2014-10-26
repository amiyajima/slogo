package main;

import java.io.File;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import backEnd.Parser;

import commands.CommandFactory;

import frontEnd.Workspace;

public class MasterWindow extends Application {
	
	private Stage myStage;
	private Scene myScene;

	private Parser myParser;
	private Workspace myCurrentWorkspace;
	private CommandFactory myCommandFactory;
	
	private Pane myRoot = new VBox();
	private TabPane myTabs = new TabPane();
	private MenuBar myMenuBar;

	static public void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
	
		new ResourceFinder("English");
		
		buildMenuBar();
		myRoot.getChildren().addAll(myMenuBar, myTabs);
		
		myScene = new Scene(myRoot);
		
		myCommandFactory = new CommandFactory();
        myParser = new Parser(myCommandFactory);

		
		buildWorkspace();
		
		myStage = primaryStage;
		myStage.setScene(myScene);
		myStage.setTitle("SLogo");
		myStage.show();
	}

	private void buildWorkspace() {
		
		myCurrentWorkspace = new Workspace(myParser);
		setKeyListener();
		setMouseListener();
		
		Tab tab = new Tab("Workspace " + (myTabs.getTabs().size() + 1));
		
		tab.setContent(myCurrentWorkspace);
		tab.getContent().setFocusTraversable(true);
		tab.setOnSelectionChanged(event -> tabChanged(tab));
		
		myTabs.getTabs().add(tab);
		myTabs.getSelectionModel().select(tab);

	}
	
	private void tabChanged(Tab tab) {
		if (tab.isSelected()) {
			tab.getContent().requestFocus();
			myCurrentWorkspace = (Workspace) tab.getContent();
			setKeyListener();
		}
	}
	
	private void setKeyListener() {
		myScene.setOnKeyReleased(myCurrentWorkspace.getKeyListener());
	}
	
	private void setMouseListener() {
		myScene.setOnMouseClicked(myCurrentWorkspace.getMouseListener());
	}

/////////////////////// MENU STUFF ////////////////////////
	/*
	 * TODO EXTRACT out all of this MenuBar stuff into its own class
	 */
	private void buildMenuBar() {
		myMenuBar = new MenuBar();

		Menu fileMenu = buildFileMenu();
		Menu editMenu = buildEditMenu();

		myMenuBar.getMenus().addAll(fileMenu, editMenu);
	}

	private Menu buildFileMenu() {
		Menu menu = new Menu("File");
		menu.getItems().addAll(buildNewWorkspaceMenuItem());
		return menu;
	}

	private Menu buildEditMenu() {
		Menu menu = new Menu("Edit");
		menu.getItems().addAll(buildImageChooserMenuItem(), buildLanguageChooserMenuItem());
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
	
	private Menu buildLanguageChooserMenuItem() {
		Menu menu = new Menu("Change Language");

		final ToggleGroup languageSelector = new ToggleGroup();
		for (String language : ResourceFinder.getPossibleLanguages()) {
		    RadioMenuItem itemEffect = new RadioMenuItem(language);
		    itemEffect.setUserData(language);
		    itemEffect.setToggleGroup(languageSelector);
		    if (language.equals("English")) itemEffect.setSelected(true);
		    menu.getItems().add(itemEffect);
		    itemEffect.setOnAction(event -> setLanguage((String) itemEffect.getUserData()));
		}
		
		return menu;
	}
	
	private void setLanguage(String s) {
		ResourceFinder.setLanguage(s);
	}
	
	private void turtleImageFileChooser(FileChooser fileChooser) {
		File file = fileChooser.showOpenDialog(myStage);
		if (file != null) {
			//myController.changeTurtleImage(file);
		}
	}

}
