import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class SortingAssignment {

	public static void main(String[] args) {


		int size = (int) (Math.random() * 40 + 10);

		System.out.println("Selection Sorting");
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		for (int i = 0; i < size; i++) {
			numbers.add((int) (Math.random() * 1000));
		}
		System.out.println(numbers);
		SelectionSort(numbers);
		System.out.println(numbers + "\n\n");

		int[] array2 = { 19, 4, 5 };
		refresh(numbers, array2);
		System.out.println(numbers);
		SelectionSort(numbers);
		System.out.println(numbers + "\n\n");

		int[] array3 = { 14, 5 };
		refresh(numbers, array3);
		System.out.println(numbers);
		SelectionSort(numbers);
		System.out.println(numbers + "\n\n");

		int[] array4 = { 20 };
		refresh(numbers, array4);
		System.out.println(numbers);
		SelectionSort(numbers);
		System.out.println(numbers + "\n\n");

		System.out.println("Insertion Sorting");
		numbers.removeAll(numbers);
		for (int i = 0; i < size; i++) {
			numbers.add((int) (Math.random() * 1000));
		}
		System.out.println(numbers);
		InsertionSort(numbers);
		System.out.println(numbers + "\n\n");

		int[] array5 = { 20, 5, 2, 6, 7, 55, 4 };
		refresh(numbers, array5);
		System.out.println(numbers);
		InsertionSort(numbers);
		System.out.println(numbers + "\n\n");

		int[] array6 = { 15, 4, 1 };
		refresh(numbers, array6);
		System.out.println(numbers);
		InsertionSort(numbers);
		System.out.println(numbers + "\n\n");

		int[] array7 = { 12, 4 };
		refresh(numbers, array7);
		System.out.println(numbers);
		InsertionSort(numbers);
		System.out.println(numbers + "\n\n");

		int[] array8 = { 20 };
		refresh(numbers, array8);
		System.out.println(numbers);
		InsertionSort(numbers);
		System.out.println(numbers + "\n\n");

	}

	/**
	 * Sorts an ArrayList<Integer> in numerical order by locating the smallest number 
	 * each iteration and placing it at the index the iteration began at.
	 * @param nums
	 */
	public static void SelectionSort(ArrayList<Integer> nums) {
		for (int i = 0; i < nums.size(); i++) {
			int start = nums.get(i);
			int temp = start;
			for (int j = i; j < nums.size(); j++) {
				if (nums.get(j) < start) {
					temp = nums.get(j); // Grab the smallest so far
					nums.set(j, start); // Put the current number back
					start = temp; // Reset the current number to the smallest so far
				}
			}
			nums.set(i, temp); // Don't swap until the smallest value is found
		}

	}

	/**
	 * Sorts an ArrayList<Integer> in numerical order by 
	 * @param nums
	 */
	public static void InsertionSort(ArrayList<Integer> nums) {
		for (int i = 0; i < nums.size(); i++) {
			for (int j = i; j > 0; j--) { // Skips to index 1 or "second value"
				if (nums.get(j) < nums.get(j - 1)) { // If the right value is less than the left
					int temp = nums.get(j - 1);
					nums.set(j - 1, nums.get(j));
					nums.set(j, temp); // Swap
				}
			}
		}
	}

	public static void refresh(ArrayList<Integer> nums, int[] newnums) {
		nums.removeAll(nums);
		for (int x : newnums) {
			nums.add(x);
		}
	}

}
