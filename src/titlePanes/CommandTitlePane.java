package titlePanes;

import javafx.scene.control.Label;
import javafx.scene.control.TitledPane;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import backEnd.Controller;

class CommandTitlePane extends TitledPane {

	public CommandTitlePane(Controller contr) {
		setText("Commands");

		VBox root = new VBox();
		root.setSpacing(20);

		Label forward = new Label("+ forward/fd <pixels>");
		forward.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
		Tooltip forwardTip = new Tooltip();

		forwardTip
				.setText("moves turtle forward in its current heading by pixels distance"
						+ '\n' + "returns the value of pixels");

		forward.setTooltip(forwardTip);

		root.getChildren().addAll(forward);

		setContent(root);
	}
}
