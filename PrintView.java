
/**
 * PrintView querys model and displays level to the console
 * 
 * @author Joel Sigo
 * @version 02/06/2013
 */
public class PrintView implements CarpetListener{
    // instance variables
    private CarpetModel model;
    
    /**
     * Constructor for objects of class PrintView
     * @param m represents CarpetModel to be queried
     */
    public PrintView(CarpetModel m) {
        model = m;
        model.addListener(this);
    }
    
    /**
     * whenever CarpetModel changes level, displays level to console
     */
    public void levelChanged() {
        System.out.println("LEVEL: " + model.getLevel());
    }
}
