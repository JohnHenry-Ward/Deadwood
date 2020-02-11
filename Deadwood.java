import java.util.*;
import java.lang.Math;

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
        //check for this.role to roles in player.currentRoom
        //if role is in room and available
            //player.role = role
        //else
            //illegal
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
    public static void movePlayer(Room newRoom){
        //if room is adjacent to player.currentRoom
            //player.room = newRoom
        //else
            //illegal move
    }

    /* Die is rolled when a player attempts to act (dieAmount = 1) OR
     * Die is rolled when a scene wraps (dieAmount = scene budget)
     * Returns an array of ints with each index representing a die roll
     */
    public static int[] rollDie(int dieCount){
        int[] dieArray = new int[dieCount];
        for(int d = 0; d < dieCount; d++){
            Random rr = new Random();
            int roll = rr.nextInt(6) + 1;
            dieArray[d] = roll;
            System.out.println("Roll " + d + ": " + dieArray[d]);
        }
        return dieArray;
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
            for(int i = 0; i < playerAmount; i++){
                Player.addCredits(playerOrder[i], 2);
            }
            maxDays = 4;
        }
        else if(playerAmount == 6){
            //players start with 4 credits
            for(int i = 0; i < playerAmount; i++){
                Player.addCredits(playerOrder[i], 4);
            }
            maxDays = 4;
        }
        else{
            //players start with rank 2
            for(int i = 0; i < playerAmount; i++){
                Player.setRank(playerOrder[i], 2);
            }
            maxDays = 4;
        }
    }
    
    public static void main(String args[]){

        System.out.println("Welcome to Deadwood!");

        /* Player amount is set by user */
        Scanner p = new Scanner(System.in);
        while(playerAmount < 2 || playerAmount > 8){
            System.out.print("How many players are playing? ");
            playerAmount = p.nextInt();

            if(playerAmount < 2 || playerAmount > 8){
                System.out.println("Whoops! Please input a number of players between 2 and 8!");
            }
        }        

        /* Player objects are created, and playerOrder[] is created to keep track of who is next */

        //MIGHT BE BETTER TO PUT THIS IN A LINKED LIST SO WE CAN LOOP BACK TO THE FRONT OF IT EASIER
        int e = 0;
        playerOrder = new Player[playerAmount];
        Scanner n = new Scanner(System.in);
        while(e < playerAmount){
            //create each player
            System.out.print("Player " + e + ", what is your name? ");
            String name = n.nextLine();
            if(!(name.isEmpty())){
                playerOrder[e] = new Player(name);
                e++;
            }
            else{
                System.out.println("Whoops! A name is required to play Deadwood!");
            }
            //set Players rooms to be trailer
            //Player.setCurrentRoom(playerOrder[x] = ???)
            //maybe Room class and card class should have a player array
        }



        currentPlayer = playerOrder[0];

        specialRules();

        //    !!!!!!!!!!!!!!!!!!!!!!!!! I THINK WE NEED A ROLES CLASS !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

        //the game begins
        //while(currentDay < maxDays){
            //if(shotCountersRemaining == 0){
                //end day
                //players go back to trailer
                //currentDay++;
            //}
            //playerX goes
            
            //user can request certain info like...(maybe just one command that prints all currentPlayer info???)
                //"who": print currentPlayer, dollars, credits, rank
                //"where": print currentPlayer is in this room (acting in this role)
                //"role": print currentPlayer is in this room (acting in this role). The budget is $x, there are X players in this room.

            //playerX can either
                //move then take a role OR (keyword: move [roomName])
                //act OR (keyword: act, must have a role in an unwrapped room)
                //rehearse OR (keyword: rehearse, must have a role in an unwrapped room)
                //move then upgrade OR (keyword: upgrade, must be in casting office with sufficient funds)
                //move then do nothing 
            
            //if on a role, must act OR rehearse, can't move
            
            //user inputs "end"
            //playerX's turn is over, loop back to top and currentPlayer = playerOrder[X+1];
        //}

        //just for testing
        for(int x = 0; x < playerOrder.length; x++){
            System.out.println("=======");
            System.out.println("Name: " + Player.getName(playerOrder[x]));
            System.out.println("Rank: " + Player.getRank(playerOrder[x]));
            System.out.println("Dollars: " + Player.getDollars(playerOrder[x]));
            System.out.println("Credits: " + Player.getCredits(playerOrder[x]));
            System.out.println("Score: " + Player.getScore(playerOrder[x]));
        }

    
    }

}