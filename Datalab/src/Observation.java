
public class Observation {

	private String location;
	private float temp_f;
	private String weather;
	private String windDeg;

	public Observation(String loc, float temp) {
		location = loc;
		temp_f = temp;
	}
	
	public Observation(String id, float temp_f, String weather, String wind_degrees) {
		this.location = id;
		this.temp_f = temp_f;
		this.weather = weather;
		this.windDeg = wind_degrees;
	}
	
	public String getLocation() {
		return location;
	}
	
	public float getTemp() {
		return temp_f;
	}

	public String getWeather() {
		return weather;
	}

	public String getWindDeg() {
		return windDeg;
	}

	public boolean colderThan(Observation other) {
		return this.temp_f < other.temp_f;
	}
	
	public String toString() {
		return "The current temperature of " + location + " is " + temp_f + "F.";
	}
}
