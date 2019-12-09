import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class ReadSortRandomWords {

	public static void main(String[] args) throws FileNotFoundException {

		int[] nums = {1, 2, 3, 4, 5, 6, 7, 8};
		// int[] nums2 = nums;
		int[] nums2 = nums.clone();
		nums2[0] = 500;

		// What will the value of nums[0] be?
		// System.out.println(nums[0]);

		printIntArray(nums);
		printIntArray(nums2);
		
		doStuffRegular(nums);
		printIntArray(nums);
		
		File f = new File("words.txt");
		Scanner sc = new Scanner(f);
		File f2 = new File("words2.txt");
		Scanner sc2 = new Scanner(f2);
		int i = 0;
		String[] words1 = new String[50];
		String[] words2 = new String[50];

		while(sc.hasNext()) {
			words1[i] = (sc.next());
			words2[i] = (sc2.next());

			i++;
		}
		
		/* Sort the arrays individually by alphabetical order */
		// System.out.println(i);
		Arrays.sort(words1);
		// System.out.println(words1[0]);
		// System.out.println(words1[49]);
		Arrays.sort(words2);
		// System.out.println(words2[0]);
		// System.out.println(words2[49]);
		
		System.out.println("\nWORDS 1 LIST:\n");
		printStringArray(words1);
		System.out.println("\nWORDS 2 LIST:\n");
		printStringArray(words2);
		
		
		/* Run alphabetical sort of first 20 words in two lists */
		System.out.println("\nSORTED LIST:\n");
		printStringArray(fillArray(words1, words2));
	}

	/* write a static void method that takes an array of integers and prints 
	 * them using an enhanced for loop */
	public static void printIntArray(int[] array) {
		for (int num: array) {
			System.out.print(num + " ");
		}
		System.out.println();
	}


	public static void doStuffRegular(int [] vals) {
		for (int i = 0; i < vals.length; i++) {
			if (vals[i] % 2 == 0) 
				vals[i] = 100;
		}
	}
	
	public static void printStringArray(String[] array) {
		int i = 0;
		for (String s : array) {
			System.out.print(s + " ");
			i++;
			if (i % 5 == 0) {
				System.out.println();
			}
		}
	}
	
	/** 
	 * Returns an array of the first 20 words from two String[] arrays 
	 * in alphabetical order
	 * @param words1 An array of Strings in alphabetical order
	 * @param words2 An array of Strings in alphabetical order
	 * @return An array with 20 Strings from both parameter arrays in 
	 * alphabetical order
	 */
	public static String[] fillArray(String[] words1, String[] words2) {
		String[] sorted = new String[20];
		int j = 0; // Index for words1
		int k = 0; // Index for words2
		for (int i = 0; i < sorted.length; i++) {
			if (words1[j].compareTo(words2[k]) < 0) {
				sorted[i] = words1[j];
				j++;
			} else if (words1[j].compareTo(words2[k]) > 0) {
				sorted[i] = words2[k];
				k++;
			}
		}
		return sorted;
	}

	/* Enhanced for loops cannot be used to edit arrays
	public static void doStuffEnhanced(int [] vals) {
		for (int val: vals) {
			if (val % 2 == 0)
				val = -100;
		}
	} 
	*/

}
