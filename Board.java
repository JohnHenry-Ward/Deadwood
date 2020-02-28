import java.util.*;
import javax.swing.*;
import java.awt.Dimension;

public class Board<Room> {
    
    /* Singleton */
    public static final Board boardGame = new Board();

    private Board(){}

    public static Board getInstance(){
        return boardGame;
    }
    /* End Singleton */


    //The board will be represented by a map
    private Map<Room, List<Room> > map = new HashMap<>();

    /* Method adds a path, from source to destination
       utilizes addRoom so that you can simultaneously develop
       pathways between new and existing rooms
     */
    public void addPath(Room source, Room destination){
        if(!map.containsKey(source)){
            addRoom(source);
        }

        if(!map.containsKey(destination)){
            addRoom(destination);
        }

        map.get(source).add(destination);
        map.get(destination).add(source);
    }

    //Method develops the nodes within the map, a helper function for addPath
    public void addRoom(Room s){
        map.put(s, new LinkedList<Room>());
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

    public void initalizeBoard(){
        
        // This is the window
        JFrame boardFrame = new JFrame("Deadwood");
        boardFrame.setVisible(true);

        // This is the image of the board
        ImageIcon image = new ImageIcon("images/board.jpg");
        JLabel boardGameImg = new JLabel(image);
        boardGameImg.setBounds(0, 0, 1200, 900);


        // This is the "pane" the board is attacked too
        JLayeredPane boardGame = new JLayeredPane();
        boardGame.setPreferredSize(new Dimension(250, 250));
        boardGame.setBorder(BorderFactory.createTitledBorder("Boardgame"));
        boardGame.add(boardGameImg, new Integer(2));

        // Adding the pane which has the image attached to it to the window
        boardFrame.add(boardGame);
        boardFrame.pack();
        boardFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public void displayBoard(){

    }
}

