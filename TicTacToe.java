public class TicTacToe {
    public static char hat_gewonnen(char[][] board) {
        // Die methode holt die vorgegebene board am main, und pruft, ob er gewinner vorliegt,
        // indem welche char auf welchen Platz steht.
        // Es sind 5 möglich Position, die einen Gewinn erzeugen, können.
        // Es gibt aber jeweils 3 mögliche Position also ein 3x3 board
        for (int i=0; i<3; i++) {
            // Pruft erstmal Spalten und Zeilen
            if ((board[i][0] == board[i][1] && board[i][1] == board[i][2] || (board[0][i] == board[1][i] && board[1][i] == board[2][1]))) {
                //Falls eine volle Spalte oder Zeile gefunden wurde, holt irgendeiner char aus diesen Spalten/Zeilen
                return board[i][0];
            }
            // Pruft nun die Diagonale
            if ((board[0][0] == board[1][1] && board[1][1] == board[2][2] || (board[0][2] == board[1][1] && board[1][1] == board[2][0]))) {
                // Falls volle Diagonale gefunden, holt char aus der Mitte
                return board[1][1];
            }

        }
        //Falls kein von beiden eine Zeile, Spalte oder Diagonale voll hat, einfach Leerzeichen als char zuruckgeben
        return ' ';
    }

    public static void main(String[] args) {
        //Spielboard initialisieren
        char[][] board = {
                {'X', '0', ' '},
                {' ', 'X', ' '},
                {'O', ' ', 'X'},
        };
        //Initialisiert Variable, die der Gewinner nach Methodenruf speichert.
        //Es wird geprüft, ob in der oben angegebenen board, ein gewinner vorliegt.
        //WICHTIG IMMER ' ' BENUTZEN BEI CHAR!, SONST WIRD ALS STRING ERKANNT
        // Char dient um SINGLE character to speichern
        char winner = hat_gewonnen(board);
        if (winner == 'X') {
            System.out.println("X hat gewonnen.");
        } else if (winner == 'O'){
            System.out.println("O hat gewonnen.");
        } else {
            System.out.println("Kein Spieler hat bis jetzt gewonnen.");
        }
    }
}