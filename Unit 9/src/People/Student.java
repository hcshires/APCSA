package People;

public class Student extends Person {

    private int grade;
    private double gpa;

    public Student(String name, String birthday, int grade, double gpa) {
        super(name, birthday);

        this.grade = grade;
        this.gpa = gpa;
    }

    public int getGrade() {
        return grade;
    }

    public double getGpa() {
        return gpa;
    }

    public String toString() {
        return "Hi my name is " + getName() + " and I am a student!\nGrade " + grade + "\nGPA: " + gpa;
    }
}
