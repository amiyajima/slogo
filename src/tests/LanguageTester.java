package tests;

import main.ResourceFinder;

public class LanguageTester {

//	private static ResourceBundle rb;
//
//	private static final String LANGUAGE = "French";
//	private static final String DEFAULT_RESOURCE_PACKAGE = "resources/";	

	public static void main(String[] args) {
		//openFile(DEFAULT_RESOURCE_PACKAGE + LANGUAGE + ".properties");
		for (String s : ResourceFinder.getPossibleLanguages()) {
			System.out.println(s);
		}
	}

	public LanguageTester() {
		
	}

//	private static void openFile(String s) {
//		rb = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + "languages/"
//				+ LANGUAGE);
//		if (rb.containsKey("Forward")) {
//			System.out.println(rb.getString("Forward"));
//		}
//		
//	}

}
