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
    }

    public static int getDollars(Player player){
        return player.dollars;
    }

    public static int getCredits(Player player){
        return player.credits;
    }

    public static int getRank(Player player){
        return player.rank;
    }

    public static void getCurrentRole(Player player){
        //will return type Role
        //return player.currentRole;
    }

    public static void getCurrentRoom(Player player){
        //will return type Room
        //return player.currentRole;
    }

    //might move this to a new Roles's Class
    public static String getRoleType(Player player){
        return "a";
        //return player.roleType;
    }

    //this might not be necessary
    public static int getScore(Player player){
        return player.dollars + player.credits + (player.rank * 5);
    }

    public static void setName(Player player, String name){
        player.name = name;
    }

    public static void addDollars(Player player, int dollars){
        player.dollars += dollars;
    }

    public static void addCredits(Player player, int credits){
        player.credits += credits;

    }

    public static void setRank(Player player, int rank){
        player.rank = rank;
    }

    public static void setCurrentRole(Player player, Role role){
        //set player.currentRole = role;
    }

    public static void setCurrentRoom(Player player, Room room){
        //set player.currentRoom = room;
    }

    //might move this to a new Role's Class
    public static void setRoleType(Player player, String rollType){
        //set player.roleType = rollType;
    }
}

