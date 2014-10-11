package titlePanes;

import javafx.scene.control.TitledPane;
import javafx.scene.layout.VBox;
import backEnd.Controller;

public class TurtleInfoTitlePane extends TitledPane {
    
    public TurtleInfoTitlePane(Controller contr) {
        setText("Turtle info");
        
        VBox root = new VBox();
        root.setSpacing(5);
        
        setContent(root);
    }
}
