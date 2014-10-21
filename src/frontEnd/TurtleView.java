package frontEnd;

import java.util.Map;

import backEnd.AbstractTurtle;
import drawer.Drawer;
import drawer.SimpleDrawer;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

public class TurtleView {
	
	private ImageView myImageView;
	private Group myPenLines;
	private Drawer myDrawer;
	private Color myPenColor;
	private Point2D myLocation;
	private DoubleProperty myOrientation;
	private BooleanProperty penDown;
	
	public TurtleView(Map<String, Property> tProps, double boundingWidth, double boundingHeight, ImageView imageView) {
		myImageView = imageView;
		myDrawer = new SimpleDrawer();
		myPenColor = Color.BLACK;
		myLocation = new Point2D(boundingWidth/2, boundingHeight/2);
		double initialX = boundingWidth/2 - getImage().getWidth()/2;
		double initialY = boundingHeight/2 - getImage().getHeight()/2;
		myImageView.setX(initialX);
		myImageView.setY(initialY);
		myOrientation = new SimpleDoubleProperty(0);
		myPenLines = new Group();
		penDown = new SimpleBooleanProperty(true);
		bindProperties(tProps);
		addListeners();
	}
	
	//possibly change this to just getImage - would make things more direct in TurtleCanvas's
	//addTurtle method when getting height and width of image
	public ImageView getImageView() {
		// TODO Auto-generated method stub
		return myImageView;//.getImage();
	}
	
	public Image getImage() {
		return myImageView.getImage();
	}
	
	public Group getPenLines() {
		return myPenLines;
	}

//	public void setX(double d) {
//		// TODO Auto-generated method stub
//		myImageView.setX(d);
//	}
//
//	public void setY(double d) {
//		// TODO Auto-generated method stub
//		myImageView.setY(d);
//	}
//
//	public double getX() {
//		// TODO Auto-generated method stub
//		return myImageView.getX();
//	}
//
//	public double getY() {
//		// TODO Auto-generated method stub
//		return myImageView.getY();
//	}

	public void setImage(Image image) {
		// TODO Auto-generated method stub
		myImageView.setImage(image);
	}
	
	public void drawLine(Point2D endPoint) {
		Line line = myDrawer.makeLine(myPenColor, myLocation, endPoint);
		myPenLines.getChildren().add(line);
//		canvas.getChildren().add(line);
	}
	
	public void changePenColor(Color c) {
		myPenColor = c;
	}
	
//	private double getTurtleX() {
//		//return getX() + getImage().getWidth()/2;
//		return myLocation.getX();
//	}
//	
//	private double getTurtleY() {
//		//return getY() + getImage().getHeight()/2;
//		return myLocation.getY();
//	}
	
	public void setTurtleX(double x) {
		myImageView.setX(x - getImage().getWidth()/2);
		// + myWidth.doubleValue()/2
		myLocation = new Point2D(x, myLocation.getY());
	}
	
	public void setTurtleY(double y) {
		myImageView.setY(y - getImage().getHeight()/2);
		// + myHeight.doubleValue()/2
		myLocation = new Point2D(myLocation.getX(), y);
	}
	
	//remove
//	public void setRotate(double d) {
//		// TODO Auto-generated method stub
//		myImageView.setRotate(d);
//	}
	
	public void setOrientation(double orientation) {
		myOrientation.set(orientation);
		myImageView.setRotate(myOrientation.get());
	}
	
	//make private
	private void addListeners() {
		myOrientation.addListener(new ChangeListener<Object>() {
			@Override
			public void changed(ObservableValue<? extends Object> observable,
					Object oldValue, Object newValue) {
				myImageView.setRotate(myOrientation.get());
			}
		});
	}
	
	public boolean penIsDown() {
		return penDown.get();
	}
	
	//probably make private
	private void bindProperties(Map<String, Property> tProps) {
		myOrientation.bindBidirectional((DoubleProperty)tProps.get(AbstractTurtle.ORIENTATION_STRING));
		penDown.bindBidirectional((BooleanProperty)tProps.get(AbstractTurtle.PEN_STRING));
	}
}
