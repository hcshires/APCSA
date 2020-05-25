public class RecursionNotes {

    public static void main(String[] args) {
        printVals(4);
        System.out.println(Fibonacci(7));
        System.out.println(calcFactorial(5));
    }

    public static void printVals(int n) {
        if (n > 0) {
            printVals(n - 1);
            System.out.println(n);
        }
    }

    public static int Fibonacci(int n) {
        if (n == 1 || n == 2) return 1;
        return Fibonacci(n - 1) + Fibonacci(n - 2);
    }

    public static int calcFactorial(int x)
    {
        // Write a base case
        if (x == 1) return 1;

        // Call the simplified solution
        return x * calcFactorial(x - 1);
    }
}
