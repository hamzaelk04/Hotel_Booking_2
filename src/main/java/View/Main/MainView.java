package View.Main;

import Util.ViewUtil;
import View.Auth.LoginView;
import View.Auth.RegisterView;

public class MainView {

    public static void displayMainView() {
        ViewUtil.printHeader();

        System.out.println("1. Register");
        System.out.println("2. Login");
        System.out.println("0. Exit");
        System.out.println("========================\n");

        int choice = ViewUtil.readIntChoice();

        switch (choice) {
            case 1:
                RegisterView.registerMenuView();
                break;
            case 2:
                LoginView.loginMenuView();
                break;
            case 0:
                System.out.println("Goodbye!");
                return;
            default:
                System.out.println("Invalid choice!\n");
        }
    }
}
