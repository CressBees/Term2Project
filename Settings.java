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
        numberGetter = locationInput.nextLine(); // number getter becomes the input
        switch(numberGetter){
            case ("1"):
            playerOneProfile();
            break;
            case ("2"):
            playerTwoProfile();
            break;
            case ("3"):
            AIOptions();
            break;
            default:
            System.out.println("Error, unrecognised input");
        }
    }

    public void introText(){
        System.out.println("1 to make a profile");
        System.out.println("2 to playerTwoProfile");
        System.out.println("3 switch between AI modes");
    }

    public void playerOneProfile(){
        System.out.println("");
        
        switch(numberGetter){
            case ("1"):
            Scanner input = new Scanner(System.in); // make scanner for input
            numberGetter = input.nextLine();
            System.out.println("You are going to wipe all data, are you sure?");
            System.out.println("")
            if(numberGetter == "1"){
                System.out.println("debug_Success");
                break;
            } else
            case ("2"):
            break;
        }

    }

    //
    public void playerTwoProfile(){

    }
    //
    public void AIOptions(){

    }
}
