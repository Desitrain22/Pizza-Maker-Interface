import java.awt.Graphics;
import java.awt.Color;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.swing.JFrame;
import javax.swing.JComponent;
/**
 * Write a description of class onionTester here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class onionTester extends JComponent
{
    public static void main(String args[])
    {
        JFrame frame=new JFrame();
        onionTester comp=new onionTester();
        frame.add(comp);
        frame.setSize(1000, 500);
        frame.setVisible(true);
    }
    public void paintComponent(Graphics g)
    {
        Onion o1=new Onion("Onion");
        o1.placeTopping(g, 0, 0);
    }
}
