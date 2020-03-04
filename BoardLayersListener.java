import java.awt.*;
import javax.swing.*;
import javax.swing.ImageIcon;
import javax.imageio.ImageIO;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import java.awt.color.*;

public class BoardLayersListener extends JFrame {

    // JLabels
    JLabel boardlabel;
    JLabel cardlabel;
    ArrayList<JLabel> playerlabels = new ArrayList<JLabel>();
    JLabel mlabel;

    // JButtons
    JButton bAct;
    JButton bRehearse;
    JButton bMove;

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
        cardlabel.setBounds(20, 65, cIcon.getIconWidth() + 2, cIcon.getIconHeight());
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
        bMove.setBounds(icon.getIconWidth() + 10, 90, 100, 20);
        bMove.addMouseListener(new boardMouseListener());

        // Place the action buttons in the top layer
        bPane.add(bAct, new Integer(2));
        bPane.add(bRehearse, new Integer(2));
        bPane.add(bMove, new Integer(2));
    }

    public void addPlayers(ImageIcon pIcon){
        // Add a dice to represent a player
        JLabel plabel = new JLabel();
        plabel.setIcon(pIcon);
        plabel.setBounds(114, 227, 46, 46);
        playerlabels.add(plabel);

        int p = playerlabels.size() - 1;
        //Code to set players location 
        //~~~~~~~
        
        bPane.add(playerlabels.get(p), new Integer(3));
        playerlabels.get(p).setVisible(true);
    }

    class boardMouseListener implements MouseListener {
        // Code for the different button clicksindex
        public void mouseClicked(MouseEvent e){

            if(e.getSource() == bAct){
                System.out.println("Acting is Selected\n");
            }else if(e.getSource() == bRehearse){
                System.out.println("Rehearse is Selected\n");
            }else if(e.getSource() == bMove){
                System.out.println("Move is Selected");
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