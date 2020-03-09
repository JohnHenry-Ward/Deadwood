import java.awt.*;
import javax.swing.*;
import javax.swing.ImageIcon;
import javax.imageio.ImageIO;
import java.awt.event.*;
import java.util.ArrayList;

public class BoardLayersListener extends JFrame {

    static Board<Room> board;
    static final long serialVersionUID = 0;

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
    JButton bEnd;

    // JLayered Pane
    JLayeredPane bPane;

    ImageIcon icon;

    // Constructor
    public BoardLayersListener() {
        super("Deadwood");

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        bPane = getLayeredPane();
        
        boardlabel = new JLabel();
        icon = new ImageIcon("images/board.jpg");
        boardlabel.setIcon(icon);
        boardlabel.setBounds(0, 0, icon.getIconWidth(), icon.getIconHeight());

        bPane.add(boardlabel, new Integer(0));

        setSize(icon.getIconWidth() + 200, icon.getIconHeight());

        //Mock card label
        cardlabel = new JLabel();
        ImageIcon cIcon = new ImageIcon("images/cards/01.png");
        cardlabel.setIcon(cIcon);
        cardlabel.setBounds(21, 68, cIcon.getIconWidth(), cIcon.getIconHeight());
        cardlabel.setOpaque(true);

        bPane.add(cardlabel, new Integer(1));

        // Create menu for action buttons
        mlabel = new JLabel("MENU");
        mlabel.setBounds(icon.getIconWidth() + 320, 0, 100, 20);
        bPane.add(mlabel, new Integer(2));

        // Create action buttons
        bAct = new JButton("ACT");
        bAct.setBackground(Color.white);
        bAct.setBounds(icon.getIconWidth() + 10, 60, 150, 100);
        bAct.addMouseListener(new boardMouseListener());

        bRehearse = new JButton("REHEARSE");
        bRehearse.setBackground(Color.white);
        bRehearse.setBounds(icon.getIconWidth() + 170, 60, 150, 100);
        bRehearse.addMouseListener(new boardMouseListener());

        bMove = new JButton("MOVE");
        bMove.setBackground(Color.white);
        bMove.setBounds(icon.getIconWidth() + 330, 60, 150, 100);
        bMove.addMouseListener(new boardMouseListener());

        bUpgrade = new JButton("UPGRADE");
        bUpgrade.setBackground(Color.white);
        bUpgrade.setBounds(icon.getIconWidth() + 10, 170, 150, 100);
        bUpgrade.addMouseListener(new boardMouseListener());

        bTakeRole = new JButton("TAKE ROLE");
        bTakeRole.setBackground(Color.white);
        bTakeRole.setBounds(icon.getIconWidth() + 170, 170, 150, 100);
        bTakeRole.addMouseListener(new boardMouseListener());

        bEnd = new JButton("END");
        bEnd.setBackground(Color.white);
        bEnd.setBounds(icon.getIconWidth() + 330, 170, 150, 100);
        bEnd.addMouseListener(new boardMouseListener());

        // Place the action buttons in the top layer
        bPane.add(bAct, new Integer(2));
        bPane.add(bRehearse, new Integer(2));
        bPane.add(bMove, new Integer(2));
        bPane.add(bUpgrade, new Integer(2));
        bPane.add(bTakeRole, new Integer(2));
        bPane.add(bEnd, new Integer(2));

        // Current Player Label
        JLabel currPlayerLabel = new JLabel("Current Player: ");
        currPlayerLabel.setBounds(icon.getIconWidth() + 10, 800, 200, 200);
        bPane.add(currPlayerLabel, new Integer(2));
    
    }

    public void displayCurrentPlayer(Player currentPlayer){
        JLabel pLabel = new JLabel();
        pLabel.setIcon(currentPlayer.getIcon());
        pLabel.setBounds(icon.getIconWidth() + 130, 877, currentPlayer.getIcon().getIconHeight(), currentPlayer.getIcon().getIconHeight());
        bPane.add(pLabel, new Integer(2));
        bPane.moveToFront(pLabel);
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
            // pLabel = players[i].getPLabel();
            pLabel = new JLabel();
            pIcon = players[i].getIcon();

            pLabel.setIcon(pIcon);
            pLabel.setBounds(995 + x, 275 + y, 46, 46);

            playerlabels.add(pLabel);

            bPane.add(pLabel, new Integer(2));
            pLabel.setVisible(true);

            x += 50;

            if(i == 3){
                x = 0;
                y += 50;
            }

        }
    }

    public void initBlankCards(Room[] rooms){
        JLabel blankCard;
        ImageIcon cardImg;
        for(int i = 0; i < rooms.length; i++){
            if(!(rooms[i].getName().equals("Trailers")) && !(rooms[i].getName().equals("Casting Office"))){
                blankCard = new JLabel();
                cardImg = new ImageIcon("images/cardback.jpg");
                Image scaledImg = cardImg.getImage();
                scaledImg = scaledImg.getScaledInstance(205, 115, java.awt.Image.SCALE_SMOOTH);
                cardImg = new ImageIcon(scaledImg);
                blankCard.setIcon(cardImg);
                blankCard.setBounds(rooms[i].getCardX(), rooms[i].getCardY(), 205, 115);
                bPane.add(blankCard, new Integer(2));
                blankCard.setVisible(true);
            }
        }
    }

    public void initShotCounters(Room[] rooms){
        JLabel shotArea;

        // shotArr[0] = new JLabel();
        // shotArr[1] = new JLabel();
        // shotArr[2] = new JLabel();
        ImageIcon shot;
        for(int i = 0; i < rooms.length; i++){
            if(!(rooms[i].getName().equals("Trailers")) && !(rooms[i].getName().equals("Casting Office"))){
                JLabel[] shotLabels = rooms[i].getShotLabels();
                ArrayList<Integer> shotCounterCoords = rooms[i].getShotCounterCoords();
                System.out.println(rooms[i].getName());
                int x = 0;
                int y = 1;
                for(int j = 0; j < shotCounterCoords.size()/2; j++){
                    shot = new ImageIcon("images/shot.png");
                    shotLabels[j] = new JLabel();
                    shotLabels[j].setIcon(shot);
                    System.out.println(shotCounterCoords.size()/2 + 1);
                    System.out.println("x: " + x);
                    shotLabels[j].setBounds(shotCounterCoords.get(x), shotCounterCoords.get(y), shot.getIconWidth(), shot.getIconHeight());
                    bPane.add(shotLabels[j], new Integer(2));
                    shotLabels[j].setVisible(true);
                    System.out.println("Placing at (x, y): " + shotCounterCoords.get(x) + ", " + shotCounterCoords.get(y));
                    x+=2;
                    y+=2;
                }
            }
        }
    }

    public void removeShotCounter(Room room){
        int shotNum = room.getShots();
        JLabel[] shotLabels = room.getShotLabels();
        shotLabels[shotNum].setVisible(false);
    }

     public void displayScores(Player[] players){
        // ImageIcon pIcon = new ImageIcon();
        JLabel pLabel;
        int offSet = 0;

        for(int i = 0; i < players.length; i++){
            pLabel = players[i].getPLabel();

            pLabel.setText("<html> Dollars: " + players[i].getDollars() + 
                            "<br> Credits: " + players[i].getCredits() + 
                            "<br> Rank: " + players[i].getRank() + 
                            "<br> Score: " + players[i].getScore() + "</html>");
            

            // pIcon = players[i].getIcon();
            ImageIcon pIcon = new ImageIcon(players[i].getPIconURL());
            pLabel.setIcon(pIcon);
            pLabel.setBounds(25 + offSet, 900, 190, 100);
            bPane.add(pLabel, new Integer(2));
            pLabel.setVisible(true);
            offSet += 125;
        }
    }

    //this notify's deadwood.java that something was clicked
    //then deadwood will update view
    class boardMouseListener implements MouseListener {
        JButton[] roomButtonArr;
        String actionMode = "";

        // Code for the different button clicksindex
        public void mouseClicked(MouseEvent e){
            
            if(e.getSource() == bAct){
                System.out.println("Acting is Selected\n");
                actionMode = "Act";
                if(Deadwood.attemptToAct()){
                    System.out.println("Success!");
                }
                else{
                    System.out.println("Fail");
                }
                //do acting logic
            }else if(e.getSource() == bRehearse){
                System.out.println("Rehearse is Selected\n");
                
                actionMode = "Rehearse";
                //do rehearsing logic
            }else if(e.getSource() == bMove){
                System.out.println("Move is Selected");
                
                actionMode = "Move";
                Player player = Deadwood.getCurrentPlayer();
                Room currentRoom = player.getCurrentRoom();
                board = Board.getInstance();
                ArrayList<Room> neighbors = board.getNeighbors(currentRoom);
                roomButtonArr = new JButton[neighbors.size()];
                int offset = 0;
                for(int i = 0; i < neighbors.size(); i++){
                    roomButtonArr[i] = new JButton(neighbors.get(i).getName());
                    roomButtonArr[i].setBackground(Color.white);
                    roomButtonArr[i].setBounds(icon.getIconWidth() + 170, 300 + offset, 150, 100);
                    roomButtonArr[i].addMouseListener(new boardMouseListener());
                    bPane.add(roomButtonArr[i], new Integer(2));
                    offset += 150;
                }
                //display valid move locations as buttons
                //need to somehow get into a "move button pressed mode"
                    //all regular actions deactivated
                    //only can click on move buttons
                
            }
            else if(e.getSource() == bUpgrade){
                System.out.println("Upgrade is Selected\n");
                
                actionMode = "Upgrade";
                //display rank options
                    //display payment options
            }
            else if(e.getSource() == bTakeRole){
                System.out.println("Take Role is Selected\n");
                
                actionMode = "Role";
                //display valid roles
            }
            else if(e.getSource() == bEnd){
                
                actionMode = "End";
                System.out.println("End is Selected\n");
                Deadwood.endTurn();
                if(Deadwood.isGameOver()){
                    Deadwood.endGame();
                }
            }
            if(actionMode.equals("Act") || actionMode.equals("Upgrade") || actionMode.equals("Role") || actionMode.equals("Rehearse")){
                Deadwood.endTurn();
                if(Deadwood.isGameOver()){
                    Deadwood.endGame();
                }
            }
            System.out.println("Mode: " + actionMode);
            displayScores(Deadwood.getPlayerOrder());
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