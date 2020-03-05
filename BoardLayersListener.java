import java.awt.*;
import javax.swing.*;
import javax.swing.ImageIcon;
import javax.imageio.ImageIO;
import java.awt.event.*;
import java.util.ArrayList;

public class BoardLayersListener extends JFrame {

    static Board<Room> board;

    // JLabels
    JLabel boardlabel;
    JLabel cardlabel;
    ArrayList<JLabel> playerlabels = new ArrayList<JLabel>();
    JLabel mlabel;

    // JButtons
    JButton bAct;
    JButton bRehearse;
    JButton bMove;
    JButton bUpgrade;
    JButton bTakeRole;

    // JLayered Pane
    JLayeredPane bPane;

    // Constructor
    public BoardLayersListener() {
        super("Deadwood");

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        bPane = getLayeredPane();

        boardlabel = new JLabel();
        ImageIcon icon = new ImageIcon("images/board.jpg");
        boardlabel.setIcon(icon);
        boardlabel.setBounds(0, 0, icon.getIconWidth(), icon.getIconHeight());

        bPane.add(boardlabel, new Integer(0));

        setSize(icon.getIconWidth() + 200, icon.getIconHeight());

        //Mock card label
        cardlabel = new JLabel();
        ImageIcon cIcon = new ImageIcon("images/cards/01.png");
        cardlabel.setIcon(cIcon);
        cardlabel.setBounds(20, 65, cIcon.getIconWidth(), cIcon.getIconHeight());
        cardlabel.setOpaque(true);

        bPane.add(cardlabel, new Integer(1));

        // Create menu for action buttons
        mlabel = new JLabel("MENU");
        mlabel.setBounds(icon.getIconWidth() + 40, 0, 100, 20);
        bPane.add(mlabel, new Integer(2));

        // Create action buttons
        bAct = new JButton("ACT");
        bAct.setBackground(Color.white);
        bAct.setBounds(icon.getIconWidth() + 10, 60, 100, 20);
        bAct.addMouseListener(new boardMouseListener());

        bRehearse = new JButton("REHEARSE");
        bRehearse.setBackground(Color.white);
        bRehearse.setBounds(icon.getIconWidth() + 10, 90, 100, 20);
        bRehearse.addMouseListener(new boardMouseListener());

        bMove = new JButton("MOVE");
        bMove.setBackground(Color.white);
        bMove.setBounds(icon.getIconWidth() + 10, 120, 100, 20);
        bMove.addMouseListener(new boardMouseListener());

        bUpgrade = new JButton("UPGRADE");
        bUpgrade.setBackground(Color.white);
        bUpgrade.setBounds(icon.getIconWidth() + 10, 150, 100, 20);
        bUpgrade.addMouseListener(new boardMouseListener());

        bTakeRole = new JButton("TAKE ROLE");
        bTakeRole.setBackground(Color.white);
        bTakeRole.setBounds(icon.getIconWidth() + 10, 180, 100, 20);
        bTakeRole.addMouseListener(new boardMouseListener());

        // Place the action buttons in the top layer
        bPane.add(bAct, new Integer(2));
        bPane.add(bRehearse, new Integer(2));
        bPane.add(bMove, new Integer(2));
        bPane.add(bUpgrade, new Integer(2));
        bPane.add(bTakeRole, new Integer(2));
    }

    // THIS CAN/WILL BE DELETED
    public void addPlayers(Player player){
        // Add a dice to represent a player
        JLabel plabel = player.getPLabel();
        ImageIcon pIcon = player.getIcon();
        plabel.setIcon(pIcon);
        plabel.setBounds(1000, 300, 46, 46);
        playerlabels.add(plabel);

        int p = playerlabels.size() - 1;
        //Code to set players location 
        //~~~~~~~
        
        bPane.add(playerlabels.get(p), new Integer(3));
        playerlabels.get(p).setVisible(true);
    }

    public void movePlayer(Player player, int xCord, int yCord){
        JLabel plabel = player.getPLabel();
        ImageIcon pIcon = player.getIcon();

        plabel.setBounds(xCord, yCord, pIcon.getIconWidth(), pIcon.getIconHeight());
    }

    public void initPlayerPosition(Player[] players){
        JLabel pLabel;
        ImageIcon pIcon;
        int x = 0;
        int y = 0;
        
        for(int i = 0; i < players.length; i++){
            pLabel = players[i].getPLabel();
            pIcon = players[i].getIcon();

            pLabel.setIcon(pIcon);
            pLabel.setBounds(995 + x, 275 + y, 46, 46);

            playerlabels.add(pLabel);

            bPane.add(pLabel, new Integer(1));
            pLabel.setVisible(true);

            x += 50;

            if(i == 3){
                x = 0;
                y += 50;
            }

        }

        // public void displayRoomButtons(Player player){

        // }
    }

    //this notify's deadwood.java that something was clicked
    //then deadwood will update view
    class boardMouseListener implements MouseListener {
        // Code for the different button clicksindex
        public void mouseClicked(MouseEvent e){

            if(e.getSource() == bAct){
                System.out.println("Acting is Selected\n");
                //do acting logic
            }else if(e.getSource() == bRehearse){
                System.out.println("Rehearse is Selected\n");
                //do rehearsing logic
            }else if(e.getSource() == bMove){
                System.out.println("Move is Selected");
                Player player = Deadwood.getCurrentPlayer();
                Room currentRoom = player.getCurrentRoom();
                board = Board.getInstance();
                ArrayList<Room> neighbors = board.getNeighbors(currentRoom);
                for(int i = 0; i < neighbors.size(); i++){
                    //create buttons for each room options
                }
                //display valid move locations as buttons
            }
            else if(e.getSource() == bUpgrade){
                System.out.println("Upgrade is Selected\n");
                //display rank options
                    //display payment options
            }
            else if(e.getSource() == bTakeRole){
                System.out.println("Take Role is Selected\n");
                //display valid roles
            }
        }
        public void mousePressed(MouseEvent e) {
        }
        public void mouseReleased(MouseEvent e) {
        }
        public void mouseEntered(MouseEvent e) {
        }
        public void mouseExited(MouseEvent e) {
        }
    }
}