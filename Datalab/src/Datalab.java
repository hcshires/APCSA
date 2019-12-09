import java.util.ArrayList;

import core.data.DataSource;

public class Datalab {

	public static void main(String[] args) {
		DataSource ds = DataSource.connect("https://data.cdc.gov/api/views/e8kx-wbww/rows.xml").load();
		ds.printUsageString();
		String path = "row/row/";
		
		BirthRate [] stats = ds.fetchArray("BirthRate", path + "year", path + "age", path + "birth_rate", path + "race");
		
		/*
		for (BirthRate i : stats) {
			System.out.println(i);
		}
		*/
		
		// Return the index of the highest birth rate in the array:
		int index = BirthRate.getHighestBirthRate(stats);
		System.out.println("The highest birth rate recorded in New York is: \n" 
						+ stats[index]);
		
		/* Find the highest birth rate in the most recent year recorded */
		ArrayList<BirthRate> yearBirths = new ArrayList<BirthRate>();

		float recentYear = BirthRate.getRecentYear(stats);
		
		/* Append year-specific data */
		for (int i = 0; i < stats.length; i++) {
			if (stats[i].getYear() == recentYear) {
				yearBirths.add(stats[i]);
			}
		}

		/* Convert to array for method usage */
		BirthRate[] latestBirths = new BirthRate[yearBirths.size()];
		
		/*
		int index2 = BirthRate.getHighestBirthRate(latestBirths);
		System.out.println("The highest " + recentYear + " birth rate recorded in New York is: \n" + 
							latestBirths[index2]);
							*/
	}

}
