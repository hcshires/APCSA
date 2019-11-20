import core.data.DataSource;

public class WeatherStation {
	private String name;
	private String id;
	private String state;
	private double latitude;
	private double longitude;
	
	public WeatherStation(String name, String id, String state, double lat, double lon) {
		this.name = name;
		this.id = id;
		this.state = state;
		this.latitude = lat;
		this.longitude = lon;
	}
	
	public String getID() {
		return this.id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public double getLat() {
		return this.latitude;
	}
	
	public boolean isLocatedInState(String otherState) {
		return this.state.equals(otherState);
	}
	
	public String toString() {
		return "Weather Station:\n\tName: " + this.name + "\n\tID: " + this.id + "\n\tState: " + 
				this.state + "\n\tLat: " + this.latitude + "\n\tLong: " + this.longitude;
	}
	
	public Observation currentWeather(String id) {
		DataSource ds = DataSource.connect("http://weather.gov/xml/current_obs/" + id + ".xml").load();
		ds.fetch("Observation", "temp_f", "weather", "wind_degrees");
		System.out.println("This is a test");
		return new Observation("lol", 0);
	
	}
	
	public static void filterByState(WeatherStation[] myStations, String stateID) {
		for (WeatherStation i : myStations) {
			if (i.state.equals(stateID)) {
				System.out.println(i);
			}
		}
	}
}
