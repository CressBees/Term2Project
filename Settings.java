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
 * 4/08/2022
 */
public class Settings
{
    // instance variables - replace the example below with your own
    /**
     * Constructor for objects of class Settings
     */
    String numberGetter;
    public Settings()
    {
        System.out.println("Debug_SettingsTestBeforeNumberGetter");
        

        introTextSettings();

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

    public void introTextSettings(){
        System.out.println("1 player 1");
        System.out.println("2 player 2");
        System.out.println("3 switch between AI modes");
    }

    //This method handles the player 1 profile
    //it does this by first asking what you want to do, then dumping you into a switch statment
    //the switch statement then activates whatever you want to do
    public void playerOneProfile(){
        System.out.println("");
        Scanner input = new Scanner(System.in); // make scanner for input
        numberGetter = input.nextLine();
        try{ //needed for writer to not break
            switch(numberGetter){
                case ("1"): // this one wipes all the dat in the Player1TrustsBetrays file
                FileWriter writer = new FileWriter("Player1TrustsBetrays");
                numberGetter = input.nextLine();
                System.out.println("You are going to wipe all data, are you sure?");
                System.out.println("[TBD]");
                if(numberGetter == "1"){
                    System.out.println("debug_Success");
                    writer.write("[TBD]");
                    writer.close();
                    input.close();
                    break;
                } else {
                    System.out.println("debug_Fail");
                    writer.close();
                    input.close();
                    break;
                }
                case ("2"):
                
                break;
            }
        }
        catch (IOException e){
            e.printStackTrace();
            System.out.println("Error: Unexpected faliure, please check game files");
        }
    }

    //
    public void playerTwoProfile(){

    }
    //
    public void AIOptions(){

    }
}
