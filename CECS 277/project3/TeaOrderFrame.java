package project3;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 * Models a tea order frame
 * @author Daniel Mendez
 * @version 1.0.0
 * @since 2019-03-19
 * **/

public class TeaOrderFrame extends JFrame {
	
	private JLabel prompt;
	private JComboBox<String> flavorOptions;
	private JComboBox<String> sizeOptions;
	private JComboBox<String> sweetOptions;
	private JComboBox<String> milkOptions;
	private JCheckBox top1;
	private JCheckBox top2;
	private JCheckBox top3;
	private JCheckBox top4;
	private JCheckBox top5;
	private JCheckBox top6;
	private JButton save;
	private JButton cancel;
	
	/**
	 * Default constructor
	 * **/
	public TeaOrderFrame() {
		
		createComponents();
		this.setTitle("New Tea Order");
		this.setSize(850, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	/**
	 * Creates the components in the JPanel
	 * **/
	private void createComponents() {
		
		prompt = new JLabel("Specify the tea order: ");
		
		String[] flavors = {"Green Tea", "Black Tea", "Jasmine Green Tea", "Rose Tea", "Oolong Tea"};
		flavorOptions = new JComboBox<String>(flavors);
		
		String[] sizes = {"S", "M", "L"};
		sizeOptions = new JComboBox<String>(sizes);
		
		String[] sweetness = {"Full", "3/4 Sweet", "1/2 Sweet", "1/4 Sweet", "Unsweetened"};
		sweetOptions = new JComboBox<String>(sweetness);
		
		String[] milk = {"Whole Milk", "Half-and-Half", "No Milk"};
		milkOptions = new JComboBox<String>(milk);
		
		save = new JButton("Save");
		ActionListener saveListener = new ButtonListener();
		save.addActionListener(saveListener);
		
		cancel = new JButton("Cancel");
		ActionListener cancelListener = new ButtonListener();
		cancel.addActionListener(cancelListener);
		
		top1 = new JCheckBox("Boba");
		top2 = new JCheckBox("Popping Boba");
		top3 = new JCheckBox("Grass Jelly");
		top4 = new JCheckBox("Lychee Jelly");
		top5 = new JCheckBox("Coconut Jelly");
		top6 = new JCheckBox("Mini Mochi");
		
		JPanel panel = new JPanel();
		panel.add(prompt);
		panel.add(flavorOptions);
		panel.add(new JLabel("Size: "));
		panel.add(sizeOptions);
		panel.add(new JLabel("Sweetness: "));
		panel.add(sweetOptions);
		panel.add(new JLabel("Milk: "));
		panel.add(milkOptions);
		panel.add(save);
		panel.add(cancel);
		panel.add(top1);
		panel.add(top2);
		panel.add(top3);
		panel.add(top4);
		panel.add(top5);
		panel.add(top6);
		this.add(panel);
	}
	
	/**
	 * Performs an acton depending on what button is pressed
	 * Pressing 'save' creates a new TeaItem, creates a new NewOrderFrame with updated item, and closes the current frame
	 * Pressing 'cancel' cancles the order, creates a new default NewOrderFrame, and closes the current frame
	 * **/
	class ButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent click) {
			
			if (click.getSource() == save) {
				TeaItem myTea = new TeaItem(sizeOptions.getSelectedItem().toString(), flavorOptions.getSelectedItem().toString(),
						sweetOptions.getSelectedItem().toString(), milkOptions.getSelectedItem().toString());
				if (top1.isSelected()) { myTea.addTopping("Boba"); }
				if (top2.isSelected()) { myTea.addTopping("Popping Boba"); }
				if (top3.isSelected()) { myTea.addTopping("Grass Jelly"); }
				if (top4.isSelected()) { myTea.addTopping("Lychee Jelly"); }
				if (top5.isSelected()) { myTea.addTopping("Coconut Jelly"); }
				if (top6.isSelected()) { myTea.addTopping("Mini Mochi"); }
				
				NewOrderFrame updateFrame = new NewOrderFrame(myTea);
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