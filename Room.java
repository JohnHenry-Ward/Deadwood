public class Room {
    Card card;
    int shotCounter;
    Role[] roles;
    String name;

    public static Rooms(String name, int shotCounter, Role[] roles, Card card){
        this.name = name;
        this.shotCounter = shotCounter;
        this.roles = roles;
        this.card = card;
    }

    public Card getCard(){
        //Returns the current card on the Room
        return card;
    }

    public void setCard(Card c){
        //Sets the card(card c) on the current room, used in resetting the board and initialization
    }

    public int getShots(){
        //Returns how many shots are currently in the shot counter
        return shotCounter;
    }

    public void removeShot(){
        //Reduces shot counter by 1, used after succesful act occurs
    }

    public Role[] getRoles(){
        //Returns an array consisting of all roles in the room, excluding roles on the card
        return roles;
    }

    public void setRoles(Role a, Role b, Role c, Role d){
        //This method is used for setting up 4 roles on a card, all iterations used in initialization
    }
    
    public void setRoles(Role a, Role b, Role c){
        //Overloaded method of upper one, lets you set just 3 roles, used in initialization
    }
    
    public void setRoles(Role a, Role b){
        //Overloaded method of upper ones, lets you set just 2 roles, used in initialization
    }

    public void setRoles(Role a){
        //Overloaded method of upper ones, lets you set just 1 role, used in initialization
    }
    
    public String getName(){
        //Returns name of the current room
        return name;
    }

    public void setName(String s){
        //Sets the name for the current room, used in initialization
    }
}
