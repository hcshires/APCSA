
public class WordGame {
	private String word;
	private int half;
	
	public WordGame(String string) {
		word = string;
		half = word.length() / 2;
	}
	
	public String scramble() {
		String firstHalf = word.substring(0, half + 1);
		String secondHalf = word.substring(half + 1);
		
		return secondHalf + firstHalf;
	}
	
	public String bananaSplit(int insertIdx, String insertText) {
		String firstHalf = word.substring(0, insertIdx);
		String secondHalf = word.substring(insertIdx);
		
		return firstHalf + insertText + secondHalf;
	}
	
	public String bananaSplit(String insertChar, String insertText) {
		int index = word.indexOf(insertChar);
		String firstHalf = word.substring(0, index);
		String secondHalf = word.substring(index);
		
		return firstHalf + insertText + secondHalf;
	}
	
	public String toString() {
		return "[" + word + "]";
	}
}
