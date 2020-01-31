import java.io.FileNotFoundException;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

class Main {
	public static void main(String[] args) throws FileNotFoundException {

		ArrayList<Student> students = new ArrayList<Student>();
		ArrayList<String> names = new ArrayList<String>();
		Scanner sc = new Scanner(new File("grades03.txt"));

		while (sc.hasNextLine()) {
			Student x;
			String first = sc.next(); // First name
			String last = sc.next(); // Last name
			int standard = sc.nextInt(); // Standard
			double grade = sc.nextDouble(); // Grade
			
			if (names.indexOf(first + last) == -1) {
				x = new Student(first, last);
				students.add(x);
				names.add(first + last);
			} else {
				for (int i = 0; i < students.size(); i++) {
					if (students.get(i).getFirst().equals(first) && students.get(i).getLast().equals(last)) {
						students.get(i).addGrade(standard, grade);
						students.get(i).avgGrade(standard);
					}
				}
			}
		}
		
		students.get(20).removeBadScores(); // Fix a random student's grades

		ClassSection section = new ClassSection(students);
		section.printRoster();

		System.out.println("\nClass Size: " + section.classSize() + " students");

	}
}