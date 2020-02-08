public class Card {
    String name;
    int budget;
    Role[] roles;

    public String getName(){
        //Gets name of card
        return name;
    }

    public void setName(String s){
        //Sets name of card, used in initialization
    }

    public int getBudget(){
        //Gets the budget of card
        return budget;
    }

    public void setBudget(int n){
        //Sets the budget of card, used in initialization
    }

    public Role[] getRoles(){
        //Returns an array, containing the roles on the card
        return roles;
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
