import java.util.ArrayList;

public class Student {
	private String firstName;
	private String lastName;
	private ArrayList<Grade> grades;
	private double[] averages = { -1.0, -1.0, -1.0, -1.0 }; // No averages exist

	public Student(String first, String last) {
		grades = new ArrayList<Grade>();
		firstName = first;
		lastName = last;
	}

	public String getFirst() {
		return firstName;
	}

	public String getLast() {
		return lastName;
	}

	public double[] getAverages() {
		return averages;
	}

	/**
	 * Records the given grade for this Student
	 * 
	 * @param int    standard
	 * @param double grade
	 */
	public void addGrade(int standard, double grade) {
		grades.add(new Grade(standard, grade));
	}

	/**
	 * Returns the average grade of this student for a specified standard
	 * 
	 * @param int standard
	 * @return double average
	 */
	public double avgGrade(int standard) {
		double average = 0.0;
		int counter = 0;
		for (Grade g : grades) {
			if (g.getStandard() == standard) {
				average += g.getScore();
				counter++;
			}
		}

		if (counter == 0) {
			average = -1;
		} else {
			average = (double) (average / counter);
			averages[standard - 1] = average;
		}
		return average;
	}

	/**
	 * Removes the scores for each Standard that are below the Student's average
	 * grade for that Standard
	 */
	public void removeBadScores() {
		for (int i = 0; i < averages.length; i++) {
			for (int j = 0; j < grades.size(); j++) {
				if (grades.get(j).getStandard() == i + 1 && grades.get(j).getScore() < averages[i]
						&& grades.get(j).getScore() != -1.0) {
					grades.remove(j);
				}
			}
		}
	}
}