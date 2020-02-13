import java.util.*;

public class Board<Room> {
    Bank bank;

    //The board will be represented by a map
    private Map<Room, List<Room> > map = new HashMap<>();

    public void addRoom(Room s){
        //This is what develops the node within the map, a helper function for addPath
        map.put(s, new LinkedList<Room>());
    }

    public void addPath(Room source, Room destination){
        //This function adds a path, from source to destination
        //addPath is what you use to add a new room to the graph,
        //it utilizes addRoom so that you can simultaneously develop
        //pathways between new and existing rooms
        if(!map.containsKey(source))
            addRoom(source);

        if(!map.containsKey(destination))
            addRoom(destination);

        map.get(source).add(destination);
        map.get(destination).add(source);
    }

    //This functions returns an arraylist consisting of all neighbors to a room
    public ArrayList<Room> getNeighbors(Room node){
        ArrayList<Room> neighbors = new ArrayList<Room>();

        for(Room v : map.keySet()){
            if(map.get(v).contains(node))
                neighbors.add(v);
        }
    
        return neighbors;
    }

    public Bank getBank(){
        //returns the currently used bank object
        return bank;
    }

    public void setBank(Bank b){
        //When game is initialized, this will set which bank is used depending on number of players
    }
    
}

