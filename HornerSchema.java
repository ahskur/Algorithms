import java.util.Arrays;

public class HornerSchema {
    public static double evalSimple(double[] a, double x) {
        double summe = 0;
        int multiplication = 0;

        for (int i = a.length - 1; i >= 0; i--) {
            // jeder neuee Term wird separat mit dem aktuellen Wert berechnet und dann zum ergebnis addiert
            summe = a[i] + x * summe;
            if (i > 0) {
                multiplication++;
            }
        }
        System.out.println("Es wurden " + multiplication + " mal multipliziert.");
        return summe;
    }
    public static double evalHorner(double[] a, double x) {
        double summe = 0;
        int multiplication = 0;
        // reduziert die Anzahl an multiplikationen, indem das ergebnis in einer einzigen Variablen addiert
        // und gleichzeitig aktualisiert wird
        for (int i = a.length - 1; i >= 0; i--) {
            summe = summe * x + a[i];
            if (i > 0) {
                multiplication++;
            }
        }
        System.out.println("Es wurden " + multiplication + " mal multipliziert.");
        return summe;
    }
    public static double evalHornerRec(double[] a, double x) {
        // Falls Array = 1, sofort abbrechen, weil keine Rekursion stattfinden kann
        if (a.length == 1) {
            return a[0];
        } else {
        // Erzeugt ein neues Array wo alle Elemente des ursprünglichen Arrays a von Index 1 bis a.length - 1 enthalten sind
        // Es wird also ein neues Array mit den verbleibenden Koeffizienten erstellt, nachdem der Term höchsten Grades weggeschlossen wird
                return a[0] + x * evalHornerRec(Arrays.copyOfRange(a, 1, a.length), x);
        }
    }

    public static void main(String[] args) {
        double[] a = {1,2,3,6,7,8,8,6,4,2,4};
        // Mehr als 30000 ergebnis wird zur "Infinity"?
        double x = 30000;

        long startTime, endTime;
        double simple, horner, hornerRec;

        // Zeit Messung für evalSimple
        startTime = System.currentTimeMillis();
        simple = evalSimple(a, x);
        endTime = System.currentTimeMillis();

        System.out.println("Evaluate mit Simple-Methode: " + simple);
        System.out.println("Zeit für Simple-Methode: " + (endTime - startTime) + " ms");

        System.out.println();

        // Zeit Messung für evalHorner
        startTime = System.currentTimeMillis();
        horner = evalHorner(a, x);
        endTime = System.currentTimeMillis();

        System.out.println("Evaluate mit Horner-Methode: " + horner);
        System.out.println("Zeit für Horner-Methode: " + (endTime - startTime) + " ms");

        System.out.println();

        // Zeit Messung für evalHornerRec
        startTime = System.currentTimeMillis();
        hornerRec = evalHornerRec(a, x);
        endTime = System.currentTimeMillis();

        System.out.println("Evaluate mit Horner-Methode: " + hornerRec);
        System.out.println("Zeit für Horner Rekursiv-Methode: " + (endTime - startTime) + " ms");
    }
}