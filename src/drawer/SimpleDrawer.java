package drawer;

import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

public class SimpleDrawer implements Drawer {

	public SimpleDrawer() {

	}

	@Override
	public Line makeLine(Color lineColor, Point2D start, Point2D end) {
		
		Line line = new Line();
		line.setStroke(lineColor);
		line.setStartX(start.getX());
		line.setStartY(start.getY());
		line.setEndX(end.getX());
		line.setEndY(end.getY());
		
		return line;
	}

}
