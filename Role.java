public class Role {
    String name;
    int rank;
    Player currentPlayer;

    public String getName(){
        //return name of role
        return name;
    }

    public void setName(String s){
        //Sets the name(String s) for this current role, used in initialization
    }

    public int getRank(){
        //Returns the rank required to acquire this role
        return rank;
    }

    public void setRank(int n){
        //Sets the rank(int n) for the role, used in initialization
    }

    public Player getPlayer(){
        //Returns the current player that has this role acquired
        return currentPlayer;
    }

    public void setPlayer(Player p){
        //Links a player(Player p) to this current role
    }
}
