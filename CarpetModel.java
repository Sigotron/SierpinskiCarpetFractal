import java.util.*;
import java.awt.*;
/**
 * Model for recursive Sierpinski Carpet design. Contains recursive method that will draw a 
 * Sierpinski Carpet at different levels.
 * 
 * @author Joel Sigo 
 * @version 02/03/2013
 */
public class CarpetModel {
    // instance variables
    private int level, baseX, baseY, size;
    private ArrayList<CarpetListener> listeners;
    
    // class constant
    public final double third = .333333333333333333;

    /**
     * Constructor for objects of class CarpetModel
     * @param initialLevel represents starting level of Sierpinski Carpet
     * @param x represents x coordinate of upper left corner of Sierpinski Carpet model
     * @param y represents y coordinate of upper left corner of Sierpinski Carpet model
     * @param w represents width and height of Sierpinski Carpet model
     */
    public CarpetModel(int initialLevel, int x, int y, int w) {
        if (initialLevel < 0) throw new IllegalArgumentException();
        level = initialLevel;
        listeners = new ArrayList<CarpetListener>();
        baseX = x;
        baseY = y;
        size = w;
    }
    
    /**
     * allows model to keep track of views that need to query CarpetModel
     * @param c represents CarpetListener to be added to ArrayList listeners
     */
    public void addListener(CarpetListener c) {
        if (c == null) throw new NullPointerException();
        listeners.add(c);
        c.levelChanged();
    }
    
    /**
     * changes level of Sierpinski Carpet model
     * @param change represents number of levels to change
     */
    public void changeLevel(int change) {
        if (level + change < 0) throw new IllegalArgumentException("Level must be > 0");
        level += change;
        notifyAllListeners();
    }
    
    /**
     * returns level of Sierpinski Carpet model
     * @return level of Sierpinski Carpet model as int
     */
    public int getLevel() {
        return level;
    }
    
    /**
     * public method for recursive method that draws Siepinski Carpet
     * @param g Graphic object to draw Sierpinski Carpet on
     */
    public void drawCarpet(Graphics g) {
        drawCarpets(level, baseX, baseY, size, g);
    }
    
    /**
     * private recursive method that draws Sierpinski Carpet
     * @param level represents number of levels of Sierpinski Carpet
     * @param x represents upper left x-coordinate of Sierpinski Carpet
     * @param y represents upper left y-coordinate of Sierpinski Carpet
     * @param w represents width and height of Sierpinski Carpet
     * @param g Graphic object to draw Sierpinski Carpet on
     */
    private void drawCarpets(int level, int x, int y, int w, Graphics g) {
        int num = (int)(third * w);
        if (level == 0) { // do nothing
        } else if (level == 1) { // base case
            g.fillRect(x + num, y + num, num, num);
        } else { //recursive case, split into 9 squares
            g.fillRect(x + num, y + num, num, num); // CENTER
            drawCarpets(level - 1, x, y, num, g); // UL
            drawCarpets(level - 1, x + num, y, num, g); // UM
            drawCarpets(level - 1, x + 2 * num, y, num, g); // UR
            drawCarpets(level - 1, x, y + num, num, g); // ML
            drawCarpets(level - 1, x + 2 * num , y + num, num, g); // MR
            drawCarpets(level - 1, x, y + 2 * num, num, g); // BL
            drawCarpets(level - 1, x + num, y + 2 * num, num, g); // BM
            drawCarpets(level - 1, x + 2 * num, y + 2 * num, num, g); // BR
        }
    }
    
    /**
     * notifys all listeners/views that the model has changed so they can
     * react appropriatly
     */
    private void notifyAllListeners() {
        Iterator<CarpetListener> it = listeners.iterator();
        while (it.hasNext()) {
            CarpetListener c = it.next();
            c.levelChanged();
        }
    }
}
