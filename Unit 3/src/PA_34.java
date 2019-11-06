
public class PA_34 {

	public static void main(String[] args) {
		Battleship sub = new Battleship("Sub", 5);
		Battleship carrier = new Battleship("Aircraft Carrier", 3);
		Battleship destroyer = new Battleship("Destroyer", 10);
		
		System.out.println("New foes have appeared!");
		
		System.out.println(sub);
		System.out.println("Sub has power " + sub.getPower());	
		
		System.out.println("\n" + destroyer);
		System.out.println("Destroyer has power " + destroyer.getPower());
		
		System.out.println("\n" + carrier);
		System.out.println("Aircraft Carrier has power " + carrier.getPower());
		
		
		destroyer.isAttacked(sub.getPower());
		System.out.println("\nDestroyer " + "has been attacked by Sub!");
		System.out.println(destroyer);
		
		sub.isAttacked(carrier.getPower());
		System.out.println("\nSub " + "has been attacked by Carrier!");
		System.out.println(sub);
		
		carrier.isAttacked(destroyer.getPower());
		System.out.println("\nAircraft Carrier " + "has been attacked by Destroyer!");
		System.out.println(carrier);
	}
}
