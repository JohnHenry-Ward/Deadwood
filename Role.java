public class Role {
    String name;
    int rank;
    Player currentPlayer = null;

    public String getName(){
        //return name of role
        return name;
    }

    Role(String name, int rank){
        this.name = name;
        this.rank = rank;
    }

    public int getRank(){
        //Returns the rank required to acquire this role
        return rank;
    }

    public Player getPlayer(){
        //Returns the current player that has this role acquired
        return currentPlayer;
    }

    public void setPlayer(Player p){
        //Links a player(Player p) to this current role
        if(currentPlayer == null)
        currentPlayer = p;
    }
}

