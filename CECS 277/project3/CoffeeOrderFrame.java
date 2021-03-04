package project3;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/**
 * Models a coffee order frame
 * @author Daniel Mendez
 * @version 1.0.0
 * @since 2019-03-19
 * **/

public class CoffeeOrderFrame extends JFrame {
	
	private JLabel prompt;
	private JComboBox<String> flavorOptions;
	private JComboBox<String> sizeOptions;
	private JComboBox<String> sugarTsp;
	private JComboBox<String> milkOptions;
	private JComboBox<String> tempOptions;
	private JLabel prompt2;
	private JTextField specialInstructions;
	private JButton save;
	private JButton cancel;
	
	/**
	 * Default constructor
	 * **/
	public CoffeeOrderFrame() {
		
		createComponents();
		this.setTitle("New Coffee Order");
		this.setSize(800, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	/**
	 * Creates the components of the JPanel
	 * **/
	private void createComponents() {
		
		prompt = new JLabel("Specify the coffee order: ");
		
		String[] flavors = {"Regular", "Mocha", "Hazelnut", "Vanilla"};
		flavorOptions = new JComboBox<String>(flavors);
		
		String[] sizes = {"S", "M", "L"};
		sizeOptions = new JComboBox<String>(sizes);
		
		String[] tsp = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
		sugarTsp = new JComboBox<String>(tsp);
		
		String[] milk = {"Whole Milk", "Half-and-Half", "No Milk"};
		milkOptions = new JComboBox<String>(milk);
		
		String[] temps = {"Hot", "Iced", "Blended"};
		tempOptions = new JComboBox<String>(temps);
		
		prompt2 = new JLabel("Special Instructions: ");
		specialInstructions = new JTextField("Add instructions...");
		
		save = new JButton("Save");
		ActionListener saveListener = new ButtonListener();
		save.addActionListener(saveListener);
		
		cancel = new JButton("Cancel");
		ActionListener cancelListener = new ButtonListener();
		cancel.addActionListener(cancelListener);
		
		JPanel panel = new JPanel();
		panel.add(prompt);
		panel.add(new JLabel("Flavor: "));
		panel.add(flavorOptions);
		panel.add(new JLabel("Size: "));
		panel.add(sizeOptions);
		panel.add(new JLabel("Sugar: "));
		panel.add(sugarTsp);
		panel.add(new JLabel("Milk: "));
		panel.add(milkOptions);
		panel.add(new JLabel("Temperature: "));
		panel.add(tempOptions);
		panel.add(prompt2);
		panel.add(specialInstructions);
		panel.add(save);
		panel.add(cancel);
		this.add(panel);
	}
	
	/**
	 * Performs an acton depending on what button is pressed
	 * Pressing 'save' creates a new CoffeeItem, creates a new NewOrderFrame with updated item, and closes the current frame
	 * Pressing 'cancel' cancles the order, creates a new default NewOrderFrame, and closes the current frame
	 * **/
	class ButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent click) {
			
			if (click.getSource() == save) {
				CoffeeItem myCoffee = new CoffeeItem(sizeOptions.getSelectedItem().toString(), flavorOptions.getSelectedItem().toString(), sugarTsp.getSelectedItem().toString(),
						milkOptions.getSelectedItem().toString(), tempOptions.getSelectedItem().toString(), specialInstructions.getText());
				
				NewOrderFrame updateFrame = new NewOrderFrame(myCoffee);
				updateFrame.setVisible(true);
			}
			if (click.getSource() == cancel) {
				NewOrderFrame defaultFrame = new NewOrderFrame();
				defaultFrame.setVisible(true);
			}
			Component button = (Component) click.getSource();
			JFrame frame = (JFrame) SwingUtilities.getRoot(button);	
			frame.setVisible(false);
		}
	}
}