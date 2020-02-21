import java.util.*;

public class Card {
    private String name;
    private int budget;
    private Role[] roles;
    private Boolean flipped = false;
    private ArrayList<Player> players = new ArrayList<Player>(); 
    //this will be players on the card

    //called when a player has entered a room for the first time
    public void initalize(String n, int b){
        name = n;
        budget = b;
        flipped = true;
    }

    public String getName(){
        //Gets name of card
        return name;
    }

    public void setName(Card card, String s){
        //Sets name of card, used in initialization
        card.name = s;
    }

    public int getBudget(){
        //Gets the budget of card
        return budget;
    }

    public void setBudget(Card card, int budget){
        //Sets the budget of card, used in initialization
        card.budget = budget;
    }

    public ArrayList<Player> getPlayers(){
        return players;
    }

    public Role[] getRoles(){
        //Returns an array, containing the roles on the card
        return roles;
    }

    public boolean getFlipped(){
        return flipped;
    }

    public void setFlipped(Boolean status){
        flipped = status;
    }

    public void setRoles(Role a, Role b, Role c){
        //This method is used for setting up 3 roles on a card, all iterations used in initialization
        roles = new Role[] {a, b, c};
    }

    public void setRoles(Role a, Role b){
        //Overloaded method of upper one, lets you set just 2 roles, used in initialization
        roles = new Role[] {a, b};
    }

    public void setRoles(Role a){
        //Overloaded method of upper ones, lets you set just 1 role, used in initialization
        roles = new Role[] {a};
    }

    public void addPlayer(Player player){
        players.add(player);
    }

    public void removePlayer(Player player){
        for(int x = 0; x < players.size(); x++){
            if(players.get(x) == player){
                players.remove(x);
            }
        }
    }
    
}
