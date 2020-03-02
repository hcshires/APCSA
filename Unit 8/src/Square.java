
public class Square {
	
	private boolean black;
	private int num;
	
	public Square(boolean b, int n) {
		black = b;
		num = n;
	}
	
	public boolean isBlack() {
		return black;
	}
	
	public int getLabel() {
		return num;
	}

	public String toString() {
		if (black) return "#";
		
		if (num == 0) return " ";
		
		// otherwise label
		return "" + num + " ";
	}
}
