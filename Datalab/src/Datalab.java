import core.data.DataSource;

public class Datalab {

	public static void main(String[] args) {
		DataSource ds = DataSource.connect("").load();
		ds.printUsageString();
	}

}
