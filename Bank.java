public class Bank{

    //there is probably a better way to do this
    int rankTwoCostDollars = 4;
    int rankTwoCostCredits = 5;
    int rankThreeCostDollars = 10;
    int rankThreeCostCredits = 10;
    int rankFourCostDollars = 18;
    int rankFourCostCredits = 15;
    int rankFiveCostDollars = 28;
    int rankFiveCostCredits = 20;
    int rankSixCostDollars = 40;
    int rankSixCostCredits = 25;

    /* Method rewards player on their success in acting based on if they are in a
     * starring role or acting as an extra
     * An on card success means that the Player receives 2 credits, and 1 shot counter is removed
     * An off card success means that the Player receives 1 credit, 1 dollar, and 1 shot counter is removed
     * If there are 0 shot counters remaining after an actor has acted, then the scene must wrap
     */
    public static void actingSuccess(Player player, String rollType){

    }

    /* Method only called when an off card actor fails to act
     * The Player recieves 1 dollar, no shot counters are removed
     */
    public static void actingFail(Player player){

    }

    /* Method called when there are 0 shot counters remaining in a room AND there is at least 1 Player acting on the card in the room
     * Method must have access to all Players in the room and the budget
     * Active player "rolls die", the amount pf die is determined by the budget of the room
     * The die amounts corelate to the players based on the roles they are on.
     * The top role gets the highest die amount, the second role gets the second die amount, and so on
     * Off Card roles receive a dollar bonus based on the rank of the role they are working on
     */
    public static void sceneWrapBonus(Room room){
        
    }

    /* Method called when a Player rehearses, rather than acts
     * The Players practice chip attribute increases by 1
     */
    public static void gainPracticeChip(Player player){

    }

    /* Method only available when a Player is in the Casting Office Room
     * Based on what rank the Player wants to have, it will cost a certain amount of dollars or credits
     * Method returns true for succesful upgrade
     * Method returns false otherwise
     */
    public static void upgrade(Player player){
        //Player.rank = upgradedRank
    }

}
