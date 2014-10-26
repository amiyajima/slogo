package titlePanes.decorators;

import javafx.scene.control.ScrollPane;
import javafx.scene.control.TitledPane;

public class ScrollableDecorator extends TitlePaneDecorator {

	public ScrollableDecorator(TitledPane pane, double height) {
		super(pane);
		wrap(height);
	}
	
	private void wrap(double height) {
		ScrollPane scrollPane = new ScrollPane();
		scrollPane.setContent(myPane.getContent());
		scrollPane.setMaxHeight(height);
		myPane.setContent(scrollPane);
	}

}
