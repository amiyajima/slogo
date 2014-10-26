package titlePanes.decorators;

import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.control.TitledPane;

public class HScrollableDecorator extends TitlePaneDecorator {

	public HScrollableDecorator(TitledPane pane, double width) {
		super(pane);
		wrap(width);
	}
	
	private void wrap(double width) {
		ScrollPane scrollPane = new ScrollPane();
		scrollPane.setContent(myPane.getContent());
		scrollPane.setMaxWidth(width);
		scrollPane.setHbarPolicy(ScrollBarPolicy.ALWAYS);
		myPane.setContent(scrollPane);
	}

}
