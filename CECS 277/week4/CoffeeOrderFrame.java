package week4;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class CoffeeOrderFrame extends JFrame {
	
	private JLabel instructions;
	private JComboBox<String> sizeOptions;
	private JComboBox<String> sugarTsp;
	private JComboBox<String> baseOptions;
	private JButton save;
	
	public CoffeeOrderFrame() {
		// Create the components
		createComponents();
		
		// Set frame propertites
		this.setTitle("New Coffee Order");
		this.setSize(800, 400);
		// HIdes the frame on close without terminating the program
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	}
	
	private void createComponents() {
		// Instantiates the components
		instructions = new JLabel("Specify your order: ");
		
		String[] sizes = {"S", "M", "L"};
		sizeOptions = new JComboBox<String>(sizes);
		
		String[] tsp = {"1", "2", "3", "4", "5"};
		sugarTsp = new JComboBox<String>(tsp);
		
		String[] bases = {"water", "whole milk", "almond milk"};
		baseOptions = new JComboBox<String>(bases);
		
		save = new JButton("Save Order");
		
		// Creating the event listener object
		ActionListener saveListener = new SaveButtonListener();
		// Using the listener object to define button reaction
		save.addActionListener(saveListener);
		
		// Create panel and add components
		JPanel panel = new JPanel();
		panel.add(instructions);
		panel.add(new JLabel("Size: "));
		panel.add(sizeOptions);
		panel.add(new JLabel("Sugar: "));
		panel.add(sugarTsp);
		panel.add(new JLabel("Milk: "));
		panel.add(baseOptions);
		panel.add(save);
		
		// Add panel to frame
		this.add(panel);
	}
	
	// INNER EVENT LISTENER CLASS FOR SAVE BUTTON
	class SaveButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent click) {
			// Getting access to the button that generated the click
			Component button = (Component) click.getSource();
			
			// Getting access to the frame in which the button is found
			JFrame frame = (JFrame) SwingUtilities.getRoot(button);
			
			frame.setVisible(false); // Close this frame
		}
	}
	
	public static void main(String[] args) {
		
		CoffeeOrderFrame c = new CoffeeOrderFrame();
		c.setVisible(true); // Set it to be visible
	}
}