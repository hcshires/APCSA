
public class Mountain {
	
	public static boolean isIncreasing(int[] array, int stop) { /* implementation not shown */ return false; }
	
	public static boolean isDecreasing(int[] array, int start) { /* implementation not shown */ return false; }
	
	public static int getPeakIndex(int[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			if (array[i] > array[i + 1] && array[i - 1] < array[i]) {
				return i;
			}
		}
		return -1;
	}
	
	public static boolean isMountain(int [] array) {
		return false;
	}
}
c