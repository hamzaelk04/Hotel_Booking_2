package view.auth;

import util.ViewUtil;

import java.util.UUID;

public class UpdateProfileView {

    public static void showMenu(UUID id) {
        ViewUtil.readIntChoice();
        boolean running = true;

        while (running) {
            System.out.println("""
                1. Update the name \n
                2. Update the email \n
                3. Update the phone \n
                4. Return \n
                0. Exit \n
                """);

            int choice = ViewUtil.readIntChoice();

            switch (choice) {
                case 1:
//                Update the name
                    break;
                case 2:
//                Update the email
                    break;
                case 3:
//                Update the phone
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    ViewUtil.readIntChoice();
                    break;
            }
        }
    }
}
