package backEnd.turtle;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class Pen {
    public static double DEFAULT_PEN_COLOR = 1.0;
    public static double DEFAULT_PEN_SIZE = 1.0;
    public static final String DEFAULT_PEN_COLOR_PACKAGE = "/resources/PenColors.properties";
    
    private DoubleProperty myPenColor;
    private DoubleProperty myPenSize;
    private Properties myPenColorProperty;
    
    
    public Pen() {
        myPenColor = new SimpleDoubleProperty(DEFAULT_PEN_COLOR);
        myPenSize = new SimpleDoubleProperty(DEFAULT_PEN_SIZE);

        
        myPenColorProperty = new Properties();
        InputStream inputStream = getClass().getResourceAsStream(DEFAULT_PEN_COLOR_PACKAGE);
        try {
            myPenColorProperty.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }        
    }
    
    public DoubleProperty getMyPenColorProperty() {
        return myPenColor;
    }
    
    public double getMyPenColor() {
        return myPenColor.doubleValue();
    }
    
    public DoubleProperty getMyPenSize() {
        return myPenSize;
    }
    
    public void setMyPenColor(double index) {
        myPenColor.setValue(index);
    }
    
    public void setMyPenSize(double index) {
        myPenSize.setValue(index);
    }
}
