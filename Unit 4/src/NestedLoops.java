
public class NestedLoops {

	public static void main(String[] args) {

		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 5; j++) {
				// System.out.println(i + " " + j);
			}
		}

		int count = 0;
		for (int x = 8; x >= 0; x--) {
			for (int y = x; y < 10; y++) {
				// System.out.println(x + " " + y);
				count++;
			}
		}

		System.out.println(count);

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if ((i + j) % 2 == 0) {
					// System.out.print("@");
				} else {
					// System.out.print("*");
				}
			}
			// System.out.println(); // new line
		}

		int p = 10;
		String word = "persnickety";

		while (p > 0) {
			int q = 0;
			while (q < word.length()) {
				if (word.substring(q, q + 1).compareTo("m") < 0) {
					System.out.println(word.substring(q, q + 1));
					p--;
				}
				q++;
			}
		}
	}
}