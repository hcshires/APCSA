package Sample2020;

public class CheckDigit {

    public static int getCheck(int num) {
        return 0;
    }

    public static boolean isValid(int numWithCheckDigit) {

        return getCheck(numWithCheckDigit) == numWithCheckDigit % 10;
    }
}
