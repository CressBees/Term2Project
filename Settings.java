import java.util.Scanner; // Look through keyboard input
import java.util.Random; //gets random numbers
// import java.util.Skynet; //useful for machine learning
import java.io.File; // does stuff w/ files
import java.io.FileWriter; //Write to files
import java.io.IOException; //makes code not break, or at least break less
/**
 * This part handles settings
 *
 * Benji
 * 28/07/2022
 */
public class Settings extends PrisionersDilemmaGame
{
    // instance variables - replace the example below with your own
    /**
     * Constructor for objects of class Settings
     */
    public Settings()
    {
        String numberGetter;
        
        
        introText();
        
        
        Scanner locationInput = new Scanner(System.in); // make scanner for input
        System.out.println("Where go?");
        numberGetter = locationInput.nextLine();
        int i = numberGetter.;
        locationInput.close();
        switch(numberGetter){
            case 1:
            
            break;
            case 2:
            
            
            break;
            case 3:
            
            break;
        }
    }
    public void introText(){
        System.out.println("1 to make a profile");
        System.out.println("2 to edit/delete a profile");
        System.out.println("3 switch between AI modes");
    }
}
