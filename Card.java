public class Card {
    static String name;
    static int budget;
    static Role[] roles;
    static Boolean flipped;
    static Player[] players; //this will players on the card

    public void initialize(String name, int budget, Role[] roles){
        this.name = name;
        this.budget = budget;
        this.roles = roles;
        flipped = false;
    }

    public String getName(Card card){
        //Gets name of card
        return card.name;
    }

    public void setName(Card card, String s){
        //Sets name of card, used in initialization
        card.name = s;
    }

    public int getBudget(Card card){
        //Gets the budget of card
        return card.budget;
    }

    public void setBudget(Card card, int budget){
        //Sets the budget of card, used in initialization
        card.budget = budget;
    }

    public Player[] getPlayers(Card card){
        return card.players;
    }

    public Role[] getRoles(Card card){
        //Returns an array, containing the roles on the card
        return card.roles;
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
    
}
