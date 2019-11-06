
public class Lesson_13 {

	public static void main(String[] args) {
		/* Problem 1 */
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.print("1");
			}
			System.out.println(" ");
		}
		
		/* Problem 2 */
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.print(j+1);
			}
			System.out.println(" ");
		}
		
		/* Problem 3 */
		for (int i = 1; i < 6; i++) {
			for (int x = 0; x < 4; x++) {
				System.out.print(i*(x+1) + " ");
			}
			System.out.println(" ");
		}
		
		/* Problem 4 */
		for (int i = 1; i < 4; i++) {
			for (int x = 1; x < 5; x++) {
				System.out.print("("+ i + "," + x + ")");
			}
			System.out.println(" ");
		}
		
		/* Problem 5 */
		for (int i = 0; i < 6; i++) {
			for (int j = 20; j < 26; j++) {
				System.out.print(j + i + " ");
			}
			System.out.println(" ");
		}
		
		/* Problem 6 */
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < i+1; j++) {
				System.out.print("*");
			}
			System.out.println(" ");
		}
		
		/* Problem 7 */
		for (int i = 0; i < 6; i++) {
			for (int x = 6; x > i; x--) {
				System.out.print("*");
			}
			System.out.println(" ");
		}
		
		/* Problem 8 */
		for (int i = 0; i < 5; i++) {
				for (int z = 0; z < i ; z++) {
					System.out.print("A");
				}
				for (int j = 5; j > i; j--){
					System.out.print("B");
				}
			System.out.println();
		}
	}

}
