import java.util.ArrayList;

public class Delimiter {
	
	private String openSymbol;
	private String closeSymbol;

	public static void main(String[] args) {
		
		Delimiter bold = new Delimiter("<b>", "</b>");
		String[] stuff = {"fdashjfdhajfkljsda", "fsdajfdk", "<b>", "daqwerd", "</b>", "<b>", "<b>", "</b>", "</b>", "html", "is"
				, "very", "epic" };
		
		// Returns an ArrayList, so we can assign the method call to an object
		ArrayList<String> delims = bold.findDelimiter(stuff);
		
		// WHAHAHHAT?!?! THERE'S A BUILT-IN toString()?!?!?
		System.out.println(delims);
		
		// Enhanced for loop cuz why not
		for (String item : delims) {
			// System.out.println(item);
		}
		
		// Regular for loop cuz why not
		for (int i = 0; i < delims.size(); i++) {
			System.out.print(delims.get(i));
		}
		System.out.println();
	}
	
	public Delimiter(String start, String finish) {
		this.openSymbol = start;
		this.closeSymbol = finish;
	}
	
	
	/**
	 * Find opening and closing symbols in the array of stuff
	 * @param arr An array of text with delimiters
	 * @return A list of delimiter tags from the original array
	 */
	public ArrayList<String> findDelimiter(String [] arr) {
		
		/* How to DECLARE/INITIALIZE an ArrayList
		 * Can only hold OBJECTS, not PRIMITIVES
		 */
		ArrayList<Integer> numbers;
		numbers = new ArrayList<Integer>();
		
		ArrayList<String> delims = new ArrayList<String>();
		
		for (String item : arr) {
			if (item.equals(this.openSymbol) || item.equals(this.closeSymbol)) {
				delims.add(item); // Adds an item onto end, but we could specify an index to add it as well
			}
		}
		
		System.out.println(delims.size()); // Length of ArrayList
		
		return delims;
	}
	
	public boolean isBalanced(ArrayList<String> delims) {
		return false;
	}

}
