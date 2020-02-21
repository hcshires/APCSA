
public class Crossword {

	private Square[][] puzzle;
	
	/** Constructs a Crossword puzzle
	 * 
	 * @param blackSquares - booleans that determine where 
	 * to place black and white squares in the puzzle 2DArray
	 * True: Black square
	 * False: White square
	 */
	public Crossword(boolean[][] blackSquares) {
		// initialize squares to be same size as blackSquare
		puzzle = new Square[blackSquares.length][blackSquares[0].length]; // [rows][columns]. This is a Square 2D ARRAY
		
		int counter = 0;
		
		// MUST use counting loops to initialize objects
		for (int r = 0; r < puzzle.length; r++) {
			for (int c = 0; c < puzzle[0].length; c++) {
				if (toBeLabeled(r, c, blackSquares)) {
					counter++;
					puzzle[r][c] = new Square(false, counter);
				} else {
					puzzle[r][c] = new Square(blackSquares[r][c], 0);
				}
			}
		}
		
		/* now need to initialize every individual square in squares 
		 * Currently, each item is null
		 */
		
	}
	
	public Square[][] getPuzzle() {
		return puzzle;
	}

	private boolean toBeLabeled(int r, int c, boolean[][] blackSquares) {
		if (blackSquares[r][c] == true) { // black squares don't get numbered
			return false;
		}
		
		if (c == 0 || r == 0) {
			return true; // white square on the left or top
		}
		
		// If there's a black square to the left
		if (blackSquares[r][c - 1] == true) { // NOT in the first column
			return true;
		}
		
		// If there's a black square above
		if (r > 0 && blackSquares[r - 1][c] == true) {
			return true;
		}
		
		return false; // white squares that don't get labeled
	}
	
	public String toString() {
		String output = "";
		for (int r = 0; r < puzzle.length; r++) {
			for (int c = 0; c < puzzle[0].length; c++) {
				output += puzzle[r][c].toString();
			}
			output += "\n";
		}
		return output;
	}
}
