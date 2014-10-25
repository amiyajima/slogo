package backEnd.turtle;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

/**
 * Pen class for SLogo. Pen is a passive data object. We made it as such because it will
 * always be held by a turtle and allowed for us to package the properties related to the pen
 * together while separating it from the rest of the turtle's implementation. 
 * 
 * @author Ethan Chang
 *
 */
public class Pen {
    public static final double DEFAULT_PEN_COLOR = 1.0;
    public static final double DEFAULT_PEN_SIZE = 1.0;
    public static final String DEFAULT_PEN_COLOR_PACKAGE = "/resources/PenColors.properties";
    
    private DoubleProperty myPenColor;
    private DoubleProperty myPenSize;
    private Properties myPenColorProperty;
    
    
    /**
     * Constructor to initialize the pen
     */
    public Pen () {
        myPenColor = new SimpleDoubleProperty(DEFAULT_PEN_COLOR);
        myPenSize = new SimpleDoubleProperty(DEFAULT_PEN_SIZE);

        
        myPenColorProperty = new Properties();
        InputStream inputStream = getClass().getResourceAsStream(DEFAULT_PEN_COLOR_PACKAGE);
        try {
            myPenColorProperty.load(inputStream);
        } 
        catch (IOException e) {
            e.printStackTrace();
        }        
    }
    
    /**
     * Retrieves the pen's color property
     * @return color property
     */
    public DoubleProperty getMyPenColorProperty () {
        return myPenColor;
    }
    
    /**
     * Retrieves the pen's color
     * @return index of pen color
     */
    public double getMyPenColor () {
        return myPenColor.doubleValue();
    }
    
    /**
     * Retrieves the pen's size
     * @return pen's size
     */
    public DoubleProperty getMyPenSize () {
        return myPenSize;
    }
    
    /**
     * Set the penColor
     * @param index
     */
    public void setMyPenColor (double index) {
        myPenColor.setValue(index);
    }
    
    /**
     * Set the pen's size
     * @param size size of pen's stroke 
     */
    public void setMyPenSize (double size) {
        myPenSize.setValue(size);
    }
}
