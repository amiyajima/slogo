package frontEnd;

import java.io.File;
import java.util.Observable;
import java.util.Observer;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import backEnd.Controller;
import drawer.Drawer;
import drawer.SimpleDrawer;

public class TurtleCanvas extends Group {// implements Observer {
//observer commented out	
	public double boundingWidth, boundingHeight, myPadding;
	
	private DoubleProperty myWidth, myHeight;
	private Point2D turtleLocation;
	public DoubleProperty turtleOrientation;
	private boolean isPenDown;
	private Color penColor;
	Rectangle myBackground;
	Group myGridLines;
	ImageView turtleView;
	Drawer myDrawer;

	public TurtleCanvas(double width, double height, double padding, Controller controller) {
		super();
		
		myWidth = new SimpleDoubleProperty(3.*width/4.);
		myHeight = new SimpleDoubleProperty(3.*height/4.);
		myPadding = padding;	
		
		boundingWidth = myWidth.get() - 2*myPadding;
		boundingHeight = myHeight.get() - 2*myPadding;
		
		penColor = Color.BLACK;
		
		myDrawer = new SimpleDrawer();
		
		addBackground();
		addGridLines();
		addTurtle();
		addListeners();
	}
	
	public void setTurtleX(double x) {
		
		turtleView.setX(x - turtleView.getImage().getWidth()/2);
		// + myWidth.doubleValue()/2
	}
	
	public void setTurtleY(double y) {
		turtleView.setY(y - turtleView.getImage().getWidth()/2);
		// + myHeight.doubleValue()/2
	}
	
	public void setTurtleOrientation(double orientation) {
		turtleOrientation.set(orientation);
		turtleView.setRotate(turtleOrientation.get());
	}
	
	public void changeBackgroundColor(Color c) {
		myBackground.setFill(c);
	}
	
	public void changePenColor(Color c) {
		penColor = c;
	}
	
	public void changeTurtleImage(File f) {
		turtleView.setImage(new Image("file:"+f.getAbsolutePath()));
	}
	
	public void toggleGridLines() {
		myGridLines.setVisible(!myGridLines.isVisible());
	}

	private void addBackground() {
		
		Rectangle container = new Rectangle();
		container.setWidth(myWidth.doubleValue());
		container.setHeight(myHeight.doubleValue());
		container.setFill(Color.WHITE);
		container.setStroke(Color.BLACK);
		container.setX(0);
		container.setY(0);
		
		myBackground = new Rectangle();
		myBackground.setWidth(boundingWidth);
		myBackground.setHeight(boundingHeight);
		myBackground.setFill(Color.WHITE);
		myBackground.setStroke(Color.BLACK);
		myBackground.setX(myPadding);
		myBackground.setY(myPadding);
		
		getChildren().addAll(container, myBackground);
	}
	
	private void addTurtle() {
		turtleView = new ImageView(new Image(getClass().getResourceAsStream("../resources/images/rcd.png")));
		turtleView.setX(boundingWidth/2 - turtleView.getImage().getWidth()/2);
		turtleView.setY(boundingHeight/2 - turtleView.getImage().getHeight()/2);
		
		turtleOrientation = new SimpleDoubleProperty(0);
		
		getChildren().add(turtleView);
	}

//	@Override
	public void update(Observable o, Object arg) {
		
		System.out.println("HERE!!!!!" + arg.toString());
		
		//TODO Change these to Properties to get their names
		if (arg instanceof Point2D) {
			if (isPenDown) drawLine((Point2D)arg);
			turtleLocation = (Point2D)arg;
			setTurtleX(turtleLocation.getX());
			setTurtleY(turtleLocation.getY());
		}
		
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
	
	private void addListeners() {
		turtleOrientation.addListener(new ChangeListener<Object>() {
			@Override
			public void changed(ObservableValue<? extends Object> observable,
					Object oldValue, Object newValue) {
				turtleView.setRotate(turtleOrientation.get());
			}
		});
//		turtleLocation.addListener(new ChangeListener<Object>() {
//			@Override
//			public void changed(ObservableValue<? extends Object> observable,
//					Object oldValue, Object newValue) {
//				// TODO Auto-generated method stub
//			}
//		});
	}
	
	private void drawLine(Point2D endPoint) {
		myDrawer.makeLine(penColor, turtleLocation, endPoint);
	}

}
