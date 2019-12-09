import java.awt.Point;

public class ArrayNotes {

	public static void main(String[] args) {
		
		// an array with four values
		int [] numbers = new int[4];
		
		System.out.println(numbers.length);
		// An array is immutable (can't change w/o making a new object)
		
		// Print last number in numbers
		System.out.println(numbers[numbers.length - 1]);
		
		// Assign value of 33, 12, 674
		numbers[0] = 33;
		numbers[1] = 12;
		numbers[2] = 674;
		// CONTENTS of array are MUTABLE
		System.out.println(numbers[0]);
		
		String[] days = {"Sunday", "Monday", "Tuesday", "Wednesday", 
				"Thursday", "Friday", "Saturday"};
		days[0] = "Sunday";
		
		// Use java's Point class
		Point[] points = new Point[3];
		points[0] = new Point(8, 9);
		System.out.println(points[0]);
		
		Point[] morePoints = {new Point(1, 2), new Point(3, 4), new Point(8, 9)};
		
		// For each Point in morePoints, print each
		for (Point fancyPants : morePoints) {
			System.out.println(fancyPants);
		}
		
		// Use an enhanced for loop (foreach)
		for (String s : days) {
			System.out.println(s);
			s = "Funday"; // Doesn't do shi--affect original list
		}
		
		for (int num : numbers) {
			if (num > 100) {
				System.out.println(num);
			}
		}
	}
	
	/* Answers to AP:
	 * 1. E
	 * 2. C 
	 * 3. E
	 * 4. A
	 * 5. C
	 */
}
