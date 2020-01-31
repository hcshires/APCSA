
public class Card {
	private String rank;
	private String suit;
	private int value;

	public Card(String rank, String suit, int value) {
		this.rank = rank;
		this.suit = suit;
		this.value = value;
	}
	
	public String getRank() {
		return rank;
	}
	
	public String getSuit() {
		return suit;
	}
	
	public int getValue() {
		return value;
	}
	
	public boolean matches(Card other) {
		return this.suit.equals(other.suit) && this.rank.equals(other.rank) && this.value == other.value;
	} 
	
	public String toString() {
		return "[" + rank + ", " + suit + ", " + value + "]";
	}
}
