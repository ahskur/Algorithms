// by LCP, BRAP
// 22.10.2023

public class HappyNumbers {
    public static boolean isHappy(int n) {
        // Initialisiert alle variablen, bzw summe, die am Anfang immer gleich 0 sein soll
        // und die Anzahl an Zyklen, die das programm laufen soll.
        // Falls die Anzahl überschritten wird, sofort abbrechen, weil der Wert nie fröhlich sein wird/wiederholt sich
        int iterations = 0;
        int sum = 0;
        // Schleife läuft, solange der angegebene Wert 1 ist, bis eine Lösung (fröhlich oder nicht) erreicht würde
        while (n > 0) {
            System.out.println(n);
            // Jedes Mal, das eine Ziffer getestet wird, 1 an die Anzahl an Zyklen addieren
            iterations++;
            // Hole letzte Ziffer von n (immer von rechts nach links z.B: 82 → Erst 2 wird angerechnet, dann 8)
            int ziffer = n % 10;
            System.out.println("Ziffer: " + ziffer);
            // Ziffer wird quadriert und summiert
            int quader = ziffer * ziffer;
            System.out.println("Quadriert: " + quader);
            sum = sum + quader;
            System.out.println("Summe: " + sum);
            // Falls die Summe gleich 1 ist, abbrechen und 'return true' → Zahl ist fröhlich.
            // Dabei muss aber aufgepasst werden: Falls die erste anzurechnen Ziffer '1' ist,
            // dann ist die Summe sofort eins und wird falschweise abgebrochen.
            // z.B: 81 → Ziffer '1' wird zuerst gelesen, quadriert und an var 'sum' addiert, d.h summe == 1, daher abbrechen.
            // Um das zu vermeiden, wird versucht die ganze Zahl 'n' durch '1' zu teilen. Falls es != 1 ist,
            // bedeutet, dass die Zahl nicht vollständig gelesen würde bzw. nicht alle Ziffer gefunden worden sind also nicht abbrechen.
            if (sum == 1 && n/1 == 1) return true;
            // Letzte Ziffer von n fällt Weg, weil sie schon quadriert und summiert würde
            n = n / 10;
            // Prüft, ob die Anzahl an maximale Zyklen erreicht würde,
            // wenn ja, abbrechen, weil die Summe sich unendlich wiederholt
            if (iterations > 13) return false;
            // Falls n = 0 ist, das bedeutet, dass alle Ziffern gefunden und summiert worden sind.
            // Setze dann n als die Werte der Summe, sodass die Summe getestet sein kann, bis Summe = 1 erreicht würde.
            // z.B: 19 → 82 → 68 → 100 → 1
            // Summe muss auch dabei wieder = 0 gesetzt werden,
            // sonst addieren sich die Ziffern der letzte Vorgang auch dazu
            if (n == 0) {
                n = sum;
                sum = 0;
            }
        }
        return false;
    }

    public static int nextHappyNumber(int n) {
        // Während Schleife läuft, immer +1 an 'n' addieren, sodass immer die nächste Zahl versucht wird
        while (true) {
            n++;
            // Dann neues 'n' testen, falls es fröhlich ist, wird die Schleife am main abgebrochen
            // und geprinted
            if (isHappy(n)) {
                return n;
            }
        }
    }

    public static void main(String[] args) {
        int n = 103;
        if (isHappy(n)) {
            System.out.println(n + " ist fröhlich.");
        } else {
            System.out.println(n + " ist traurig.");
            // Falls Zahl ist traurig, versuche die nächste Zahl zu finden, die fröhlich ist
            int next = nextHappyNumber(n);
            System.out.println("Die nächste fröhliche Zahl nach " + n + " ist " + next);
        }
        }
    }


