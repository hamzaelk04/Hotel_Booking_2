package View.Main;

import Util.ViewUtil;

public class MainView {
    public static void displayMainView() {
        while (true) {
            ViewUtil.printHeader();

            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("0. Exit");
            System.out.println("========================\n");

            int choice = ViewUtil.readIntChoice();
        }
    }
}
