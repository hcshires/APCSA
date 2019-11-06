
public class PA_51 {

	public static void main(String[] args) {
		APLine line1 = new APLine(5, 4, -17);
		double slope1 = line1.getSlope();
		boolean onLine1 = line1.isOnLine(5,  -2);
		
		APLine line2 = new APLine(-25, 40, 30);
		double slope2 = line2.getSlope();
		boolean onLine2 = line2.isOnLine(5, -2);
		
		System.out.println("Line 1: " + line1 + " " + slope1 + " " + onLine1);
		System.out.println("Line 2: " + line2 + " " + slope2 + " " + onLine2);
		
		APLine line3 = new APLine(-3, 1, 8);
		line3.toTable();
		
		APLine line4 = new APLine(2, 3, 5);
		System.out.println(line4 + " " + line4.getSlope());
		line4.toTable();
	}

}
