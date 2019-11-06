public class PA_42 {

	public static void main(String[] args) {

		for (int i = 0; i < 10; i+=2) {
			System.out.println(i);
		}
		
		/* for (spot1; spot2; spot3) {
		 * 		spot1 --> code here runs once, before the loop starts
		 * 		spot2 --> boolean expression, checked before each iteration
		 * 		spot3 --> counter update, after each iteration
		 * }
		 */
		
		for (int i = 100; i > 0; i -= 5, System.out.println(i));
		
		String word = "melacholy";
		
		for (int i = 0; i < word.length(); i++) {
			System.out.println(word.substring(i, i+1));
		}
		
		for (int i = 0; i < word.length(); i++) {
			if (word.substring(i, i+1).equals("l")) {
				word = word.substring(0, i) + "w" + word.substring(i+1);
			}
		}
		System.out.println(word);
		
		System.out.println(countOccurrences("banana", "an"));
		
		/* count the # of occurrences of the substring sub that
		 * appear in the word w.
		 */
	}
	
	public static int countOccurrences(String w, String sub) {
		int c = 0;
		for (int i = 0; i < w.length(); i++) {
			if (w.indexOf(sub) != -1) {
				c++;
			}
		}
		
		return c;
	}
}
