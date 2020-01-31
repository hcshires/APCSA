import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListAlgorithms {

	public static void main(String[] args) throws FileNotFoundException {
		
		ArrayList<String> words = new ArrayList<String>();
		Scanner sc = new Scanner(new File("words2.txt")); // Read in a file
		System.out.println(sc.nextLine()); // Print first line
		
		words.add(sc.nextLine()); // Put in first value
		
		while (sc.hasNext()) { // If there is another word in the file
			String item = sc.nextLine();
			int i = 0;
			boolean added = false;
			while (i < words.size() && !added) {
				if (item.compareTo(words.get(i)) < 0) {
					words.add(i, item); // Add shifts index 0 to 1 and inserts "item" to 0
					added = true; // Break out of the current (inner while) loop. Can't add item multiples times
				}
				i++;
			}
			
			if (!added) { // If the item happens to be the biggest, it will add to the end
				words.add(item);
			}
			
			/* 
			 * for (int i = 0; i < words.size(); i++) {
				 	if (item.compareTo(words.get(i)) < 0) {
						words.add(i, item); // Add shifts index 0 to 1 and inserts "item" to 0
						break; // Break out of the current (inner for) loop. Can't add item multiples times
					}
					if (item.compareTo(words.get(words.size() - 1)) >= 0) {
						words.add(item); // If it's bigger than last value, add to end
						break; // Prevent adding on infinitely to the loop
					}
				}
			 */
		}
		
		for (String s : words) {
			System.out.println(s);
		}
		
		ArrayList<Integer> nums = new ArrayList<Integer>();
		
		for (int i = 0; i < 10; i++) {
			nums.add((int)(Math.random() * 10 + 1)); // 10 Random nums from 1 to 10
		}
		
		System.out.println(nums);
		
		// Remove duplicates in nums
		for (int j = 0; j < nums.size(); j++) {
			for (int k = nums.size() - 1; k > j; k--) {
				if (nums.get(j) == nums.get(k)) {
					nums.remove(k);
				}
			}
		}
		System.out.println(nums);
	}

}
