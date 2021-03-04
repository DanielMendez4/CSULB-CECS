package week4;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JFrameDemo {

	public static void main(String[] args) {
		
		JFrame frame = new JFrame(); // Instantiating a frame
		
		// Created components
		JLabel text = new JLabel("Click a button: ");
		JButton button1 = new JButton("Button 1");
		// Drop down menu
		String[] options = {"Option 1", "Option 2", "Option 3"};
		JComboBox<String> dropDownMenu = new JComboBox<String>(options);
		
		// Creating a panel to hold components
		JPanel panel = new JPanel();
		
		// Adding components to the panel
		panel.add(text);
		panel.add(button1);
		panel.add(dropDownMenu);
		
		// Add panel to frame
		frame.add(panel);
		
		// Adding to the frame
		// frame.add(text);
		// frame.add(button1);
		
		frame.setTitle("New Frame");
		frame.setSize(500, 500);
		frame.setVisible(true); // Making it visible on program run
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Terminates the program when the window is closed
	}
}