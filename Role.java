public class Role {
    private String name;
    private int rank;
    private Player currentPlayer = null;

    public String getName(Role role){
        return role.name;
    }

    Role(String name, int rank){
        name = name;
        rank = rank;
    }

    public int getRank(Role role){
        //Returns the rank required to acquire this role
        return role.rank;
    }


    public void getPlayer(){
        
    
    }

    public void setRank(Role role, int rank){
        //Sets the rank(int rank) for the role, used in initialization
        role.rank = rank;
    }

    public Player getPlayer(Role role){

        //Returns the current player that has this role acquired
        return role.currentPlayer;
    }

    public void setPlayer(Player player, Role role){
        //Links a player(Player p) to this current role
        // if(currentPlayer == null)
        // currentPlayer = p;
        role.currentPlayer = player;

    }
}

