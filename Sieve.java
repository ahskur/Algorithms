import java.util.ArrayList;
import java.util.Scanner;

public class Sieve {
    public static ArrayList Sieve(Scanner n) {
        if (n.hasNextInt()) {
            // Nun hol die Eingabe und speichert als integer auf nummer
            int nummer = Integer.parseInt(n.nextLine());
            ArrayList<Integer> nummer_liste = new ArrayList<>();
            // Starte immer mit 2, weil 0 ist 0 also nicht teilbar, und 1 kein Prim ist
            int anfang = 2;
            // Schleife, die immer +1 an 'anfang' summiert und checkt nochmal, ob Nummer Prim ist
            // läuft, solange eingegebene Nummer nicht erreicht wurde
            while (anfang <= nummer) {
                // Falls Nummer Prim ist, also nicht sauber durch 2 teilbar ist, in einer Liste hinfügen
                if (istPrim(anfang)) {
                    nummer_liste.add(anfang);
                }
                anfang++;
            }
                System.out.println(nummer_liste);
                return nummer_liste;
            }
        return null;
    }

    public static boolean istPrim(int testnummer) {
        // Initialisiert neue Var, um die Anzahl an Vorgänge zu rechnen
        int i = 2;
        for (; i <= testnummer / 2; i++) {
            if ((testnummer % i) == 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        // Erzeug Scanner um User Input zu nehmen - In diesem Fall nummer_eingabe
        Scanner nummer_eingabe = new Scanner(System.in);
        System.out.println("Bitte Nummer eingeben:");
        Sieve(nummer_eingabe);
        }
    }

