// Prisoners Dilemma Game
// Made by: Benji Cresswell
// v0.1.2
// This is the primary class, the one that you need to run
// to start the game

// Imports for dif parts
import java.util.Scanner; // Look through keyboard input
import java.util.Random; //gets random numbers
public class PrisionersDilemmaGame
{
    // instance variables - replace the example below with your own
    boolean isSecondPlayer; //if there is a second player
    boolean playerOneChoice; // players decision on if trust or betray
    boolean playerTwoChoice; // if there is anthother player, this is there choice
    boolean AIChoice; // wheather the ai will betray or trust
    boolean enableAI; // if the AI needs to be used
    int outcomePlayerOne; //The amount of years in prison player 1 will recive
    int outcomePlayerTwo; //The amount of years in prison player 2/AI will recive
    int outcomeTotal; //The amount of years in prison each side will recive in total
    int defectSubtraction = 1; //how much defecting lessins your sentance
    int defectAddition = 3; // how much defecting increases the other players
    /**
     * Constructor for objects of class PrisionersDilemmaGame
     */
    public PrisionersDilemmaGame()
    {
        // Introductions & Explainations, done of launch
        introText();
        //Sends the player to where they want to go
        switch(location()){
            case 1:
            System.out.println("you're playing the game");
            prisonFunc();
            break;
            case 2:
            System.out.println("settings");
            break;
            case 3:
            System.out.println("Error: Incorrect Input dtected, please restart the program");
            break;

        }
    }

    static void introText()
    {
        System.out.println("Welcome to the Prisoners Dilemma");
        System.out.println("This is a classic game theory experiment");
        System.out.println("press 1 to go to the game and 2 to edit options");
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
    
    //Runs the Prison Game Part
    public void prisonFunc(){


        System.out.println("You are now playing the prisoners Dillemma");
        System.out.println("You are a prisoner, you and your co-consqiritor have been caught robbing a bank");
        System.out.println("The police have given both you and your comrade a choice");
        System.out.println("You could remain silent(cooperate) Or, you could defect(betray) and provide a testimoney to the police");
        System.out.println("If you chose to cooperate the police will give you one year in prision");
        System.out.println("and if you betray the police will remove a year from your sentence but add three to your partners");
        System.out.println("the catch is that your partner is also making these choices and if you play nice, they may betray you");
        System.out.println("Your goal is to minimize the number of years you spend in prison");
        System.out.println("--------------------------------------------------------------------------------------------------------");
        System.out.println("Some notes");
        System.out.println("at certain points when you make your choices you will be asked to input either a 1 or 0,");
        System.out.println("DO NOT input anything other than the requested inputs or unexpected errors or even crashes may occur");
        System.out.println("have fun");


        if(isSecondPlayer()==true)
        {
            enableAI = false;
        } else{
            enableAI = true;
        }

        if(enableAI==true){
            if(getAIDecision()==true){
                AIChoice = true; // AI coops
                System.out.println("you have been trusted by the AI!");
            }
            else{
                AIChoice = false; //AI betrays
                System.out.println("you have been betrayed by the AI!");
            }
        }
        
        //gets player ones choice
        if(getPlayerChoice()==true)
        {
            playerOneChoice = true; //player cooperates
        }
        else{
            playerOneChoice = false; // player defects
        }
        
        //gets player twos results
        if(getPlayerChoice()==true){
            playerTwoChoice = true; // player2 coops
        }
        else{
            playerTwoChoice = false; //player two defects
        }
        getResults();
        
    }
    //Finds out if the first player cooperates or defects
    public boolean getPlayerChoice()
    {
        Scanner keyboardInput = new Scanner(System.in); //make scanner for input
        for(int i = 0;i < 6;i++){ // for loop had a purpose but I got rid of that so it's just antiquated code I am too afraid to remove
            System.out.println("Input a 1 for cooperate and 0 for defect");
            byte playerInput = keyboardInput.nextByte(); //get use input
            if(playerInput == 0){
                return(false);
            }
            else if(playerInput == 1){
                return(true);
            }
            else{
                System.out.println("Error: Unrecognised input, please try again");
                System.out.println("outputting debug info"+i);
            }
        }
        System.out.println("Error: Unrecognised Error"); //if the player enters unreadable info 6 times in row it will just defualt to true
        return(true);
    }

    //finds out if there is a second player
    // it makes a keyboard input variable and gets the input of the player
    public boolean isSecondPlayer()
    {
        Scanner keyboardInput = new Scanner(System.in); //make scanner for input
        for(int i = 0;i < 6;i++){ // for loop is so that the player
            System.out.println("Input a 1 if there is a second player and a 0 if there is not");
            byte playerInput = keyboardInput.nextByte(); //get user input
            if(playerInput == 0){
                return(false);
            }
            else if(playerInput == 1){
                return(true);
            }
            else{ //if the user does not enter a 0 or 1  it goes back to the start
                System.out.println("Error: Unrecognised input, please try again");
                System.out.println("outputting debug info"+i);
            }
        }
        System.out.println("Error: Unrecognised Error, returning true"); //if the player enters unreadable info 6 times in row it will just defualt to true
        return(true);
    }

    // this meth decides whether the AI will coop or defect, for now it will just decide randomly will make more advanced later
    public boolean getAIDecision(){
        int trustCooeffciant = 50; // this is how trustworthy the AI thinks the player is, I will make this more advanced later
        int randomNumber = (int)Math.floor(Math.random()*(100-1+1)+1); // generates a random number between 1 and 100(inclusive)
        if(randomNumber > trustCooeffciant){ // if the generated random number is larger than the trust cooefficant then is will trust you, but if not it will betray you
            return(true);
        } else {
            return(false);
        }
    }

    //This handles the results of the game, it adds all the results of the defections up, if both players coop, it does nothing
    public void getResults(){
        outcomePlayerOne = 1; //each player starts with one year in prison
        outcomePlayerTwo = 1;
        if(playerOneChoice == false){
            outcomePlayerOne = outcomePlayerOne - defectSubtraction;
            outcomePlayerTwo = outcomePlayerTwo + defectAddition;
        }
        if(playerTwoChoice == false){
            outcomePlayerTwo = outcomePlayerTwo - defectSubtraction;
            outcomePlayerOne = outcomePlayerOne + defectAddition;
        }
        outcomeTotal = outcomePlayerOne + outcomePlayerTwo;
        System.out.println("Player 1 gets "+outcomePlayerOne+" years in prison");
        System.out.println("Player 2 gets "+outcomePlayerTwo+" years in prison");
        System.out.println("in total you got a combined "+outcomeTotal+" years in prison");
    }

}