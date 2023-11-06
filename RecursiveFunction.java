public class RecursiveFunction {
    // PSEUDOCODE
    // Wenn/Falls y gleich 0 ist, gibt die Funktion x zurück
    // Sonst macht beide Werte -1 und ruft die Funktion nochmal, um zu prüfen ob y nun = 0 ist.

    // if y = 0 then x
    //else f(x-1, y-1)
    //fi

    // ^ das terminiert aber nie, falls ein y < 0 gegeben wird

    public static int rec(int x, int y) {
        if (y == 0) {
            return x;
            // Falls y < 0, summiert um 1 bis es null wird und return x
            // Falls y > 0, subtrahiert -1, bis y == 0 und return x
        } else if (y < 0) {
            while (y < 0) {
                x++;
                y++;
            }
            return x;
        } else {
            return rec(x - 1, y - 1);
        }
    }
    public static int iter(int x, int y) {
        if (y < 0) {
            while (y < 0) {
                x++;
                y++;
            }
        }
        while (y > 0) {
            x--;
            y--;
        }
        return x;
    }

    public static void main(String[] args) {
        int x = 454;
        int y = -88;
        System.out.println("Rekursion: " +rec(x,y));
        System.out.println("Iterativ: " + iter(x,y));
    }
}