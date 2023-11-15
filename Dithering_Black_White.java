import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.Color;
import java.io.File;
import java.io.IOException;

public class Dithering_Black_White {

    // Define the Grayscale characters and thresholds
    private static final char[] Graustufe = {' ', '░', '▒', '▓', '■'};
    private static final int GraustufeLen = Graustufe.length;

    private static void readImage(int GraustufeLen, char[] Graustufe, boolean reverseOrder, String path) {
        BufferedImage img = null;

        try {
            // Try to get image, if format is wrong or can't be read throw exception and exit
            img = ImageIO.read(new File(path));
        } catch (IOException e) {
            System.err.println("Fehler: " + e);
            System.exit(-1);
        }

        int m = img.getHeight();
        int n = img.getWidth();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int value = img.getRGB(j, i);

                Color c = new Color(value);
                int r, g, b;
                r = c.getRed();
                g = c.getGreen();
                b = c.getBlue();

                double rr = r / 255.0;
                double gg = g / 255.0;
                double bb = b / 255.0;

                // Set the 'weight' of each color when creating the gray color for substitution
                double gray = 0.30*rr + 0.59*gg + 0.11*bb;
                // Subtract the smallest possible amount from gray using ulp(1.0) so white can be true white
                int CharIndex = (int)((GraustufeLen) * (gray-Math.ulp(1.0)));

                if (reverseOrder) {
                    // Reverse the order of character mapping
                    CharIndex = GraustufeLen - 1 - CharIndex;
                }
                System.out.print(Graustufe[CharIndex]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // Check if any command line argument was given
        if (args.length != 1) {
            System.out.println("Bitte Weg zum Bild eingeben");
            System.exit(1);
        }
        String path = args[0];
        // Choose whether to print white on black or black on white
        boolean reverseOrder = true; // Set to true for black on white

        readImage(GraustufeLen, Graustufe, reverseOrder, path);
    }
}
