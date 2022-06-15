// Imports for dif parts
import java.util.Scanner; // Look through keyboard input
/**
 * Write a description of class PrisionersDilemmaGame here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class PrisionersDilemmaGame
{
    // instance variables - replace the example below with your own
    private int x;
    /**
     * Constructor for objects of class PrisionersDilemmaGame
     */
    public PrisionersDilemmaGame()
    {
        // initialise instance variables
        x = 0;
        // Introductions & Explainations, done of launch
        introText();
        
        
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public int sampleMethod(int y)
    {
        // put your code here
        return x + y;
    }
    public void introText()
    {
        System.out.println("Welcome to the Prisoners Dilemma");
        System.out.println("This is a classic game theory experiment");
        System.out.println("[insert other stuff here]");
    }
}
