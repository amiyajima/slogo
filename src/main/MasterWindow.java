package main;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
import javafx.util.Duration;
import frontEnd.Workspace;

public class MasterWindow extends Application {

	private Pane root;
	private TabPane tabs;
	private MenuBar menubar;

	static public void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		root = new VBox();
		buildTabPane();
		buildMenuBar();

		root.getChildren().addAll(menubar, tabs);

		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("SLogo");
		primaryStage.show();
	}

	public void buildWorkspace() {
		Tab tab = new Tab("Workspace " + (tabs.getTabs().size() + 1));
		tab.setContent(new Workspace());
		
		// Model model = new Model();
		// View view = new View("English", stage);
		// new Controller(model, view);

		tabs.getTabs().add(tab);
	}

	private void buildTabPane() {
		tabs = new TabPane();
		buildWorkspace();
		buildTabSelector();
	}

	private void buildMenuBar() {
		menubar = new MenuBar();

		Menu fileMenu = buildFileMenu();
		Menu editMenu = buildEditMenu();

		menubar.getMenus().addAll(fileMenu, editMenu);
	}

	private Menu buildFileMenu() {
		Menu menu = new Menu("File");
		menu.getItems().addAll(buildNewWorkspaceMenuItem());
		return menu;
	}

	private Menu buildEditMenu() {
		Menu menu = new Menu("Edit");
		menu.getItems().addAll(buildImageChooserMenuItem());
		return menu;
	}

	private MenuItem buildNewWorkspaceMenuItem() {

		MenuItem menu = new MenuItem("New Workspace");

		menu.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				buildWorkspace();
			};
		});

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

		// menu.setOnAction(new EventHandler<ActionEvent>() {
		// @Override
		// public void handle(ActionEvent e) {
		// File file = fileChooser.showOpenDialog(myStage);
		// if (file != null) {
		// myController.changeTurtleImage(file);
		// }
		// };
		// });

		return menu;
	}
	
	private void switchTab(Tab tab) {
		tab.getContent().requestFocus();
		// Change the model/controllers focus + preferences??
	}

	/**
	 * @author Brian Bolze 
	 * NOTE - The basic model of this code was based off of
	 *         some code on StackOverflow.com here:
	 *         http://stackoverflow.com/questions/
	 *         19025268/javafx-tabpane-switch-
	 *         tabs-only-when-focused/19046535#19046535
	 */
	private void buildTabSelector() {

		// Change the focus of the scene to the selected tab (for UI elements)
		tabs.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
					@Override
					public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
						Platform.runLater(new Runnable() {
							@Override
							public void run() {
								if (tabs.getTabs().size() > 0) {
									final Tab selectedTab = tabs.getTabs().get(newValue.intValue());
									
									final Timeline animation = new Timeline(
										new KeyFrame(Duration.millis(25), 
										new EventHandler<ActionEvent>() {
											@Override
											public void handle(ActionEvent event) {
												switchTab(selectedTab);
											}
										})	
									);	
									animation.setCycleCount(1);
									animation.play();
									
								}
							}
								
		});}});

	}

}
