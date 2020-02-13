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
<<<<<<< HEAD
        this.card.name = s;
=======
        name = s;
>>>>>>> b6dec963021c61b62d150af2a71ce17bb072d944
    }

    public int getBudget(Card card){
        //Gets the budget of card
        return card.budget;
    }

    public void setBudget(Card card, int budget){
        //Sets the budget of card, used in initialization
<<<<<<< HEAD
        this.card.budget = budget;
=======
        budget = n;
>>>>>>> b6dec963021c61b62d150af2a71ce17bb072d944
    }

    public Players[] getPlayers(Card card){
        return this.card.players;
    }

    public Role[] getRoles(Card card){
        //Returns an array, containing the roles on the card
<<<<<<< HEAD
        return card.roles;
=======
        if(roles.length <= 0)
        return null;
        else
        return roles;
>>>>>>> b6dec963021c61b62d150af2a71ce17bb072d944
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
