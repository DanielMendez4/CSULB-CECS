package project3;

import javax.swing.JFrame;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

/**
 * Models a new order frame
 * @author Daniel Mendez
 * @version 1.0.0
 * @since 2019-03-19
 * **/

public class NewOrderFrame extends JFrame {
	
	private JLabel instructions;
	private JButton coffeeButton;
	private JButton teaButton;
	private JButton pastryButton;
	private JButton done;
	private JButton exit;
	private JPanel panel;
	private JTextArea textArea;
	private JScrollPane scrollPane;
	private static ArrayList<Item> allItems = new ArrayList<Item>();
	
	/**
	 * Default constructor
	 * **/
	public NewOrderFrame() {
		
		createComponents();
		this.setTitle("New Order");
		this.setSize(600, 800);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	/**
	 * Overloaded constructor
	 * @param newItem - item to be added to the receipt
	 * **/
	public NewOrderFrame(Item newItem) {
		
		allItems.add(newItem);
		createComponents();
		this.setTitle("New Order");
		this.setSize(600, 800);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	/**
	 * Creates the components of the JPanel
	 * **/
	private void createComponents() {
		
		instructions = new JLabel("Select an item to purchase:");
		
		coffeeButton = new JButton("Coffee");
		ActionListener coffeeListener = new CoffeeButtonListener();
		coffeeButton.addActionListener(coffeeListener);
		
		teaButton = new JButton("Tea");
		ActionListener teaListener = new TeaButtonListener();
		teaButton.addActionListener(teaListener);
		
		pastryButton = new JButton("Pastry");
		ActionListener pastryListener = new PastryButtonListener();
		pastryButton.addActionListener(pastryListener);
		
		panel = new JPanel();
		
		if (allItems.isEmpty()) {
			panel.add(instructions);
			panel.add(coffeeButton);
			panel.add(teaButton);
			panel.add(pastryButton);
			exit = new JButton("Exit");
			ActionListener exitListener = new ExitButtonListener();
			exit.addActionListener(exitListener);
			panel.add(exit);
			this.add(panel);
		}
		else {
			panel.removeAll();
			panel.add(instructions);
			panel.add(coffeeButton);
			panel.add(teaButton);
			panel.add(pastryButton);
			done = new JButton("Done");
			panel.add(done);
			ActionListener doneListener = new DoneButtonListener();
			done.addActionListener(doneListener);
			
			textArea = new JTextArea(30, 50);
			textArea.setEditable(false);
			panel.add(textArea);
			textArea.append("                              ------------------------------Current Order------------------------------\n\n");
			for (int i = 0; i < allItems.size(); i++) { textArea.append("- " + allItems.get(i).toString() + "\n"); }
			
			double subtotal = 0.00;
			for (int i = 0; i < allItems.size(); i++) { subtotal = subtotal + allItems.get(i).calculateCost(); }
			String formatSubtotal = String.format("%.2f", subtotal);
			
			double tax = subtotal * .10;
			String formatTax = String.format("%.2f", tax);
			
			double grandTotal = subtotal + tax;
			String formatGrandTotal = String.format("%.2f", grandTotal);
			
			textArea.append("Subtotal:\t$" + formatSubtotal + "\n");
			textArea.append("Tax:\t$" + formatTax + "\n");
			textArea.append("Grand Total:\t$" + formatGrandTotal + "\n");
			panel.revalidate();
			panel.repaint();
			scrollPane = new JScrollPane(textArea);
			panel.add(scrollPane);
			this.add(panel);
		}
	}
	//------------------------------INNER ACTION LISTENER CLASS------------------------------
	
	/**
	 * Performs an acton depending on what button is pressed
	 * Pressing 'coffee' will open a CoffeeOrderFrame and close the current frame
	 * **/
	class CoffeeButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent click) {
			CoffeeOrderFrame c = new CoffeeOrderFrame();
			c.setVisible(true);
			Component button = (Component) click.getSource();
			JFrame frame = (JFrame) SwingUtilities.getRoot(button);
			frame.setVisible(false);
		}
	}
	
	/**
	 * Performs an acton depending on what button is pressed
	 * Pressing 'tea' will open a TeaOrderFrame and close the current frame
	 * **/
	class TeaButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent click) {
			TeaOrderFrame t = new TeaOrderFrame();
			t.setVisible(true);
			Component button = (Component) click.getSource();
			JFrame frame = (JFrame) SwingUtilities.getRoot(button);
			frame.setVisible(false);
		}
	}
	
	/**
	 * Performs an acton depending on what button is pressed
	 * Pressing 'pastry' will open a PastryOrderFrame and close the current frame
	 * **/
	class PastryButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent click) {
			PastryOrderFrame p = new PastryOrderFrame();
			p.setVisible(true);
			Component button = (Component) click.getSource();
			JFrame frame = (JFrame) SwingUtilities.getRoot(button);
			frame.setVisible(false);
		}
	}
	
	/**
	 * Performs an acton depending on what button is pressed
	 * Pressing 'done' will open a FinalOrder and close the current window
	 * **/
	class DoneButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent click) {
			if (click.getSource() == done) {
				FinalizeOrder finalFrame = new FinalizeOrder(allItems);
				finalFrame.setVisible(true);
			}
			Component button = (Component) click.getSource();
			JFrame frame = (JFrame) SwingUtilities.getRoot(button);	
			frame.setVisible(false);
		}
	}
	
	/**
	 * Performs an acton depending on what button is pressed
	 * Pressing 'exit' will close the current frame and terminate the program
	 * **/
	class ExitButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent click) {
			Component button = (Component) click.getSource();
			JFrame frame = (JFrame) SwingUtilities.getRoot(button);
			frame.setVisible(false);
		}
	}
	//---------------------------------------------------------------------------------------
	
	public static void main(String[] args) {
		
		NewOrderFrame n = new NewOrderFrame();
		n.setVisible(true);
	}
}