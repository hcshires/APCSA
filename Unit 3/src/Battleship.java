
public class Battleship {
	private String name;
	private int power;
	private int health;
	
	public Battleship(String type, int pow) {
		name = type;
		power = pow;
		health = 100;
	}
	
	public int getPower() {
		return power;
	}
	
	public void isAttacked(int attackDamage) {
		if (attackDamage < 4) {
			health -= 3;
		}
		else if (attackDamage < 8) {
			health -= 5;
		}
		else {
			health -= 7;
		}
	}
	
	public boolean stillFloating() {
		return health > 0;
	}
	
	// Returns name and health
	public String toString() {
		return "Ship Name: " + name + " (" + health + ")";
	}
}
