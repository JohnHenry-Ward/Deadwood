public class Role {
    private String name;
    private int rank;
    private Player currentPlayer = null;
    private boolean roleAvailable = true;

    public String getName(){
        return name;
    }

    public Role(String n, int r){
        name = n;
        rank = r;
        currentPlayer = null;
        roleAvailable = true;
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
        currentPlayer = player;
    }

    public void setRoleAvailable(boolean avail){
        roleAvailable = avail;
    }

    public boolean isRoleAvailable(){
        return roleAvailable;
    }
}

