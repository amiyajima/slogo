package main;

import java.io.File;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import backEnd.Parser;

import commands.CommandFactory;

import frontEnd.Workspace;

/**
 * Effectively the 'Main' class for our application. This sets up the global
 * Parser and Command Factory and sets up the main window
 * 
 * @author Brian Bolze
 *
 */
public class MasterWindow extends Application {

	public static Parser myParser = new Parser();
	public static CommandFactory myCommandFactory = new CommandFactory();
	
	private Stage myStage;
	private Scene myScene;
	public Workspace myCurrentWorkspace;
	private MenuBar myMenuBar;
	private Pane myRoot = new VBox();
	private TabPane myTabs = new TabPane();

	static public void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		myScene = new Scene(myRoot);
		myStage = primaryStage;
		myStage.setScene(myScene);
		myStage.setTitle("SLogo");

		new ResourceFinder("English");
		myCommandFactory = new CommandFactory();
		myParser = new Parser();
		myMenuBar = new MasterMenuBar(this);
		myRoot.getChildren().addAll(myMenuBar, myTabs);

		buildWorkspace();

		myStage.show();
	}

	/**
	 * Called by MasterMenuBar when a new tab is created. This sets the focus to
	 * the new workspace and sets the mouse and key listeners to the appropriate
	 * workspace
	 */
	void buildWorkspace() {
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

	void saveWorkspacePreferences(File file) {
		myCurrentWorkspace.savePropertiesToFile(file);
	}

	void loadWorkspacePreferences(File file) {
		myCurrentWorkspace.loadPropertiesFromFile(file);
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
}
