import java.util.ArrayList;

public class Deck {
	private ArrayList<Card> deck = new ArrayList<Card>();
	private int cardIndex;
	
	public Deck(String[] ranks, String[] suits, int[] values) {
		for (String s : suits) {
			for (int i = 0; i < ranks.length; i++) {
				deck.add(new Card(ranks[i], s, values[i]));
			}
		}
		cardIndex = 0;
	}
	
	public boolean isEmpty() {
		return cardIndex == deck.size();
	}
	
	public int size() {
		return deck.size() - cardIndex;
	}
	
	public void shuffle() {
		for (int i = 0; i < deck.size() * 100; i++) {
			int index1 = (int)(Math.random() * deck.size());
			int index2 = (int)(Math.random() * deck.size());
			
			Card currentCard = deck.get(index1);
			Card temp = deck.get(index2);
			
			deck.set(index2, currentCard);
			deck.set(index1, temp);
		}
	}
	
	public Card deal() {
		Card deal = deck.get(cardIndex);
		cardIndex++;
		return deal;
	}
	
	public String toString() {
		String undealt = "";
		String dealt = "";
		int counter = 0;
		for (int i = cardIndex; i < deck.size(); i++) {
			if (counter % 3 == 0) {
				undealt += "\n";
			}
			undealt += deck.get(i) + " ";
			counter++;
				

		}
		
		for (int i = 0; i < cardIndex; i++) {
			if (i % 3 == 0) {
				dealt += "\n";
			}
			dealt += deck.get(i) + " ";
		}
		return "Undealt: " + undealt + "\nDealt: " + dealt;
	}
}
