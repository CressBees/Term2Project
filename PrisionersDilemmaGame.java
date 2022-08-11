/**
 * Prisoners Dilemma Game
 * Made by: Benji Cresswell
 * v0.4
 * last update 11/08/2022 (d/m/y)
 * This is the primary class, the one that you need to run
 * to start the game
 */

//Changelog:
//Added Settings
//  --Settings is extremly bugged at the moment

// Imports for dif parts
import java.util.Scanner; // Look through keyboard input
import java.util.Random; //gets random numbers
// import java.util.Skynet; //useful for machine learning
import java.io.File; // does stuff w/ files
import java.io.FileWriter; //Write to files
import java.io.IOException; //makes code not break, or at least break less

public class PrisionersDilemmaGame {
    // instance variables - replace the example below with your own

    /**
     * Constructor for objects of class PrisonersDilemmaGame
     */
    public static void main(String[] args) {
        //this.PrisonersDilemmaGame();
    }

    public PrisionersDilemmaGame() {
        // Introductions & Explanations, done of launch
        introText();
        // Sends the player to where they want to go
        if(inputOutput() == true){
            System.out.println("you're playing the game");
            new Game(this);
        } else {
            System.out.println("settings!");
            Settings Settings = new Settings();
            System.out.println("debug_test");
        }
    }

    public void introText() {
        System.out.println("Welcome to the Prisoners Dilemma");
        System.out.println("This is a classic game theory experiment");
        System.out.println("press 1 to go to the game and 2 to edit options");
        System.out.println("N.b. set up a profile in the options menu to save past results");
    }

    //this one gets input for location, it should be a binary method but I realised that far too late
    // also the if elses should be a switch but bruh

    //This handles I/O for the program
    public boolean inputOutput() {
        Scanner input = new Scanner(System.in); // make scanner for input
        String numberGetter; // gets numbers
        for(byte i = 0; i >= 6; i++){ //for loop so user can make mult tries
            numberGetter = input.nextLine();
            System.out.println("debug_NumberGetter"); //debug
            switch(numberGetter){
                case "1":
                input.close(); //close the scanner
                System.out.println("debug_true"); //debug
                return(true); //true
                case "2":
                input.close();
                System.out.println("debug_false"); //debug
                return(false); //false
                default: //if bad input, try again
                System.out.println("Error: unrecognised input, please enter ONLY a 1 or 2");
                break;
            }
        }
        System.out.println("Error, too many failed attempts, defaulting to false");
        return(false); //if too many fails, def to false
    }
}