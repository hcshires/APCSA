import javax.swing.*;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;

public class CrosswordRunner extends JPanel {
	private static final int RECT_X = 5; // X coord
	private static final int RECT_Y = 5; // Y coord
	private static final int RECT_WIDTH = 20;
	private static final int RECT_HEIGHT = RECT_WIDTH; // a square

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		boolean[][] blacksquares = { 
				{ true, false, false, true, true, true, false, false, false },
				{ false, false, false, false, true, false, false, false, false },
				{ false, false, false, false, false, false, true, true, true },
				{ false, false, true, false, false, false, true, false, false },
				{ true, true, true, false, false, false, false, false, false },
				{ false, false, false, false, true, false, false, false, false },
				{ false, false, false, true, true, true, false, false, true } 
				}; // all the squares that are black (true) and white (false)

		Crossword cw = new Crossword(blacksquares);
		
		// System.out.println(cw);
		
		/* Run the GUI */
		SwingUtilities.invokeLater(new Runnable() {
	         public void run() {
	            onCreate();
	         }
	      });
	}
	
	/** Draws components specified here
	 * @param g - Graphics for use in super
	 */
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		// draw rectangle
		g.setColor(Color.BLACK);
		// g.drawRect(RECT_X, RECT_Y, RECT_WIDTH, RECT_HEIGHT);
		g.fillRect(RECT_X, RECT_Y, RECT_WIDTH, RECT_HEIGHT);
		g.drawRect(RECT_X + 50, RECT_Y, RECT_WIDTH, RECT_HEIGHT);
	}
	
	@Override
	public Dimension getPreferredSize() {
		// Size the window effectively
		return new Dimension(RECT_WIDTH + 2 * RECT_X, RECT_HEIGHT + 2 * RECT_Y);
	}
	
	private static void onCreate() {
		CrosswordRunner main = new CrosswordRunner();
		
		/* Set properties of our JFrame */
		JFrame frame = new JFrame("Crossword Puzzle");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(main); // Rectangle
		frame.pack();
		frame.setLocationByPlatform(true);
		frame.setVisible(true);
		
	}

}
