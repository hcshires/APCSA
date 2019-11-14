import core.data.DataSource;

public class Observation {

	private String location;
	private float temp_f;

	public Observation(String loc, float temp) {
		location = loc;
		temp_f = temp;
	}

	public boolean colderThan(Observation other) {
		return this.temp_f < other.temp_f;
	}
	
	public String toString() {
		return "The current temperature of " + location + " is " + temp_f;
	}
}
