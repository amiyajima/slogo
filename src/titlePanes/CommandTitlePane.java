package titlePanes;

import javafx.scene.control.Label;
import javafx.scene.control.TitledPane;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import backEnd.Controller;

public class CommandTitlePane extends TitledPane {

	public CommandTitlePane(Controller contr) {
		setText("Commands");

		VBox root = new VBox();
		root.setSpacing(5);

		Label forward = new Label("+ FORWARD/FD <pixels>");
		forward.setFont(Font.font("Verdana", FontWeight.BOLD, 10));
		Tooltip forwardTip = new Tooltip();

		forwardTip
				.setText("moves turtle forward in its current heading by pixels distance"
						+ '\n' + "returns the value of pixels");

		forward.setTooltip(forwardTip);

		Label back = new Label("+ BACK/BK <pixels>");
		back.setFont(Font.font("Verdana", FontWeight.BOLD, 10));
		Tooltip backTip = new Tooltip();

		backTip.setText("moves turtle backward in its current heading by pixels distance"
				+ '\n' + "returns the value of pixels");

		back.setTooltip(backTip);

		root.getChildren().addAll(forward, back);

		setContent(root);
	}
}
