
public class Point {
	private double x;
	private double y;

	public Point(double x, double y) {
		this.x = x; // This object's x (not the constructor)
		this.y = y;
	}

	public void translate(double deltax, double deltay) {
		x += deltax;
		y += deltay;
	}

	public double distance(Point other) {
		double a2 = Math.pow(other.x - this.x, 2);
		double b2 = Math.pow(other.y - this.y, 2);
		return Math.sqrt(a2 + b2);
	}

	public Point midpoint(Point other) {
		double xm = (this.x + other.x) / 2;
		double ym = (this.y + other.y) / 2;
		Point mid = new Point(xm, ym);
		return mid;
	}

	public String toString() {
		return "Point: (" + x + ", " + y + ")";
	}

	public double getX() {
		return x;
	}
	
	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}
	
	public boolean equals(Point other) {
		return this.x == other.x && this.y == other.y;
	}
} 
