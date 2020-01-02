import java.util.ArrayList;

public class PA_72 {

	public static void main(String[] args) {
		
		// Create an ArrayList of Integers
		ArrayList<Integer> ints = new ArrayList<Integer>();
		
		// Add 10 random values
		for (int i = 0; i < 10; i++) {
			ints.add((int)Math.round(Math.random() * 40 + 50)); // Test
		}
		
		// Print all the values enchanced for
		for (int num : ints) {
			System.out.print(num + " ");
		}
		System.out.println("\n--------------------");
		int length = ints.size();
		
		// Swap the first and last values
		Integer temp = ints.get(0);
		ints.set(0, ints.get(length - 1));
		ints.set(length - 1, temp);
		
		// Print values counting for
		for (int i = 0; i < length; i++) {
			System.out.print(ints.get(i) + " ");
		}
		
		System.out.println("\n--------------------");
		
		// Remove "50s" so that i isn't screwed up by removing from the front
		for (int i = length - 1; i >= 0; i--) {
			if (ints.get(i) < 60 && ints.get(i) > 49) {
				ints.remove(i);
			}
		}
		
		// Print result
		System.out.println(ints);
	}

}
