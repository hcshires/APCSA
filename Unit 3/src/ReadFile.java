import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFile {

	public static void main(String[] args) {
		Scanner s1 = null;
		File f;

		try {
			f = new File("gettys.txt");
			s1 = new Scanner(f);
		} catch (FileNotFoundException e) {
			System.out.println("The system could not find the file. Check your file's name and location and try again.");
			e.printStackTrace(); // Print the error
		}

		if (s1 != null) {
			while (s1.hasNext()) {
				String word = s1.next();
				
				/* Short Circuit evaluation
				 * 		if the first part of an && is false, java DOES NOT
				 * 		check the second part
				 */
				if (word.length() >= 2 && word.substring(word.length() - 2).equals("ed")) {
					System.out.println(word);
				}
			}
		} else {
			System.out.println("Improper declaration of Scanner object!");
		}

		System.out.println("We made it!");
	}
}
