// Imports for dif parts
import java.util.Scanner; // Look through keyboard input
/**
 * Game part
 *
 * Benji Cresswell
 */
public class Prison extends PrisionersDilemmaGame
{
    // instance variables
    private int playerChoice; // players decision on if trust or betray
    private int playerTwoChoice; // if there is anthother player, this is there choice
    private int AIChoice; // wheather the ai will betray or trust
    private int outcome; //The amount of years in prison each side will recive
    
    /**
     * Constructor for objects of class Prison
     */
    public Prison()
    {
        // initialise instance variables
        explainer();
        getPlayerChoice();
    }
    
    public void explainer(){ // expalins how the specfic actions you take work
        System.out.println("[TBD]");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
    }
    
    public boolean getPlayerChoice()
    {
        Scanner keyboardInput = new Scanner(System.in); //make scanner for input
        for(int i = 0;i < 6;i++){ // for loop is so that the player
        System.out.println("make choice 0 for trust 1 for betray");
        byte playerInput = keyboardInput.nextByte(); //get where user wants to go
            if(playerInput == 0){
                return(true);
            }
            else if(playerInput == 1){
                return(false);
            }
            else{
                System.out.println("Error: Unrecognised input, please try again");
                System.out.println("outputting debug info"+i);
            }
        }
        return(true); // this is a hack fix to make an error go away, fix later!
    }
}