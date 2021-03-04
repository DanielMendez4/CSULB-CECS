package project3;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/**
 * Models the final order
 * @author Daniel Mendez
 * @version 1.0.0
 * @since 2019-03-19
 * **/

public class FinalizeOrder extends JFrame {
	
	private JLabel prompt;
	private JTextArea textArea;
	private JPanel panel;
	private JScrollPane scrollPane;
	private double grandTotal;
	private double userPay = 0.00;
	
	private JLabel prompt2;
	private JTextField payment;
	private JButton pay;
	
	private JLabel notEnoughCash;
	private double leftover;
	
	private JButton exit;
	
	/**
	 * Overloaded constructor
	 * @param itemList - array list of the items on the receipt
	 * **/
	public FinalizeOrder(ArrayList<Item> itemList) {
		
		createComponents(itemList);
		this.setTitle("Finalize Order");
		this.setSize(600, 800);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	/**
	 * Creates the components of the JPanel
	 * @param itemList - array list of items on the receipt
	 * **/
	private void createComponents(ArrayList<Item> itemList) {
		
		double subtotal = 0.00;
		for (int i = 0; i < itemList.size(); i++) { subtotal = subtotal + itemList.get(i).calculateCost(); }
		String formatSubtotal = String.format("%.2f", subtotal);
		
		double tax = subtotal * .10;
		String formatTax = String.format("%.2f", tax);
		
		grandTotal = subtotal + tax;
		String formatGrandTotal = String.format("%.2f", grandTotal);
		
		panel = new JPanel();
		
		prompt = new JLabel("Amount Due: $" + formatGrandTotal);
		panel.add(prompt);
		
		textArea = new JTextArea(30, 50);
		textArea.setEditable(false);
		panel.add(textArea);
		textArea.append("                              ------------------------------Current Order------------------------------\n\n");
		for (int i = 0; i < itemList.size(); i++) { textArea.append("- " + itemList.get(i).toString() + "\n"); }
		
		textArea.append("Subtotal:\t$" + formatSubtotal + "\n");
		textArea.append("Tax:\t$" + formatTax + "\n");
		textArea.append("Grandtotal:\t$" + formatGrandTotal + "\n");
		scrollPane = new JScrollPane(textArea);
		panel.add(scrollPane);
		
		prompt2 = new JLabel("Payment: $");
		payment = new JTextField("Pay Here...");
		pay = new JButton("Pay");
		pay.addActionListener(new PayButtonListener());
		
		panel.add(prompt2);
		panel.add(payment);
		panel.add(pay);
		this.add(panel);
	}
	
	/**
	 * Performs an action depending on what button is pressed
	 * Pressing 'pay' gets value from the textfield
	 * Calculates how much more the user needs to pay OR how much change the user will receive
	 * **/
	class PayButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent click) {
			
			if (notEnoughCash != null) {
				panel.remove(notEnoughCash);
				panel.repaint();
			}
			
			userPay = userPay + Double.parseDouble(payment.getText().trim());
			
			leftover = grandTotal - userPay;
			String formatLeftover = String.format("%.2f", leftover);
			
			if (leftover > 0) {
				notEnoughCash = new JLabel("Insufficient payment! Amount still due: $" + formatLeftover);
				panel.add(notEnoughCash);
				panel.revalidate();
				panel.repaint();
			} 
			else if (leftover <= 0) {
				String formatUserPay = String.format("%.2f", userPay);
				double change = Math.abs(leftover);
				String formatChange = String.format("%.2f", change);
				panel.remove(prompt2);
				panel.remove(payment);
				panel.remove(pay);
				textArea.append("\nPayment: $" + formatUserPay + "\n");
				textArea.append("Change: $" + formatChange + "\n");
				textArea.append("                              ------------------------------THANK YOU------------------------------");
				
				exit = new JButton("Exit");
				ActionListener exitListener = new ExitButtonListener();
				exit.addActionListener(exitListener);
				panel.add(exit);
				
				panel.revalidate();
				panel.repaint();
			}
		}
	}
	
	/**
	 * Performs an action depending on what button is pressed
	 * Pressing 'exit' terminates the program
	 * **/
	class ExitButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent click) {
			Component button = (Component) click.getSource();
			JFrame frame = (JFrame) SwingUtilities.getRoot(button);
			frame.setVisible(false);
		}
	}
}