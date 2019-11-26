import core.data.*;

public class StationRunner {

	public static void main(String[] args) {
		DataSource ds = DataSource.connect("http://weather.gov/xml/current_obs/index.xml").load();
		// ds.printUsageString();
		
		WeatherStation ws = ds.fetch("WeatherStation", "station/station_name", 
				"station/station_id", "station/state", "station/latitude", "station/longitude");
		
		System.out.println(ws);
		System.out.println(ws.isLocatedInState("IA"));
		System.out.println(ws.isLocatedInState("AB"));
		
		WeatherStation[] allstns = ds.fetchArray("WeatherStation", "station/station_name", 
				"station/station_id", "station/state", "station/latitude", "station/longitude");
		
		System.out.println("Total Stations: " + allstns.length);
		
		// Use filterByState static method
		WeatherStation.filterByState(allstns, "IA");
		
		double mostSouth = 90.0;
		String nameSouth = "";
		
		// Find station that is farthest south
		for (WeatherStation i : allstns) {
			double lat = i.getLat();
			if (lat < mostSouth) {
				mostSouth = i.getLat();
				nameSouth = i.getName();
			}
		}
		
		System.out.println(nameSouth + "is the farthest south at Lat: " + mostSouth + "\n");
		Observation ob = ws.currentWeather("KDSM");
		System.out.println(ob);
		System.out.println("Weather: " + ob.getWeather() + "\nWind: " + ob.getWindDeg());
	}

}
