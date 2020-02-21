public class Player{
    private String name;
    private int dollars;
    private int credits;
    private int rank = 1;
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

    public void addDollars(int amount){
        dollars += amount;
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

    public void setRoleType(String rt){
        roleType = rt;
    }

    public String getRoleType(){
        return roleType;
    }

}

