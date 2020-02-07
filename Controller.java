public class Controller{
    String currentPlayer;
    int currentDay;
    int maxDays;
    String[] playerOrder;
    int scenesRemaining;

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
    public static void specialRules(int playerCount){

    }
    
    public static void main(String args[]){
        //setup board
        //play game
        //end game
    
    }

}