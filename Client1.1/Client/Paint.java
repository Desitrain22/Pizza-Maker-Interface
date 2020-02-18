import java.net.*; 
import java.io.*; 
import java.util.Scanner;
import java.util.ArrayList;
import java.io.Serializable;
import java.awt.Graphics;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.swing.JFrame;
import javax.swing.JComponent;
import java.awt.Graphics; 
/**
 * Write a description of class paint here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Paint extends JComponent
{
    static BufferedImage pizzaImage;
    static BufferedImage table;
    static BufferedImage text;
    static BufferedImage name;
    public static void paint()
    {

        
        JFrame frame=new JFrame();
        Paint comp = new Paint();
        frame.add(comp);
        frame.setSize(1000, 800);
        frame.setVisible(true);
        try
        {
            pizzaImage=ImageIO.read(new File("Cheese.png"));
        }
        catch(Exception E)
        {
            System.out.println("error loading image");
        }
        try
        {
            table=ImageIO.read(new File("Table.jpg"));
        }
        catch(Exception E)
        {
            System.out.println("error loading image");
        }
        try
        {
            text=ImageIO.read(new File("text.png"));
        }
        catch(Exception E)
        {
            System.out.println("error loading image");
        }
        try
        {
            name=ImageIO.read(new File("Name.png"));
        }
        catch(Exception E)
        {
            System.out.println("error loading image");
        }
        frame.repaint();
    }

    public void paintComponent(Graphics g)
    {
        g.drawImage(table, 0, 0, null);
        g.drawImage(pizzaImage, 0, -30, null);
        g.drawImage(name,600,0,null);
        for(Topping t:Client.getNewArr())
        {
            t.placeTopping(g, t.getX(), t.getY());
        }
    }
}
