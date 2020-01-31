public class Grade {
	private double score;
	private int standard;

	public Grade(int standard, double score) {
		this.score = score;
		this.standard = standard;
	}

	public double getScore() {
		return this.score;
	}

	public int getStandard() {
		return this.standard;
	}
}