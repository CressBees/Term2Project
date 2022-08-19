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
    /**
     * Constructor for objects of class Settings
     */
    PrisionersDilemmaGame currentGame;
    String numberGetter;
    public Settings(PrisionersDilemmaGame game)
    {
        currentGame = game;
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
            while(true){
                System.out.println("You've been Gnomed!");
            }
        }
    }

    public void introTextSettings(){
        System.out.println("1 player 1");
        System.out.println("2 player 2");
        System.out.println("3 Other Options(AI, debug, etc...)");
    }

    //This method handles the player 1 profile
    //it does this by first asking what you want to do, then dumping you into a switch statment
    //the switch statement then activates whatever you want to do
    public void playerOneProfile(){
        System.out.println("1 for clear all data, 2 for fabricating, three for checking");
        try{ //needed for writer to not break
            FileWriter writer = new FileWriter("Player1TrustsBetrays",true);
            switch(currentGame.inputOutput()){
                case (1): // this one wipes all the dat in the Player1TrustsBetrays file
                System.out.println("You are going to wipe all data, are you sure?");
                System.out.println("[TBD]");
                if(currentGame.inputOutput() == 1){
                    System.out.println("debug_Success");
                    writer.write("");
                    writer.close();
                    break;
                } else {
                    System.out.println("debug_Fail");
                    writer.close();
                    break;
                }
                //--------------------------------------------------------------------------\\
                //add extra trusts or betrays to your file
                case (2):
                System.out.println("This will add extra trusts/betrays or years in prison to your record");
                Scanner input = new Scanner(System.in); //get other input
                String stringInput;
                switch(currentGame.inputOutput()){
                    case 1: //add trusts
                    System.out.println("how many trusts?");
                    stringInput = input.nextLine();
                    int number = Integer.parseInt(stringInput);
                    for(int i = 0; i >= number; i++){
                        writer.write("1, ");
                    }
                    break;
                    case 2:
                    System.out.println("how many betrays?");
                    stringInput = input.nextLine();
                    int number2 = Integer.parseInt(stringInput); //has to be number2 instead of number because otherwise it throws a weird error
                    for(int i = 0; i >= number2; i++){
                        writer.write("2, ");
                    }
                    break;
                }
                //---------------------------------------------------------------------------\\
                //This one has nested switch statements, it functions more like a flowchart than code and handles switch between AI modes
                case 3:

            }
        }
        catch (IOException e){
            e.printStackTrace();
            System.out.println("Error: Unexpected faliure, please check game files");
        }
    }

    //
    public void playerTwoProfile(){
        System.out.println("1 for clear all data, 2 for fabricating, three for checking");
        try{ //needed for writer to not break
            FileWriter writer = new FileWriter("Player2TrustsBetrays",true);
            switch(currentGame.inputOutput()){
                case (1): // this one wipes all the dat in the Player1TrustsBetrays file
                System.out.println("You are going to wipe all data, are you sure?");
                System.out.println("[TBD]");
                if(currentGame.inputOutput() == 1){
                    System.out.println("debug_Success");
                    writer.write("");
                    writer.close();
                    break;
                } else {
                    System.out.println("debug_Fail");
                    writer.close();
                    break;
                }
                //--------------------------------------------------------------------------\\
                case (2):
                System.out.println("This will add extra trusts/betrays or years in prison to your record");
                Scanner input = new Scanner(System.in); //get other input
                String stringInput;
                switch(currentGame.inputOutput()){
                    case 1:
                    System.out.println("how many trusts?");
                    stringInput = input.nextLine();
                    int number = Integer.parseInt(stringInput);
                    for(int i = 0; i >= number; i++){
                        writer.write("1, ");
                    }
                    break;
                    case 2:
                    
                    break;
                }
                case 3:
                
            }
        }
        catch (IOException e){
            e.printStackTrace();
            System.out.println("Error: Unexpected faliure, please check game files");
        }
    }
    //
    public void AIOptions(){
        System.out.println("Enter a 1 for AI modes and 2 for Debug Ai");
        switch(currentGame.inputOutput()){
            case 1:
            System.out.println("Which AI mode do you want to switch to?");
            System.out.println("1 for trustworthy, 2 for normal and 3 for decitful");
            switch(currentGame.inputOutput()){
                case 1:
                currentGame.trustCooeffciant = 80;
                break;
                case 2:
                currentGame.trustCooeffciant = 50;
                break;
                case 3:
                currentGame.trustCooeffciant = 20;
                break;
            }
            break;
            case 2:
            System.out.println("Do you want to enable debug mode");
            break;
            default:
        }
        System.out.println("Return to main menu?(1 for yes 2 for no)");
        if(currentGame.inputOutput() == 1){
            new PrisionersDilemmaGame();
        } else{
            System.out.println("Thanks for playing");
        }
    }
}