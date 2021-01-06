/*  CharacterPanel.java
	D. Mendez, R. John, K. Cruz
	CECS 343
	Due 03 Dec 2019
	Title: Character Panel class
	Description: displays the GUI for Character Selection
*/

package kingOfTokyo;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

public class CharacterPanel extends JFrame {
	
	/**
	 * Instance Variables
	 */
	JMenuBar menuBar;
	JScrollPane scrollPane;
	JPanel centerPanel;
	
	private JLabel prompt1;
	private JLabel prompt2;
	private JLabel prompt3;
	private JLabel prompt4;
	private JLabel prompt5;
	private JLabel prompt6;

	private JComboBox<String> player1;
	private JComboBox<String> player2;
	private JComboBox<String> player3;
	private JComboBox<String> player4;
	private JComboBox<String> player5;
	private JComboBox<String> player6;

	private String[] charOptions = new String[] {"The King", "Meka Dragon", "Cyber Bunny", "Alienoid", "Gigazaur", "Kraken", "Pandakai"};
	
	private JButton saveAndContinue;
	
	private Monsters P1 = new Monsters();
	private Monsters P2 = new Monsters();
	private Monsters P3 = new Monsters();
	private Monsters P4 = new Monsters();
	private Monsters P5 = new Monsters();
	private Monsters P6 = new Monsters();
	
	ArrayList<Monsters> players;
	
	/**
	 * Default Constructor
	 */
	public CharacterPanel() {
		this.setTitle("King of Tokyo");
		this.setSize(750,500);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.createMenuBar();
		centerPanel = new JPanel();
		this.createDefaultPanel();
		scrollPane = new JScrollPane(centerPanel);
		this.add(scrollPane, BorderLayout.CENTER);
		
		this.setVisible(true);
	}
	
	/**
	 * Creates the default panel
	 */
	private void createDefaultPanel() {
		centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
		JLabel panelTitle = new JLabel("King of Tokyo: Character Selection");
		panelTitle.setFont(new Font(Font.SERIF, Font.BOLD, 30));
		centerPanel.add(panelTitle);
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(0,2));
		prompt1 = new JLabel("Player 1: ");
		player1 = new JComboBox<String>(charOptions);
		prompt2 = new JLabel("Player 2: ");
		player2 = new JComboBox<String>(charOptions);
		panel.add(prompt1);
		panel.add(player1);
		panel.add(prompt2);
		panel.add(player2);
		centerPanel.add(panel);
		
		players = new ArrayList<Monsters>();
		players.add(P1);
		players.add(P2);
		
		saveAndContinue = new JButton("Save & Continue");
		ActionListener saveAndContinueListener = new CharMenuButtonListener();
		saveAndContinue.addActionListener(saveAndContinueListener);
		centerPanel.add(saveAndContinue);
	}
	
	/**
	 * Creates a panel for 3 players
	 */
	private void create3PlayerPanel() {
		centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
		JLabel panelTitle = new JLabel("King of Tokyo: Character Selection");
		panelTitle.setFont(new Font(Font.SERIF, Font.BOLD, 30));
		centerPanel.add(panelTitle);
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(0,2));
		prompt1 = new JLabel("Player 1: ");
		player1 = new JComboBox<String>(charOptions);
		prompt2 = new JLabel("Player 2: ");
		player2 = new JComboBox<String>(charOptions);
		prompt3 = new JLabel("Player 3: ");
		player3 = new JComboBox<String>(charOptions);
		panel.add(prompt1);
		panel.add(player1);
		panel.add(prompt2);
		panel.add(player2);
		panel.add(prompt3);
		panel.add(player3);
		centerPanel.add(panel);
		
		players = new ArrayList<Monsters>();
		players.add(P1);
		players.add(P2);
		players.add(P3);
		
		saveAndContinue = new JButton("Save & Continue");
		ActionListener saveAndContinueListener = new CharMenuButtonListener();
		saveAndContinue.addActionListener(saveAndContinueListener);
		centerPanel.add(saveAndContinue);
	}
	
	/**
	 * Creates a panel for 4 players
	 */
	private void create4PlayerPanel() {
		centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
		JLabel panelTitle = new JLabel("King of Tokyo: Character Selection");
		panelTitle.setFont(new Font(Font.SERIF, Font.BOLD, 30));
		centerPanel.add(panelTitle);
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(0,2));
		prompt1 = new JLabel("Player 1: ");
		player1 = new JComboBox<String>(charOptions);
		prompt2 = new JLabel("Player 2: ");
		player2 = new JComboBox<String>(charOptions);
		prompt3 = new JLabel("Player 3: ");
		player3 = new JComboBox<String>(charOptions);
		prompt4 = new JLabel("Player 4: ");
		player4 = new JComboBox<String>(charOptions);
		panel.add(prompt1);
		panel.add(player1);
		panel.add(prompt2);
		panel.add(player2);
		panel.add(prompt3);
		panel.add(player3);
		panel.add(prompt4);
		panel.add(player4);
		centerPanel.add(panel);
		
		players = new ArrayList<Monsters>();
		players.add(P1);
		players.add(P2);
		players.add(P3);
		players.add(P4);
		
		saveAndContinue = new JButton("Save & Continue");
		ActionListener saveAndContinueListener = new CharMenuButtonListener();
		saveAndContinue.addActionListener(saveAndContinueListener);
		centerPanel.add(saveAndContinue);
	}
	
	/**
	 * Creates a panel for 5 players
	 */
	private void create5PlayerPanel() {
		centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
		JLabel panelTitle = new JLabel("King of Tokyo: Character Selection");
		panelTitle.setFont(new Font(Font.SERIF, Font.BOLD, 30));
		centerPanel.add(panelTitle);
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(0,2));
		prompt1 = new JLabel("Player 1: ");
		player1 = new JComboBox<String>(charOptions);
		prompt2 = new JLabel("Player 2: ");
		player2 = new JComboBox<String>(charOptions);
		prompt3 = new JLabel("Player 3: ");
		player3 = new JComboBox<String>(charOptions);
		prompt4 = new JLabel("Player 4: ");
		player4 = new JComboBox<String>(charOptions);
		prompt5 = new JLabel("Player 5: ");
		player5 = new JComboBox<String>(charOptions);
		panel.add(prompt1);
		panel.add(player1);
		panel.add(prompt2);
		panel.add(player2);
		panel.add(prompt3);
		panel.add(player3);
		panel.add(prompt4);
		panel.add(player4);
		panel.add(prompt5);
		panel.add(player5);
		centerPanel.add(panel);
		
		players = new ArrayList<Monsters>();
		players.add(P1);
		players.add(P2);
		players.add(P3);
		players.add(P4);
		players.add(P5);
		
		saveAndContinue = new JButton("Save & Continue");
		ActionListener saveAndContinueListener = new CharMenuButtonListener();
		saveAndContinue.addActionListener(saveAndContinueListener);
		centerPanel.add(saveAndContinue);
	}
	
	/**
	 * Creates a panel for 6 players
	 */
	private void create6PlayerPanel() {
		centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
		JLabel panelTitle = new JLabel("King of Tokyo: Character Selection");
		panelTitle.setFont(new Font(Font.SERIF, Font.BOLD, 30));
		centerPanel.add(panelTitle);
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(0,2));
		prompt1 = new JLabel("Player 1: ");
		player1 = new JComboBox<String>(charOptions);
		prompt2 = new JLabel("Player 2: ");
		player2 = new JComboBox<String>(charOptions);
		prompt3 = new JLabel("Player 3: ");
		player3 = new JComboBox<String>(charOptions);
		prompt4 = new JLabel("Player 4: ");
		player4 = new JComboBox<String>(charOptions);
		prompt5 = new JLabel("Player 5: ");
		player5 = new JComboBox<String>(charOptions);
		prompt6 = new JLabel("Player 6: ");
		player6 = new JComboBox<String>(charOptions);
		panel.add(prompt1);
		panel.add(player1);
		panel.add(prompt2);
		panel.add(player2);
		panel.add(prompt3);
		panel.add(player3);
		panel.add(prompt4);
		panel.add(player4);
		panel.add(prompt5);
		panel.add(player5);
		panel.add(prompt6);
		panel.add(player6);
		centerPanel.add(panel);
		
		players = new ArrayList<Monsters>();
		players.add(P1);
		players.add(P2);
		players.add(P3);
		players.add(P4);
		players.add(P5);
		players.add(P6);
		
		saveAndContinue = new JButton("Save & Continue");
		ActionListener saveAndContinueListener = new CharMenuButtonListener();
		saveAndContinue.addActionListener(saveAndContinueListener);
		centerPanel.add(saveAndContinue);
	}
	
	/**
	 * Creates a menu bar used to select the number of players
	 */
	private void createMenuBar() {
		menuBar = new JMenuBar();
		
		JMenu menu;
		JMenuItem menuItem;
		
		menu = new JMenu("# of Players");
		
		menuItem = new JMenuItem("2");
		menuItem.addActionListener(new NumPlayerListener());
		menu.add(menuItem);
		
		menuItem = new JMenuItem("3");
		menuItem.addActionListener(new NumPlayerListener());
		menu.add(menuItem);

		menuItem = new JMenuItem("4");
		menuItem.addActionListener(new NumPlayerListener());
		menu.add(menuItem);
		
		menuItem = new JMenuItem("5");
		menuItem.addActionListener(new NumPlayerListener());
		menu.add(menuItem);
		
		menuItem = new JMenuItem("6");
		menuItem.addActionListener(new NumPlayerListener());
		menu.add(menuItem);
		
		menuBar.add(menu);
		this.add(menuBar, BorderLayout.NORTH);
	}
	
	/**
	 * Allows for the menu bar selections to trigger an event
	 */
	class NumPlayerListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent click) {
			JMenuItem menuItem = (JMenuItem) click.getSource();
			String item = menuItem.getText();
			if (item.equals("2")) {
				centerPanel.removeAll();
				createDefaultPanel();
				centerPanel.revalidate();
				centerPanel.repaint();
			}
			else if (item.equals("3")) {
				centerPanel.removeAll();
				create3PlayerPanel();
				centerPanel.revalidate();
				centerPanel.repaint();
			}
			else if (item.equals("4")) {
				centerPanel.removeAll();
				create4PlayerPanel();
				centerPanel.revalidate();
				centerPanel.repaint();
			}
			else if (item.equals("5")) {
				centerPanel.removeAll();
				create5PlayerPanel();
				centerPanel.revalidate();
				centerPanel.repaint();
			}
			else if (item.equals("6")) {
				centerPanel.removeAll();
				create6PlayerPanel();
				centerPanel.revalidate();
				centerPanel.repaint();
			}
		}
	}
	
	/**
	 * Allows for buttons on the panel to trigger an event
	 */
	class CharMenuButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent click) {
			Component button = (Component) click.getSource();
			JFrame frame = (JFrame) SwingUtilities.getRoot(button);
			
			if (click.getSource() == saveAndContinue) {
				
				if (players.size() == 2) {
					P1.setMonsterName(player1.getSelectedItem().toString());
					P2.setMonsterName(player2.getSelectedItem().toString());
				}
				else if (players.size() == 3) {
					P1.setMonsterName(player1.getSelectedItem().toString());
					P2.setMonsterName(player2.getSelectedItem().toString());
					P3.setMonsterName(player3.getSelectedItem().toString());
				}
				else if (players.size() == 4) {
					P1.setMonsterName(player1.getSelectedItem().toString());
					P2.setMonsterName(player2.getSelectedItem().toString());
					P3.setMonsterName(player3.getSelectedItem().toString());
					P4.setMonsterName(player4.getSelectedItem().toString());
				}
				else if (players.size() == 5) {
					P1.setMonsterName(player1.getSelectedItem().toString());
					P2.setMonsterName(player2.getSelectedItem().toString());
					P3.setMonsterName(player3.getSelectedItem().toString());
					P4.setMonsterName(player4.getSelectedItem().toString());
					P5.setMonsterName(player5.getSelectedItem().toString());	
				}
				else if (players.size() == 6) {
					P1.setMonsterName(player1.getSelectedItem().toString());
					P2.setMonsterName(player2.getSelectedItem().toString());
					P3.setMonsterName(player3.getSelectedItem().toString());
					P4.setMonsterName(player4.getSelectedItem().toString());
					P5.setMonsterName(player5.getSelectedItem().toString());
					P6.setMonsterName(player6.getSelectedItem().toString());
				}
				
				GameBoardPanel gbp = new GameBoardPanel(players);
				frame.setVisible(false);
			}
		}
	}
}