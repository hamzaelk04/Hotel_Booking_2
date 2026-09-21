package Util;

import java.util.Scanner;

public class ViewUtil {
    private static final Scanner scanner = new Scanner(System.in);

    public static Scanner getScanner() { return scanner; }

    public static void printHeader() {
        System.out.println("========================\n");
        System.out.println("     HOTEL BOOKING   \n");
        System.out.println("========================\n");
    }

    public static int readIntChoice() {
        while (true) {
            String line = scanner.nextLine().trim();
            try {
                return Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.\n");
            }
        }
    }

    public static void waitForBackOrExit() {
        while (true) {
            System.out.println("1. Back to menu");
            System.out.println("0. Exit");
            int choice = readIntChoice();

            if (choice == 1) {
                return;
            }

            if (choice == 0) {
                System.out.println("Goodbye!");
                System.exit(0);
            }

            System.out.println("Invalid choice!\n");
        }
    }
}
