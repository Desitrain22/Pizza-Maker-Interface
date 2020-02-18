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
public class Client extends Thread implements Serializable
{ 
    // initialize socket and input output streams
    private static double price;
    private Socket socket; 
    private DataInputStream  input; 
    private DataOutputStream out; 
    private ObjectOutputStream obOut;
    private ObjectInputStream inOb;
    private transient ArrayList<Topping> arr;
    private static ArrayList<Topping> newArr;
    // constructor to put ip address and port 
    public Client()
    {
    }
    public Client(String address, int port, String x, ArrayList<Topping> p, int count) throws ClassNotFoundException
    { 
        // establish a connection 
        arr = new ArrayList<Topping>();
        for (Topping t : p)
        {
            arr.add(t);
        }
        try
        { 
            socket = new Socket(address, port); 
            System.out.println("Connected"); 

            // takes input from terminal 
            input  = new DataInputStream(System.in); 

            // sends output to the socket 
            out = new DataOutputStream(socket.getOutputStream());
            obOut = new ObjectOutputStream(socket.getOutputStream());
            inOb = new ObjectInputStream(socket.getInputStream());
        } 
        catch(UnknownHostException u) 
        { 
            System.out.println(u); 
        } 
        catch(IOException i) 
        { 
            System.out.println(i); 
        } 

        // string to read message from input 
        String line = ""; 

        // keep reading until "Over" is input 
        

        try
        { 
            while (count == 1)
            {
                //out.writeUTF(x);
                obOut.writeObject(arr);
                
                //obOut.writeObject(x);
                count++;
            }
            while(count == 0)
            {
                try 
                {
                    newArr = (ArrayList<Topping>)inOb.readObject();
                    count--;
                }
                catch(IOException e)
                {
                    System.out.print(e);
                }
            }
        } 
        catch(IOException i) 
        { 
        } 

        // // close the connection 
        try
        { 
            input.close(); 
            out.close();

            obOut.close();
            socket.close(); 
        } 
        catch(IOException i) 
        { 
        } 
    } 

    public static void main(String args[]) throws ClassNotFoundException
    { 
        
        Scanner scan = new Scanner(System.in);
        System.out.println("What do you want the size to be?(S, M, or L)");
        String size = scan.next();
        Pizza p = new Pizza(size);
        String name = "";
        String ans = "yes";
        String coverage = "";
        int amount;
        System.out.println("Available toppings:\n-Tomatoes\t-Onion  \t-Olives\n-Green Pepper\t-Jalapeno \t-Pineapple\n-Chicken\t-Bacon  \t-Pepperoni");
        while (ans.equals("yes") || ans.equals("Yes"))
        {
            System.out.println("What toppings do you want?");
            name = scan.next();
            System.out.println("Do you want topping on whole Pizza or Half of Pizza?(W/H)");
            coverage = scan.next();
            if (coverage.equals("H") || coverage.equals("Half"))
            {
                System.out.println("Which side of Pizza do want this topping to be placed?(L/R)");
                coverage = scan.next();
            }
            System.out.println("On a scale of 1-4, how much do you want (4 being the most)");
            amount = scan.nextInt();
            if (name.equals("Tomatoes") || name.equals("tomatoes"))
            {
                Tomatoes toma = new Tomatoes(name, coverage, amount);
                p.addInfo(toma);
            }
            if (name.equals("Bacon") || name.equals("bacon"))
            {
                Bacon baco = new Bacon(name, coverage, amount);
                p.addInfo(baco);
            }
            if (name.equals("Onion") || name.equals("onion"))
            {
                Onion onio = new Onion(name, coverage, amount);
                p.addInfo(onio);
            }
            if (name.equals("Olives") || name.equals("olives"))
            {
                Olives oliv = new Olives(name, coverage, amount);
                p.addInfo(oliv);
            }
            if (name.equals("Green Pepper") || name.equals("green pepper") || name.equals("GreenPepper") || name.equals("greenpepper"))
            {
                greenPepper grpe = new greenPepper(name, coverage, amount);
                p.addInfo(grpe);
            }
            if (name.equals("Jalapeno") || name.equals("jalapeno"))
            {
                Jalapeno jala = new Jalapeno(name, coverage, amount);
                p.addInfo(jala);
            }
            if (name.equals("Pineapple") || name.equals("pineapple"))
            {
                Pineapple pine = new Pineapple(name, coverage, amount);
                p.addInfo(pine);
            }
            if (name.equals("Chicken") || name.equals("chicken"))
            {
                Chicken chic = new Chicken(name, coverage, amount);
                p.addInfo(chic);
            }
            if (name.equals("Pepperoni") || name.equals("pepperoni"))
            {
                Pepperoni pepp = new Pepperoni(name, coverage, amount);
                p.addInfo(pepp);
            }

            System.out.println("Do you want more toppings?");
            ans = scan.next();
        }
        System.out.println("Would you like a drink?");
        ans = scan.next();
        if(ans.equals("yes") || ans.equals("Yes"))
        {
            Drink drink = new Drink("Drink", "Regular", 1);
            p.addInfo(drink);
        }
        System.out.println("Would you like any sides?");
        ans = scan.next();
        if(ans.equals("yes") || ans.equals("Yes"))
        {
            // System.out.println("Would you like a Salad?");
            // String y = scan.next();
            // if(y.equals("yes") || y.equals("Yes"))
            // {
                // Salad salad = new Salad("Salad", "Regular", 1);
                // p.addInfo(salad);
            // }
            System.out.println("Would you like chips?");
            String s = scan.next();
            if(s.equals("yes") || s.equals("Yes"))
            {
                Chips chips = new Chips("Chips", "Regular", 1);
                p.addInfo(chips);
            }
            System.out.println("Would you like a cookie?");
            String b = scan.next();
            if(b.equals("yes") || b.equals("Yes"))
            {
                Cookie cookie = new Cookie("Cookie", "Regular", 1);
                p.addInfo(cookie);
            }
            
        }
        p.slicePizza();
        price = p.determinePrice();
        System.out.println(p.toString());
        String toppingList = "";
        for (Topping t: p.getTopping())
        {
            toppingList += t.toString() + "\n"; 
        }
        Client c = new Client("10.215.56.165", 5001, toppingList, p.getTopping(), 1);
        boolean num = true;
        while(num)  {
            try
            {
                
                Client c1 = new Client("10.215.56.165", 5002, toppingList, p.getTopping(), 0);
                num = false;
            }
            
            catch(Exception E)
            {
                System.out.print("Waiting");
            }
        }
        Audio.playAudio();
        Paint.paint();
    }
    public static ArrayList<Topping> getNewArr()
    {
        return newArr;
    }
    public static double getPrice()
    {
        return price;
    }
}
