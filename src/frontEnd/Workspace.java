package frontEnd;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import backEnd.Controller;
import backEnd.Model;
import backEnd.Parser;

public class Workspace extends VBox {

	public Properties myDisplayProperties;

	private Model myModel;
	private View myView;
	private Controller myController;

	private double myWidth = 900;
	private double myHeight = 600;

	private static final Properties DEFAULT_DISPLAY_PROPERTIES = new Properties();

	public Workspace(Parser parser) {
		this(DEFAULT_DISPLAY_PROPERTIES, parser);
	}

	public Workspace(Properties preferences, Parser parser) {

		myDisplayProperties = preferences;

		setMinWidth(myHeight);
		setMinWidth(myWidth);

		myModel = new Model(parser);
		myView = new View(myWidth, myHeight, "English");
		myController = new Controller(myModel, myView);

		getChildren().add(myView);

	}

	public EventHandler<KeyEvent> getKeyListener() {
		return myController.myKeyListener;
	}

	public EventHandler<MouseEvent> getMouseListener() {
		return myController.myMouseListener;
	}

	public void savePropertiesToFile(File file) {
		try {
			OutputStream fileOS = new FileOutputStream(file);
			myDisplayProperties.store(fileOS, null);
			fileOS.close();
		} catch (IOException e) {
			System.out.println(e.toString() + ": " + file.toString());
		}
	}
	
	public void loadPropertiesFromFile(File file) {
		try {
			InputStream fileIS = new FileInputStream(file);
			myDisplayProperties.load(fileIS);
		} catch (IOException e) {
			System.out.println(e.toString() + ": " + file.toString());
		}
		printProps();
	}
	private void printProps() {
		for (Object s:myDisplayProperties.keySet()) {
			System.out.println(s);
		}
	}

}
