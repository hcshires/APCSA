import java.util.Scanner;

public class Loops {

	private static Scanner sc;

	public static void main(String[] args) {
		
		System.out.println("What number would you like factors of?");
		sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		int factor = 1;
		int prime = 0;
		double average = 0;
		int avgCount = 0;
		
		while (num != factor - 1) {
			if (num % factor == 0) {
				System.out.println(factor + " is a factor of " + num);
				prime++;
			}
			factor++;
		}
		
		// Check if prime after factoring
		if (prime <= 2) {
			System.out.println(num + " is prime");
		}
		
		/* Get #'s from the user until they enter 0. 
		 * Find the average of the numbers entered.
		 */
		System.out.println("\nEnter numbers to average: ");
		while (num != 0) {
			num = sc.nextInt();
			average += num;
			avgCount++;
		}
		
		average /= avgCount - 1;
		System.out.println("The average is " + average);

	}

}
