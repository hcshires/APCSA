import java.awt.event.ActionEvent;
import javax.swing.*;

public class Gui {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Welcome to AP CSA!");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close
		frame.setSize(500, 500);
		
		JButton button = new JButton("Click Me!");
		
		button.setBounds(0, 0, 0, 0);
		
		frame.getContentPane().add(button); // Add button to GUI
		frame.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		
	}

}
