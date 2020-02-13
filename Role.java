public class Role {
    String name;
    int rank;
    Player currentPlayer = null;

    public String getName(Role role){
        return role.name;
    }

    Role(String name, int rank){
        this.name = name;
        this.rank = rank;
    }

    public int getRank(Role role){
        //Returns the rank required to acquire this role
        return role.rank;
    }


    public Player getPlayer(){

    public void setRank(Role role, int rank){
        //Sets the rank(int rank) for the role, used in initialization
        this.role.rank = rank;
    }

    public Player getPlayer(Role role){

        //Returns the current player that has this role acquired
        return role.currentPlayer;
    }

    public void setPlayer(Player player, Role role){
        //Links a player(Player p) to this current role
        if(currentPlayer == null)
        currentPlayer = p;
        this.role.currentPlayer = player;

    }
}

