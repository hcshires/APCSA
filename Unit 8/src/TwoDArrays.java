
public class TwoDArrays {

	public static void main(String[] args) {
		
		// declare a 2D array
		int row = 5;
		int column = 10;
		
		int[][] twoD = new int[row][column];
		
		for (int i = 0; i < row; i++) {
			int sum = 0;
			for (int j = 0; j < column; j++) {
				twoD[i][j] = (int)(Math.random() * 90 + 10);
				sum += twoD[i][j];
				System.out.print("[" + twoD[i][j] + "]");
				
			}
			System.out.print(" Sum of Row " + i + ": " + sum);
			System.out.println(" ");
		}
		
		// access the 3rd item in the 4th row
		System.out.println(twoD[2][3]);
		
		// enhanced for loop
		for (int[] r : twoD) {
			int sum = 0;
			for (int val: r) {
				sum += val;
			}
			
			System.out.println("Average sum: " + (double)sum / r.length);
		}
		
		// how to traverse column-by-column, aka column-major oder (can't use an enhanced for)
		for (int j = 0; j < twoD[0].length; j++) { // row
			for (int i = 0; i < twoD.length; i++) { // column
				System.out.print(twoD[i][j] + " "); // [i] is changing the row
			}
			System.out.println();
		}
	}

}
