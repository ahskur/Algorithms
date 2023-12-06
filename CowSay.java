import java.util.Random;

public class CowSay {

    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_YELLOW = "\u001B[33m";
    private static final String ANSI_BLUE = "\u001B[34m";
    private static final String ANSI_PURPLE = "\u001B[35m";
    private static final String ANSI_CYAN = "\u001B[36m";

    public static void main(String[] args) {
        String text = "Hallo Welt UwU!";
        int width = 40;
        String eyes = "oo";
        boolean tongueOut = false;
        String customEyes = null;
        String colorCode = ANSI_RESET;

        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "-s":
                    eyes = "**";
                    tongueOut = true;
                    break;
                case "-W":
                    width = Integer.parseInt(args[++i]);
                    break;
                case "-b":
                    eyes = "==";
                    break;
                case "-t":
                    eyes = "--";
                    break;
                case "-d":
                    eyes = "xx";
                    tongueOut = true;
                    break;
                case "-g":
                    eyes = "$$";
                    break;
                case "-p":
                    eyes = "@@";
                    break;
                case "-w":
                    eyes = "00";
                    break;
                case "-y":
                    eyes = "..";
                    break;
                case "-e":
                    if (i + 1 < args.length) {
                        customEyes = args[++i];
                    }
                    break;
                case "-T":
                    tongueOut = true;
                    break;
                case "--random-color":
                    colorCode = getRandomColorCode();
                    break;
                default:
                    break;
            }
        }

        // Override the eyes with customEyes if provided
        if (customEyes != null) {
            eyes = customEyes;
        }

        String cowSays = buildCowSpeech(text, width, eyes, tongueOut, colorCode);
        System.out.println(cowSays);
    }

    private static String buildCowSpeech(String text, int width, String eyes, boolean tongueOut, String colorCode) {
        StringBuilder result = new StringBuilder();
        int lineLength = width - 4; // padding for box and eyes

        result.append(" ");
        result.append(" _______\n");
        result.append("/ ").append(text).append(" \\\n");
        result.append("\\ ").append(" ".repeat(Math.max(0, text.length()))).append(" /\n");
        result.append(" ");
        result.append("-".repeat(Math.max(0, width + 2))).append("\n");

        // Customize the cow/horse face
        String cowFace = " ";

        if (tongueOut) {
            cowFace += "U ";
        }
        cowFace += "(" + colorCode + eyes + ANSI_RESET + ")";

        result.append(cowFace).append("\n");
        result.append(" ".repeat(Math.max(0, width - 7))).append("\\   ^__^\n");
        result.append(" ".repeat(Math.max(0, width - 7))).append(" \\  (").append(eyes).append(")\\_______\n");
        result.append(" ".repeat(Math.max(0, width - 7))).append("    (__)\\       )\\/\\\n");
        result.append(" ".repeat(Math.max(0, width - 7))).append("        ||----w |\n");
        result.append(" ".repeat(Math.max(0, width - 7))).append("        ||     ||");

        return result.toString();
    }
    private static String getRandomColorCode() {
        String[] colorCodes = {ANSI_RED, ANSI_GREEN, ANSI_YELLOW, ANSI_BLUE, ANSI_PURPLE, ANSI_CYAN};
        return colorCodes[new Random().nextInt(colorCodes.length)];
    }
}
