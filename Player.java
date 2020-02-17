public class Player{
    private String name;
    private int dollars;
    private int credits;
    private int rank;
    private Role currentRole;
    private Room currentRoom;
    private int practiceChips;
    private String roleType;

    public Player(String n){
        name = n;
    }

    public String getName(){
        return name;
    }

    public int getDollars(){
        return dollars;
    }

    public int getCredits(){
        return credits;
    }

    public int getPracticeChips(){
        return practiceChips;
    }

    public int getRank(){
        return rank;
    }

    public Role getCurrentRole(){
        return currentRole;
    }

    public Room getCurrentRoom(){
        return currentRoom;
    }

    //this might not be necessary
    public int getScore(){
        return dollars + credits + (rank * 5);
    }

    public void addDollars(int amoutn){
        dollars += amoutn;
    }

    public void addCredits(int amount){
        credits += amount;
    }

    public void addPracticeChip(){
        practiceChips += 1;
    }

    public void setRank(int r){
        rank = r;
    }

    public void setCurrentRole(Role role){
        currentRole = role;
    }

    public void setCurrentRoom(Room room){
        currentRoom = room;
    }

    //might move this to a new Role's Class
    public static void setRoleType(Player player, String rollType){
        //set player.roleType = rollType;
    }

    //might move this to a new Roles's Class
    public String getRoleType(){
        return roleType;
    }
}

