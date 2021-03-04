package project3;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 * Models a pastry order frame
 * @author Daniel Mendez
 * @version 1.0.0
 * @since 2019-03-19
 * **/

public class PastryOrderFrame extends JFrame {
	
	private JComboBox<String> pastryOptions;
	private JComboBox<String> muffinFlavor;
	private JComboBox<String> cheesecakeFlavor;
	private JComboBox<String> cookieFlavor;
	private JComboBox<String> danishFlavor;
	private JCheckBox heating;
	private JButton save;
	private JButton cancel;
	private JPanel panel;
	
	/**
	 * Default constructor
	 * **/
	public PastryOrderFrame() {
		
		createComponents();
		this.setTitle("New Pastry Order");
		this.setSize(800, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	/**
	 * Creates the components of the JPanel
	 * **/
	private void createComponents() {
		
		String[] pastries = {"Muffin", "Cheesecake Slice", "Cookie", "Danish"};
		pastryOptions = new JComboBox<String>(pastries);
		ActionListener comboBoxListener = new ComboBoxListener();
		pastryOptions.addActionListener(comboBoxListener);
		
		String[] muffins = {"Banana Nut", "Blueberry", "Chocolate Chip", "Coffee Cake"};
		muffinFlavor = new JComboBox<String>(muffins);
		
		String[] cheesecakeSlices = {"Regular", "Cherry", "Blueberry"};
		cheesecakeFlavor = new JComboBox<String>(cheesecakeSlices);
		
		String[] cookies = {"Oatmeal", "White Choco & Macadamias", "Chocolate Chip", "Double Fudge"};
		cookieFlavor = new JComboBox<String>(cookies);
		
		String[] danishes = {"Apple Cinnamon", "Strawberry & Cheese", "Double Cheese"};
		danishFlavor = new JComboBox<String>(danishes);
		
		heating = new JCheckBox("Heated");
		
		save = new JButton("Save");
		ActionListener saveListener = new ButtonListener();
		save.addActionListener(saveListener);
		
		cancel = new JButton("Cancel");
		ActionListener cancelListener = new ButtonListener();
		cancel.addActionListener(cancelListener);
		
		panel = new JPanel();
		panel.add(pastryOptions);
		panel.add(cancel);
		this.add(panel);
	}
	
	/**
	 * Performs an acton depending on what button is pressed
	 * Pressing 'save' creates a new PastryItem, creates a new NewOrderFrame with updated item, and closes the current frame
	 * Pressing 'cancel' cancles the order, creates a new default NewOrderFrame, and closes the current frame
	 * **/
	class ButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent click) {
			
			if (click.getSource() == save) {
				
				String selectPastry = (String) pastryOptions.getSelectedItem();
				
				if (selectPastry.equals("Muffin")) {
					PastryItem myPastry = new PastryItem(pastryOptions.getSelectedItem().toString(), muffinFlavor.getSelectedItem().toString(), heating.isSelected());
					NewOrderFrame updateFrame = new NewOrderFrame(myPastry);
					updateFrame.setVisible(true);
				}
				else if (selectPastry.equals("Cheesecake Slice")) {
					PastryItem myPastry = new PastryItem(pastryOptions.getSelectedItem().toString(), cheesecakeFlavor.getSelectedItem().toString(), heating.isSelected());
					NewOrderFrame updateFrame = new NewOrderFrame(myPastry);
					updateFrame.setVisible(true);
				}
				else if (selectPastry.equals("Cookie")) {
					PastryItem myPastry = new PastryItem(pastryOptions.getSelectedItem().toString(), cookieFlavor.getSelectedItem().toString(), heating.isSelected());
					NewOrderFrame updateFrame = new NewOrderFrame(myPastry);
					updateFrame.setVisible(true);
				}
				else if (selectPastry.equals("Danish")) {
					PastryItem myPastry = new PastryItem(pastryOptions.getSelectedItem().toString(), danishFlavor.getSelectedItem().toString(), heating.isSelected());
					NewOrderFrame updateFrame = new NewOrderFrame(myPastry);
					updateFrame.setVisible(true);
				}
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
	
	/**
	 * Performs an acton depending on what combo box is selected
	 * Selecting a different option from the PastryOptions combo box updates the frame to match current pastry's flavors
	 * **/
	class ComboBoxListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent select) {
			
			String selectPastry = (String) pastryOptions.getSelectedItem();
			
			if (selectPastry.equals("Muffin")) {
				panel.removeAll();
				panel.add(pastryOptions);
				ActionListener comboBoxListener = new ComboBoxListener();
				pastryOptions.addActionListener(comboBoxListener);
				panel.add(muffinFlavor);
				panel.add(heating);
				panel.add(save);
				panel.add(cancel);
				panel.revalidate();
				panel.repaint();
			}
			else if (selectPastry.equals("Cheesecake Slice")) {
				panel.removeAll();
				panel.add(pastryOptions);
				ActionListener comboBoxListener = new ComboBoxListener();
				pastryOptions.addActionListener(comboBoxListener);
				panel.add(cheesecakeFlavor);
				panel.add(heating);
				panel.add(save);
				panel.add(cancel);
				panel.revalidate();
				panel.repaint();

			}
			else if (selectPastry.equals("Cookie")) {
				panel.removeAll();
				panel.add(pastryOptions);
				ActionListener comboBoxListener = new ComboBoxListener();
				pastryOptions.addActionListener(comboBoxListener);
				panel.add(cookieFlavor);
				panel.add(heating);
				panel.add(save);
				panel.add(cancel);
				panel.revalidate();
				panel.repaint();
			}
			else if (selectPastry.equals("Danish")) {
				panel.removeAll();
				panel.add(pastryOptions);
				ActionListener comboBoxListener = new ComboBoxListener();
				pastryOptions.addActionListener(comboBoxListener);
				panel.add(danishFlavor);
				panel.add(heating);
				panel.add(save);
				panel.add(cancel);
				panel.revalidate();
				panel.repaint();
			}
		}
	}
}