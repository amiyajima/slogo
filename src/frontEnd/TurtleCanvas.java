package frontEnd;

import java.io.File;
import java.util.Map;
import java.util.Observable;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import backEnd.Controller;
import backEnd.turtle.Turtle;
import backEnd.turtle.TurtleProperties;

public class TurtleCanvas extends Group {// implements Observer {
//observer commented out
	
	private double boundingWidth, boundingHeight, myPadding;
	private DoubleProperty myWidth, myHeight;
	private Rectangle myBackground;
	private Group myGridLines;
	private TurtleView turtleView;

	public TurtleCanvas(double width, double height, double padding, Controller controller) {
		super();
		
		myWidth = new SimpleDoubleProperty(width);
		myHeight = new SimpleDoubleProperty(height);
		myPadding = padding;	
		
		boundingWidth = myWidth.get() - 2*myPadding;
		boundingHeight = myHeight.get() - 2*myPadding;
		
		addBackground();
		addGridLines();
		addClipper();
	}
	
	//remove later - currently needed by Controller in changeXPos
	public void setTurtleX(double x) {
		turtleView.setTurtleX(x);
	}
	
	//remove later - corresponding method for X currently needed by controller
	public void setTurtleY(double y) {
		turtleView.setTurtleY(y);
	}
	
	public void changeBackgroundColor(Color c) {
		myBackground.setFill(c);
	}
	
	//remove later - currently needed by controller
	public void changePenColor(Color c) {
		//penColor = c;
		turtleView.changePenColor(c);
	}
	
	public void changeTurtleImage(File f) {
		turtleView.setImage(new Image("file:"+f.getAbsolutePath()));
	}
	
	public void toggleGridLines() {
		myGridLines.setVisible(!myGridLines.isVisible());
	}
	
	public void addTurtle(Turtle turtle) {
		ImageView turtleImage = new ImageView(new Image(getClass().getResourceAsStream("../resources/images/rcd.png")));
		@SuppressWarnings("rawtypes")
		TurtleProperties tProps = turtle.getTurtleProperties();
		turtleView = new TurtleView(tProps, boundingWidth, boundingHeight, turtleImage);
		//change to just adding group for turtle?
		getChildren().add(turtleView.getImageView());
		getChildren().add(turtleView.getPenLines());
		getChildren().add(turtleView.getStamps());
	}

//	@Override //not actually overriding, just being called by View
	// not actually observing Point2D! won't be able to when stop passing Turtle
	// should change to DoubleProperties
	public void update(Observable o, Object arg) {
		System.out.println("HERE!!!!!" + arg.toString());
		//TODO Change these to Properties to get their names
		if(arg instanceof Turtle) {
			Turtle turtle = (Turtle)arg;
			addTurtle(turtle);
		}
//		else if (arg instanceof Point2D) {
//			if (turtleView.penIsDown()) turtleView.drawLine((Point2D)arg);
//			Point2D newPoint = (Point2D)arg;
//			turtleView.setTurtleX(newPoint.getX());
//			turtleView.setTurtleY(newPoint.getY());			
//		}
	}

	private void addBackground() {
		
		Rectangle container = makeRect(myWidth.doubleValue(), myHeight.doubleValue(), 0, 0);
		container.setFill(Color.WHITE);
		container.setStroke(Color.BLACK);
		
		myBackground = makeRect(boundingWidth, boundingHeight, myPadding, myPadding);
		myBackground.setFill(Color.WHITE);
		myBackground.setStroke(Color.BLACK);

		
		getChildren().addAll(container, myBackground);
	}
	
	private void addClipper() {
		Rectangle container = makeRect(boundingWidth, boundingHeight, myPadding, myPadding);
		setClip(container);
	}
	
	private Rectangle makeRect(double width, double height, double xpos, double ypos) {
		Rectangle rect = new Rectangle(width, height);
		rect.setX(xpos);
		rect.setY(ypos);
		return rect;
	}
	
	private void addGridLines() {
		myGridLines = new Group();
		for (int row = 0; row < 20; row++) {
			for (int col = 0; col < 20; col++) {
				Rectangle rect = new Rectangle(boundingWidth/20., boundingHeight/20.);
				rect.setTranslateX(myPadding + rect.getWidth()*col);
				rect.setTranslateY(myPadding + rect.getHeight()*row);
				rect.setStroke(Color.LIGHTGRAY);
				rect.setStrokeWidth(.4);
				rect.setFill(null);
				myGridLines.getChildren().add(rect);
			}
		}
		getChildren().add(myGridLines);
	}
		
	public double getBoundingWidth() {
		return boundingWidth;
	}
	
	public double getBoundingHeight() {
		return boundingHeight;
	}
}
