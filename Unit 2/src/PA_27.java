
public class PA_27 {

	public static void main(String[] args) {
		System.out.println("Hello World!");
		
		WordGame word = new WordGame("apple");
		System.out.println(word.scramble());
		System.out.println(word.bananaSplit(3, "LOL"));
		System.out.println(word.bananaSplit("l", "Epic"));
		System.out.println(word);
	}
}
