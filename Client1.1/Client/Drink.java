import java.awt.Graphics;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
/**
 * Write a description of class Drink here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Drink extends Topping
{
     static BufferedImage drink;
    /**
     * Constructor for objects of class greenPepper
     */
    public Drink(String n)
    {
        // initialise instance variables
        super(n);
    }
    public Drink(String n, String c, int a)
    {
        // initialise instance variables
        super(n, c, a);
       
    }
    public void placeTopping(Graphics g, int x, int y)
    {        
         try 
        {
            drink= ImageIO.read(new File("Drink.png"));
        }
        catch(Exception E)
        {
            System.out.println("Error loading image");
        }
        g.drawImage(drink, x, y, null);
    }
}
