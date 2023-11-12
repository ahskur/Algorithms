import java.util.Random;

public class GameOfLife {
    private static int[][] initializeGrid(int size, double wahrscheinlichkeit) {
        /**
        @param size takes size of grid and wahrscheinlichkeit to create a starting board.
                                Grid is created using size * size
         @param wahrscheinlichkeit is used to see if cell is alive or dead at beginning of game
         @return grid A completed grid ready to start the game
         **/
        int[][] grid = new int[size][size];
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                // Attributes 1 for a living cell and 0 for dead cell
                // Generate a random double and compare to given wahrscheinlichkeit to see if ceel is alive
                // Do this for every single cell from board generated from size
                if (random.nextDouble() < wahrscheinlichkeit) {
                    grid[i][j] = 1;
                } else {
                    grid[i][j] = 0;
                }
            }
        }
        return grid;
    }

    private static int[][] nextGrid(int[][] grid) {
        /**
         * @param grid takes generated grid and looks to see if there are new cells or new dead cells
         * @return newGrid A new grid with updated dead or alvie cells
         */
        // Create new grid by taking size of old grid first
        int size = grid.length;
        int[][] nextGrid = new int[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                // Check each cell to see how many neigbors
                int liveNeighbors = countLiveNeighbors(grid);

                if (grid[i][j] == 1) {
                    if (liveNeighbors < 2 || liveNeighbors > 3) {
                        nextGrid[i][j] = 0; // Cell die
                    } else {
                        nextGrid[i][j] = 1; // Cell alive
                    }
                } else {
                    // Falls GENAU 3 nachbarn, zelle lebt wird also 1
                    if (liveNeighbors == 3) {
                        nextGrid[i][j] = 1;
                    }
                }
            }
        }
        return nextGrid;
    }

    private static int countLiveNeighbors(int[][] grid) {
        /**
         * Counts the number of neighbors around a cell
         * @param grid
         * @return menge Amount of neighbors of a cell
         */
        int size = grid.length;
        int menge = 0, zeile = 0, spalte = 0;

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                zeile += i;
                spalte += j;

                if (zeile >= 0 && zeile < size) {
                    if (spalte >= 0 && spalte < size) {
                        if (!(i == 0 && j == 0)) {
                            menge += grid[zeile][spalte];
                        }
                    }
                }
            }
        }
        return menge;
    }

    private static void printGrid(int[][] grid) {
        /**
         * Prints grid to the console displaying with row as a string
         *
         * @param grid
         */
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Bitte Grosse des Spielfelds und Wahrscheinlichkeit in Kommandozeile miteingeben.");
            System.exit(1);
        }
        int groesse = Integer.parseInt(args[0]);
        double wahrscheinlichkeit = Double.parseDouble(args[1]);

        int[][] grid = initializeGrid(groesse, wahrscheinlichkeit);

        System.out.println("Spielanfang:");
        printGrid(grid);

        // Runde = Wie lange soll das Spiel laufen
        int runde = 5;
        for (int i = 0; i < runde; i++) {
            grid = nextGrid(grid);
            System.out.println("\nRunde " + (i + 1));
            printGrid(grid);
        }
    }
}
