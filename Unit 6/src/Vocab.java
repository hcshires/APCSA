public class Vocab {
	
	/** 
	 * The controlled vocabulary for a Vocab object. 
	 */
	public static void main(String[] args) {
		Vocab v = new Vocab();
		System.out.println(v.findWord("body")); // Returns true
		System.out.println(v.findWord("thing")); // Returns false
		
		String[] otherWords = { "header", "body", "test", "a", "pop", "div", "b", "class", "p", "LOL" };
		String[] badWords = v.notInVocab(otherWords);
		
		System.out.println(v.countNotInVocab(otherWords));
		
		for (String s : badWords) {
			System.out.println(s);
		}
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
		int count = this.countNotInVocab(wordArray);
		String [] strs = new String[count];
		
		for (String s : wordArray) {
			if (!this.findWord(s)) {
				count--;
				strs[count] = s;
			}
		}
		
		return strs;
	}
}

