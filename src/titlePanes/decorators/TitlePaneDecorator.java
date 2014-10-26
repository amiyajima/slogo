package titlePanes.decorators;

import javafx.scene.control.TitledPane;

/**
 * Used as a wrapper around TitlePanes to provide options and customizations
 * without adding duplicated code
 * 
 * @author brianbolze
 *
 */
public abstract class TitlePaneDecorator {

	protected TitledPane myPane;

	public TitlePaneDecorator(TitledPane pane) {
		myPane = pane;
	}

}
