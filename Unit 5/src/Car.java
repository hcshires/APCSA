import java.awt.Color;

public class Car {

	private Color color;
	private double weight;
	private String model;
	private int id;
	
	/* A static variable is also called a class variable
	 * because all objects of the class share it.
	 * Object have their own instance variables, but a
	 * static variable is shared by all.
	 */
	private static int counter = 1; // CLASS variable, not an INSTANCE variable
	// private final static int wheelCount = 4;

	public Car(Color color, double weight, String model) {
		this.color = color;
		this.weight = weight;
		this.model = model;
		id = counter;
		counter++;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}
	
	public int getID() { 
		return id;
	}
	
	public static double distanceTraveled(int speed, int time) {
		/* This static method is shared by the class.
		 * You CANNOT reference any specific instance variables here,
		 * like color, weight, etc.
		 */
		System.out.println("We have made " + (counter - 1) + " cars.");
		return speed * time;
	}
}
