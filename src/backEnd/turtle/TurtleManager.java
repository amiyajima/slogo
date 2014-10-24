package backEnd.turtle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Stack;

/**
 * Turtle manager for slogo. Keeps track of all turtles as well as which ones
 * are active/inactive. These lists are kept on a stack where the bottom-most
 * list is a list of all current active turtles. Once temporary lists are used
 * (ask commands) they can be popped on the stack.
 *
 * @author Ethan Chang
 *
 */
public class TurtleManager extends Observable {

    public static final String INITIAL_TURTLE = "turtle1";

    private Map<Double, Turtle> myTurtles;
    private double myCanvasWidth;
    private double myCanvasHeight;
    private Stack<List<Turtle>> myStoredTurtleLists;
    private List<Turtle> myActiveTurtles;
    private String activeId;

    /**
     * Constructor for turtle manager. Initializes a map which will map the
     * string names of turtles (their id) with the actual turtle. Also creates
     * the stack which will be used to keep track of temporary and active turtle
     * lists. Does not initially add a turtle because observer must first be
     * attached before a new turtles can be added.
     *
     * @param canvasWidth
     *            the width of the canvas the turtle will be added to
     * @param canvasHeight
     *            the height of the canvas the turtle will be added to
     */
    public TurtleManager (double canvasWidth, double canvasHeight) {
        myTurtles = new HashMap<>();
        myCanvasWidth = canvasWidth;
        myCanvasHeight = canvasHeight;
        myStoredTurtleLists = new Stack<List<Turtle>>();
        myActiveTurtles = new ArrayList<>();
        myStoredTurtleLists.push(myActiveTurtles);
    }

    /**
     * Creates a new turtle if a with a given id does not already exist.
     *
     * @param turtleName
     *            id of the turtle
     */
    private void addNewTurtle (Double turtleId) {
        System.out.println("Turtle created");
        Turtle newTurtle = new Turtle(Double.toString(turtleId), myCanvasWidth, myCanvasHeight);
        myTurtles.put(turtleId, newTurtle);
        setChanged();
        notifyObservers(newTurtle); //change to TurtleProperties
    }

    /**
     * Creates a list of turtles. Begins by checking if there exists a turtle
     * with that id. If it does, it is added to the list, if it does not, a new
     * turtle is made, added to the map, and then the list.
     *
     * @param turtleNames
     *            list of names of the turtles desired
     * @return returns the list of turtles requested
     */
    private List<Turtle> createTurtleList (List<Double> turtleIds) {
        List<Turtle> turtleList = new ArrayList<>();
        for (Double s : turtleIds) {
            if (!myTurtles.keySet().contains(s)) {
                addNewTurtle(s);
            }
            turtleList.add(myTurtles.get(s));
        }
        return turtleList;
    }

    /**
     * Updates what the current active turtles are for the tell command. Since
     * tell commands overwrite previous tell commands, there is only a need for
     * one active turtle list.
     *
     * @param turtleNames
     *            list of names for turtles to be in active turtles
     */
    public void updateActiveTurtleList (List<Double> turtleIds) {
        List<Turtle> newActiveTurtles = createTurtleList(turtleIds);
        myActiveTurtles.clear();
        for(Turtle t : newActiveTurtles) {
            myActiveTurtles.add(t);
        }
    }

    /**
     * Creates a list of temporary turtles for the ask command. After the
     * command finishes, these commands should be forgotten, so we add them to
     * the top of the stack.
     * 
     * @param turtleNames
     */
    public void addTemporaryTurtleList (List<Double> turtleIds) {
        List<Turtle> turtleList = createTurtleList(turtleIds);
        myStoredTurtleLists.push(turtleList);

    }

    /**
     * Returns the appropriate turtle list at the top of the stack. If there in
     * an ask command, a temporary turtle list should be at the top of the
     * stack. For anything else it should be the active turtles list.
     *
     * @return list of turtles
     */
    public List<Turtle> getTurtleList () {
        System.out.println(myStoredTurtleLists.size());
        return Collections.unmodifiableList(myStoredTurtleLists.peek());
    }

    /**
     * Updates the stack. If a temporary list was just used it should be
     * removed. If there is only one item in the stack it must be an active
     * turtle list from the tell command. This should not be removed.
     */
    public void updateStoredTurtleLists () {
        if (myStoredTurtleLists.size() > 1) {
            myStoredTurtleLists.pop();
        }
    }
    
    public int getNumberOfTurtles() {
        return myTurtles.size();
    }

}
