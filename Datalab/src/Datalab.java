import core.data.DataSource;

public class Datalab {

	public static void main(String[] args) {
		DataSource ds = DataSource.connect("https://data.cdc.gov/api/views/e8kx-wbww/rows.xml").load();
		ds.printUsageString();
		String path = "row/row/";
		
		int [] year = ds.fetchIntArray(path + "year");
		BirthRate [] stats = ds.fetchArray("BirthRate", path + "age", path + "birth_rate", path + "race");
		
		for (BirthRate i : stats) {
			for (int j : year) {
				System.out.println(i);
			}
		}
	}

}
