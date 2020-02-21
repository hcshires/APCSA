import java.util.ArrayList;

public class SeatingChart {

	private Student[][] seats;

	/**
	 * Creates a seating chart with the given number of rows and columns from the
	 * students in studentList. Empty seats in the seating chart are represented by
	 * null
	 * 
	 * @param studentList
	 * @param rows        the number of rows of seats in the classroom
	 * @param cols        the number of columns of seats in the classroom
	 * 
	 *                    PRECONDITION: rows > 0; cols > 0; rows * cols >=
	 *                    sutdentList.size() POSTCONDITION: - Students appear in the
	 *                    seathing chart in the same order as they appear in
	 *                    studentList, starting at seats[0][0]. - seats is filled
	 *                    column by column from stuentList, followed by any empty
	 *                    seats (represented by null) - studentList is unchanged.
	 */
	public SeatingChart(ArrayList<Student> studentList, int rows, int cols) {
		seats = new Student[rows][cols];
		int counter = 0;
		for (int c = 0; c < seats[0].length; c++) { // Change to next column after
			for (int r = 0; r < seats.length; r++) { // Fill column first
				if (counter < studentList.size()) {
					seats[r][c] = studentList.get(counter);
					counter++;
				}
			}
		}
	}

	public Student[][] getSeatingChart() {
		return seats;
	}

	/**
	 * Removes students who have more than a given number of absences from the
	 * seating chart, replacing those entries in the seating chart with null and
	 * returns the number of students removed.
	 * 
	 * @param allowedAbsences
	 * @return number of students removd from seats
	 */
	public int removeAbsentStudents(int allowedAbsences) {
		int students = 0;
		for (int r = 0; r < seats.length; r++) {
			for (int c = 0; c < seats[0].length; c++) {
				if (seats[r][c] != null && seats[r][c].getAbsences() > allowedAbsences) {
					seats[r][c] = null;
					students++;
				}
			}
		}
		return students;
	}

	public String toString() {
		String sc = "";
		// MUST TRAVERSE THIS WAY
		for (int i = 0; i < seats.length; i++) { // row
			for (int j = 0; j < seats[0].length; j++) { // column
				sc += "[" + seats[i][j] + "]" + " "; // [i] is changing the row
			}
			sc += "\n";
		}
		return sc;
	}
}
