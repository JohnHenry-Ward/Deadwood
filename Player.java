public class Player{
    String name;
    int dollars;
    int credits;
    int rank;
    Role currentRole;
    Room currentRoom;
    int practiceChips;
    String roleType;

    public Player(String name){
        this.name = name;
    }

    public static String getName(Player player){
        return player.name;
        //return player.name;
    }

    public int getDollars(Player player){
        return -1;
        //return player.dollars;
    }

    public int getCredits(Player player){
        return -1;
        //return player.credits;
    }

    public int getRank(Player player){
        return -1;
        //return player.rank;
    }

    public void getCurrentRole(Player player){
        //will return type Role
        //return player.currentRole;
    }

    public void getCurrentRoom(Player player){
        //will return type Room
        //return player.currentRole;
    }

    public String getRoleType(Player player){
        return "a";
        //return player.roleType;
    }

    public void setName(Player player, String name){
        //set player.name = name;
    }

    public void addDollars(Player player, int dollars){
        //set player.dollars += dollars;
    }

    public void addCredits(Player player, int credits){
        //set player.credits += player.credits;
    }

    public void setRank(Player player, int rank){
        //set player.rank = rank;
    }

    public void setCurrentRole(Player player, Role role){
        //set player.currentRole = role;
    }

    public void setCurrentRoom(Player player, Room room){
        //set player.currentRoom = room;
    }

    public void setRoleType(Player player, String rollType){
        //set player.roleType = rollType;
    }
}

