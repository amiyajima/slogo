package frontEnd;

import javafx.scene.Node;
import backEnd.Controller;

/**
 * An abstract panel class that creates a panel and adds to the appropriate
 * group
 * 
 * @author Brian Bolze
 * @author Ethan Chang
 * @author Eli Lichtenberg
 * @author Anna Miyajima
 * 
 */
abstract class Panel extends Node {
    /**
     * Create a new panel given what root it should be added to and what
     * controller handles its actions.
     * 
     * @param root
     * @param controller
     */
    Panel (Node root, Controller controller) {
    }

}
