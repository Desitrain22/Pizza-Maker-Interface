import java.awt.Graphics;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * Write a description of class Chips here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Chips extends Topping
{
        static BufferedImage chips;
    /**
     * Constructor for objects of class Pineapple
     */
    public Chips(String n)
    {
        // initialise instance variables
        super(n);
        
    
    }
    public Chips(String n, String c, int a)
    {
        // initialise instance variables
        super(n, c, a);
       
    
    }
    public void placeTopping(Graphics g, int x, int y)
    {        
         try 
        {
            chips= ImageIO.read(new File("Chips.png"));
        }
        catch(Exception E)
        {
            System.out.println("Error loading image");
        }
        g.drawImage(chips, x, y, null);
    }
}
