package frontEnd;

import java.util.Map;

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
import backEnd.turtle.AbstractTurtle;
import backEnd.turtle.TurtleProperties;
import drawer.Drawer;
import drawer.SimpleDrawer;

public class TurtleView {
	
	private ImageView myImageView;
	private Group myPenLines;
	private Group myStamps;
	private Drawer myDrawer;
	private Color myPenColor;
	
//	private Point2D myLocation;
	private DoubleProperty myXPosition;
	private DoubleProperty myYPosition;
	
	private DoubleProperty myOrientation;
	private BooleanProperty penDown;
	private BooleanProperty linesCleared;
	
	public TurtleView(TurtleProperties tProps, double boundingWidth, double boundingHeight, ImageView imageView) {
		myImageView = imageView;
		myDrawer = new SimpleDrawer();
		myPenColor = Color.BLACK;
//		myLocation = new Point2D(boundingWidth/2, boundingHeight/2);
		myXPosition = new SimpleDoubleProperty(boundingWidth/2);
		myYPosition = new SimpleDoubleProperty(boundingHeight/2);
		double initialX = boundingWidth/2 - getImage().getWidth()/2;
		double initialY = boundingHeight/2 - getImage().getHeight()/2;
		myImageView.setX(initialX);
		myImageView.setY(initialY);
		myOrientation = new SimpleDoubleProperty(0);
		myPenLines = new Group();
		myStamps = new Group();
		penDown = new SimpleBooleanProperty(true);
		linesCleared = new SimpleBooleanProperty(false);
		addListeners();
		bindProperties(tProps);
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
	
	public Group getStamps() {
		return myStamps;
	}

	public void setImage(Image image) {
		// TODO Auto-generated method stub
		myImageView.setImage(image);
	}
	
	public void drawLine(Point2D endPoint) {
		Point2D startPoint = new Point2D(myXPosition.get(), myYPosition.get());
		Line line = myDrawer.makeLine(myPenColor, startPoint, endPoint);
		myPenLines.getChildren().add(line);
//		canvas.getChildren().add(line);
	}
	
	public void drawStamp() {
		ImageView stamp = new ImageView(myImageView.getImage());
		stamp.setX(myXPosition.get() - getImage().getWidth()/2); //repeated code
		stamp.setY(myYPosition.get() - getImage().getHeight()/2); //repeated code
		myStamps.getChildren().add(stamp);
	}
	
	public void changePenColor(Color c) {
		myPenColor = c;
	}
	
	//change to just set imageView?, private?
	public void setTurtleX(double x) {
		myXPosition.set(x);
		myImageView.setX(x - getImage().getWidth()/2);
		// + myWidth.doubleValue()/2
//		myLocation = new Point2D(x, myLocation.getY());
	}
	
	//change to just set imageView?, private?
	public void setTurtleY(double y) {
		myYPosition.set(y);
		myImageView.setY(y - getImage().getHeight()/2);
		// + myHeight.doubleValue()/2
//		myLocation = new Point2D(myLocation.getX(), y);
	}
	
	public void setOrientation(double orientation) {
		myOrientation.set(orientation);
		myImageView.setRotate(myOrientation.get());
	}
	
	private void addListeners() {
		myXPosition.addListener(new ChangeListener<Object>() {
			@Override
			public void changed(ObservableValue<? extends Object> observable,
					Object oldValue, Object newValue) {
				// TODO Auto-generated method stub
				setTurtleX(myXPosition.get());
			}
		});
		myYPosition.addListener(new ChangeListener<Object>() {
			@Override
			public void changed(ObservableValue<? extends Object> observable,
					Object oldValue, Object newValue) {
				// TODO Auto-generated method stub
				setTurtleY(myYPosition.get());
			}
		});
		
		myOrientation.addListener(new ChangeListener<Object>() {
			@Override
			public void changed(ObservableValue<? extends Object> observable,
					Object oldValue, Object newValue) {
				myImageView.setRotate(myOrientation.get());
			}
		});
		linesCleared.addListener(new ChangeListener<Object>() {
			@Override
			public void changed(ObservableValue<? extends Object> observable,
					Object oldValue, Object newValue) {
				// TODO Auto-generated method stub	
				if(linesCleared.get()) {
					myPenLines.getChildren().clear();
				}
			}
		});
	}
	
	public boolean penIsDown() {
		return penDown.get();
	}
	
	private void bindProperties(TurtleProperties tProps) {
		myXPosition.bindBidirectional(tProps.getXPosition());
		myYPosition.bindBidirectional(tProps.getYPosition());
		
		myOrientation.bindBidirectional(tProps.getOrientation());
		penDown.bindBidirectional(tProps.getIsPenDown());
		linesCleared.bindBidirectional(tProps.getLinesCleared());
		
	}
}
