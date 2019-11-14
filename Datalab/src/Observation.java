
public class Observation {

	private String location;
	private float temp_f;

	public Observation(String loc, float temp) {
		location = loc;
		temp_f = temp;
	}
	
	public String getLocation() {
		return location;
	}
	
	public float getTemp() {
		return temp_f;
	}

	public boolean colderThan(Observation other) {
		return this.temp_f < other.temp_f;
	}
	
	public String toString() {
		return "The current temperature of " + location + " is " + temp_f + "F.";
	}
}
