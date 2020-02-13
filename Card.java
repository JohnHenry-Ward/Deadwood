public class Card {
    String name;
    int budget;
    Role[] roles;
    Boolean flipped;
    Players[] players; //this will players on the card

    public void Card(String name, int budget, Role[] roles){
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
        this.card.name = s;
    }

    public int getBudget(Card card){
        //Gets the budget of card
        return card.budget;
    }

    public void setBudget(Card card, int budget){
        //Sets the budget of card, used in initialization
        this.card.budget = budget;
    }

    public Players[] getPlayers(Card card){
        return this.card.players;
    }

    public Role[] getRoles(Card card){
        //Returns an array, containing the roles on the card
        return card.roles;
    }

    public void setRoles(Role a, Role b, Role c){
        //This method is used for setting up 3 roles on a card, all iterations used in initialization
    }

    public void setRoles(Role a, Role b){
        //Overloaded method of upper one, lets you set just 2 roles, used in initialization
    }

    public void setRoles(Role a){
        //Overloaded method of upper ones, lets you set just 1 role, used in initialization
    }
    
}
