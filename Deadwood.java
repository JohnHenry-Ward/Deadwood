import java.util.*;
import java.lang.Math;

public class Deadwood{
    static Player currentPlayer;
    static int currentDay;
    static int maxDays;
    static Player[] playerOrder;
    static int scenesRemaining;
    static int playerAmount;
    static Room[] rooms;
    static Card[] cards;
    static String[] colors = new String[]{"blue", "green", "red", "yellow", "cyan", "orange", "pink", "violet"}; //used for identifying players

    /* Before the game begins, roles, cards, and room objects must be created
     */
    public static void initalizeBoard(){
        //createRoles();
        //createCards();
        createRooms();
    }

    /* The first thing that happens at the beginning of each day (and the beginning of the game)
     * Sets the Players in the Trailer
     * Assigns 1 Card to each Room
     * Resets shot counter for each Room
     */
    public static void newDay(){
        //set each players room to the trailers
        // for(int x = 0; x < playerAmount; x++){
        //     Player.setCurrentRoom(playerOrder[x], room[0]);
        // }

        //assign cards to rooms
        // for(int x = 0; x < 10; x++){
            // Room.setCard(rooms[x], cards[x]);
        // }
        //reset shot counters
    }

    public static void createRoles(){
        //create all role objects? 137
        //created just roles on board, not cards?
        Role roles[x] = new Role(); //creates 1 role

    }

    public static void createCards(){
        //create all card objects? 40
        Card cards[x] = new Card() //creates 1 card
    }

    public static void createRooms(){
         //create all room objects, 10 rooms + trailer + casting office
        //maybe read in from a file?
        // rooms = new Room[10];
        // rooms[0] = new Room("MainStreet", 3, [role[x], role[y], role[z]], card);
        // rooms[1] = new Room();
        // rooms[2] = new Room();
        // rooms[3] = new Room();
        // rooms[4] = new Room();
        // rooms[5] = new Room();
        // rooms[6] = new Room();
        // rooms[7] = new Room();
        // rooms[8] = new Room();
        // rooms[9] = new Room();
        //rooms[1] = new Room("name", 5, [Role.getRole[Roles[x]]], Card.getCard(Cards[x]));
        Room rooms[x] = new Room("name", 5, cards[x]);
        Room.setRoles(newRoom, role1, role2, role3);
    }

    /* The final method that is called at the end of the game
     * Score is calculated by (dollars + credits + (rank*5))
     */
    public static int calculateScore(Player player){
        return Player.getDollars(player) + Player.getCredits(player) + (Player.getRank(player) * 5);
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

        //sorted from highest (index 0), to lowest (index dieCount - 1)
        Arrays.sort(dieArray, Collections.reverseOrder());

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

        playerAmount = Integer.parseInt(args[0]);
        System.out.println("Welcome to Deadwood! You've selected a " + playerAmount + " player game!");
        playerOrder = new Player[playerAmount];
        int e = 0;
        while(e < playerAmount){
            playerOrder[e] = new Player(colors[e]);
            e++;
        }

        currentPlayer = playerOrder[0];

        specialRules();

        firstDay();

        newDay();

        //the game begins
        //while(currentDay < maxDays){
            //if(shotCountersRemaining == 0){
                //end day
                //players go back to trailer
                //currentDay++;
                //newDay()
            //}
            //playerX goes
            System.out.println("Player: " + Player.getName(playerOrder[0]) + ", you're up! ");
            Scanner in = new Scanner(System.in);
            String playerInput = in.nextLine();
            while(!(playerInput.equals("end"))){

                if(playerInput.equals("who")){
                    System.out.println("Who: " + Player.getName(playerOrder[0]));
                }
                else if(playerInput.equals("where")){
                    System.out.println("Where: " + Player.getCurrentRoom(playerOrder[0]));
                }
                else if(playerInput.equals("role")){
                    System.out.println("Role: " + Player.getCurrentRole(playerOrder[0]));
                }
                else if(playerInput.equals("act")){
                    //act
                    //end move
                }
                else if(playerInput.equals("rehearse")){
                    //+1 practice chip
                    //end move
                }
                else if(playerInput.contains("move")){
                    String[] moveLocation = playerInput.split(" ");
                    String location = moveLocation[1];
                    System.out.println(location);
                    //if legal move
                        //move player
                    //if illegal move
                        //notify player move is illegal
                }
                else if(playerInput.equals("upgrade")){
                    System.out.println(Player.getName(playerOrder[0]) + " is rank " + Player.getRank(playerOrder[0]));
                    System.out.println("Here are the ranks and their prices");
                    System.out.println("Rank | Dollars | Credits");
                    System.out.println("  2  |    4    |    5   ");
                }

                playerInput = in.nextLine();

            }

            
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
                //if first player in a room, reveal card
            
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