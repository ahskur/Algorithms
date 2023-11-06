import java.util.Random;

public class PrimeTwins {
    public static int[][] primeTwins(int amount) {
        // Initialisiert integer array mit amount und 2
        int[][] primeTwins = new int[amount][2];
        // Initialisiert der random number generator
        Random random = new Random();

        for (int i = 0; i < amount; i++) {
            // Testet für jede random generierte Nummer, ob der Paar prim ist und erhöht die Menge
            // an Iterationen um 1, bis die gewünschte Menge getestet würde
            int num = random.nextInt(100);
            while (!istPrim(num) || !istPrim(num + 2)) {
                num = random.nextInt(100);
            }
            primeTwins[i][0] = num;
            primeTwins[i][1] = num + 2;
        }
        return primeTwins;
    }
    public static boolean istPrim(int testnummer) {
        if (testnummer <= 1) {
            return false;
        }
        // Initialisiert neue Var, um die Anzahl an Vorgänge zu rechnen
        int i = 2;
        for (; i <= testnummer / 2; i++) {
            if ((testnummer % i) == 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int amount = 10; // Testnummer(Anzahl an gewünschten Primzahlpaare) eingeben
        // Speichert das Ergebnis in einen int array
        int[][] result = primeTwins(amount);

        System.out.println("Primzahlzwillinge sind: ");
        // Liefert alle mögliche Paare, bis die gewünschte Menge (amount) erreicht würde
        for (int i = 0; i < amount; i++) {
            System.out.println(result[i][0] + " und " + result[i][1]);
        }
    }
}
