public class Encryption {
    /**
     * Hol aus der Kommandozeile welche Verschlüsselungsmethode eingesetzt wird
     * @param args Falls mehr als 3 in der CLI eingegeben wurden, hole return den index 1 sonst wird zur dafault rot13
     */
    private static String getEncryptionType(String[] args) {
        if (args.length >= 3) {
            // If there is 3 arguments, then index 1 should be the type 13 or 6
            return args[1].toLowerCase();
        } else {
            return "rot13";
        }
    }

    /**
     * Dient um die Buchstaben eines String entweder um 13 oder um 6 nach vorne zu ziehen, z.B aus "a" wird "m" usw.
     * @param s
     * @param encryptionType Entweder rot13 or rot6
     */
    private static void encrypt(String s, String encryptionType) {
        if (encryptionType.equals("rot13")) {
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if       (c >= 'a' && c <= 'm') c += 13;
                else if  (c >= 'A' && c <= 'M') c += 13;
                else if  (c >= 'n' && c <= 'z') c -= 13;
                else if  (c >= 'N' && c <= 'Z') c -= 13;
                System.out.print(c);
            }
            // Rot6 schiebt die Buchstaben um 6 nach vorne, aus "a" wird "f" z.B
        } else if (encryptionType.equals("rot6")) {
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if       (c >= 'a' && c <= 'f') c += 6;
                else if  (c >= 'A' && c <= 'F') c += 6;
                else if  (c >= 'g' && c <= 'z') c -= 6;
                else if  (c >= 'G' && c <= 'Z') c -= 6;
                System.out.print(c);
                }

        } else {
            System.out.println("Invalid encryption. Please use 'rot13' or 'rot6'.");
            return;
        }
        System.out.println();
    }
    /**
     * Dient um die funktion encrypt mit anderen parameter aufrufen
     * @param s String von commando zeile argument
     * @param encryptionType Entweder encrypt oder decryptr
     **/
    private static void decrypt(String s, String encryptionType) {
        encrypt(s, encryptionType);
    }


    public static void main(String[] args) {
        try {
            // Operation sollte die Methode encrypt oder decrypt aus der Kommandozeile bekommen
            String operation = args[0].toLowerCase();
            // args[2] sollte den text sein
            String text = args[2];
            String encryptionType = getEncryptionType(args);

            if (operation.equals("encrypt")) {
                encrypt(text, encryptionType);
            } else if (operation.equals("decrypt")) {
                decrypt(text, encryptionType);
            } else {
                System.out.println("Please specify 'encrypt' or 'decrypt'.");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Please provide a operation (encrypt/decrypt), type(rot13 or rot6), and a text.");
        }
    }
}
