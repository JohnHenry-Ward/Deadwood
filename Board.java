import java.util.*;

public class Board<Room> {
    Room trailer;
    Room castingOffice;

    //The board will be represented by a map
    private Map<Room, List<Room> > map = new HashMap<>();

    public void addRoom(Room s){

    }

    //This function adds an edge, from source to destination
    //addEdge is what you use to add a new room to the graph,
    //it utilizes addRoom so that you can simultaneously develop
    //pathways between new and existing rooms
    public void addEdge(Room source, Room Destination){

    }

    //This functions returns an arraylist consisting of all neighbors to a room
    public ArrayList<Room> getNeighbors(Room node){
        ArrayList<Room> neighbors = new ArrayList<Room>();
        return neighbors;
    }

}

