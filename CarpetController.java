import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 * CarpetController allows user to change the level of the CarpetModel utilizing
 * buttons.
 * 
 * @author Joel Sigo
 * @version 02/06/2013
 */
public class CarpetController extends JPanel implements ActionListener {
    // instance variable
    private CarpetModel model;

    /**
     * Constructor for objects of class CarpetController. Sets up buttons
     * and overall layout of JFrame.
     * @param m represents CarpetModel 
     */
    public CarpetController(CarpetModel m) {
        model = m;
        JButton up = new JButton("   UP   ");
        JButton down = new JButton("DOWN");
        this.add(up);
        this.add(down);
        up.addActionListener(this);
        down.addActionListener(this);
    }
    
    /**
     * defines action to be performed when user clicks on a button
     * @param e represents ActionEvent ie a button press
     */
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand() == "   UP   ") model.changeLevel(1);
        else if (model.getLevel() > 0) model.changeLevel(-1);
    }
}
