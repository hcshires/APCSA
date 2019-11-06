
public class Section28 {

	public static void main(String[] args) {
		/* Math functions are in Math class, they are all 
		 * static functions.
		 * 
		 * Static means the functions are class functions,
		 * not instance functions. They are NOT specific to any one object 
		 * of the class
		 */
		
		System.out.println(Math.pow(3, 2)); // Returns double
		
		// random #'s from 0 - 1 (not including 1)
		for (int i = 0; i < 10; i++) {
			System.out.println("0 - 1: " + Math.random());
		}
		
		// random integers from 0 - 10 (11 different whole numbers)
		for (int i = 0; i < 10; i++) {
			System.out.println("0 - 10: " + (int)(Math.random() * 11));
		}
		
		// random integers from 3 - 7 (5 different whole numbers)
		for (int i = 0; i < 10; i++) {
			System.out.println("3 - 7: " + (int)(Math.random() * 5 + 3));
		}
		
		// random integers from 30 - 39 (10 different whole numbers)
		for (int i = 0; i < 10; i++) {
			System.out.println("30 - 39: " + (int)(Math.random() * 10 + 30));
		}
		
		// random integers from low to high
		for (int i = 0; i < 10; i++) {
			System.out.println("New : " + newRandom(58, 60));
		}	
	}
	
	public static int newRandom(int low, int high) {
		int numberOfNumbers = high - low + 1;
		return (int)(Math.random() * numberOfNumbers + low);
	}
}
