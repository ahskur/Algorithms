import java.util.Arrays;

public class DifferentialPolynom {

    public static double[] diffPoly(double[] coeffs) {
        int n = coeffs.length;

        // Falls Länge der Polynom 1 ist, es ist eine konstante Funktion daher 0
        if (n == 1) {
            coeffs[0] = 0;
        }
        // "Ableitung" einzelnen Werten
        for (int i = 1; i < n; i++) {
            coeffs[i - 1] = i * coeffs[i];
        }
        return coeffs = Arrays.copyOfRange(coeffs, 0, n - 1);
    }

    public static void main(String[] args) {
        // Hier Funktion eingeben z.B 1 + x^2 + x^3 IMMER LINKS NACH RECHTS!
        double[] funktion = {1, 2, 3};
        diffPoly(funktion);
    }
}


