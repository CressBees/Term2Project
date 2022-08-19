import java.util.Scanner; // Look through keyboard input
import java.util.Random; //gets random numbers
// import java.util.Skynet; //useful for machine learning
import java.io.File; // does stuff w/ files
import java.io.FileWriter; //Write to files
import java.io.IOException; //makes code not break, or at least break less

/**
 * Write a description of class Game here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

public class Game
{
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
    PrisionersDilemmaGame currentGame;
    /**
     * Constructor for objects of class Game
     */
    public Game(PrisionersDilemmaGame game)
    {
        //Begin the game
        currentGame = game;
        prisonFunc();
    }

    //This meth is basically the hub world for all the other meths
    //
    public void prisonFunc() {
        System.out.println("You are now playing the prisoners Dilemma");
        System.out.println("You are a prisoner, you and your co-conspirator have been caught robbing a bank");
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
        //Line break for ease of reading

        System.out.println("Is there a second player?");
        System.out.println("Input a 1 for yes and 2 for no");
        if (currentGame.inputOutput() == 1) {
            enableAI = false;
        } else {
            enableAI = true;
        }

        //there is 100% a better way to do this, Too Bad!
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
        System.out.println("Input a 1 for cooperate and 2 for defect");
        if (currentGame.inputOutput() == 1) {
            playerOneChoice = true; // player cooperates
        } else {
            playerOneChoice = false; // player defects
        }

        // gets player twos results
        System.out.println("Input a 1 for cooperate and 2 for defect");
        if(enableAI == false){
            System.out.println("P2");
            if (currentGame.inputOutput() == 1) {
                playerTwoChoice = true; // player2 coops
                System.out.println("2True");
            } else {
                playerTwoChoice = false; // player two defects
                System.out.println("2False");
            }
        }

        getResults();

        System.out.println("Would you like to return to the menu");
        if(currentGame.inputOutput() == 1){
            new PrisionersDilemmaGame();
        } else {
            System.out.println("thank you for playing!");
        }

    }

    // this meth decides whether the AI will coop or defect, for now it will just
    // decide randomly will make more advanced later
    public boolean getAIDecision() {
        int randomNumber = (int) Math.floor(Math.random() * (100 - 1 + 1) + 1); // generates a random number between 1
        // and 100(inclusive)
        if (randomNumber > currentGame.trustCooeffciant) { // if the generated random number is larger than the trust coefficient
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
        //It does this by looking at the choices each player made
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
}
