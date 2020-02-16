public class Bank{

    //there is probably a better way to do this
    private int rankTwoCostDollars = 4;
    private int rankTwoCostCredits = 5;
    private int rankThreeCostDollars = 10;
    private int rankThreeCostCredits = 10;
    private int rankFourCostDollars = 18;
    private int rankFourCostCredits = 15;
    private int rankFiveCostDollars = 28;
    private int rankFiveCostCredits = 20;
    private int rankSixCostDollars = 40;
    private int rankSixCostCredits = 25;

    /* Method rewards player on their success in acting based on if they are in a
     * starring role or acting as an extra
     * An on card success means that the Player receives 2 credits, and 1 shot counter is removed
     * An off card success means that the Player receives 1 credit, 1 dollar, and 1 shot counter is removed
     * If there are 0 shot counters remaining after an actor has acted, then the scene must wrap
     */
    public static void actingSuccess(Player player, String rollType){
        /*
        Room currentRoom = Player.getCurrentRoom(player);
        
        if(rollType == "onCard"){
            Player.addCredits(player, 2);
            Room.removeShot(currentRoom);
        }
        else if(rollType == "offCard"){
            Player.addCredits(player, 1);
            Player.addDollars(player, 1);
            Room.removeShot(currentRoom);
        }

        if(Room.getShots(currentRoom) == 0){
            Card currentCard = Room.getCard(currentRoom);
            Player[] players = Card.getPlayers(currentCard);

            if(players.length != 0){
                sceneWrapBonus(players, currentRoom);
            }
        }*/
    }

    /* Method only called when an off card actor fails to act
     * The Player recieves 1 dollar, no shot counters are removed
     */
    public void actingFail(Player player){
        player.addDollars(1);
    }

    /* Method called when there are 0 shot counters remaining in a room AND there is at least 1 Player acting on the card in the room
     * Method must have access to all Players in the room and the budget
     * Active player "rolls die", the amount pf die is determined by the budget of the room
     * The die amounts corelate to the players based on the roles they are on.
     * The top role gets the highest die amount, the second role gets the second die amount, and so on
     * Off Card roles receive a dollar bonus based on the rank of the role they are working on
     */
    public static void sceneWrapBonus(Player[] players, Room room, Card card){
        /*
        int budget = Card.getBudget(card);
        int[] dieRolls = Deadwood.rollDie(budget);

        int loopVar = 0;
        for(int x = 0; x < budget; x++){
            Player.addDollars(players[loopVar], dieRolls[x]);
            if(loopVar >= players.length){
                loopVar = 0;
            }
        }

        Player offCardPlayers[] = Room.getPlayers(room);

        for(int x = 0; x < offCardPlayers.length; x++){
            Role playerRole = Player.getRole(offCardPlayers[x]);
            int bonus = Role.getRank(playerRole);
            Player.addDollars(offCardPlayers[x], bonus);
        }
    */
    }

    /* Method called when a Player rehearses, rather than acts
     * The Players practice chip attribute increases by 1
     */
    public void gainPracticeChip(Player player){
        player.addPracticeChip();
    }

    /* Method only available when a Player is in the Casting Office Room
     * Based on what rank the Player wants to have, it will cost a certain amount of dollars or credits
     * Method returns true for succesful upgrade
     * Method returns false otherwise
     */
    public static void upgrade(Player player, int rankRequest){
        //Player.rank = upgradedRank
    }

}
