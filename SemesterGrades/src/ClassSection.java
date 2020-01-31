import java.util.ArrayList;

public class ClassSection {
	private ArrayList<Student> students;
	private Student example;

	public ClassSection(ArrayList<Student> students) {
		this.students = students;
	}

	public Student getStudent(String first, String last) {
		Student student = new Student(first, last);
		boolean isAdded = false;
		for (Student s : students) {
			if (s.getFirst().equals(first) && s.getLast().equals(last)) {
				student = s;
				isAdded = true;
			}
		}

		if (!isAdded) {
			students.add(student);
		}
		return student;
	}

	public void printRoster() {
		for (int i = 0; i < students.size(); i++) {
			for (int j = i + 1; j < students.size(); j++) {
				if (students.get(i).getLast().compareTo(students.get(j).getLast()) > 0) {
					example = students.get(i);
					students.set(i, students.get(j));
					students.set(j, example);
				}
			}
		}

		for (Student s : students) {
			String firstname = s.getFirst();
			String lastname = s.getLast();
			double[] stand = s.getAverages();
			System.out.println(
					firstname + " " + lastname + " " + stand[0] + " " + stand[1] + " " + stand[2] + " " + stand[3]);
		}
	}

	public int classSize() {
		return students.size();
	}
}