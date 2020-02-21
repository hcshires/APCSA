
public class Student {
	private String firstName;
	private int absences;
	
	public Student(String firstName, int absences) {
		this.firstName = firstName;
		this.absences = absences;
	}

	public String getFirstName() {
		return firstName;
	}

	public int getAbsences() {
		return absences;
	}
	
	public String toString() {
		return firstName + ": " + absences;
	}
}
