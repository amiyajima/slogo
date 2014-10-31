package frontEnd;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Observable;
import java.util.Properties;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import backEnd.turtle.Turtle;
import backEnd.turtle.TurtleProperties;

/**
 * Portion of GUI on which graphical representation of turtles move.
 * 
 * @author Brian Bolze
 * @author Ethan Chang
 * @author Eli Lichtenberg
 * @author Anna Miyajima
 *
 */
public class TurtleCanvas extends Group {
	
	private static final double GRID_LINE_WIDTH = .4;
	private static final int NUM_COLS = 20;
	private static final int NUM_ROWS = 20;
	private double myBoundingWidth;
	private double myBoundingHeight;
	private double myPadding;
	private DoubleProperty myWidth;
	private DoubleProperty myHeight;
	private Rectangle myBackground;
	private Group myGridLines;
	private TurtleView myTurtleView;
	private DoubleProperty myBackgroundIndex;
	private StringProperty myPalette;
	private Properties myColorProperties;
	
	/**
	 * Constructor for TurtleCanvas. Sets width, height, and padding.
	 * 
	 * @param width Width of canvas GUI element
	 * @param height Height of canvas GUI element
	 * @param padding Padding between GUI elements
	 * @throws IOException
	 */
	public TurtleCanvas (double width, double height, double padding) 
			throws IOException {
		super();
		myWidth = new SimpleDoubleProperty(width);
		myHeight = new SimpleDoubleProperty(height);
		myPadding = padding;	
		myBoundingWidth = myWidth.get() - 2 * myPadding;
		myBoundingHeight = myHeight.get() - 2 * myPadding;
		
		addBackground();
		addGridLines();
		addClipper();
		
		myBackgroundIndex = new SimpleDoubleProperty(0);
		myPalette = new SimpleStringProperty("");
		myColorProperties = new Properties();
		InputStream fileInput = getClass().getResourceAsStream("/resources/PenColors.properties");
		myColorProperties.load(fileInput);
		addListeners();
	}
	
	/**
	 * Sets background color of canvas.
	 * @param c Color to make canvas background
	 */
	public void changeBackgroundColor (Color c) {
		myBackground.setFill(c);
	}
	
	/**
	 * Returns String representing color of background of canvas.
	 * @return Background color of canvas as String
	 */
	public String getBackgroundColor () {
		return myBackground.getFill().toString();
	}
	
	/**
	 * Sets color of turtle's pen.
	 * @param c Color to make pen
	 */
	public void changePenColor (Color c) {
		myTurtleView.changePenColor(c);
	}
	
	/**
	 * Changes the image used to display a turtle on the canvas.
	 * @param f File holding image
	 */
	public void changeTurtleImage (File f) {
		myTurtleView.setImage(new Image("file:" + f.getAbsolutePath()));
	}
	
	/**
	 * If grid lines are off, turns on grid lines.
	 * If grid lines are on, turns off grid lines.
	 */
	public void toggleGridLines () {
		myGridLines.setVisible(!myGridLines.isVisible());
	}
	
	private void addTurtle (Turtle turtle) throws IOException {
		ImageView turtleImage = new ImageView(new Image(getClass().
				getResourceAsStream("../resources/images/rcd.png")));
		TurtleProperties tProps = turtle.getTurtleProperties();
		myTurtleView = new TurtleView(tProps, myBoundingWidth, 
				myBoundingHeight, turtleImage, myColorProperties);
		getChildren().add(myTurtleView.getImageView());
		getChildren().add(myTurtleView.getPenLines());
		getChildren().add(myTurtleView.getStamps());
	}
	
	void update (Observable o, Object arg) throws IOException {
		if (arg instanceof Turtle) {
			Turtle turtle = (Turtle)arg;
			addTurtle(turtle);
		}
	}

	private void addBackground () {
		
		Rectangle container = makeRect(myWidth.doubleValue(), myHeight.doubleValue(), 0, 0);
		container.setFill(Color.WHITE);
		container.setStroke(Color.BLACK);
		
		myBackground = makeRect(myBoundingWidth, myBoundingHeight, myPadding, myPadding);
		myBackground.setFill(Color.WHITE);
		myBackground.setStroke(Color.BLACK);

		
		getChildren().addAll(container, myBackground);
	}
	
	private void addClipper () {
		Rectangle container = makeRect(myBoundingWidth, myBoundingHeight, myPadding, myPadding);
		setClip(container);
	}
	
	private Rectangle makeRect (double width, double height, 
			double xpos, double ypos) {
		Rectangle rect = new Rectangle(width, height);
		rect.setX(xpos);
		rect.setY(ypos);
		return rect;
	}
	
	private void addGridLines () {
		myGridLines = new Group();
		for (int row = 0; row < NUM_ROWS; row++) {
			for (int col = 0; col < NUM_COLS; col++) {
				Rectangle rect = new Rectangle(myBoundingWidth / NUM_COLS, 
						myBoundingHeight / NUM_ROWS);
				rect.setTranslateX(myPadding + rect.getWidth() * col);
				rect.setTranslateY(myPadding + rect.getHeight() * row);
				rect.setStroke(Color.LIGHTGRAY);
				rect.setStrokeWidth(GRID_LINE_WIDTH);
				rect.setFill(null);
				myGridLines.getChildren().add(rect);
			}
		}
		getChildren().add(myGridLines);
	}
		
	/**
	 * Returns the width by which turtles are bounded on the canvas.
	 * @return Bounding width of canvas
	 */
	public double getBoundingWidth () {
		return myBoundingWidth;
	}
	
	/**
	 * Returns the height by which turtles are bounded on the canvas.
	 * @return Bounding height of canvas
	 */
	public double getBoundingHeight () {
		return myBoundingHeight;
	}
	
	void bindToModelProperties (DoubleProperty backgroundIndex, 
			StringProperty palette) {
		myBackgroundIndex.bindBidirectional(backgroundIndex);
		myPalette.bindBidirectional(palette);
	}
	
	private void addListeners () {
		addBackgroundIndexListener();
		addPaletteListener();
	}

	private void addPaletteListener () {
		myPalette.addListener(new ChangeListener<Object>() {
			@Override
			public void changed (ObservableValue<? extends Object> observable,
					Object oldValue, Object newValue) {
				// write to property object
				String[] strArray = myPalette.get().split(": ");
				String key = strArray[0];
				String value = strArray[1];
				myColorProperties.setProperty(key, value);
			}
		});
	}

	private void addBackgroundIndexListener () {
		myBackgroundIndex.addListener(new ChangeListener<Object>() {
			@Override
			public void changed (ObservableValue<? extends Object> observable,
					Object oldValue, Object newValue) {
				String str = myColorProperties.getProperty(
						myBackgroundIndex.getValue().intValue() + "");
				Color c = Color.valueOf(str);
				changeBackgroundColor(c);
			}
		});
	}

}
