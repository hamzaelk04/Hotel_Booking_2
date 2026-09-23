package view.main;

import util.InputUtil;
import util.PromptUtil;
import util.ViewUtil;
import view.auth.LoginView;
import view.auth.RegisterView;

public class MainView {

    public static void showMenu() {
        ViewUtil.printHeader();
        boolean running = true;

        while (running) {
            System.out.println("""
                    1. Register \n
                    2. Login \n
                    0. Exit \n
                    ======================== \n
                    """);

            int choice = ViewUtil.readIntChoice();

            switch (choice) {
                case 1:
                    RegisterView.showMenu();
                    break;
                case 2:
                    LoginView.showMenu();
                    break;
                case 0:
                    System.out.println("Press Enter to Exit!");
                    InputUtil.emptyInput(PromptUtil.emptyPrompt());
                    running = false;
                default:
                    System.out.println("Invalid choice!\n");
            }
        }
    }
}
