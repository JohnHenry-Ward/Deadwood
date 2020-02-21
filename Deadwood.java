import java.util.*;
import java.io.*;

public class Deadwood{
    static Player currentPlayer;
    static int currentDay;
    static int maxDays;
    static Player[] playerOrder;
    static int scenesRemaining;
    static int playerAmount;
    static Room[] rooms;
    static Card[] cards = new Card[40];
    static String[] colors = new String[]{"BLUE", "GREEN", "RED", "YELLOW", "CYAN", "ORANGE", "PINK", "VIOLET"};//used for identifying players
    static Board<Room> board;
    static int cardsFlipped = -1;
    static Scanner sc;

    /* Before the game begins, room objects are created and initalized, card objects are created
     */
    public static void initalizeBoard(){
        specialRules();
        board = new Board<Room>();
        createRooms();
        createPaths();
        //set each players room to the trailers
        for(int x = 0; x < playerAmount; x++){
            playerOrder[x].setCurrentRoom(rooms[0]);
            rooms[0].addPlayer(playerOrder[x]);
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
        //clear card objects from rooms
        //reset shot counters
    }

    //FORMAT: name,budget,description,numberOfRoles,roleName,roleRank,roleDescription role stuff continues for numberOfRoles

    //read from text file
    //this will be called the first time a player enters a room
    //avoids problem of creating 10 new objects at the start of every day, and instead creating them over the course of the game
    public static void flipCard(Room room){
        //this is the first card flipped

        //NEED TO SOME HOW MAKE IT REMEMBER WHAT IT LAST READ
        cardsFlipped++; //AKA what line was read last
        
        try{
            // Scanner sc;
            if(cardsFlipped == 0){
                File cardFile = new File("cards.txt");
                sc = new Scanner(cardFile);
            }
            String cardLine = sc.nextLine();
            String[] cardLineArray = cardLine.split(",");
            String name = cardLineArray[0];
            int budget = Integer.parseInt(cardLineArray[1]);
            int numRoles = Integer.parseInt(cardLineArray[2]);
            cards[cardsFlipped] = new Card();
            room.setCard(cards[cardsFlipped]);
            room.getCard().initalize(name, budget);
            
            String roleName;
            int roleRank;
            Role[] roles = new Role[numRoles];
            int i = 0;
            for(int x = 0; x <= numRoles + 1; x+=2){
                roleName = cardLineArray[3 + x];
                roleRank = Integer.parseInt(cardLineArray[4 + x]);
                Role role = new Role(roleName, roleRank);
                roles[i] = role;
                i++;
        }
        room.getCard().setRoles(roles[0], roles[1], roles[2]);
        }
        catch(FileNotFoundException e){
            System.out.println("File not found");
        }
        
    }
    
    public static void createRooms(){
         //create all room objects, 10 rooms + trailer + casting office
         //maybe read in from a file?

         rooms = new Room[12];
         
         rooms[0] = new Room("Trailers", 0, null);

         rooms[1] = new Room("Casting Office", 0, null);

         rooms[2] = new Room("Main Street", 3, null);
         rooms[2].setRoles(new Role("Railroad worker", 1), new Role("Falls off Roof", 2), new Role("Woman in black Dress", 2), new Role("Mayor McGinty", 4));

         rooms[3] = new Room("Saloon", 2, null);
         rooms[3].setRoles(new Role("Reluctant Farmer", 1), new Role("Woman in Red Dress", 2));

         rooms[4] = new Room("Bank", 1, null);
         rooms[4].setRoles(new Role("Suspicious Gentleman", 2), new Role("Flustered Teller", 3));

         rooms[5] = new Room("Church", 2, null);
         rooms[5].setRoles(new Role("Dead Man", 1), new Role("Crying Woman", 2));

         rooms[6] = new Room("Hotel", 3, null);
         rooms[6].setRoles(new Role("Sleeping Drunkard", 1), new Role("Rare Player", 1), new Role("Falls from Balcony", 2), new Role("Australian Bartender", 3));

         rooms[7] = new Room("Secret Hideout", 3, null);
         rooms[7].setRoles(new Role("Clumsy Pit Fighter", 1), new Role("Thug with Knife", 2), new Role("Dangerous Tom", 3), new Role("Penny, who is Lost", 4));
         
         rooms[8] = new Room("Ranch", 2, null);
         rooms[8].setRoles(new Role("Shot in Leg", 1), new Role("Saucy Fred", 2), new Role("Man Under Horse", 3));

         rooms[9] = new Room("General Store", 2, null);
         rooms[9].setRoles(new Role("Man in Overalls", 1), new Role("Mister Keach", 3));

         rooms[10] = new Room("Jail", 1, null);
         rooms[10].setRoles(new Role("Prisoner in Cell", 2), new Role("Feller in Irons", 3));

         rooms[11] = new Room("Train Station", 3, null);
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

    }
    
    public static boolean isNeighbor(Room source, Room destination){
        ArrayList<Room> neighbors = board.getNeighbors(source);
        boolean isNeighbor = false;

        for(int x = 0; x < neighbors.size(); x++){
            if(!isNeighbor && destination.getName() == (neighbors.get(x)).getName()){
                isNeighbor = true;
            }
        }

        return isNeighbor;
    }

    /* The final method that is called at the end of the game
     * Score is calculated by (dollars + credits + (rank*5))
     */
    public static int calculateScore(Player player){
        return player.getDollars() + player.getCredits() + (player.getRank() * 5);
    }

    //clears players roles once the scene wraps
    public static void clearPlayerRoles(Room room){
        ArrayList<Player> offCardPlayers = room.getPlayers();
        ArrayList<Player> onCardPlayers = room.getCard().getPlayers();


        if(offCardPlayers != null){
            for(int x = 0; x < offCardPlayers.size(); x++){
                offCardPlayers.get(x).setCurrentRole(null);
            }
        }

        if(onCardPlayers != null){
            for(int x = 0; x < onCardPlayers.size(); x++){
                onCardPlayers.get(x).setCurrentRole(null);
            }
        }

        room.updateWrapped(true);
    }

    public static void roleOptions(){
        Room currRoom = currentPlayer.getCurrentRoom();
        Card currCard = currRoom.getCard();
        Role[] offCardRoles = currRoom.getRoles();
        Role[] onCardRoles = currCard.getRoles();
        System.out.println("The on card roles for the card " + currCard.getName() + " are");
        for(int x = 0; x < onCardRoles.length; x++){
            System.out.print(onCardRoles[x].getName() + " which is rank: " + onCardRoles[x].getRank() + ". ");
            if(onCardRoles[x].getPlayer() == null){
                System.out.println(" There is no one working on this role!");
            }
            else{
                System.out.println(onCardRoles[x].getPlayer().getName() + " is working on this role");
            }
        }

        System.out.println("The off card roles for the card " + currRoom.getName() + " are");
        for(int x = 0; x < offCardRoles.length; x++){
            System.out.print(offCardRoles[x].getName() + " which is rank: " + offCardRoles[x].getRank() + ". ");
            if(offCardRoles[x].getPlayer() == null){
                System.out.println(" There is no one working on this role!");
            }
            else{
                System.out.println(offCardRoles[x].getPlayer().getName() + " is working on this role");
            }

        }
    }

    /* Assigns a Role to a Player
     * Returns true if Role is available and succesfully taken
     * Returns false otherwise
     */
    public static boolean takeARole(String roleName){
        
        Room currentRoom = currentPlayer.getCurrentRoom();
        Card currentCard = currentRoom.getCard();
        Role[] roomRoles = currentRoom.getRoles();
        Role[] cardRoles = currentCard.getRoles();
        Boolean roleTaken = false;

        for(int x = 0; x < roomRoles.length; x++){
            if(roomRoles[x].getName().equals(roleName) && roomRoles[x].isRoleAvailable() && currentPlayer.getRank() >= roomRoles[x].getRank() && currentRoom.hasWrapped() == "unwrapped"){
                currentPlayer.setCurrentRole(roomRoles[x]);
                currentPlayer.setRoleType("offCard");
                roomRoles[x].setPlayer(currentPlayer);
                roomRoles[x].setRoleAvailable(false);
                roleTaken = true;
            }
        }

        for(int x = 0; x < cardRoles.length; x++){
            if(cardRoles[x].getName().equals(roleName) && roomRoles[x].isRoleAvailable() && currentPlayer.getRank() >= cardRoles[x].getRank()  && currentRoom.hasWrapped() == "unwrapped"){
                currentPlayer.setCurrentRole(cardRoles[x]);
                currentPlayer.setRoleType("onCard");
                cardRoles[x].setPlayer(currentPlayer);
                roomRoles[x].setRoleAvailable(false);
                roleTaken = true;
            }
        }

        //if role is onCard, add player to onCard players

        if(roleTaken){
            System.out.println("Congrats! You are now working on " + currentPlayer.getCurrentRole().getName() + " which is an " + currentPlayer.getRoleType() + " role.");
        }
        return roleTaken;
    }

    /* Player must be assigned to a role to be able to act
     * "Die is rolled" and die output + Players practice chips are compared to the scene budget
     * Returns true for succesfully acting
     * Returns false otherwise
     */
    public static boolean attemptToAct(int budget, String rollType){
        //first check if they can act ie: are on a role in an unwrapped room
        Role playerRole = currentPlayer.getCurrentRole();
        Room playerRoom = currentPlayer.getCurrentRoom();

        Boolean acted = false;

        if(playerRole != null && playerRoom.hasWrapped() != "wrapped"){
            int[] dieRoll = rollDie(1);
            System.out.println("die roll: " + dieRoll[0]);
            //success
            if(dieRoll[0] >= budget){
                Bank.actingSuccess(currentPlayer, rollType);
                acted = true;
            }
            //fail
            else if(rollType == "offCard"){
                Bank.actingFail(currentPlayer);
            }
        }
        else{
            System.out.println("You have yet to take a role!");
        }
        return acted;
    }

    public static void rehearse(){
        Role playerRole = currentPlayer.getCurrentRole();
        Room playerRoom = currentPlayer.getCurrentRoom();

        if(playerRole != null && playerRoom.hasWrapped() != "wrapped"){

            int budget = ((currentPlayer.getCurrentRoom()).getCard()).getBudget();
            if((currentPlayer.getPracticeChips() + currentPlayer.getRank()) >= budget){
                System.out.println("The budget of the room is " + budget + " and you are rank " + currentPlayer.getRank() + " with " + currentPlayer.getPracticeChips() + " so you are guarenteed success if you act! So no more rehearsing!!");
            }
            else{
                currentPlayer.getPracticeChips();
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
    public static void movePlayer(Player player, Room newRoom){
        Room currentRoom = player.getCurrentRoom();

        boolean isNeighbor = isNeighbor(currentRoom, newRoom);

        if(isNeighbor && player.getCurrentRole() == null){
            System.out.println(player.getName() + " is now in " + newRoom.getName());
            player.setCurrentRoom(newRoom);
            currentRoom.removePlayer(player);
            newRoom.addPlayer(player);
            //players need to be added to room aswell
        }
        else if(!isNeighbor){
            System.out.println("Sorry! " + currentRoom.getName() + " is not next to " + newRoom.getName());
        }
        else if(!(player.getCurrentRole() == null)){
            System.out.println("Sorry! You can't leave a room until it has wrapped! There are still " + currentRoom.getShots() + " shot(s) remaining!");
        }
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
        currentPlayer = playerOrder[currentPlayerIndex];

        //the game begins
        while(currentDay < maxDays){
            if(totalShotsRemaning() == 0){
                // end day
                // players go back to trailer
              //  currentDay++;
                //newDay();
            }            

            if(currentPlayerIndex == playerAmount){
                currentPlayerIndex = 0;
            }

            currentPlayer = playerOrder[currentPlayerIndex];
            
            System.out.println("Player: " + currentPlayer.getName() + ", you're up! ");
            Scanner in = new Scanner(System.in);
            String playerInput = in.nextLine();
            while(!(playerInput.equals("end"))){

                if(playerInput.equals("who")){
                    System.out.println("Current player: " + currentPlayer.getName());
                }
                else if(playerInput.equals("room")){
                    Room currRoom = currentPlayer.getCurrentRoom();
                    ArrayList<Player> playersInRoom = currRoom.getPlayers();
                    System.out.println("Room: " + currRoom.getName());
                    System.out.println("Players in room: " + playersInRoom.size());
                    for(int x = 0; x < playersInRoom.size(); x++){
                        System.out.println(playersInRoom.get(x).getName());
                    }
                }
                else if(playerInput.equals("card")){
                    System.out.println("Current room: " + currentPlayer.getCurrentRoom().getName());
                    System.out.println("Card in room: " + currentPlayer.getCurrentRoom().getCard().getName());
                    Role[] roles = currentPlayer.getCurrentRoom().getCard().getRoles();
                    for(int x = 0; x < roles.length; x++){
                        System.out.println("Role name: " + roles[x].getName());
                        System.out.println("Role rank: " + roles[x].getRank());
                        System.out.println("Role player: " + roles[x].getPlayer());
                    }
                }
                else if(playerInput.equals("where")){
                    System.out.println("Current player is in room: " + currentPlayer.getCurrentRoom().getName() + " which is " + currentPlayer.getCurrentRoom().hasWrapped());
                }
                else if(playerInput.equals("role")){
                    if(currentPlayer.getCurrentRole() != null){
                        System.out.println("The current player's role is: " + currentPlayer.getCurrentRole().getName());
                    }
                    else{
                        System.out.println("Player " + currentPlayer.getName() + " has not taken a role!");
                    }
                }
                else if(playerInput.equals("role options")){
                    if(currentPlayer.getCurrentRoom().hasWrapped() == "wrapped"){
                        System.out.println("Sorry! The room: " + currentPlayer.getCurrentRoom().getName() + " has wrapped!");
                    }
                    else if(currentPlayer.getCurrentRole() == null){
                        roleOptions();
                    }
                    else{
                        System.out.println("Sorry! You are already working on role: " + currentPlayer.getCurrentRole().getName());
                        System.out.println(currentPlayer.getCurrentRoom().getName() + " (the room you are currently in) needs to wrap before you can take a new role.");
                    }
                }
                else if(playerInput.contains("work")){
                    try{
                        String[] inputArray = playerInput.split("-");
                        String roleName = inputArray[1];
                        if(takeARole(roleName)){
                            break;
                        }
                        else{
                            System.out.println("Sorry! This role is either spelt wrong, not in this room, already has someone acting on it, the room is wrapped, or you aren't the right rank!");
                        }
                    } catch (ArrayIndexOutOfBoundsException ex){
                        System.out.println("Whoops, looks like your syntax is wrong. If you need to see what roles there are, type 'role options'");
                    }
                }
                else if(playerInput.equals("act")){
                    if(attemptToAct(((currentPlayer.getCurrentRoom()).getCard()).getBudget(), currentPlayer.getRoleType())){
                        break;
                    }
                }
                else if(playerInput.equals("rehearse")){
                    rehearse();
                    break;
                }
                else if(playerInput.contains("move")){
                    String[] moveLocation = playerInput.split("-");
                    String location = moveLocation[1];
                    for(int x = 0; x < rooms.length; x++){
                        if(rooms[x].getName().equals(location)){
                            movePlayer(currentPlayer, rooms[x]);
                            if(rooms[x].getCard() == null){
                                //not equals to trailers or casting office
                                if(!(rooms[x].equals(rooms[0])) && !(rooms[x].equals(rooms[1]))){
                                    flipCard(rooms[x]);
                                }
                            }
                            break;
                        }
                    }
                    break;
                }
                else if(playerInput.contains("upgrade")){
                    System.out.println(currentPlayer.getName() + " is rank " + currentPlayer.getRank());
                    String[] upgradePlayer = playerInput.split("-");
                        if(upgradePlayer[1].toLowerCase() == "c" && upgradePlayer.length == 3){
                            try{
                            int rankChoice = Integer.parseInt(upgradePlayer[3]);
                            }catch(Exception e){
                                break;
                            }
                        }else if(currentPlayer.getCurrentRoom().getName() == "Casting Office"){
                            System.out.println("Here are the ranks and their prices:\n"
                                             + "Rank | Dollars | Credits\n"
                                             + "  2  |    4    |    5   \n"
                                             + "  3  |    10   |    10  \n"
                                             + "  4  |    18   |    15  \n"
                                             + "  5  |    28   |    20  \n"
                                             + "  6  |    40   |    25  ");

                            System.out.println("Syntax for buying a rank:\n"
                                             + "Buying with Dollars: upgrade-$-(rank number)\n"
                                             + "Buying with Credits: upgrade-c-(rank number)");
                        }
                }
                else if(playerInput.equals("score")){
                    System.out.println("Dollars: " + currentPlayer.getDollars()
                                     + "\nCredits: " + currentPlayer.getCredits()
                                     + "\nRank: " + currentPlayer.getRank()
                                     + "\nScore: " + calculateScore(currentPlayer));

                }
                else{
                    //show syntax
                    System.out.println("Whoops! Looks like your syntax is wrong. Here is what you can do.");
                    System.out.println("who (prints out the current player");
                    System.out.println("where (prints out where the current player is");
                    System.out.println("role (prints out the current player's role");
                    System.out.println("role options (prints all role options for the current player)");
                    System.out.println("work-roleName (this makes the current player begin to work on a specified role");
                    System.out.println("act (this makes the current player attempt to act on their role, if they have one");
                    System.out.println("rehearse (this give the current player a practice chip, unless they have guarenteed acting success)");
                    System.out.println("move-location (this moves the current player to a specified room, if possible");
                    System.out.println("upgrade (this prompts the user for more information about upgrading their rank)");
                    System.out.println("score (shows the current players dollars, credits, rank, and total score");
                    System.out.println("end (this ends your move)");

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
        /*
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
            }*/

    
            
        }
    }
}