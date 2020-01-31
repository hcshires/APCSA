
public class Elevens {

	public static void main(String[] args) {
		String[] ranks = {"A", "B", "C", "D"};
		String[] suits = {"King", "Queen", "Jack"}; 
		int[] values = {10, 9, 8, 7};
				
		Deck deck = new Deck(ranks, suits, values);
		System.out.println("The size of the deck is " + deck.size());
		deck.shuffle();
		
		System.out.println("Original Deck: " + deck + "\n");
		
		while (!deck.isEmpty()) {
			deck.deal();
			System.out.println(deck + "\n");
		}
		
		System.out.println("\n" + deck.size() + " card(s) remaining");
		System.out.println(deck);
		

	}

}
