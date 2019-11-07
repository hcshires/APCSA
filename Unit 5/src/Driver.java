import java.awt.Color;

public class Driver {

	public static void main(String[] args) {
		
		/* Examples of calling static methods */
		System.out.println(Math.random() * 100);
		System.out.println(Math.sqrt(75));
		System.out.println();
		
		/* Static methods can be called without a tie to an object */
		
		Car car1 = new Car(Color.RED, 2500, "Honda CRV");
		Car car2 = new Car(Color.BLUE, 2000, "Lamborghini Aventador");
		Car car3 = new Car(Color.GRAY, 4000, "Chevrolet Silverado");
		
		System.out.println(car1.getID() + "\n" + car2.getID() + "\n" + car3.getID());
		
		System.out.println(Car.distanceTraveled(70, 3));

	}

}
