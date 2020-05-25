package Sample2020;

public class Hailstone {

    /* Part A */
    public static int hailstoneLength(int n) {
        int num = n;
        int length = 1;
        while (num > 1) {
            if (num % 2 == 0) {
                num /= 2;
            } else {
                num += (3 * num) + 1;
            }
            length++;
        }

        return length;
    }

    public static boolean isLongSeq(int n) {
        return false;
    }

    /* Part B */

    /*
        public static double propLong(int n)
        I need to use hailstoneLength and isLongSeq when implementing the propLong method as well as a local variable, a double type,
        to store the amount of long sequences and then divide by the number of sequences checked. First, I need to find the lengths
        of the hailstone series' using a for loop iterating from 1 to the int parameter n and the method hailstoneLength. Then for
        each length, I will use the result of isLongSeq for each number n and then add 1 to the value of the double variable if
        isLongSeq returns true. Finally, I will divide the double by n and return the result.
     */
}
