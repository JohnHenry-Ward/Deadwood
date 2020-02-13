public class Player{
    static String name;
    static int dollars;
    static int credits;
    static int rank;
    static Role currentRole;
    static Room currentRoom;
    static int practiceChips;
    static String roleType;

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

    public static int getPracticeChips(Player player){
        return player.practiceChips;
    }

    public static int getRank(Player player){
        return player.rank;
    }

    public static Role getCurrentRole(Player player){
        return player.currentRole;
    }

    public static Room getCurrentRoom(Player player){
        return player.currentRoom;
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

    public static void addPracticeChip(Player player){
        player.practiceChips += 1;
    }

    public static void setRank(Player player, int rank){
        player.rank = rank;
    }

    public static void setCurrentRole(Player player, Role role){
        player.currentRole = role;
    }

    public static void setCurrentRoom(Player player, Room room){
        player.currentRoom = room;
    }

    //might move this to a new Role's Class
    public static void setRoleType(Player player, String rollType){
        //set player.roleType = rollType;
    }
}

