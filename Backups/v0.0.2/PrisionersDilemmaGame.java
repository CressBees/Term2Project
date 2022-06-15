// Prisoners Dilemma Game
// Made by: Benji Cresswell
// v0.0.2
// This is the primary class, the one that you need to run
// to start the game

// Imports for dif parts
import java.util.Scanner; // Look through keyboard input
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
        switch(location()){
            case 1:
            System.out.println("you're playing the game");
            break;
            case 2:
            System.out.println("settings");
            case 3:
            System.out.println("Error: Incorrect Input dtected, please try again");
        }
    }

    static void introText()
    {
        System.out.println("Welcome to the Prisoners Dilemma");
        System.out.println("This is a classic game theory experiment");
        System.out.println("[insert other stuff here]");
    }

    static byte location()
    {
        Scanner locationInput = new Scanner(System.in); //make scanner for input
        System.out.println("Wherego?");
        byte desiredLocation = locationInput.nextByte(); //get where user wants to go
        if(desiredLocation < 3 && desiredLocation > 0){
            if(desiredLocation == 1){
                return(1); // goto game
            }
            else{
                return(2); //goto options
            }
        }
        else{
            return(3); //not one or 2, try again
        }
    }

}
