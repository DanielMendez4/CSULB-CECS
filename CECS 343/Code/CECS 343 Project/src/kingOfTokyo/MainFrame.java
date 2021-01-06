/*  MainFrame.java
	D. Mendez, R. John, K. Cruz
	CECS 343
	Due 03 Dec 2019
	Title: Main Frame class
	Description: shows the GUI for the Main Menu
*/

package kingOfTokyo;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;

public class MainFrame extends JFrame {
	
	/**
	 * Instance variables
	 */
	JScrollPane scrollPane;
	JPanel centerPanel;
	JLayeredPane layerPane;
	
	Border raisedbevel = BorderFactory.createRaisedBevelBorder();
	Border lowerdbevel = BorderFactory.createLoweredBevelBorder();
		
	private JButton play;
	private JButton exit;
	
	/**
	 * Default Constructor
	 */
	public MainFrame() {
		this.setTitle("King of Tokyo");
		this.setSize(827,873);
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
	 */
	private void createDefaultPanel() {
		centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
		
		JLabel imgLabel = new JLabel(new ImageIcon("C:\\Users\\Daniel\\Downloads\\KoTMainMenu.jpg"));
		imgLabel.setVerticalTextPosition(JLabel.TOP);
		imgLabel.setHorizontalTextPosition(JLabel.CENTER);
		
		centerPanel.add(imgLabel);

		play = new JButton("PLAY");
		play.setBounds(300, 440, 75, 50);
		ActionListener playListener = new MainMenuButtonListener();
		play.addActionListener(playListener);
		layerPane.add(play);
		
		exit = new JButton("EXIT");
		exit.setBounds(400, 440, 75, 50);
		ActionListener exitListener = new MainMenuButtonListener();
		exit.addActionListener(exitListener);
		layerPane.add(exit);
	}
	
	/**
	 * Allows for buttons on the panel to trigger an event
	 */
	class MainMenuButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent click) {
			Component button = (Component) click.getSource();
			JFrame frame = (JFrame) SwingUtilities.getRoot(button);
			
			if (click.getSource() == play) {
				CharacterPanel cp = new CharacterPanel();
				frame.setVisible(false);
			}
			if (click.getSource() == exit) {
				frame.setVisible(false);
			}
		}
	}
	
	//---------------------------------------------------------------------------------------------
	
	public static void main(String[] args) {
		MainFrame f = new MainFrame();
	}
}