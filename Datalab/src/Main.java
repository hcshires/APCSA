import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import core.data.*;

/* Use the Sinbad library to fetch information from xml files on the Internet */
public class Main {
	public static void main(String[] args) throws FileNotFoundException {

		int timeout = 15 * 60;
		
		/* Hope Des Moines sermons
		DataSource church = DataSource.connect("http://sermons.hopedesmoines.org/sermons.xml");
		church.setCacheTimeout(timeout);
		church.load();
		// church.printUsageString();
		
		String[] authors = church.fetchStringArray("channel/item/author/value");
		String[] sermons = church.fetchStringArray("channel/item/title");
		
		for (String i : authors) { // for i in authors, i is each value in authors
			System.out.println(i);
		}
		
		System.out.println("The latest sermon by " + authors[0] + " is entitled " + sermons[0]);
		*/
		
		Scanner sc = new Scanner(new File("goodstations.txt"));
		String[] stations = new String[2605];
		
		/* for (String i : stations) {
			i = sc.nextLine();
			String id = i;
			
			DataSource ds = DataSource.connect("http://weather.gov/xml/current_obs/" + id + ".xml");
			
			ds.setCacheTimeout(timeout); // Grab newest values from server every 15 mins
			ds.load(); // Download the data from ds
			
			float temp = ds.fetchFloat("temp_f"); // Grab a float "temp_f" in ds
			String loc = ds.fetchString("location");
			
			/*
			String dir = ds.fetchString("wind_dir");
			float wnd = ds.fetchFloat("wind_kt");
			float wndchill = ds.fetchFloat("windchill_f");
			
			System.out.println(" with wind from the " + dir + " gusting at " + wnd + " knots. "
					+ "\nThe current windchill is " + wndchill + " F.");
			
			System.out.println("The temperature at " + loc + " is " + temp + "F");
			*/
		String id = "KDSM";
		String id2 = "KPDX";
		
		DataSource ds = DataSource.connect("http://weather.gov/xml/current_obs/" + id + ".xml");
		DataSource ds2 = DataSource.connect("http://weather.gov/xml/current_obs/" + id2 + ".xml");
		
		ds.setCacheTimeout(timeout); // Grab newest values from server every 15 mins
		ds2.setCacheTimeout(timeout);
		
		ds.load(); // Download the data from ds
		ds2.load();
		
		float temp = ds.fetchFloat("temp_f"); // Grab a float "temp_f" in ds
		String loc = ds.fetchString("location");
		
		float temp2 = ds2.fetchFloat("temp_f");
		String loc2 = ds2.fetchString("location");
		
		Observation obs = new Observation(loc, temp);
		Observation obs2 = new Observation(loc2, temp2);
		
		System.out.println("Is " + loc + " colder than " + loc2 + "? " + obs.colderThan(obs2));
		
		Observation obs3 = ds.fetch("Observation", "location", "temp_f"); // Create object for ID
		Observation obs4 = ds2.fetch("Observation", "location", "temp_f"); // Create object for ID2
		
		System.out.println(obs3);
		System.out.println(obs4);
		
		}
}
