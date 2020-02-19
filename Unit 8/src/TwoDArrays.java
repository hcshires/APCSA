
public class TwoDArrays {

	public static void main(String[] args) {
		
		int[][] twoD = new int[5][10];
		int r = 5;
		int c = 10;
		
		for (int i = 0; i < r; i++) {
			int sum = 0;
			for (int j = 0; j < c; j++) {
				twoD[i][j] = (int)(Math.random() * 10);
				sum += twoD[i][j];
				System.out.print("[" + twoD[i][j] + "]");
				
			}
			System.out.print(" Sum of Row " + i + ": " + sum);
			System.out.println(" ");
		}

	}

}
