import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.Color;
import java.io.File;
import java.io.IOException;

public class Dithering_with_Floyd {

    // This array can be altered to make different types of images
    private static final char Graustufe[] = "$@B%8&WM#*oahkbdpqwmZO0QLCJUYXzcvunxrjft/|()1{}[]?-_+~<>i!lI;:,\"^`'. ".toCharArray();
    private static final int GraustufeLen = Graustufe.length;

    public static void readImage(int GraustufeLen, char[] Graustufe, String path) {
        BufferedImage img = null;

        try {
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

                // Calculate grayscale value using a weighted sum
                double gray = 0.30 * r + 0.59 * g + 0.11 * b;

                // Find the closest character based on the grayscale value
                int CharIndex = (int) ((GraustufeLen - 1) * (gray / 255.0));
                char selectedChar = Graustufe[CharIndex];

                System.out.print(selectedChar);

                // Calculate the error
                double error = gray - CharIndex * (255.0 / (GraustufeLen - 1));

                // Apply Floyd-Steinberg dithering to the neighboring pixels
                if (j + 1 < n) {
                    adjustPixel(img, j + 1, i, error, 7.0 / 16.0);
                }
                if (i + 1 < m) {
                    if (j > 0) {
                        adjustPixel(img, j - 1, i + 1, error, 3.0 / 16.0);
                    }
                    adjustPixel(img, j, i + 1, error, 5.0 / 16.0);
                    if (j + 1 < n) {
                        adjustPixel(img, j + 1, i + 1, error, 1.0 / 16.0);
                    }
                }
            }
            System.out.println();
        }
    }

    public static void adjustPixel(BufferedImage img, int x, int y, double error, double factor) {
        Color c = new Color(img.getRGB(x, y));
        int r = c.getRed();
        int g = c.getGreen();
        int b = c.getBlue();

        r = (int) (r + error * factor);
        g = (int) (g + error * factor);
        b = (int) (b + error * factor);

        r = Math.min(255, Math.max(0, r));
        g = Math.min(255, Math.max(0, g));
        b = Math.min(255, Math.max(0, b));

        img.setRGB(x, y, new Color(r, g, b).getRGB());
    }

    public static void main(String[] args) {
        // Check if any command line argument was given
        if (args.length != 1) {
            System.out.println("Bitte Weg zum Bild eingeben");
            System.exit(1);
        }
        String path = args[0];
        readImage(GraustufeLen, Graustufe, path);
        // Exit after program run once
        System.exit(0);
    }
}
