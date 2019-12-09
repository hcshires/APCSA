public class Vocab {
	
	/** 
	 * The controlled vocabulary for a Vocab object. 
	 */
	public static void main(String[] args) {
		Vocab v = new Vocab();
		System.out.println(v.findWord("body")); // Returns true
		System.out.println(v.findWord("thing")); // Returns false
		
		String[] otherWords = { "header", "body", "test", "a", "ppop", "div", "b", "class", "p", "LOL" };
		
		System.out.println(v.countNotInVocab(otherWords));
	}
	
	private String[] theVocab = { "html", "header", "body", "footer", "a", "i", "div", "b", "class", "p", "span" };
	
	/** 
	 * Searches for a string in theVocab. 
	 * Returns true if its String parameter str is an exact match to an element in 
	 * theVocab and returns false otherwise. 
	 */
	public boolean findWord(String str){
		for (String s : theVocab) {
			if (s.equals(str)) {
				return true;
			}
		}
		return false;
	}
	
	/** 
	 * Counts how many strings in wordArray are not found in theVocab, as described in part (a). 
	 */
	public int countNotInVocab(String[] wordArray){
		int count = 0;
		for (String s : wordArray) {
			if (!this.findWord(s)) {
				count++;
			}
		}
		return count;
	}
	
	/** 
	 * Returns an array containing strings from wordArray not found in theVocab, as described in part (b). 
	 */
	public String[] notInVocab(String[] wordArray){
		String [] strs = new String[wordArray.length];
		for (String s : wordArray) {
			
		}
		return new String[1];
	}
}

