import java.awt.Graphics;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
/**
 * Write a description of class Cookie here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Cookie extends Topping
{
    // instance variables - replace the example below with your own
     static BufferedImage cookie;
    /**
     * Constructor for objects of class greenPepper
     */
    public Cookie(String n)
    {
        // initialise instance variables
        super(n);
    }
    public Cookie(String n, String c, int a)
    {
        // initialise instance variables
        super(n, c, a);
       
    }
    public void placeTopping(Graphics g, int x, int y)
    {        
         try 
        {
            cookie= ImageIO.read(new File("Cookie.png"));
        }
        catch(Exception E)
        {
            System.out.println("Error loading image");
        }
        g.drawImage(cookie, x, y, null);
    }
}
