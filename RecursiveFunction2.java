public class RecursiveFunction2 {

    public static int marge(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n - homer(marge(n-1));
        }
    }

    public static int homer(int n) {
        if (n == 0) {
            return 0;
        } else {
            return n - marge(homer(n - 1));
        }
    }

    public static boolean dispute(int n) {
            return !(marge(n) == homer(n));
    }

    public static int[] differenceDisputes(int x){
    return null;
    }

    public static void main(String[] args) {
        int testJahr = 15;

        int[] differences = differenceDisputes(testJahr);

        for (int i = 0; i < differences.length; i++) {
            System.out.println("Jahr " + i + ": " + differences[i]);
            }

        // Ob in einem bestimmten Jahr was passiert
        if (testJahr < differences.length && differences[testJahr] == 1) {
            System.out.println("Ja, es gibt streit im Jahr " + testJahr);
        } else {
            System.out.println("Kein Streit im Jahr " + testJahr);
        }

    }
    }

