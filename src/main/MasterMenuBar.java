package main;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.ToggleGroup;

public class MasterMenuBar extends MenuBar {
	
	MasterWindow myMaster;

	public MasterMenuBar(MasterWindow master) {
		super();
		
		myMaster = master;
		
		Menu fileMenu = buildFileMenu();
		Menu editMenu = buildEditMenu();

		getMenus().addAll(fileMenu, editMenu);
		
	}
	
	private Menu buildFileMenu() {
		Menu menu = new Menu("File");
		menu.getItems().addAll(buildNewWorkspaceMenuItem());
		return menu;
	}

	private Menu buildEditMenu() {
		Menu menu = new Menu("Edit");
		menu.getItems().addAll(buildLanguageChooserMenuItem());
		return menu;
	}

	private MenuItem buildNewWorkspaceMenuItem() {
		MenuItem menu = new MenuItem("New Workspace");
		menu.setOnAction(event -> myMaster.buildWorkspace());
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
	
}
