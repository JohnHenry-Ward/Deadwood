public class Role {
    private String name;
    private int rank;
    private Player currentPlayer;

    public String getName(){
        return name;
    }

    public Role(String n, int r){
        name = n;
        rank = r;
        currentPlayer = null;
    }

    public int getRank(){
        //Returns the rank required to acquire this role
        return rank;
    }


    public Player getPlayer(){
        return currentPlayer;
    }

    public void setRank(Role role, int rank){
        //Sets the rank(int rank) for the role, used in initialization
        role.rank = rank;
    }

    public void setPlayer(Player player){
        //Links a player(Player p) to this current role
        // if(currentPlayer == null)
        // currentPlayer = p;
        currentPlayer = player;

    }
}

