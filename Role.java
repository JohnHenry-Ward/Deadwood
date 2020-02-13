public class Role {
    String name;
    int rank;
    Player currentPlayer;

    public String getName(Role role){
        return role.name;
    }

    public void setName(String s){
        //Sets the name(String s) for this current role, used in initialization
    }

    public int getRank(Role role){
        //Returns the rank required to acquire this role
        return role.rank;
    }

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
        this.role.currentPlayer = player;
    }
}

