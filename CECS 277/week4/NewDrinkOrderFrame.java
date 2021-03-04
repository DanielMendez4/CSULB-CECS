package week4;

import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class NewDrinkOrderFrame extends JFrame {
	
	private JLabel instructions;
	private JButton coffeeButton;
	private JButton bobaButton;
	
	public NewDrinkOrderFrame() {
		// Call private helper method to create and add the components
		createComponents();
		// Set the frame properties
		this.setTitle("New Drink Order");
		this.setSize(500, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void createComponents() {
		// Instantiate the components
		instructions = new JLabel("Select your drink type: ");
		coffeeButton = new JButton("Coffee");
		
		// Adding reaction to coffee button
		ActionListener coffeeListener = new CoffeeButtonListener();
		coffeeButton.addActionListener(coffeeListener);
		
		bobaButton = new JButton("Boba");
		
		// Create the panel and add the coponents
		JPanel panel = new JPanel();
		panel.add(instructions);
		panel.add(coffeeButton);
		panel.add(bobaButton);
		
		// Add panel to this frame
		this.add(panel);
	}
	
	// INNER ACTION LISTENER CLASS i.e. EVENT LISTENER
	
	class CoffeeButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent click) {
			// Open a new coffee order frame
			CoffeeOrderFrame c = new CoffeeOrderFrame();
			c.setVisible(true);
			
		}
		
	}
	
	public static void main(String[] args) {
		
		NewDrinkOrderFrame n = new NewDrinkOrderFrame();
		n.setVisible(true); // Makes the frame visible
	}

}
