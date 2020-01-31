import java.io.FileNotFoundException;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

class Main {
	public static void main(String[] args) throws FileNotFoundException {

		ArrayList<Student> students = new ArrayList<Student>();
		Scanner sc = new Scanner(new File("grades03.txt"));

		Student s1 = new Student("Henry", "Shires");
		Student s2 = new Student("PD", "Dahal");
		Student s3 = new Student("Levi", "Janssen");
		Student s4 = new Student("Henry", "Shires");
		Student s5 = new Student("Xiangheng", "Li");

		s1.addGrade(1, 90.0);
		s1.addGrade(1, 80.0);
		s1.addGrade(2, 85.6);
		s1.addGrade(2, 75.9);
		s1.addGrade(2, 56.8);
		s1.addGrade(2, 100.0);

		students.add(s1);
		students.add(s2);
		students.add(s3);
		students.add(s4);
		students.add(s5);
		// students.add(s6);

		s1.avgGrade(2);
		s1.avgGrade(1);
		s1.avgGrade(3);

		while (sc.hasNextLine()) {
			String first = sc.next(); // First name
			String last = sc.next(); // Last name
			int standard = sc.nextInt(); // Standard
			double grade = sc.nextDouble(); // Grade
			
			

			Student x = new Student(first, last);

			x.addGrade(standard, grade);
			x.avgGrade(standard);
			students.add(x);

		}

		ClassSection section = new ClassSection(students);
		section.printRoster();

		System.out.println("Class Size: " + section.classSize() + "students");

	}
}