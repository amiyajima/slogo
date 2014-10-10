package drawer;

import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

public interface Drawer {

	public Line makeLine(Color lineColor, Point2D start, Point2D end);
	
}
