package exam2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FilledFrame extends JFrame {
	
	private static final int FRAME_WIDTH = 300;
	private static final int FRAME_HEIGHT = 200;
	private JButton button1;
	private JButton button2;
	private JLabel text;
	private JPanel panel;
	
	public FilledFrame() {
		
		button1 = new JButton("Hello");
		text = new JLabel("");
		button2 = new JButton("Good bye");
		panel = new JPanel();
		ClickListener listener = new ClickListener();
		panel.add(button1);
		panel.add(text);
		panel.add(button2);
		button1.addActionListener(listener);
		button2.addActionListener(listener);
		this.add(panel);
	}
	
	class ClickListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent event) {
			
			if (event.getSource() == button1) {
				text.setText("Saved!");
				panel.revalidate();
				panel.repaint();
			}
			else if (event.getSource() == button2) {
				text.setText("Cancelled");
				panel.revalidate();
				panel.repaint();
			}
		}
	}
	
	public static void main(String[] a) {
		FilledFrame frame = new FilledFrame();
		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		frame.setVisible(true);
	}
}