public class Room {
    static Card card;
    static int shotCounter;
    static Role[] roles;
    static String name;
    static Player[] players; //this will be players in the room only, not the card

    Room(String name, int shotCounter, Card card){
        this.name = name;
        this.shotCounter = shotCounter;
        this.card = card;
    }

    public Card getCard(Room room){
        //Returns the current card on the Room
        return room.card;
    }

    public void setCard(Card c){
        //Sets the card(card c) on the current room, used in resetting the board and initialization
    }

    public int getShots(Room room){
        //Returns how many shots are currently in the shot counter
        return room.shotCounter;
    }

    public void removeShot(Room room){
        //Reduces shot counter by 1, used after succesful act occurs
        room.shotCounter =- 1;
    }

    public Role[] getRoles(){
        //Returns an array consisting of all roles in the room, excluding roles on the card
        return roles;
    }

    public void setRoles(Role a, Role b, Role c, Role d){
        //This method is used for setting up 4 roles on a card, all iterations used in initialization
        roles = new Role[] {a, b, c, d};
    }
    
    public void setRoles(Role a, Role b, Role c){
        //Overloaded method of upper one, lets you set just 3 roles, used in initialization
        roles = new Role[] {a, b, c};
    }
    
    public void setRoles(Role a, Role b){
        //Overloaded method of upper ones, lets you set just 2 roles, used in initialization
        roles = new Role[] {a, b};
    }

    public void setRoles(Role a){
        //Overloaded method of upper ones, lets you set just 1 role, used in initialization
        roles = new Role[] {a};
    }
    
    public static String getName(Room room){
        //Returns name of the current room
        return room.name;
    }

    public void setName(String s){
        //Sets the name for the current room, used in initialization
    }
}
