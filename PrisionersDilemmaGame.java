/**
 * Prisoners Dilemma Game
 * Made by: Benji Cresswell
 * v0.3.1
 * last update 28/07/2022 (d/m/y)
 * This is the primary class, the one that you need to run
 * to start the game
 */

//Changelog:
//Fixed bug involving ai prison years
//Stored past scores
//Log of past games added

// Imports for dif parts
import java.util.Scanner; // Look through keyboard input
import java.util.Random; //gets random numbers
// import java.util.Skynet; //useful for machine learning
import java.io.File; // does stuff w/ files
import java.io.FileWriter; //Write to files
import java.io.IOException; //makes code not break, or at least break less

public class PrisionersDilemmaGame {
    // instance variables - replace the example below with your own
    boolean isSecondPlayer; // if there is a second player
    boolean playerOneChoice; // players decision on if trust or betray
    boolean playerTwoChoice; // if there is anthother player, this is there choice
    boolean AIChoice; // wheather the ai will betray or trust
    boolean enableAI; // if the AI needs to be used
    int outcomePlayerOne; // The amount of years in prison player 1 will recive
    int outcomePlayerTwo; // The amount of years in prison player 2/AI will recive
    int outcomeTotal; // The amount of years in prison each side will recive in total
    int defectSubtraction = 1; // how much defecting lessins your sentance, def is 1
    int defectAddition = 3; // how much defecting increases the other players, def is 3
    String numberGetter; // gets numbers

    /**
     * Constructor for objects of class PrisonersDilemmaGame
     */
    public static void main(String[] args) {
        // this.PrisonersDilemmaGame();
    }

    public PrisionersDilemmaGame() {
        // Introductions & Explanations, done of launch
        introText();
        // Sends the player to where they want to go
        switch (location()) {
            case 1:
            System.out.println("you're playing the game");
            prisonFunc();
            break;
            case 2:
            System.out.println("settings");
            new Settings();
            break;
            case 3:
            System.out.println("Error: Incorrect Input detected, restarting");
            new PrisionersDilemmaGame();
            break;

        }
    }

    public void introText() {
        System.out.println("Welcome to the Prisoners Dilemma");
        System.out.println("This is a classic game theory experiment");
        System.out.println("press 1 to go to the game and 2 to edit options");
        System.out.println("N.b. set up a profile in the options menu to save past results");
    }

    public byte location() {
        Scanner locationInput = new Scanner(System.in); // make scanner for input
        System.out.println("Where go?");
        numberGetter = locationInput.nextLine();
        if (numberGetter.equals("1") | numberGetter.equals("2")) { // if it is a one or two
            if (numberGetter.equals("1")) {
                return (1); // goto game
            } else {
                return (2); // goto options
            }
        } else {
            return (3); // not one or 2, try again
        }
    }

    // Runs the Prison Game Part
    public void prisonFunc() {
        System.out.println("You are now playing the prisoners Dilemma");
        System.out.println("You are a prisoner, you and your co-consqiritor have been caught robbing a bank");
        System.out.println("The police have given both you and your comrade a choice");
        System.out.println(
            "You could remain silent(cooperate) Or, you could defect and provide a testimony to the police");
        System.out.println("If you chose to cooperate the police will give you one year in prison");
        System.out.println(
            "and if you defect the police will remove a year from your sentence but add three to your partners");
        System.out.println(
            "the catch is that your partner is also making these choices and if you play nice, they may betray you");
        System.out.println("Your goal is to minimize the number of years you spend in prison");
        System.out.println("--------------------------------------------------------------------------------------------------------");
        System.out.println("Some notes");
        System.out.println("at certain points when you make your choices you will be asked to input either a 1 or 2,");
        System.out.println("DO NOT input anything other than the requested inputs or unexpected errors may occur");
        System.out.println("have fun");

        if (isSecondPlayer() == true) {
            enableAI = false;
        } else {
            enableAI = true;
        }

        if (enableAI == true) {
            if (getAIDecision() == true) {
                AIChoice = true; // AI coops
                System.out.println("you have been trusted by the AI!");
            } else {
                AIChoice = false; // AI betrays
                System.out.println("you have been betrayed by the AI!");
            }
        }

        // gets player ones choice
        if (getPlayerChoice() == true) {
            playerOneChoice = true; // player cooperates
        } else {
            playerOneChoice = false; // player defects
        }

        // gets player twos results
        if(enableAI == false){
            System.out.println("P2");
            if (getPlayerChoice() == true) {
                playerTwoChoice = true; // player2 coops
                System.out.println("2True");
            } else {
                playerTwoChoice = false; // player two defects
                System.out.println("2False");
            }
        }

        getResults();
        if(playAgain()==true){
            new PrisionersDilemmaGame();
        }

    }

    // Finds out if the first player cooperates or defects
    public boolean getPlayerChoice() {
        Scanner keyboardInput = new Scanner(System.in);
        for (int i = 0; i < 6; i++) { // for loop so if player eneters bad input they can try again
            System.out.println("Input a 1 for cooperate and 2 for defect");
            String playerInput = keyboardInput.nextLine(); // get user input
            if (playerInput.equals("1")) {
                keyboardInput.close(); //closes scanner
                return (true); // Trust
            } else if (playerInput.equals("2")) {
                keyboardInput.close();
                return (false); // Betray
            } else {
                System.out.println("Error: Unrecognised input, please try again");
                System.out.println("outputting debug info" + i);
            }
        }

        System.out.println("Error: Unrecognised Error"); // if the player enters unreadable info 6 times in row it will
        // just default to true
        return (true);
    }

    // finds out if there is a second player
    // it makes a keyboard input variable and gets the input of the player
    public boolean isSecondPlayer() {
        Scanner keyboardInput = new Scanner(System.in);
        for(int i = 0; i < 6; i++) { // for loop is so that if the player enters an unrecognised input they can try
            // again, it stops at six attempts
            System.out.println("Input a 1 if there is a second player and a 2 if there is not");
            String playerInput = keyboardInput.nextLine(); // get user input
            if (playerInput.equals("2")) {
                System.out.println("False");
                keyboardInput.close(); //closes scanner
                return (false); // there is not a second player
            } else if (playerInput.equals("1")) {
                System.out.println("True");
                keyboardInput.close();
                return (true); // there is a second
            } else { // if the user does not enter a 0 or 1 it goes back to the start
                System.out.println("Error: Unrecognised input, please try again");
                System.out.println("outputting debug info" + i);
            }
        }

        System.out.println("Error: Unrecognised Error, returning true"); // if the player enters unreadable info 6 times
        // in row it will just defualt to true
        return (true);
    }
    // this meth decides whether the AI will coop or defect, for now it will just
    // decide randomly will make more advanced later
    public boolean getAIDecision() {
        int trustCooeffciant = 50; // this is how trustworthy the AI thinks the player is, I will make this more
        // advanced later
        int randomNumber = (int) Math.floor(Math.random() * (100 - 1 + 1) + 1); // generates a random number between 1
        // and 100(inclusive)
        if (randomNumber > trustCooeffciant) { // if the generated random number is larger than the trust coefficient
            // then is will trust you, but if not it will betray you
            System.out.println("AITrust");
            return (true);
        } else {
            System.out.println("AIBetray");
            return (false);
        }
    }

    // This handles the results of the game, it adds all the results of the
    // defections up, if both players coop, it does nothing
    // at base defect subract == 3
    public void getResults() {
        outcomePlayerOne = 1; // each player starts with one year in prison
        outcomePlayerTwo = 1;
        if (playerOneChoice == false) { //if  p1 defects it will subtract from his years and add to other
            outcomePlayerOne = outcomePlayerOne - defectSubtraction;
            outcomePlayerTwo = outcomePlayerTwo + defectAddition;
        }
        if (playerTwoChoice == false&&enableAI == false){ //same as prev but w/ AI as well
            outcomePlayerTwo = outcomePlayerTwo - defectSubtraction;
            outcomePlayerOne = outcomePlayerOne + defectAddition;
        }
        if (enableAI == true&&AIChoice == false){
            outcomePlayerTwo = outcomePlayerTwo - defectSubtraction;
            outcomePlayerOne = outcomePlayerOne + defectAddition;
        }

        outcomeTotal = outcomePlayerOne + outcomePlayerTwo; // p1 yrs + p2 yrs
        System.out.println("Player 1 gets " + outcomePlayerOne + " years in prison");
        System.out.println("Player 2 gets " + outcomePlayerTwo + " years in prison");
        System.out.println("in total you got a combined " + outcomeTotal + " years in prison");

        //this part writes to a file containing records of p1's past moves
        //It does this by 
        try{
            FileWriter writer = new FileWriter("Player1TrustsBetrays",true);
            if(playerOneChoice == true){
                writer.write("1,");
                writer.close();
            }
            else if(playerOneChoice == false){
                writer.write("2,");
                writer.close();
            }
            else{
                System.out.println("Error: an unreachable state has been reached, please check if reality is working");
            }
        }
        catch (IOException e){
            e.printStackTrace();
            System.out.println("Error: Writing Failed, please check the games integrity");
        }
        try{
            FileWriter writer = new FileWriter("Player2TrustsBetrays",true);
            if(playerTwoChoice == true){
                writer.write("1,");
                writer.close();
            }
            else if(playerTwoChoice == false){
                writer.write("2,");
                writer.close();
            }
            else{
                System.out.println("Error: an unreachable state has been reached, please check if reality is working");
            }
        }
        catch (IOException e){
            e.printStackTrace();
            System.out.println("Error: Writing Failed, please check the games integrity");
        }

    }

    // This meth handles if you play again
    public boolean playAgain() {
        System.out.println("Would you like to play again?");
        Scanner keyboardInput = new Scanner(System.in);
        for (int i = 0; i < 6; i++) { // for loop is so that if the player enters an unrecognised input they can try again.
            // it stops at six attempts
            System.out.println("press 1 for yes and 2 for no");
            String playerInput = keyboardInput.nextLine();
            if (playerInput.equals("1")) {
                System.out.println("1");
                keyboardInput.close(); //closes scanner
                return (true); //play again
            } else if (playerInput.equals("2")) {
                System.out.println("2");
                keyboardInput.close();
                return (false); //don't play again
            } else {
                System.out.println("3");
                System.out.println("Error, Unrecognised input. Please try again");
            }
        }
        System.out.println("Unknown Error, Defaulting to true"); // if six attempts fail it defaults to true
        return (true);
    }
}