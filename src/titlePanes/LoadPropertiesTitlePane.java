package titlePanes;

import java.io.File;
import backEnd.Controller;
import javafx.scene.control.Button;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;


public class LoadPropertiesTitlePane extends TitledPane {

    public LoadPropertiesTitlePane (Controller controller) {
        setText("Load Properties");
        VBox root = new VBox();
        root.setSpacing(30);

        Button button = new Button("Select Variable Properties");
        button.setOnAction(event -> openFile(controller));
        root.getChildren().add(button);
        setContent(root);

    }

    private void openFile (Controller contr) {
        FileChooser varPropertiesChooser = new FileChooser();
        varPropertiesChooser.setTitle("Upload Image");
        varPropertiesChooser.getExtensionFilters()
                .addAll(
                        new FileChooser.ExtensionFilter("VariableProperties",
                                                        "*.properties"));

        Stage fileStage = new Stage();
        File file = varPropertiesChooser.showOpenDialog(fileStage);
        if (file != null)
            contr.setVariableProperties(file);
    }
}
