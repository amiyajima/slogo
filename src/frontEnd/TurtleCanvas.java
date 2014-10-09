package frontEnd;

import java.util.Observable;
import java.util.Observer;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import backEnd.Controller;

public class TurtleCanvas extends Group implements Observer {
	
	private DoubleProperty myWidth, myHeight;
	private Point2D turtleLocation;
	private Color penColor;
	Rectangle myBackground;
	ImageView turtleView;

	public TurtleCanvas(double width, double height, Controller controller) {
		super();
		
		myWidth = new SimpleDoubleProperty(3.*width/4.);
		myHeight = new SimpleDoubleProperty(3.*height/4.);
		penColor = Color.BLACK;
		
		addBackground();
		addTurtle();
	}
	
	public void setTurtleX(double x) {
		turtleView.setX(x - turtleView.getImage().getWidth()/2);
	}
	
	public void setTurtleY(double y) {
		turtleView.setY(y - turtleView.getImage().getWidth()/2);
	}
	
	public void changeBackgroundColor(Color c) {
		myBackground.setFill(c);
	}
	
	public void changePenColor(Color c) {
		penColor = c;
	}

	private void addBackground() {
		myBackground = new Rectangle();
		myBackground.setWidth(myWidth.doubleValue());
		myBackground.setHeight(myHeight.doubleValue());
		myBackground.setFill(Color.WHITE);
		myBackground.setStroke(Color.BLACK);
		myBackground.setX(0);
		myBackground.setY(0);
		
		getChildren().add(myBackground);
	}
	
	private void addTurtle() {
		turtleView = new ImageView(new Image(getClass().getResourceAsStream("../resources/images/rcd.png")));
		turtleView.setX(myWidth.doubleValue()/2 - turtleView.getImage().getWidth()/2);
		turtleView.setY(myHeight.doubleValue()/2 - turtleView.getImage().getHeight()/2);
		getChildren().add(turtleView);
	}

	@Override
	public void update(Observable o, Object arg) {
		if (arg instanceof Point2D) {
			turtleLocation = (Point2D)arg;
			setTurtleX(turtleLocation.getX());
			setTurtleY(turtleLocation.getY());
		}
		
	}

}
