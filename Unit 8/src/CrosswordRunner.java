import javax.swing.*;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;

public class CrosswordRunner extends JPanel {
	private static final int RECT_X = 5; // X coord
	private static final int RECT_Y = 5; // Y coord
	private static final int RECT_WIDTH = 40;
	private static final int RECT_HEIGHT = RECT_WIDTH; // a square

	private static boolean[][] blacksquares = { { true, false, false, true, true, true, false, false, false },
			{ false, false, false, false, true, false, false, false, false },
			{ false, false, false, false, false, false, true, true, true },
			{ false, false, true, false, false, false, true, false, false },
			{ true, true, true, false, false, false, false, false, false },
			{ false, false, false, false, true, false, false, false, false },
			{ false, false, false, true, true, true, false, false, true } }; // all the squares that are black (true)
																				// and white (false)

	private static Crossword cw = new Crossword(blacksquares);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		cw.getPuzzle();

		// System.out.println(cw);

		/* Run the GUI */
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				onCreate();
			}
		});
	}

	/**
	 * Draws components specified here
	 * 
	 * @param g - Graphics for use in super
	 */
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		Square[][] puzzle = cw.getPuzzle();

		/* Draw Puzzle */
		g.setColor(Color.BLACK);
		int counterX = 0;
		int counterY = 0;
		for (int r = 0; r < puzzle.length; r++) {
			for (int c = 0; c < puzzle[0].length; c++) {
				if (puzzle[r][c].isBlack()) {
					g.fillRect(RECT_X + counterX, RECT_Y + counterY, RECT_WIDTH, RECT_HEIGHT);
				} else {
					g.drawRect(RECT_X + counterX, RECT_Y + counterY, RECT_WIDTH, RECT_HEIGHT);
					if (puzzle[r][c].getLabel() != 0) {
						g.drawString(puzzle[r][c].getLabel() + "", RECT_X + counterX + 2, RECT_Y + counterY + 20);
					}
				}
				counterX += RECT_WIDTH;
			}
			counterX = 0;
			counterY += RECT_HEIGHT;
		}

		/* Add labels */

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
		JLabel one = new JLabel("1: Word that rhymes with \"Butter\"");

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(main); // Rectangle
		// frame.getContentPane().add(one); // Label one
		frame.pack();
		frame.setLocationByPlatform(true);
		frame.setVisible(true);

		/* Create instructions */

	}

}
