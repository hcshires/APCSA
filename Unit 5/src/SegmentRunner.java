
public class SegmentRunner {

	public static void main(String[] args) {
		/* If you don't write any constructors,
		 *  Java provides a default, no parameters constructor
		 *  
		 *  If you DO write a constructor with parameters,
		 * 	then those MUST be used.
		 */
		
		Segment s1 = new Segment(new Point(2, 3), new Point(4, 5));
		Segment s2 = new Segment(new Point(4, 6), new Point(12, 18));
		Segment s3 = s2; // Two variables pointing at same object
		
		/* If you DO NOT override the .equals method
		 * then java uses == to compare addresses
		 */
		
		System.out.println(s1.equals(s2));
		System.out.println(s2.equals(s3));
		
		Segment s4 = new Segment();
		// Write a toString for the segment class that prints:
		System.out.println(s1); // This segment connects (2, 3) to (5, 1)
		
		Point sPoint = s1.getP1();
		Point sPoint2 = s2.getP2();
		
		sPoint = new Point(100, 200);
		sPoint.setX(99);
		
		System.out.println(sPoint);
		System.out.println(s1);
		
		/* Created a .equals method that overrides the default */
		System.out.println(sPoint.equals(sPoint));
		System.out.println(sPoint.equals(sPoint2));
		
		System.out.println(s2.equals(s3));
	}

}