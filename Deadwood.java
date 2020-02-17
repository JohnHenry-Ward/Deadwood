import java.util.*;

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
    static Board<Room> board = new Board<Room>();
    static int cardsFlipped = -1;

    /* Before the game begins, room objects are created and initalized, card objects are created
     */
    public static void initalizeBoard(){
        specialRules();
        createRooms();
        createPaths();
        currentPlayer = playerOrder[0];
        //set each players room to the trailers
        for(int x = 0; x < playerAmount; x++){
            playerOrder[x].setCurrentRoom(rooms[0]);
        }
    }

    /* The first thing that happens at the beginning of each day (and the beginning of the game)
     * Sets the Players in the Trailer
     * Assigns 1 Card to each Room
     * Resets shot counter for each Room
     */
    public static void newDay(){
        //set each players room to the trailers
        for(int x = 0; x < playerAmount; x++){
            playerOrder[x].setCurrentRoom(rooms[0]);
        }

        //assign cards to rooms (dont think we need this here)
        // for(int x = 0; x < 10; x++){
            // Room.setCard(rooms[x], cards[x]);
        // }
        //reset shot counters
    }

    public static void createRoles(){
        //create all role objects? 137
        //created just roles on board, not cards?
        //Role roles[x] = new Role(); //creates 1 role

    }

    //read from text file
    //this will be called the first time a player enters a room
    //avoids problem of creating 10 new objects at the start of every day, and instead creating them over the course of the game
    public static void flipCard(Room room){
        cardsFlipped++;
        //cards[cardsFlipped].initialize(name, budget, roles);
        room.setCard(cards[cardsFlipped]);
    }
    
    public static void createRooms(){
         //create all room objects, 10 rooms + trailer + casting office
         //maybe read in from a file?

         rooms = new Room[12];
         
         rooms[0] = new Room("Trailers", 0, null);

         rooms[1] = new Room("Casting Office", 0, null);

         rooms[2] = new Room("Main Street", 3, new Card());
         rooms[2].setRoles(new Role("Railroad worker", 1), new Role("Falls off Roof", 2), new Role("Woman in black Dress", 2), new Role("Mayor McGinty", 4));

         rooms[3] = new Room("Saloon", 2, new Card());
         rooms[3].setRoles(new Role("Reluctant Farmer", 1), new Role("Woman in Red Dress", 2));

         rooms[4] = new Room("Bank", 1, new Card());
         rooms[4].setRoles(new Role("Suspicious Gentleman", 2), new Role("Flustered Teller", 3));

         rooms[5] = new Room("Church", 2, new Card());
         rooms[5].setRoles(new Role("Dead Man", 1), new Role("Crying Woman", 2));

         rooms[6] = new Room("Hotel", 3, new Card());
         rooms[6].setRoles(new Role("Sleeping Drunkard", 1), new Role("Rare Player", 1), new Role("Falls from Balcony", 2), new Role("Australian Bartender", 3));

         rooms[7] = new Room("Secret Hideout", 3, new Card());
         rooms[7].setRoles(new Role("Clumsy Pit Fighter", 1), new Role("Thug with Knife", 2), new Role("Dangerous Tom", 3), new Role("Penny, who is Lost", 4));
         
         rooms[8] = new Room("Ranch", 2, new Card());
         rooms[8].setRoles(new Role("Shot in Leg", 1), new Role("Saucy Fred", 2), new Role("Man Under Horse", 3));

         rooms[9] = new Room("General Store", 2, new Card());
         rooms[9].setRoles(new Role("Man in Overalls", 1), new Role("Mister Keach", 3));

         rooms[10] = new Room("Jail", 1, new Card());
         rooms[10].setRoles(new Role("Prisoner in Cell", 2), new Role("Feller in Irons", 3));

         rooms[11] = new Room("Train Station", 3, new Card());
         rooms[11].setRoles(new Role("Crusty Prospector", 1), new Role("Dragged by Train", 1), new Role("Preacher with Bag", 2), new Role("Cyrus the Gunfighter", 4));
    }

    //paths are created on a graph, each node is a room
    public static void createPaths(){
        board.addPath(rooms[0], rooms[2]);//trailer <-> main street
        board.addPath(rooms[0], rooms[3]);//trailer <-> saloon
        board.addPath(rooms[0], rooms[6]);//trailer <-> Hotel
        board.addPath(rooms[2], rooms[3]);//main street <-> saloon
        board.addPath(rooms[2], rooms[10]);//main street <-> jail
        board.addPath(rooms[3], rooms[9]);//saloon <-> general store
        board.addPath(rooms[3], rooms[4]);//saloon <-> bank
        board.addPath(rooms[4], rooms[8]);//bank <-> ranch
        board.addPath(rooms[4], rooms[5]);//bank <-> church
        board.addPath(rooms[4], rooms[6]);//bank <-> hotel
        board.addPath(rooms[5], rooms[6]);//church <-> hotel
        board.addPath(rooms[5], rooms[7]);//church <-> secret hideout
        board.addPath(rooms[7], rooms[8]);//secret hideout <-> ranch
        board.addPath(rooms[7], rooms[1]);//secret hideout <-> casting office
        board.addPath(rooms[8], rooms[1]);//ranch <-> casting office
        board.addPath(rooms[8], rooms[9]);//ranch <-> general store
        board.addPath(rooms[9], rooms[11]);//general store <-> train station
        board.addPath(rooms[9], rooms[10]);//general store <-> jail
        board.addPath(rooms[10], rooms[11]);//jail <-> train station
        board.addPath(rooms[11], rooms[1]);//train station <-> casting office

        ArrayList<Room> rr = board.getNeighbors(rooms[10]);
        System.out.println(rr.get(0).getName());
        System.out.println(rr.get(1).getName());
        System.out.println(rr.get(2).getName());
    }
    

    /* The final method that is called at the end of the game
     * Score is calculated by (dollars + credits + (rank*5))
     */
    public static int calculateScore(Player player){
        return player.getDollars() + player.getCredits() + (player.getRank() * 5);
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
        //first check if they can act ie: are on a role in an unwrapped room
        Role playerRole = currentPlayer.getCurrentRole();
        Room playerRoom = currentPlayer.getCurrentRoom();

        if(playerRole != null && !playerRoom.hasWrapped()){
            int[] dieRoll = rollDie(1);
            //success
            if(dieRoll[0] >= budget){
                Bank.actingSuccess(currentPlayer, rollType);
            }
            //fail
            else if(rollType == "offCard"){
                Bank.actingFail(currentPlayer);
            }
        }
        else{
            System.out.println("You have yet to take a role!");
        }
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
        }

        //sorted from lowest (index 0), to highest (index dieCount - 1)
        Arrays.sort(dieArray);

        return dieArray;
    }

    //method goes room by room summing up all shots remaing
    //used to check if the day should end
    public static int totalShotsRemaning(){
        int shotsRemaining = 0;
        for(int x = 0; x < 10; x++){
            shotsRemaining += rooms[x].getShots();
        }
        
        return shotsRemaining;
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
                playerOrder[i].addCredits(2);
            }
            maxDays = 4;
        }
        else if(playerAmount == 6){
            //players start with 4 credits
            for(int i = 0; i < playerAmount; i++){
                playerOrder[i].addCredits(4);
            }
            maxDays = 4;
        }
        else{
            //players start with rank 2
            for(int i = 0; i < playerAmount; i++){
                playerOrder[i].setRank(2);
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

        initalizeBoard();

        int currentPlayerIndex = 0;

        //the game begins
        while(currentDay < maxDays){
            if(totalShotsRemaning() == 0){
                // end day
                // players go back to trailer
              //  currentDay++;
                //newDay();
            }
            //playerX goes
            

            if(currentPlayerIndex == playerAmount){
                currentPlayerIndex = 0;
                System.out.println("reset!");
            }

            currentPlayer = playerOrder[currentPlayerIndex];
            
            System.out.println("Player: " + currentPlayer.getName() + ", you're up! ");
            Scanner in = new Scanner(System.in);
            String playerInput = in.nextLine();
            while(!(playerInput.equals("end"))){

                if(playerInput.equals("who")){
                    System.out.println("Who: " + playerOrder[0].getName());
                }
                else if(playerInput.equals("where")){
                    System.out.println("Where: " + playerOrder[0].getCurrentRoom().getName());
                }
                else if(playerInput.equals("role")){
                    System.out.println("Role: " + playerOrder[0].getCurrentRole().getName());
                }
                else if(playerInput.equals("act")){
                    attemptToAct(((currentPlayer.getCurrentRoom()).getCard()).getBudget(), currentPlayer.getRoleType());
                    //act
                    //end move
                }
                else if(playerInput.equals("rehearse")){
                    Role playerRole = currentPlayer.getCurrentRole();
                    Room playerRoom = currentPlayer.getCurrentRoom();

                    if(playerRole != null && !playerRoom.hasWrapped()){

                        int budget = ((currentPlayer.getCurrentRoom()).getCard()).getBudget();
                        if((currentPlayer.getPracticeChips() + currentPlayer.getRank()) >= budget){
                            System.out.println("The budget of the room is " + budget + " and you are rank " + currentPlayer.getRank() + " with " + currentPlayer.getPracticeChips() + " so you are guarenteed success if you act! So no more rehearsing!!");
                            //move continues
                        }
                        else{
                            currentPlayer.getPracticeChips();
                            //end move
                        }

                    }
                    else{
                        System.out.println("You have yet to take a role!");
                    }
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
                    System.out.println(playerOrder[0].getName() + " is rank " + playerOrder[0].getRank());
                
                
                    System.out.println("Here are the ranks and their prices");
                    System.out.println("Rank | Dollars | Credits");
                    System.out.println("  2  |    4    |    5   ");
                    System.out.println("  3  |    10   |    10  ");
                    System.out.println("  4  |    18   |    15  ");
                    System.out.println("  5  |    28   |    20  ");
                    System.out.println("  6  |    40   |    25  ");
                }
                

                playerInput = in.nextLine();

            

            
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
        }

        currentPlayerIndex++; //move to next player

        //just for testing
            for(int x = 0; x < playerOrder.length; x++){
                System.out.println("=======");
                System.out.println("Name: " + playerOrder[x].getName());
                System.out.println("Rank: " + playerOrder[x].getRank());
                System.out.println("Dollars: " + playerOrder[x].getDollars());
                System.out.println("Credits: " + playerOrder[x].getCredits());
                System.out.println("Score: " + playerOrder[x].getScore());

                //so this is the synax for getters

                System.out.println(rooms[3].getName()); //notice there is no parameters
                Role[] RA = rooms[3].getRoles();
                System.out.println(RA[0].getName());
            }

    
            
        }
    }
}