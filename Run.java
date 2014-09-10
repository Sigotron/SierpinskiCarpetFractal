import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
/**
 * Runs Sierpinski Carpet Program
 * 
 * @author Joel Sigo
 * @version 02/06/2013
 */
public class Run {
    public static void main(String[] args) {
        JFrame win = new JFrame();
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        CarpetModel joel = new CarpetModel(0,0,0,800);
        win.getContentPane().add(new GraphicView(joel, 800), BorderLayout.CENTER);
        win.getContentPane().add(new CarpetController(joel), BorderLayout.SOUTH);
        PrintView view = new PrintView(joel);
        win.pack();
        win.setVisible(true);
    }
}
