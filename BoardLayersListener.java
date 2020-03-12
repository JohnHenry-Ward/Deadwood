import java.awt.*;
import javax.swing.*;
import javax.swing.ImageIcon;
import javax.imageio.ImageIO;
import java.awt.event.*;
import java.util.*;
import java.lang.*;

public class BoardLayersListener extends JFrame {

    static Board<Room> board;
    static final long serialVersionUID = 0;
    static boolean roomsVisible = false;
    static boolean rolesVisible = false;
    static boolean moveSelections = false;
    static boolean upgradesVisible = false;
    static JButton[] roomButtonArr;
    static JButton[] roleButtonArr;
    static JButton[] upgradeButtonArrDollar = new JButton[5];
    static JButton[] upgradeButtonArrCredit = new JButton[5];
    static JLabel[] upgradeLabels = new JLabel[8];
    static Role[] roleArr;
    
    // JLabels
    JLabel boardlabel;
    JLabel cardlabel;
    ArrayList<JLabel> playerlabels = new ArrayList<JLabel>();
    JLabel mlabel;
    JLabel[] blankCards;

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

        // Create menu for action buttons
        mlabel = new JLabel("MENU");
        mlabel.setBounds(icon.getIconWidth() + 320, 0, 100, 20);
        bPane.add(mlabel, new Integer(2));

        // Create action buttons
        bAct = new JButton("ACT");
        bAct.setName("act");
        bAct.setBackground(Color.white);
        bAct.setBounds(icon.getIconWidth() + 10, 60, 150, 100);
        bAct.addMouseListener(new boardMouseListener());

        bRehearse = new JButton("REHEARSE");
        bRehearse.setName("rehearse");
        bRehearse.setBackground(Color.white);
        bRehearse.setBounds(icon.getIconWidth() + 170, 60, 150, 100);
        bRehearse.addMouseListener(new boardMouseListener());

        bMove = new JButton("MOVE");
        bMove.setName("move");
        bMove.setBackground(Color.white);
        bMove.setBounds(icon.getIconWidth() + 330, 60, 150, 100);
        bMove.addMouseListener(new boardMouseListener());

        bUpgrade = new JButton("UPGRADE");
        bUpgrade.setName("upgrade");
        bUpgrade.setBackground(Color.white);
        bUpgrade.setBounds(icon.getIconWidth() + 10, 170, 150, 100);
        bUpgrade.addMouseListener(new boardMouseListener());

        bTakeRole = new JButton("TAKE ROLE");
        bTakeRole.setName("work");
        bTakeRole.setBackground(Color.white);
        bTakeRole.setBounds(icon.getIconWidth() + 170, 170, 150, 100);
        bTakeRole.addMouseListener(new boardMouseListener());

        bEnd = new JButton("END");
        bEnd.setName("end");
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
        for(int i = 0; i < playerlabels.size(); i++){
            if(player.getName() == playerlabels.get(i).getName()){
                /*bPane.remove(playerlabels.get(i));
                JLabel plabel = new JLabel();
                plabel.setBounds(xCord, yCord, player.getIcon().getIconWidth(), player.getIcon().getIconHeight());
                plabel.setName(player.getName());
                playerlabels.set(i, plabel);

                bPane.add(playerlabels.get(i));*/
                playerlabels.get(i).setBounds(xCord, yCord, player.getIcon().getIconWidth(), player.getIcon().getIconHeight());
            }
        }
        bPane.repaint();
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
            pLabel.setName(players[i].getName());

            playerlabels.add(pLabel);

            bPane.add(playerlabels.get(i), new Integer(5));
            pLabel.setVisible(true);

            x += 50;

            if(i == 3){
                x = 0;
                y += 50;
            }

        }
    }

    public void initBlankCards(Room[] rooms){
        blankCards = new JLabel[12];
        ImageIcon cardImg;
        for(int i = 0; i < rooms.length; i++){
            if(!(rooms[i].getName().equals("Trailers")) && !(rooms[i].getName().equals("Casting Office"))){
                blankCards[i] = new JLabel();
                cardImg = new ImageIcon("images/cardback.jpg");
                Image scaledImg = cardImg.getImage();
                scaledImg = scaledImg.getScaledInstance(205, 115, java.awt.Image.SCALE_SMOOTH);
                cardImg = new ImageIcon(scaledImg);
                blankCards[i].setIcon(cardImg);
                blankCards[i].setBounds(rooms[i].getCardX(), rooms[i].getCardY(), 205, 115);
                bPane.add(blankCards[i], new Integer(2));
                blankCards[i].setVisible(true);
            }
        }
    }

    public void initShotCounters(Room[] rooms){
        ImageIcon shot = new ImageIcon("images/shot.png");
        for(int i = 0; i < rooms.length; i++){
            if(!(rooms[i].getName().equals("Trailers")) && !(rooms[i].getName().equals("Casting Office"))){
                JLabel[] shotLabels = rooms[i].getShotLabels();
                ArrayList<Integer> shotCounterCoords = rooms[i].getShotCounterCoords();
                int x = 0;
                int y = 1;
                for(int j = 0; j < shotCounterCoords.size()/2; j++){
                    shotLabels[j] = new JLabel();
                    shotLabels[j].setIcon(shot);
                    shotLabels[j].setBounds(shotCounterCoords.get(x), shotCounterCoords.get(y), shot.getIconWidth(), shot.getIconHeight());
                    bPane.add(shotLabels[j], new Integer(2));
                    shotLabels[j].setVisible(true);
                    x+=2;
                    y+=2;
                }
            }
        }
    }

    
    public void initUpgradeButtons(){
        upgradeButtonArrDollar[0] = new JButton("4");
        upgradeButtonArrDollar[0].setName("$-2");
        upgradeButtonArrDollar[0].addMouseListener(new boardMouseListener());
        upgradeButtonArrDollar[1] = new JButton("10");
        upgradeButtonArrDollar[1].setName("$-3");
        upgradeButtonArrDollar[1].addMouseListener(new boardMouseListener());
        upgradeButtonArrDollar[2] = new JButton("18");
        upgradeButtonArrDollar[2].setName("$-4");
        upgradeButtonArrDollar[2].addMouseListener(new boardMouseListener());
        upgradeButtonArrDollar[3] = new JButton("28");
        upgradeButtonArrDollar[3].setName("$-5");
        upgradeButtonArrDollar[3].addMouseListener(new boardMouseListener());
        upgradeButtonArrDollar[4] = new JButton("40");
        upgradeButtonArrDollar[4].setName("$-6");
        upgradeButtonArrDollar[4].addMouseListener(new boardMouseListener());

        upgradeButtonArrCredit[0] = new JButton("5");
        upgradeButtonArrCredit[0].setName("c-2");
        upgradeButtonArrCredit[0].addMouseListener(new boardMouseListener());
        upgradeButtonArrCredit[1] = new JButton("10");
        upgradeButtonArrCredit[1].setName("c-3");
        upgradeButtonArrCredit[1].addMouseListener(new boardMouseListener());
        upgradeButtonArrCredit[2] = new JButton("15");
        upgradeButtonArrCredit[2].setName("c-4");
        upgradeButtonArrCredit[2].addMouseListener(new boardMouseListener());
        upgradeButtonArrCredit[3] = new JButton("20");
        upgradeButtonArrCredit[3].setName("c-5");
        upgradeButtonArrCredit[3].addMouseListener(new boardMouseListener());
        upgradeButtonArrCredit[4] = new JButton("25");
        upgradeButtonArrCredit[4].setName("c-6");
        upgradeButtonArrCredit[4].addMouseListener(new boardMouseListener());

        ImageIcon board = new ImageIcon("images/board.jpg");
        int Yoffset = 0;
        for(int i = 0; i < 5; i++){
            upgradeLabels[i] = new JLabel("rank " + (i+2));
            upgradeLabels[i].setName("" + (i+2));
            ImageIcon icon = new ImageIcon("images/dice/w" + (i+2) + ".png");
            upgradeLabels[i].setIcon(icon);
            upgradeLabels[i].setBounds(board.getIconWidth() + 10, (board.getIconHeight()/2) + Yoffset, icon.getIconWidth(), icon.getIconHeight());

            upgradeButtonArrDollar[i].setBounds(board.getIconWidth() + 70, (board.getIconHeight()/2) + Yoffset, 50, 30);
            upgradeButtonArrCredit[i].setBounds(board.getIconWidth() + 130, (board.getIconHeight()/2) + Yoffset, 50, 30);

            bPane.add(upgradeLabels[i]);
            bPane.add(upgradeButtonArrCredit[i]);
            bPane.add(upgradeButtonArrDollar[i]);
            Yoffset+=60;
        }

        upgradeLabels[5] = new JLabel("RANK");
        upgradeLabels[5].setBounds(board.getIconWidth() + 10, (board.getIconHeight()/2) - 30, 100, 20);

        upgradeLabels[6] = new JLabel("DOLLARS");
        upgradeLabels[6].setBounds(board.getIconWidth() + 70, (board.getIconHeight()/2) - 30, 100, 20);

        upgradeLabels[7] = new JLabel("CREDITS");
        upgradeLabels[7].setBounds(board.getIconWidth() + 130, (board.getIconHeight()/2) - 30, 100, 20);

        bPane.add(upgradeLabels[5]);
        bPane.add(upgradeLabels[6]);
        bPane.add(upgradeLabels[7]);
        disableUpgrades();
    }

    public void disableUpgrades(){
        for(int i = 0; i < 5; i++){
            upgradeLabels[i].setVisible(false);
            upgradeButtonArrCredit[i].setVisible(false);
            upgradeButtonArrDollar[i].setVisible(false);
        }
        upgradeLabels[5].setVisible(false);
        upgradeLabels[6].setVisible(false);
        upgradeLabels[7].setVisible(false);
    }

    public void enableUpgrades(){
        for(int i = 0; i < 5; i++){
            upgradeLabels[i].setVisible(true);
            upgradeButtonArrCredit[i].setVisible(true);
            upgradeButtonArrDollar[i].setVisible(true);
        }
        upgradeLabels[5].setVisible(true);
        upgradeLabels[6].setVisible(true);
        upgradeLabels[7].setVisible(true);
    }

    public void revealCard(Room room, Card card){
        JLabel cardLabel = card.getJLabel();
        ImageIcon cardImg = card.getImage();
        cardLabel.setIcon(cardImg);
        cardLabel.setBounds(room.getCardX(), room.getCardY(), cardImg.getIconWidth(), cardImg.getIconHeight());
        cardLabel.setVisible(true);
        bPane.add(cardLabel, new Integer(3));
        blankCards[room.getID()].setVisible(false);
    }

    public void clearCard(Card card){
        JLabel cardLabel = card.getJLabel();
        cardLabel.setVisible(false);
    }

    public void removeCard(Card card){
        JLabel cardLabel = card.getJLabel();
        cardLabel.setVisible(false);
    }

    public void removeShotCounter(Room room){
        int shotNum = room.getShots();
        JLabel[] shotLabels = room.getShotLabels();
        shotLabels[shotNum].setVisible(false);
    }

    public void setNewRank(Player player, int rank){
        ImageIcon icon = new ImageIcon("images/dice/" + (""+player.getName().charAt(0)).toLowerCase() + rank + ".png");
        player.setIcon(icon);
        bPane.repaint();
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
            // ImageIcon pIcon = new ImageIcon(players[i].getPIconURL());
            ImageIcon pIcon = players[i].getIcon();
            pLabel.setIcon(pIcon);
            pLabel.setBounds(25 + offSet, 900, 190, 100);
            bPane.add(pLabel, new Integer(2));
            pLabel.setVisible(true);
            offSet += 125;
        }
    }

    public void displayVisibleButtons(Player player){
        disableMenu();
        System.out.print("DISPLAYING BUTTONS");
        if(player.getCurrentRole() != null){
            bAct.setVisible(true);
            bRehearse.setVisible(true);
        }
        if(player.getCurrentRole() == null && !player.getMoveFlag()){
            bMove.setVisible(true);
        }
        if(player.getCurrentRole() == null && player.getCurrentRoom().hasWrapped() == "unwrapped" && Deadwood.getAvailableRolesCount() != 0){
            bTakeRole.setVisible(true);
        }
        if(player.getCurrentRoom().getName() == "Casting Office"){
            bUpgrade.setVisible(true);
        }
        bEnd.setVisible(true);
    }

    public void disableMenu(){
        bAct.setVisible(false);
        bEnd.setVisible(false);
        bMove.setVisible(false);
        bRehearse.setVisible(false);
        bTakeRole.setVisible(false);
        bUpgrade.setVisible(false);
    }

    public void enableMenu(){
        bAct.setVisible(true);
        bEnd.setVisible(true);
        bMove.setVisible(true);
        bRehearse.setVisible(true);
        bTakeRole.setVisible(true);
        bUpgrade.setVisible(true);
    }

    //this notify's deadwood.java that something was clicked
    //then deadwood will update view
    class boardMouseListener implements MouseListener {
        String actionMode = "";
        
        // bEnd.setVisible(true);
        // Code for the different button clicksindex
        public void mouseClicked(MouseEvent e){
            if(e.getSource() == bAct && !moveSelections){
                System.out.println("Acting is Selected\n");
                Deadwood.actionMode = "Act";
            }else if(e.getSource() == bRehearse && !moveSelections){
                System.out.println("Rehearse is Selected\n");
                actionMode = "Rehearse";
                Deadwood.actionMode = actionMode;
                //do rehearsing logic
            }else if(e.getSource() == bMove || moveSelections){
                System.out.println("Move is Selected");

                moveSelections = true;
                actionMode = "Move";
                Player player = Deadwood.getCurrentPlayer();
                Room currentRoom = player.getCurrentRoom();
                board = Board.getInstance();
                
                int offset = 0;
                if(!roomsVisible){
                    ArrayList<Room> neighbors = board.getNeighbors(currentRoom);
                    roomButtonArr = new JButton[neighbors.size()];
                    for(int i = 0; i < neighbors.size(); i++){
                        roomButtonArr[i] = new JButton(neighbors.get(i).getName());
                        roomButtonArr[i].setName(neighbors.get(i).getName());
                        roomButtonArr[i].setBackground(Color.white);
                        roomButtonArr[i].setBounds(icon.getIconWidth() + 170, 300 + offset, 150, 100);
                        roomButtonArr[i].addMouseListener(new boardMouseListener());
                        bPane.add(roomButtonArr[i], new Integer(2));
                        offset += 150;
                        roomsVisible = true;
                    }
                }
                //display valid move locations as buttons
                //need to somehow get into a "move button pressed mode"
                    //all regular actions deactivated
                    //only can click on move buttons
                disableMenu();
                for(int j = 0; j < roomButtonArr.length; j++){
                    if(((JButton)e.getSource()).getName() == roomButtonArr[j].getName()){
                        moveSelections = false;
                        roomsVisible = false;
                        Deadwood.actionMode = ("move-" + ((JButton)e.getSource()).getName());
                        for(int x = 0; x < roomButtonArr.length; x++){
                            bPane.remove(roomButtonArr[x]);
                        }
                        enableMenu();
                        bAct.setVisible(false);
                        bRehearse.setVisible(false);
                        bUpgrade.setVisible(false);
                        bMove.setVisible(false);
                        if(((JButton)e.getSource()).getName().equals("Trailers") || ((JButton)e.getSource()).getName().equals("Casting Office")){
                            bTakeRole.setVisible(false);
                        }
                        if(((JButton)e.getSource()).getName().equals("Casting Office")){
                            bUpgrade.setVisible(true);
                        }
                        break;
                    }
                }
            }
            else if(e.getSource() == bUpgrade && !moveSelections){
                System.out.println("Upgrade is Selected\n");
                actionMode = "Upgrade";
                //display rank options
                    //display payment options
                enableUpgrades();
                disableMenu();
                bEnd.setVisible(true);
            }
            else if(e.getSource() == bTakeRole || rolesVisible){
                System.out.println("Take Role is Selected\n");
                actionMode = "Role";
                Player player = Deadwood.getCurrentPlayer();
                Room currentRoom = player.getCurrentRoom();
                int invisibleCount = 0;
                int offset = 0;
                if(!rolesVisible){
                    bEnd.setVisible(true);
                    Role[] roomRoles = currentRoom.getRoles();
                    Role[] cardRoles = currentRoom.getCard().getRoles();
                    roleArr = new Role[roomRoles.length + cardRoles.length];
                    System.arraycopy(roomRoles, 0, roleArr, 0, roomRoles.length);
                    System.arraycopy(cardRoles, 0, roleArr, roomRoles.length, cardRoles.length);
                    roleButtonArr = new JButton[roleArr.length];
                    // roleButtonArr = ArrayUtils.addAll(roomRoles, cardRoles);
                    
                    for(int i = 0; i < roleButtonArr.length; i++){
                        
                        roleButtonArr[i] = new JButton(roleArr[i].getName());
                        roleButtonArr[i].setName(roleArr[i].getName());
                        roleButtonArr[i].setBackground(Color.white);
                        roleButtonArr[i].setBounds(icon.getIconWidth() + 170, 300 + offset, 150, 100);
                        roleButtonArr[i].addMouseListener(new boardMouseListener());
                        bPane.add(roleButtonArr[i], new Integer(2));
                        offset += 100;
                        rolesVisible = true;
                        if(roleArr[i].getRank() > player.getRank()|| roleArr[i].getCurrentPlayer() != null){
                            roleButtonArr[i].setVisible(false);
                            invisibleCount++;
                        }
                    } 
                }
                disableMenu();
                for(int j = 0; j < roleButtonArr.length; j++){
                    if(invisibleCount == roleButtonArr.length){
                        bEnd.setVisible(true);
                    }
                    if(((JButton)e.getSource()).getName() == roleButtonArr[j].getName()){
                        rolesVisible = false;
                        Deadwood.actionMode = ("work-" + ((JButton)e.getSource()).getName());
                        for(int x = 0; x < roleButtonArr.length; x++){
                            bPane.remove(roleButtonArr[x]);
                        }
                        enableMenu();
                        bAct.setVisible(false);
                        bRehearse.setVisible(false);
                        bUpgrade.setVisible(false);
                        bMove.setVisible(false);
                        bTakeRole.setVisible(false);
                        break;
                    }
                }
            }
            else if(e.getSource() == bEnd){
                
                actionMode = "End";
                System.out.println("End is Selected\n");
                Deadwood.endTurn();
                disableUpgrades();
                if(Deadwood.isGameOver()){
                    Deadwood.endGame();
                }
            }
            else{
                for(int x = 0; x < 5; x++){
                    if(e.getSource() == upgradeButtonArrDollar[x]){
                        actionMode = "upgrade-" + upgradeButtonArrDollar[x].getName();
                        Deadwood.actionMode = actionMode;
                        disableUpgrades();
                    }else if(e.getSource() == upgradeButtonArrCredit[x]){
                        actionMode = "upgrade-" + upgradeButtonArrCredit[x].getName();
                        Deadwood.actionMode = actionMode;
                        disableUpgrades();
                    }
                }
            }
            /*if(actionMode.equals("Act") || actionMode.equals("Upgrade") || actionMode.equals("Role") || actionMode.equals("Rehearse")){
                Deadwood.endTurn();
                if(Deadwood.isGameOver()){
                    Deadwood.endGame();
                }
            }*/
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