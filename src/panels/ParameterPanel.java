package panels;

import javafx.scene.control.Accordion;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.BorderPane;
import titlePanes.TitlePaneFactory;
import backEnd.Controller;

class ParameterPanel extends Panel {

	public ParameterPanel(BorderPane borderPane, Controller controller) {
		
		super(borderPane, controller);
		
		Accordion root = new Accordion();
		root.setPrefSize(borderPane.getPrefWidth()/4, borderPane.getPrefHeight()/5);
		
		TitlePaneFactory factory = new TitlePaneFactory();
		
		//Pen color
		//Background color
		//Turtle image
		for (TitledPane tp : factory.buildAllTitleFrames(controller)) {		
			root.getPanes().add(tp);
		}
		
		borderPane.setRight(root);
		
	}

}
