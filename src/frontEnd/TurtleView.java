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
import backEnd.turtle.Turtle;
import backEnd.turtle.TurtleProperties;
import drawer.Drawer;
import drawer.SimpleDrawer;

public class TurtleView {
	
	public static final int HALF_CIRCLE = 180;
	public static final int RIGHT_ORIENTATION = 90;
	private ImageView myImageView;
	private Group myPenLines;
	private Group myStamps;
	private Drawer myDrawer;
	private Color myPenColor;
	
	private double myLineStartX;
	private double myLineStartY;
	
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
		
		myLineStartX = myXPosition.get();
		myLineStartY = myYPosition.get();
		
		myOrientation = new SimpleDoubleProperty(0);
		myPenLines = new Group();
		myStamps = new Group();
		penDown = new SimpleBooleanProperty(true);
		linesCleared = new SimpleBooleanProperty(false);
		addListeners();
		bindProperties(tProps);
	}
	
	//addTurtle method when getting height and width of image
	public ImageView getImageView() {
		// TODO Auto-generated method stub
		return myImageView;
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
		Point2D startPoint = new Point2D(myLineStartX, myLineStartY);
		Line line = myDrawer.makeLine(myPenColor, startPoint, endPoint);
		myPenLines.getChildren().add(line);
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
	}
	
	//change to just set imageView?, private?
	public void setTurtleY(double y) {
		myYPosition.set(y);
		myImageView.setY(y - getImage().getHeight()/2);
	}
	
	public void setOrientation(double orientation) {
		myOrientation.set(orientation);
		myImageView.setRotate(myOrientation.get());
	}
	
	// extract methods
	private void addListeners() {
		myXPosition.addListener(new ChangeListener<Object>() {
			@Override
			public void changed(ObservableValue<? extends Object> observable,
					Object oldValue, Object newValue) {
				// TODO Auto-generated method stub
				setTurtleX(myXPosition.get());
				if(facingHorizontal()) {
					if(penDown.get()) {
						Point2D lineEnd = new Point2D(myXPosition.get(), myYPosition.get());
						drawLine(lineEnd);
					}
					myLineStartX = myXPosition.get();
					myLineStartY = myYPosition.get(); //not actually needed, but more readable
				}
			}
		});
		myYPosition.addListener(new ChangeListener<Object>() {
			@Override
			public void changed(ObservableValue<? extends Object> observable,
					Object oldValue, Object newValue) {
				// TODO Auto-generated method stub
				setTurtleY(myYPosition.get());
				Point2D lineEnd = new Point2D(myXPosition.get(), myYPosition.get());
				if(penDown.get()) drawLine(lineEnd);
				myLineStartX = myXPosition.get();
				myLineStartY = myYPosition.get();
				System.out.println(myXPosition.get() + ", " + myYPosition.get());
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
				if(linesCleared.get()) {
					myPenLines.getChildren().clear();
				}
			}
		});
	}
	
	private boolean facingHorizontal() {
		// TODO Auto-generated method stub
		if(Math.abs(myOrientation.get()%HALF_CIRCLE) == RIGHT_ORIENTATION) return true;
		return false;
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
