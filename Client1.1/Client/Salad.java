import java.awt.Graphics;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
/**
 * Write a description of class Salad here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Salad extends Topping
{
     static BufferedImage salad;
    /**
     * Constructor for objects of class greenPepper
     */
    public Salad(String n)
    {
        // initialise instance variables
        super(n);
    }
    public Salad(String n, String c, int a)
    {
        // initialise instance variables
        super(n, c, a);
       
    }
    public void placeTopping(Graphics g, int x, int y)
    {        
         try 
        {
            salad= ImageIO.read(new File("Salad.png"));
        }
        catch(Exception E)
        {
            System.out.println("Error loading image");
        }
        g.drawImage(salad, x, y, null);
    }
}
