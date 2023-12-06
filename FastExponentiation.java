/********************************************************
 Da n = 13 ungerade ist, f(2) = 2 * (2)^12 = 8192
 ********************************************************/

public class FastExponentiation {
    private static int recursive = 0;
    private static int iterations = 0;
    public static double fastPotRek(double x, int n) {
        recursive++;
        if (n == 0) {
            return 1;
        } else if (n % 2 == 0) {
            double wert = fastPotRek(x, n / 2);
            return wert * wert;
        } else {
            return x * fastPotRek(x, n - 1);
        }
    }

    public static double fastPotIter(double x, int n) {
        double result = 1;
        while (n > 0) {
            iterations++;
            if (n % 2 == 1) {
                result *= x;
            }
            x *= x;
            n /= 2;
        }
        return result;
    }

    public static void main(String[] args) {

        double resultRek = fastPotRek(2, 13);
        System.out.println("Rekursiv Ergebnis: " + resultRek);
        System.out.println("Rekursive Aufrufe: " + recursive);

        double resultIter = fastPotIter(2, 13);
        System.out.println("Iterativ Ergebnis: " + resultIter);
        System.out.println("Iterative Aufrufe: " + iterations);
    }
}