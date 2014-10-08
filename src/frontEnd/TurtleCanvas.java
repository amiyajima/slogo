package frontEnd;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import backEnd.Controller;

public class TurtleCanvas extends Group {
	
	private double myWidth;
	private double myHeight;
	Rectangle myBackground;
	ImageView turtleView;

	public TurtleCanvas(double width, double height, Controller controller) {
		super();
		
		myWidth = 3.*width/4.;
		myHeight = 4.*height/5.;
		
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

	private void addBackground() {
		myBackground = new Rectangle();
		myBackground.setWidth(myWidth);
		myBackground.setHeight(myHeight);
		myBackground.setFill(Color.WHITE);
		myBackground.setStroke(Color.BLACK);
		getChildren().add(myBackground);
	}
	
	private void addTurtle() {
		turtleView = new ImageView(new Image(getClass().getResourceAsStream("../resources/images/rcd.png")));
		turtleView.setX(myWidth/2 - turtleView.getImage().getWidth()/2);
		turtleView.setY(myHeight/2 - turtleView.getImage().getHeight()/2);
		getChildren().add(turtleView);
	}

}