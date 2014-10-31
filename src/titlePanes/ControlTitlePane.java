package titlePanes;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import backEnd.Controller;


public class ControlTitlePane extends TitledPane {

    public ControlTitlePane (Controller contr) {

        setText("Controls");

        VBox root = new VBox();
        root.setSpacing(20);

        makeButtons(root, contr);

        makeLocationFields(root, contr);

        makePenColorBox(root, contr);

        makeHelpText(root);

        setContent(root);

    }

    private void makeButtons (VBox root, Controller contr) {

        VBox vbox = new VBox();
        HBox hbox = new HBox();

        Button upButton = new Button(">");
        upButton.setRotate(-90);
        upButton.setTranslateX(40);
        Button leftButton = new Button("<");
        Button rightButton = new Button(">");
        Button downButton = new Button(">");
        downButton.setRotate(90);

        setSize(new Button[] { upButton, leftButton, rightButton, downButton });

        upButton.setOnAction(event -> handle(contr, "Forward"));
        downButton.setOnAction(event -> handle(contr, "Backward"));
        rightButton.setOnAction(event -> handle(contr, "Right"));
        leftButton.setOnAction(event -> handle(contr, "Left"));

        hbox.getChildren().addAll(leftButton, downButton, rightButton);

        vbox.getChildren().addAll(upButton, hbox);

        root.getChildren().add(vbox);

    }

    private void handle (Controller c, String s) {
        try {
            c.move10(s);
        }
        catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    private void makeLocationFields (VBox root, Controller contr) {

        VBox vbox = new VBox();
        HBox xhbox = new HBox();
        HBox yhbox = new HBox();

        Label xlabel = new Label("X Loc: ");
        Label ylabel = new Label("Y Loc: ");

        TextField xtf = new TextField();
        xtf.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle (ActionEvent event) {
                try {
                    contr.runScript("setxy " + xtf.getText() + " ycor");
                }
                catch (Exception e) {
                    // TODO Auto-generated catch block
                    System.out.println(e.toString());
                }
            }

        });

        TextField ytf = new TextField();
        ytf.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle (ActionEvent event) {
                try {
                    contr.runScript("setxy " + "xcor " + ytf.getText());
                }
                catch (Exception e) {
                    // TODO Auto-generated catch block
                    System.out.println(e.toString());
                }
            }

        });

        xhbox.getChildren().addAll(xlabel, xtf);
        yhbox.getChildren().addAll(ylabel, ytf);
        vbox.getChildren().addAll(xhbox, yhbox);

        root.getChildren().add(vbox);
    }

    private void makePenColorBox (VBox root, Controller contr) {
        VBox vbox = new VBox();

        Label label = new Label("Pen color: ");
        vbox.getChildren().add(label);

        ColorPicker colorPicker = new ColorPicker();
        colorPicker.setValue(Color.BLACK);
        vbox.getChildren().add(colorPicker);

        colorPicker.setOnAction(event -> contr.changePenColor(colorPicker
                .getValue()));

        root.getChildren().add(vbox);
    }

    private void makeHelpText (Pane root) {

        VBox vbox = new VBox();

        Label label1 = new Label();
        Label label2 = new Label();
        label1.setText("Additionally");
        label2.setText("Use A,S,W,D keys for navigation");

        label1.setFont(Font.font("Verdana", FontWeight.BOLD, 12));

        vbox.getChildren().addAll(label1, label2);
        root.getChildren().add(vbox);
    }

    private void setSize (Button[] b) {
        for (Button a : b)
            a.setPrefSize(40, 40);
    }

}
