/*  GameBoardPanel.java
	D. Mendez, R. John, K. Cruz
	CECS 343
	Due 03 Dec 2019
	Title: Game Board Panel class
	Description: displays the GUI for the Game Board
*/

package kingOfTokyo;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;

public class GameBoardPanel extends JFrame {
	
	/**
	 * Instance Variables
	 */
	JScrollPane scrollPane;
	JPanel centerPanel;
	JLayeredPane layerPane;
	
	JTextArea vp1;
	JTextArea lp1;
	
	JTextArea vp2;
	JTextArea lp2;
	
	JTextArea vp3;
	JTextArea lp3;
	
	JTextArea vp4;
	JTextArea lp4;
	
	JTextArea vp5;
	JTextArea lp5;
	
	JTextArea vp6;
	JTextArea lp6;
	
	Border raisedbevel = BorderFactory.createRaisedBevelBorder(); 
 	Border loweredbevel = BorderFactory.createLoweredBevelBorder();
	
	private ArrayList<Monsters> mPlayers;
	
	/**
	 * Default Constructor
	 * @param pPlayers - an ArrayList of type Players
	 */
	public GameBoardPanel(ArrayList<Monsters> pPlayers) {
		
		mPlayers = pPlayers;
		
		this.setTitle("King of Tokyo");
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
				
		centerPanel = new JPanel();
		layerPane = getLayeredPane();
		this.createDefaultPanel();
		scrollPane = new JScrollPane(centerPanel);
		this.add(scrollPane, BorderLayout.CENTER);
		
		this.setVisible(true);
	}
	
	/**
	 * Creates the default panel
	 * Shows the Game Board, Character Cards, Victory Points, and Life Points
	 */
	public void createDefaultPanel() {
		
		JLabel imgLabel = new JLabel(new ImageIcon("C:\\Users\\Daniel\\Downloads\\KoT GameBoard.jpg"));
		centerPanel.add(imgLabel);
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(0,2));
		
		for (int i = 0; i < mPlayers.size(); i++) {
			
			if (mPlayers.get(i).getMonsterName().equals("The King")) {
				JLabel player = new JLabel(new ImageIcon("C:\\Users\\Daniel\\Downloads\\KoT The King.jpg"));
				panel.add(player);
			}
			else if (mPlayers.get(i).getMonsterName().equals("Meka Dragon")) {
				JLabel player = new JLabel(new ImageIcon("C:\\Users\\Daniel\\Downloads\\KoT Meka Dragon.jpg"));
				panel.add(player);
			}
			else if (mPlayers.get(i).getMonsterName().equals("Cyber Bunny")) {
				JLabel player = new JLabel(new ImageIcon("C:\\Users\\Daniel\\Downloads\\KoT Cyber Bunny.jpg"));
				panel.add(player);
			}
			else if (mPlayers.get(i).getMonsterName().equals("Alienoid")) {
				JLabel player = new JLabel(new ImageIcon("C:\\Users\\Daniel\\Downloads\\KoT Alienoid.jpg"));
				panel.add(player);
			}
			else if (mPlayers.get(i).getMonsterName().equals("Gigazaur")) {
				JLabel player = new JLabel(new ImageIcon("C:\\Users\\Daniel\\Downloads\\KoT Gigazaur.jpg"));
				panel.add(player);
			}
			else if (mPlayers.get(i).getMonsterName().equals("Kraken")) {
				JLabel player = new JLabel(new ImageIcon("C:\\Users\\Daniel\\Downloads\\KoT Kraken.jpg"));
				panel.add(player);
			}
			else if (mPlayers.get(i).getMonsterName().equals("Pandakai")) {
				JLabel player = new JLabel(new ImageIcon("C:\\Users\\Daniel\\Downloads\\KoT Pandakai.jpg"));
				panel.add(player);
			}
		}
		centerPanel.add(panel);
		
		if (mPlayers.size() == 2) {
			
			vp1 = new JTextArea("Victory Points: " + mPlayers.get(0).getVictoryPoints());
			vp1.setEditable(false);
			vp1.setBounds(1150, 625, 100, 25);
			vp1.setBorder(BorderFactory.createCompoundBorder(raisedbevel, loweredbevel));
			layerPane.add(vp1);

			lp1 = new JTextArea("Life Points: " + mPlayers.get(0).getHealthPoints());
			lp1.setEditable(false);
			lp1.setBounds(1350, 625, 100, 25);
			lp1.setBorder(BorderFactory.createCompoundBorder(raisedbevel, loweredbevel));
			layerPane.add(lp1);
			
			vp2 = new JTextArea("Victory Points: " + mPlayers.get(1).getVictoryPoints());
			vp2.setEditable(false);
			vp2.setBounds(1475, 625, 100, 25);
			vp2.setBorder(BorderFactory.createCompoundBorder(raisedbevel, loweredbevel));
			layerPane.add(vp2);

			lp2 = new JTextArea("Life Points: " + mPlayers.get(1).getHealthPoints());
			lp2.setEditable(false);
			lp2.setBounds(1675, 625, 100, 25);
			lp2.setBorder(BorderFactory.createCompoundBorder(raisedbevel, loweredbevel));
			layerPane.add(lp2);
		}
		else if (mPlayers.size() ==3) {
			
			vp1 = new JTextArea("Victory Points: " + mPlayers.get(0).getVictoryPoints());
			vp1.setEditable(false);
			vp1.setBounds(1150, 465, 100, 25);
			vp1.setBorder(BorderFactory.createCompoundBorder(raisedbevel, loweredbevel));
			layerPane.add(vp1);

			lp1 = new JTextArea("Life Points: " + mPlayers.get(0).getHealthPoints());
			lp1.setEditable(false);
			lp1.setBounds(1350, 465, 100, 25);
			lp1.setBorder(BorderFactory.createCompoundBorder(raisedbevel, loweredbevel));
			layerPane.add(lp1);
			
			vp2 = new JTextArea("Victory Points: " + mPlayers.get(1).getVictoryPoints());
			vp2.setEditable(false);
			vp2.setBounds(1475, 465, 100, 25);
			vp2.setBorder(BorderFactory.createCompoundBorder(raisedbevel, loweredbevel));
			layerPane.add(vp2);

			lp2 = new JTextArea("Life Points: " + mPlayers.get(1).getHealthPoints());
			lp2.setEditable(false);
			lp2.setBounds(1675, 465, 100, 25);
			lp2.setBorder(BorderFactory.createCompoundBorder(raisedbevel, loweredbevel));
			layerPane.add(lp2);
			
			vp3 = new JTextArea("Victory Points: " + mPlayers.get(2).getVictoryPoints());
			vp3.setEditable(false);
			vp3.setBounds(1150, 790, 100, 25);
			vp3.setBorder(BorderFactory.createCompoundBorder(raisedbevel, loweredbevel));
			layerPane.add(vp3);

			lp3 = new JTextArea("Life Points: " + mPlayers.get(2).getHealthPoints());
			lp3.setEditable(false);
			lp3.setBounds(1350, 790, 100, 25);
			lp3.setBorder(BorderFactory.createCompoundBorder(raisedbevel, loweredbevel));
			layerPane.add(lp3);
		}
		else if (mPlayers.size() == 4) {
			
			vp1 = new JTextArea("Victory Points: " + mPlayers.get(0).getVictoryPoints());
			vp1.setEditable(false);
			vp1.setBounds(1150, 465, 100, 25);
			vp1.setBorder(BorderFactory.createCompoundBorder(raisedbevel, loweredbevel));
			layerPane.add(vp1);

			lp1 = new JTextArea("Life Points: " + mPlayers.get(0).getHealthPoints());
			lp1.setEditable(false);
			lp1.setBounds(1350, 465, 100, 25);
			lp1.setBorder(BorderFactory.createCompoundBorder(raisedbevel, loweredbevel));
			layerPane.add(lp1);
			
			vp2 = new JTextArea("Victory Points: " + mPlayers.get(1).getVictoryPoints());
			vp2.setEditable(false);
			vp2.setBounds(1475, 465, 100, 25);
			vp2.setBorder(BorderFactory.createCompoundBorder(raisedbevel, loweredbevel));
			layerPane.add(vp2);

			lp2 = new JTextArea("Life Points: " + mPlayers.get(1).getHealthPoints());
			lp2.setEditable(false);
			lp2.setBounds(1675, 465, 100, 25);
			lp2.setBorder(BorderFactory.createCompoundBorder(raisedbevel, loweredbevel));
			layerPane.add(lp2);
			
			vp3 = new JTextArea("Victory Points: " + mPlayers.get(2).getVictoryPoints());
			vp3.setEditable(false);
			vp3.setBounds(1150, 790, 100, 25);
			vp3.setBorder(BorderFactory.createCompoundBorder(raisedbevel, loweredbevel));
			layerPane.add(vp3);

			lp3 = new JTextArea("Life Points: " + mPlayers.get(2).getHealthPoints());
			lp3.setEditable(false);
			lp3.setBounds(1350, 790, 100, 25);
			lp3.setBorder(BorderFactory.createCompoundBorder(raisedbevel, loweredbevel));
			layerPane.add(lp3);
			
			vp4 = new JTextArea("Victory Points: " + mPlayers.get(3).getVictoryPoints());
			vp4.setEditable(false);
			vp4.setBounds(1475, 790, 100, 25);
			vp4.setBorder(BorderFactory.createCompoundBorder(raisedbevel, loweredbevel));
			layerPane.add(vp4);

			lp4 = new JTextArea("Life Points: " + mPlayers.get(3).getHealthPoints());
			lp4.setEditable(false);
			lp4.setBounds(1675, 790, 100, 25);
			lp4.setBorder(BorderFactory.createCompoundBorder(raisedbevel, loweredbevel));
			layerPane.add(lp4);
		}
		else if (mPlayers.size() == 5) {
			vp1 = new JTextArea("Victory Points: " + mPlayers.get(0).getVictoryPoints());
			vp1.setEditable(false);
			vp1.setBounds(1150, 300, 100, 25);
			vp1.setBorder(BorderFactory.createCompoundBorder(raisedbevel, loweredbevel));
			layerPane.add(vp1);

			lp1 = new JTextArea("Life Points: " + mPlayers.get(0).getHealthPoints());
			lp1.setEditable(false);
			lp1.setBounds(1350, 300, 100, 25);
			lp1.setBorder(BorderFactory.createCompoundBorder(raisedbevel, loweredbevel));
			layerPane.add(lp1);
			
			vp2 = new JTextArea("Victory Points: " + mPlayers.get(1).getVictoryPoints());
			vp2.setEditable(false);
			vp2.setBounds(1475, 300, 100, 25);
			vp2.setBorder(BorderFactory.createCompoundBorder(raisedbevel, loweredbevel));
			layerPane.add(vp2);

			lp2 = new JTextArea("Life Points: " + mPlayers.get(1).getHealthPoints());
			lp2.setEditable(false);
			lp2.setBounds(1675, 300, 100, 25);
			lp2.setBorder(BorderFactory.createCompoundBorder(raisedbevel, loweredbevel));
			layerPane.add(lp2);
			
			vp3 = new JTextArea("Victory Points: " + mPlayers.get(2).getVictoryPoints());
			vp3.setEditable(false);
			vp3.setBounds(1150, 625, 100, 25);
			vp3.setBorder(BorderFactory.createCompoundBorder(raisedbevel, loweredbevel));
			layerPane.add(vp3);

			lp3 = new JTextArea("Life Points: " + mPlayers.get(2).getHealthPoints());
			lp3.setEditable(false);
			lp3.setBounds(1350, 625, 100, 25);
			lp3.setBorder(BorderFactory.createCompoundBorder(raisedbevel, loweredbevel));
			layerPane.add(lp3);
			
			vp4 = new JTextArea("Victory Points: " + mPlayers.get(3).getVictoryPoints());
			vp4.setEditable(false);
			vp4.setBounds(1475, 625, 100, 25);
			vp4.setBorder(BorderFactory.createCompoundBorder(raisedbevel, loweredbevel));
			layerPane.add(vp4);

			lp4 = new JTextArea("Life Points: " + mPlayers.get(3).getHealthPoints());
			lp4.setEditable(false);
			lp4.setBounds(1675, 625, 100, 25);
			lp4.setBorder(BorderFactory.createCompoundBorder(raisedbevel, loweredbevel));
			layerPane.add(lp4);
			
			vp5 = new JTextArea("Victory Points: " + mPlayers.get(4).getVictoryPoints());
			vp5.setEditable(false);
			vp5.setBounds(1150, 950, 100, 25);
			vp5.setBorder(BorderFactory.createCompoundBorder(raisedbevel, loweredbevel));
			layerPane.add(vp5);

			lp5 = new JTextArea("Life Points: " + mPlayers.get(4).getHealthPoints());
			lp5.setEditable(false);
			lp5.setBounds(1350, 950, 100, 25);
			lp5.setBorder(BorderFactory.createCompoundBorder(raisedbevel, loweredbevel));
			layerPane.add(lp5);
		}
		else if (mPlayers.size() == 6) {
			vp1 = new JTextArea("Victory Points: " + mPlayers.get(0).getVictoryPoints());
			vp1.setEditable(false);
			vp1.setBounds(1150, 300, 100, 25);
			vp1.setBorder(BorderFactory.createCompoundBorder(raisedbevel, loweredbevel));
			layerPane.add(vp1);

			lp1 = new JTextArea("Life Points: " + mPlayers.get(0).getHealthPoints());
			lp1.setEditable(false);
			lp1.setBounds(1350, 300, 100, 25);
			lp1.setBorder(BorderFactory.createCompoundBorder(raisedbevel, loweredbevel));
			layerPane.add(lp1);
			
			vp2 = new JTextArea("Victory Points: " + mPlayers.get(1).getVictoryPoints());
			vp2.setEditable(false);
			vp2.setBounds(1475, 300, 100, 25);
			vp2.setBorder(BorderFactory.createCompoundBorder(raisedbevel, loweredbevel));
			layerPane.add(vp2);

			lp2 = new JTextArea("Life Points: " + mPlayers.get(1).getHealthPoints());
			lp2.setEditable(false);
			lp2.setBounds(1675, 300, 100, 25);
			lp2.setBorder(BorderFactory.createCompoundBorder(raisedbevel, loweredbevel));
			layerPane.add(lp2);
			
			vp3 = new JTextArea("Victory Points: " + mPlayers.get(2).getVictoryPoints());
			vp3.setEditable(false);
			vp3.setBounds(1150, 625, 100, 25);
			vp3.setBorder(BorderFactory.createCompoundBorder(raisedbevel, loweredbevel));
			layerPane.add(vp3);

			lp3 = new JTextArea("Life Points: " + mPlayers.get(2).getHealthPoints());
			lp3.setEditable(false);
			lp3.setBounds(1350, 625, 100, 25);
			lp3.setBorder(BorderFactory.createCompoundBorder(raisedbevel, loweredbevel));
			layerPane.add(lp3);
			
			vp4 = new JTextArea("Victory Points: " + mPlayers.get(3).getVictoryPoints());
			vp4.setEditable(false);
			vp4.setBounds(1475, 625, 100, 25);
			vp4.setBorder(BorderFactory.createCompoundBorder(raisedbevel, loweredbevel));
			layerPane.add(vp4);

			lp4 = new JTextArea("Life Points: " + mPlayers.get(3).getHealthPoints());
			lp4.setEditable(false);
			lp4.setBounds(1675, 625, 100, 25);
			lp4.setBorder(BorderFactory.createCompoundBorder(raisedbevel, loweredbevel));
			layerPane.add(lp4);
			
			vp5 = new JTextArea("Victory Points: " + mPlayers.get(4).getVictoryPoints());
			vp5.setEditable(false);
			vp5.setBounds(1150, 950, 100, 25);
			vp5.setBorder(BorderFactory.createCompoundBorder(raisedbevel, loweredbevel));
			layerPane.add(vp5);

			lp5 = new JTextArea("Life Points: " + mPlayers.get(4).getHealthPoints());
			lp5.setEditable(false);
			lp5.setBounds(1350, 950, 100, 25);
			lp5.setBorder(BorderFactory.createCompoundBorder(raisedbevel, loweredbevel));
			layerPane.add(lp5);
			
			vp6 = new JTextArea("Victory Points: " + mPlayers.get(5).getVictoryPoints());
			vp6.setEditable(false);
			vp6.setBounds(1475, 950, 100, 25);
			vp6.setBorder(BorderFactory.createCompoundBorder(raisedbevel, loweredbevel));
			layerPane.add(vp6);

			lp6 = new JTextArea("Life Points: " + mPlayers.get(5).getHealthPoints());
			lp6.setEditable(false);
			lp6.setBounds(1675, 950, 100, 25);
			lp6.setBorder(BorderFactory.createCompoundBorder(raisedbevel, loweredbevel));
			layerPane.add(lp6);
		}
	}
}
