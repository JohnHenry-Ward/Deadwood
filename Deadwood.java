import java.util.*;

public class Deadwood{
    static Player currentPlayer;
    static int currentDay;
    static int maxDays;
    static Player[] playerOrder;
    static int scenesRemaining;
    static int playerAmount;

    /* The first thing that happens at the beginning of each day (and the beginning of the game)
     * Sets the Players in the Trailer
     * Assigns 1 Card to each Room
     * Resets sho counter for each Room
     */
    public static void newDay(){
        //set players to trailer
        //assign cards to rooms
        //reset shot counters
    }

    /* The final method that is called at the end of the game
     * Score is calculated by (dollars + credits + (rank*5))
     */
    public static int calculateScore(){
        return -1;
    }

    /* Assigns a Role to a Player
     * Returns true if Role is available and succesfully taken
     * Returns false otherwise
     */
    public static boolean takeARole(Role role){
        return false;
    }

    /* Player must be assigned to a role to be able to act
     * "Die is rolled" and die output + Players practice chips are compared to the scene budget
     * Returns true for succesfully acting
     * Returns false otherwise
     */
    public static void attemptToAct(int budget, String rollType){
            // if(succesful){
            //     bank.payout(player, rolltype)
            // }
    }

    /* Player wants to move from their current room to a new room
     * Room must be adjacent to players current room
     * Returns true if succesfully moved
     * Returns false otherwise
     */
    public static void movePlayer(Room room){

    }

    /* Die is rolled when a player attempts to act (dieAmount = 1) OR
     * Die is rolled when a scene wraps (dieAmount = scene budget)
     * Returns an array of ints with each index representing a die roll
     */
    public static int[] rollDie(int dieAmount){
        int[] a = {-1};
        return a;
    }

    /* Method called before the game begins, and adds special rules depending on playerCount
     * 2-3 Players: 3 days
     * 4 Players:   Normal rules
     * 5 Players:   Players start with 2 credits
     * 6 Players:   Players start with 4 credits
     * 7-8 Players: Players start at rank 2
     */
    public static void specialRules(){
        if(playerAmount <= 3){
            maxDays = 3;
        }
        else if(playerAmount == 4){
            maxDays = 4;
        }
        else if(playerAmount == 5){
            //players start with 2 credits
            maxDays = 4;
        }
        else if(playerAmount == 6){
            //players start with 4 credits
            maxDays = 4;
        }
        else{
            //players start with rank 2
            maxDays = 4;
        }
    }
    
    public static void main(String args[]){

        System.out.println("Welcome to Deadwood!");

        while(playerAmount < 2 || playerAmount > 8){
            System.out.print("How many players are playing? ");
            Scanner in = new Scanner(System.in);
            playerAmount = in.nextInt();

            if(playerAmount < 2 || playerAmount > 8){
                System.out.println("Whoops! Please input a number of players between 2 and 8!");
            }
        }

        // int i = 1;
        // String[] players;
        // players = new String[playerAmount];
        // for(int x = 0; x < playerAmount; x++){
        //     players[x] = "P" + i;
        //     i++;
        // }

        int e = 0;
        // Player players[0];
        playerOrder = new Player[playerAmount];
        while(e < playerAmount){
            //create each player
            System.out.print("Player " + e + ", what is your name?");
            Scanner in = new Scanner(System.in);
            String name = in.nextLine();
            //playerOrder[e] = new Player(name);
        }

        //put players in an array (linked list?) to keep track of who is next


        specialRules();

    
    }

}