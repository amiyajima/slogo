package frontEnd;

import java.io.IOException;
import java.util.Properties;
import java.util.ResourceBundle;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.DoubleProperty;
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
import backEnd.turtle.TurtleProperties;
import drawer.Drawer;
import drawer.SimpleDrawer;

public class TurtleView {
	
	private static final double INACTIVE_OPACITY = .4;
	private static final int ACTIVE_OPACITY = 1;
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
	private BooleanProperty myPenDown;
	private BooleanProperty myLinesCleared;
	private BooleanProperty myVisibility;
	
	private DoubleProperty myStampCount;
	
	private DoubleProperty myPenColorIndex;
	private DoubleProperty myPenSize;
	private DoubleProperty myShapeIndex;
	
	private BooleanProperty myActivity;
	
	private Properties myColorProperties;
	private ResourceBundle myImageResources;
	
	public TurtleView (TurtleProperties tProps, double boundingWidth, 
			double boundingHeight, ImageView imageView, Properties cProps) 
					throws IOException {
		myImageView = imageView;
		myDrawer = new SimpleDrawer();
		myPenColor = Color.BLACK;
		myXPosition = new SimpleDoubleProperty(boundingWidth / 2);
		myYPosition = new SimpleDoubleProperty(boundingHeight / 2);
		double initialX = boundingWidth / 2 - getImage().getWidth() / 2;
		double initialY = boundingHeight / 2 - getImage().getHeight() / 2;
		myImageView.setX(initialX);
		myImageView.setY(initialY);
		
		myColorProperties = cProps;
		myImageResources = ResourceBundle.getBundle("resources/images/Images");
		
		myLineStartX = myXPosition.get();
		myLineStartY = myYPosition.get();
		
		myOrientation = new SimpleDoubleProperty(0);
		myPenLines = new Group();
		myStamps = new Group();
		myPenDown = new SimpleBooleanProperty(true);
		myLinesCleared = new SimpleBooleanProperty(false);
		myVisibility = new SimpleBooleanProperty(true);
		myStampCount = new SimpleDoubleProperty(0);
		myPenColorIndex = new SimpleDoubleProperty(0);
		myPenSize = new SimpleDoubleProperty(0);
		myShapeIndex = new SimpleDoubleProperty(0);
		myActivity = new SimpleBooleanProperty(true);
		addListeners();
		bindProperties(tProps);
	}
	
	//addTurtle method when getting height and width of image
	public ImageView getImageView () {
		return myImageView;
	}
	
	public Image getImage () {
		return myImageView.getImage();
	}
	
	public Group getPenLines () {
		return myPenLines;
	}
	
	public Group getStamps () {
		return myStamps;
	}

	public void setImage (Image image) {
		myImageView.setImage(image);
	}
	
	public void drawLine (Point2D endPoint) {
		Point2D startPoint = new Point2D(myLineStartX, myLineStartY);
		Line line = myDrawer.makeLine(myPenColor, myPenSize.get(), startPoint, endPoint);
		myPenLines.getChildren().add(line);
	}
	
	public void drawStamp () {
		ImageView stamp = new ImageView(myImageView.getImage());
		stamp.setX(myXPosition.get() - getImage().getWidth() / 2); //repeated code
		stamp.setY(myYPosition.get() - getImage().getHeight() / 2); //repeated code
		stamp.setRotate(myOrientation.get());
		myStamps.getChildren().add(stamp);
	}
	
	public void changePenColor (Color c) {
		myPenColor = c;
	}
	
	//change to just set imageView?, private?
	public void setTurtleX (double x) {
		myXPosition.set(x);
		myImageView.setX(x - getImage().getWidth() / 2);
	}
	
	//change to just set imageView?, private?
	public void setTurtleY (double y) {
		myYPosition.set(y);
		myImageView.setY(y - getImage().getHeight() / 2);
	}
	
	public void setOrientation (double orientation) {
		myOrientation.set(orientation);
		myImageView.setRotate(myOrientation.get());
	}
	
	// extract methods
	private void addListeners () {
		addXPositionListener();
		addYPositionListener();
		addOrientationListener();
		myLinesCleared.addListener(new ChangeListener<Object>() {
			@Override
			public void changed (ObservableValue<? extends Object> observable,
					Object oldValue, Object newValue) {
				if (myLinesCleared.get()) {
					myPenLines.getChildren().clear();
				}
			}
		});
		myVisibility.addListener(new ChangeListener<Object>() {
			@Override
			public void changed (ObservableValue<? extends Object> observable,
					Object oldValue, Object newValue) {
				myImageView.setVisible(myVisibility.get());
			}
		});
		myStampCount.addListener(new ChangeListener<Object>() {
			@Override
			public void changed (ObservableValue<? extends Object> observable,
					Object oldValue, Object newValue) {
				if (myStampCount.get() == 0) {
					myStamps.getChildren().clear();
				}
				else {
					drawStamp();
				}
			}
		});
		myPenColorIndex.addListener(new ChangeListener<Object>() {
			@Override
			public void changed (ObservableValue<? extends Object> observable,
					Object oldValue, Object newValue) {
				String str = myColorProperties.getProperty(
						myPenColorIndex.getValue().intValue() + "");
				Color c = Color.valueOf(str);
				changePenColor(c);
			}
		});
		myShapeIndex.addListener(new ChangeListener<Object>() {
			@Override
			public void changed (ObservableValue<? extends Object> observable,
					Object oldValue, Object newValue) {
				String str = myImageResources.getString(
						myShapeIndex.getValue().intValue() + "");
				setImage(new Image("/resources/images/" + str));
			}
		});
		myActivity.addListener(new ChangeListener<Object>() {
			@Override
			public void changed (ObservableValue<? extends Object> observable,
					Object oldValue, Object newValue) {
				if (myActivity.get()) {
					myImageView.setOpacity(ACTIVE_OPACITY);
				}
				else {
					myImageView.setOpacity(INACTIVE_OPACITY);
				}
			}
		});
	}

	private void addOrientationListener() {
		myOrientation.addListener(new ChangeListener<Object>() {
			@Override
			public void changed (ObservableValue<? extends Object> observable,
					Object oldValue, Object newValue) {
				myImageView.setRotate(myOrientation.get());
			}
		});
	}

	private void addYPositionListener() {
		myYPosition.addListener(new ChangeListener<Object>() {
			@Override
			public void changed (ObservableValue<? extends Object> observable,
					Object oldValue, Object newValue) {
				setTurtleY(myYPosition.get());
				Point2D lineEnd = new Point2D(myXPosition.get(), myYPosition.get());
				if (myPenDown.get()) drawLine(lineEnd);
				myLineStartX = myXPosition.get();
				myLineStartY = myYPosition.get();
			}
		});
	}

	private void addXPositionListener() {
		myXPosition.addListener(new ChangeListener<Object>() {
			@Override
			public void changed (ObservableValue<? extends Object> observable,
					Object oldValue, Object newValue) {
				setTurtleX(myXPosition.get());
				if (facingHorizontal()) {
					if (myPenDown.get()) {
						Point2D lineEnd = new Point2D(myXPosition.get(), myYPosition.get());
						drawLine(lineEnd);
					}
					myLineStartX = myXPosition.get();
					myLineStartY = myYPosition.get(); //not actually needed, but more readable
				}
			}
		});
	}
	
	private boolean facingHorizontal () {
		if (Math.abs(myOrientation.get() % HALF_CIRCLE) == RIGHT_ORIENTATION) {
			return true;
		}
		return false;
	}

	public boolean penIsDown () {
		return myPenDown.get();
	}
	
	private void bindProperties (TurtleProperties tProps) {
		myXPosition.bindBidirectional(tProps.getXPosition());
		myYPosition.bindBidirectional(tProps.getYPosition());
		
		myOrientation.bindBidirectional(tProps.getOrientation());
		myPenDown.bindBidirectional(tProps.getIsPenDown());
		myLinesCleared.bindBidirectional(tProps.getLinesCleared());
		myVisibility.bindBidirectional(tProps.getVisibility());
		myStampCount.bindBidirectional(tProps.getStampCount());
		
		myPenColorIndex.bindBidirectional(tProps.getPenColorIndex());
		myPenSize.bindBidirectional(tProps.getPenSize());
		myShapeIndex.bindBidirectional(tProps.getShapeIndex());
		
		myActivity.bindBidirectional(tProps.getActivity());
	}
}
