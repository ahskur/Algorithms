import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.Color;
import java.io.File;
import java.io.IOException;

public class Dithering {
    private static void readImage(int GraustufeLen, char[] Graustufe, String path) {
        /**
         *@param readImage uses length of Grayscale array, the array itself and image path given from command line
         *                 to read each pixel contained in the image and transform the color from RGB to one in the grayscale array given
         *                 Grayscale can be edited to obtain different types of images
         *@return Transformed Image
         **/
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
                int value = img.getRGB(i, j);

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
                int CharIndex = (int)((GraustufeLen-1) * (gray));
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
        // This array can be altered to make different types of images
        char Graustufe[] = "$@B%8&WM#*oahkbdpqwmZO0QLCJUYXzcvunxrjft/|()1{}[]?-_+~<>i!lI;:,\"^`'. ".toCharArray();
        int GraustufeLen = Graustufe.length;
        readImage(GraustufeLen,Graustufe, path);
        // Exit after program run once
        System.exit(0);
    }
}