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
		myScene = new Scene(myRoot);
		myStage = primaryStage;
		myStage.setScene(myScene);
		myStage.setTitle("SLogo");
		new ResourceFinder("English");
		myMenuBar = new MasterMenuBar(this);
		myRoot.getChildren().addAll(myMenuBar, myTabs);
		myCommandFactory = new CommandFactory();
        myParser = new Parser(myCommandFactory);
		buildWorkspace();
		myStage.show();
	}

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
		myCurrentWorkspace.writePropertiesToFile(file);
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
