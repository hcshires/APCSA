/**
 * BirthRate Class - Creates an instance of a birth rate statistic from a DataSource object
 * 
 * @author Velotics Technologies
 *
 */

public class BirthRate {
	private float year;
	private String age;
	private float birth_rate;
	private String race;
	private static final int sample = 1000;
	
	/**
	 * Constructs a BirthRate with the age and race of the female
	 * 
	 * @param age	The age of the female
	 * @param birth_rate	Percent birth rate
	 * @param race	The race of the female
	 */
	public BirthRate(float year, String age, float birth_rate, String race) {
		this.year = year;
		this.age = age;
		this.birth_rate = birth_rate;
		this.race = race;
	}

	public String getAge() {
		return age;
	}

	public float getBirth_rate() {
		return birth_rate;
	}

	public String getRace() {
		return race;
	}
	
	public float getYear() {
		return year;
	}

	/**
	 * Returns the birth rate as a percent of a 1,000 people sample
	 * @return
	 */
	public double getPercentRate() {
		return (this.birth_rate / sample) * 100;
	}
	
	public String toString() {
		return getPercentRate() + "% of " + sample + race + "females gave birth in the year " + year;
	}
}
