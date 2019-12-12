
public class PA_64 {

	public static void main(String args[]) {

		/* make the following calls to makePythagoreanTriple.
		/ print the results of each using the printIntArray method below. */
		printIntArray(makePythagoreanTriple(5, 2));
		printIntArray(makePythagoreanTriple(2, 5));
		printIntArray(makePythagoreanTriple(3, 1));

		/*make calls to computeScore for each word in the array below.
		*/
		String scrabbleWords[] = {"zeta", "quantify", "banana", "joyful"};
		
		for (String str: scrabbleWords) {
			System.out.println(str + " is worth " + computeScore(str) + " points in Scrabble");
		}
	
		/* tests for rotateRight */
		int [] numbers = {50, 60, 70, 80, 90};
		System.out.print("Rotate this right one spot: ");
		printIntArray(numbers);
		System.out.print("Results in: ");
		rotateRight(numbers);
		printIntArray(numbers);

		int [] numbers2 = {100, 200};
		System.out.print("Rotate this right one spot: ");
		printIntArray(numbers2);
		System.out.print("Results in: ");
		rotateRight(numbers2);
		printIntArray(numbers2);
		
	}

	public static void printIntArray(int nums[]) {

		for(int i = 0; i < nums.length-1; i++) {
			System.out.print(nums[i] + ", ");

		}
		System.out.println(nums[nums.length-1]);

	}
	
	/**
	 * Take two integer parameters, (swap them if necessary so that m>n) and calculates the 
	 * Pythagorean triple using the above expressions.  Place the resulting values a, b, 
	 * and c into a new array of three elements, and return the array.
	 * 
	 * @param m
	 * @param n
	 * @return
	 */
	public static int[] makePythagoreanTriple(int m, int n) {

		int[] triple = new int[3];
		if (n > m) {
			int temp = m;
			m = n;
			n = temp;
		}
		
		triple[0] = (int)Math.pow(m, 2) - (int)Math.pow(n, 2);
		triple[1] = 2 * m * n;
		triple[2] = (int)Math.pow(m, 2) + (int)Math.pow(n, 2);
		return triple;
	}
	
	/**
	 * Takes a String parameter and calculates and returns the Scrabble score for that word
	 * 
	 * @param str
	 * @return
	 */
	public static int computeScore(String str) {
		int score = 0;
		final String[] alphabet = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", 
				"m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z" };
		final int[] values = { 1, 3, 3, 2, 1, 4, 2, 4, 1, 8, 5, 1, 3, 1, 1, 3, 10, 1, 1, 1, 1, 4, 4, 8, 4, 10 };
		
		for (int i = 0; i < str.length(); i++) {
			int count = 0;
			 String letter = str.substring(i, i + 1);
			 for (String a : alphabet) {
				 if (letter.equals(a)) {
					 score += values[count];
				 }
				 count++;
			 }
		}
		
		return score;
	}
	
	/**
	 * Rotate the elements in vals to the right one spot (the number farthest right should be rotated to the first spot)
	 * 
	 * @param vals
	 */
	public static void rotateRight(int[] vals) {
		int[] clone = vals.clone();
		vals[0] = clone[vals.length - 1];
		for (int i = 0; i < vals.length - 1; i++) {
			vals[i + 1] = clone[i];
		}
	}

}

