public class Room {
    private static Card card;
    private int shotCounter;
    private Role[] roles;
    private String name;
    private Player[] players; //this will be players in the room only, not the card

    public Room(String n, int shots, Card c){
        name = n;
        shotCounter = shots;
        card = c;
    }

    public Card getCard(){
        //Returns the current card on the Room
        return card;
    }

    public static void setCard(Card c){
        card = c;
        //Sets the card(card c) on the current room, used in resetting the board and initialization
    }

    public int getShots(){
        //Returns how many shots are currently in the shot counter
        return shotCounter;
    }

    public void removeShot(){
        //Reduces shot counter by 1, used after succesful act occurs
        shotCounter =- 1;
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
    
    public String getName(){
        //Returns name of the current room
        return name;
    }
}
