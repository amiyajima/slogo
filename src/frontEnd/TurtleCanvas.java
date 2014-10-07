package frontEnd;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import backEnd.Controller;

public class TurtleCanvas extends Canvas {

	public TurtleCanvas(double width, double height, Controller controller) {
		super(3.*width/4., 4.*height/5.);
	}

	public void changeBackgroundColor(Color c) {
		GraphicsContext gc = getGraphicsContext2D();
		gc.setFill(c);
		gc.fillRect(0, 0, getWidth(), getHeight());
	}

}
