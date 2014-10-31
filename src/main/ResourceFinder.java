package main;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Used to get the ResourceBundles for the language and the command list. Called
 * by MasterWindow to set up and change languages, and by the CommandFactory and
 * others to get the names of the commands and more
 * 
 * @author brianbolze
 *
 */
public class ResourceFinder {

	private static final String DEFAULT_RESOURCE_PACKAGE = "resources/";
	private static final String DEFAULT_LANGUAGE = "English";
	private static final ResourceBundle MY_COMMAND_RESOURCES = ResourceBundle
			.getBundle("resources/Commands");
	private static final ResourceBundle MY_VARIABLE_RESOURCES = ResourceBundle
			.getBundle("resources/Variables");
	private static final ResourceBundle MY_POSSIBLE_LANGUAGES_RESOURCES = ResourceBundle
			.getBundle("resources/languages/Languages");

	private static ResourceBundle myLanguageResources;

	public ResourceFinder() {
		this(DEFAULT_LANGUAGE);
	}

	public ResourceFinder(String language) {
		setMyLanguageResources(language);
	}

	public static ResourceBundle getMyLanguageResources() {
		return myLanguageResources;
	}

	public static ResourceBundle getMyCommandResources() {
		return MY_COMMAND_RESOURCES;
	}

	public static void setLanguage(String language) {
		setMyLanguageResources(language);
	}

	public static List<String> getPossibleLanguages() {
		
		List<String> list = new ArrayList<String>();
		
		for (String s : MY_POSSIBLE_LANGUAGES_RESOURCES.keySet()) {
			list.add(MY_POSSIBLE_LANGUAGES_RESOURCES.getString(s));
		}
		
		return list;
	}

	private static void setMyLanguageResources(String language) {
		myLanguageResources = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE
				+ "languages/" + language);
	}

}
