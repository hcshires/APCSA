/**
 * Segment Class - Creates a segment with two end points.
 * 
 * A segment is a geometrical object composing of one dimension and two end points terminating the object.
 * The Segment class allows for a Segment object to be generated using two Point objects.
 * The Segment may be returned as a string listing the points or a boolean determining if one Segment is equal to another.
 * @author Velotics Technologies
 *
 */

public class Segment {

	private Point p1;
	private Point p2;
	
	/**
	 * Create a segment with two points
	 * 
	 * This constructor allows the user to create a segment
	 * object by specifying the two end points for the segment
	 * 
	 * @param p1	The first end point
	 * @param p2	The second end point
	 */
	
	/* Encapsulation means enclosing/hiding data
	 * so that the user cannot access it directly
	 */
	public Segment(Point p1, Point p2) {
		this.p1 = p1;
		this.p2 = p2;
	}
	
	/* Overloading: making additional methods with the same name, 
	 * but different parameters
	 */
	
	// No args constructor
	/**
	 * Construct a Segment with two default Points
	 */
	public Segment() {
		p1 = new Point(0, 0);
		p2 = new Point(10, 0);
	}
	
	// getter/accessor method. gives read access to user
	/**
	 * Get the first Point object
	 * @return
	 */
	public Point getP1() {
		return p1;
	}

	// setter/mutator method. allows write access to user
	/**
	 * Change the first Point object to a new Point
	 * @param p1
	 */
	public void setP1(Point p1) {
		this.p1 = p1;
	}

	/**
	 * Get the second Point object
	 * @return
	 */
	public Point getP2() {
		return p2;
	}
	
	/**
	 * Change the second Point object to a new Point
	 */
	public void setP2(Point p2) {
		this.p2 = p2;
	}

	/**
	 * Return the Segment as a string listing the two Points
	 * @return
	 */
	public String toString() {
		return "This segment connects " + p1 + " with " + p2;
	}
	
	/**
	 * Return true if two Segments are equal to each other
	 * @param other
	 * @return
	 */
	public boolean equals(Segment other) {
		return (this.p1.equals(other.p1) && this.p2.equals(other.p2)) || 
				(this.p2.equals(other.p1) && this.p1.equals(other.p2));
	}
}
