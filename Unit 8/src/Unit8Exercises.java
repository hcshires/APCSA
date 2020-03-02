import java.util.Arrays;

public class Unit8Exercises {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	
		int randRows = (int)(Math.random()*7 + 3);
		int randCols = (int)(Math.random()*7 + 3);
		int[][] m1 = new int[randRows][randCols];
		fillArray(m1);
		printMatrix(m1);
		
		/* ************** blockSum tests ************* 		 */
		
		int randRow = (int)(Math.random() * (randRows-2) + 1);
		int randCol = (int)(Math.random() * (randCols-2) + 1);
		System.out.println("The blockSum of spot (" + randRow + ", " + randCol + ") is " + blockSum(m1, randRow, randCol));
		System.out.println("The blockSum of spot (" + 0 + ", " + randCol + ") is " + blockSum(m1, randRow, randCol));
		System.out.println("The blockSum of spot (" + randRow + ", " + 0 + ") is " + blockSum(m1, randRow, 0));
		System.out.println("The blockSum of spot (" + (randRows-1) + ", " + randCol + ") is " + blockSum(m1, randRows-1, randCol));
		System.out.println("The blockSum of spot (" + randRow + ", " + (randCols-1) + ") is " + blockSum(m1, randRow, randCols-1));
		System.out.println("The blockSum of spot (" + (randRows-1) + ", " + (randCols-1) + ") is " + blockSum(m1, randRows-1, randCols-1));
		
		/* ************* getColumn tests ********** - TESTED
		 
		int[][] m = {{1, 2, 3}, {4,5,6}, {7,8,9}};
		printMatrix(m);
		// test getColumn
		int[] col = getColumn(m, 0);
		System.out.println("The first column of the matrix is:");
		printArray(col);
		int[] col2 = getColumn(m, 2);
		System.out.println("The last column of the matrix is:");
		printArray(col2);
		System.out.println("\n\n");
		
		*/
		 

		/* ************ isLatin tests ************
		int[][] m2 = {{1, 2, 3}, {2,3,1}, {3,1,2}};
		printMatrix(m2);
		System.out.println("TEST: the matrix above IS " + (isLatin(m2) ? "": "NOT ") + "a Latin Sqaure (should be TRUE)");
		

		int[][] m3 = {{10, 30, 20, 0}, {0, 20, 30, 10}, {30, 0, 10, 20}, {20, 10, 0, 30}};
		printMatrix(m3);
		System.out.println("TEST: the matrix above IS " + (isLatin(m3) ? "": "NOT ") + "a Latin Sqaure (should be TRUE)");
		
		int[][] m4 = {{1, 2, 1}, {2,1,1}, {1,1,2}};
		printMatrix(m4);
		System.out.println("TEST: the matrix above IS " + (isLatin(m4) ? "": "NOT ") + "a Latin Sqaure (should be FALSE)");
		
		int[][] m5 = {{1, 2, 3}, {2, 5, 1}, {3,1,2}};
		printMatrix(m5);
		System.out.println("TEST: the matrix above IS " + (isLatin(m5) ? "": "NOT ") + "a Latin Sqaure (should be FALSE)");
		
		int[][] m6 = {{1, 2}, {1, 2}};
		printMatrix(m6);
		System.out.println("TEST: the matrix above IS " + (isLatin(m6) ? "": "NOT ") + "a Latin Sqaure (should be FALSE)");

		*/

	}
	
	public static int blockSum(int[][] matrix, int row, int col) {
		int sum = 0;
		for (int r = 0; r < matrix.length; r++) {
			for (int c = 0; c < matrix[0].length; c++) {
				if (Math.abs((r - row)) <= 1 && Math.abs(c - col) <= 1 && (r != row || c != col)) {
					sum += matrix[r][c];
				}
			}
		}

		return sum;
	}
	
	public static boolean isLatin(int[][] square) {
		return false;
	}
	
	/** Returns a specified column from a 2D Array
	 * 
	 * @param arr2D - the array to get the column from
	 * @param c - an integer holding the specified column
	 * @return int[] column - the column requested from the arr2D parameter
	 */
	public static int[] getColumn(int[][] arr2D, int c) {
		int[] column = new int[arr2D.length];
		for (int i = 0; i < arr2D.length; i++) {
			column[i] = arr2D[i][c];
		}
		
		return column;
	}
	
	public static void printArray(int[] row) {
		for (int x: row) {
			System.out.print(x + " ");
		}
		System.out.println();
	}

	public static void printMatrix(int[][] mat) {
		for (int[] row: mat) {
			printArray(row);
		}
	}
	
	
	
	public static boolean hasAllValues(int [] arr1, int[] arr2) {
		System.out.println();
		printArray(arr1);
		printArray(arr2);
		for (int i = 0; i < arr1.length; i++ ) {
			boolean found = false;
			for (int j = 0; j < arr2.length; j++) {
				if (arr1[i] == arr2[j]) found = true;
			}
			if (!found) {
				System.out.println("arr2 does not include " + arr1[i]);
				return false;

			}
		}
		return true;
	}
	
	public static boolean containsDuplicates(int[] arr) {
		for (int i = 0; i < arr.length; i++ ) {
			for (int j = i+1; j < arr.length; j++) {
				if (arr[i] == arr[j]) return true;
			}
		}
		return false;
		
	}
	
	public static void fillArray(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++ ) {
			for (int j = 0; j < matrix[0].length; j++ ) {
				matrix[i][j] = (int)(Math.random()*10);
			}
		}
	}
}
