package util;

import java.util.Scanner;

public class InputUtil {
    private static final Scanner scanner = ViewUtil.getScanner();

    public static String readName(String prompt) {
        while (true) {
            System.out.println(prompt);
            String input = scanner.nextLine().trim();

            if (ValidationUtil.isValidName(input)) {
                return input;
            }
            System.out.println("❌ Le nom est invalide (ex: Hamza ElKabraoui)");
        }
    }

    public static String readEmail(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();

            if (ValidationUtil.isValidEmail(input)) {
                return input.toLowerCase();
            }
            System.out.println("❌ Format d'email invalide (ex: exemple@domaine.com).");
        }
    }

    public static String readPassword(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine();

            if (ValidationUtil.isValidPassword(input)) {
                return input;
            }
            System.out.println("❌ Mot de passe trop faible (Min 8 caractères, 1 majuscule, 1 minuscule, 1 chiffre).");
        }
    }

    public static String readPhone(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine();

            if (ValidationUtil.isValidPhone(input)) {
                return input;
            }
            System.out.println("❌ Numéro de téléphone invalide (ex: 0612345678 ou +212612345678).");
        }
    }

    public static void emptyInput(String prompt) {
        while (true) {
            System.out.println(prompt);
            String input = scanner.nextLine();

            if (input.isBlank()) {
                return;
            }
            System.out.println("❌ Press Enter please.");
        }
    }
}
