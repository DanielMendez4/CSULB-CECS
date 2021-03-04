package week6;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BalanceFrame extends JFrame {
	
	private JLabel label;
	private JButton button;
	private double balance;
	private JPanel panel;
	private JTextField textfield;
	private JLabel errorMsg;
	
	private static final double principal = 100;
	
	public BalanceFrame() {
		balance = principal;
		createComponents();
		this.setTitle("Balance");
		
	}
	
	private void createComponents() {
		
		textfield = new JTextField("interest rate");
		label = new JLabel(String.format("Current Balance $%.2f", balance));
		
		button = new JButton("add interest");
		button.addActionListener(new ButtonListener());
		
		panel = new JPanel();
		panel.add(textfield);
		panel.add(button);
		panel.add(label);
		this.add(panel);
	}
	
	class ButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent click) {
			
			if (errorMsg != null) {
				panel.remove(errorMsg);
				panel.repaint(); // If component removed, must call repaint to see changes
			}
			
			try {
				double interestRate = Double.parseDouble(textfield.getText().trim());
				
				balance += balance * interestRate;
				
				label.setText(String.format("Current Balance $%.2f", balance));
			}
			catch (NumberFormatException e) {
				// Print a label with error message
				errorMsg = new JLabel("Invalid! Please enter a numeric value.");
				panel.add(errorMsg); // Any time
				panel.revalidate();
			}
		}
	}
	
	public static void main(String[] args) {
		BalanceFrame b = new BalanceFrame();

		b.setSize(400, 400);
		b.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		b.setVisible(true);
	}
}
