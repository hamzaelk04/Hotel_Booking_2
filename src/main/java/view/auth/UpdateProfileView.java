package view.auth;

import service.AuthService;
import strategy.ProfileUpdateStrategy;
import strategy.profile.UpdateNameStrategy;
import util.ViewUtil;

import java.util.UUID;

public class UpdateProfileView {
    private final static AuthService authService = new AuthService();

    public static void showMenu(UUID id) {
        ViewUtil.readIntChoice();
        boolean running = true;

        while (running) {
            System.out.println("""
                1. Update the name \n
                2. Update the email \n
                3. Update the phone \n
                0. Exit \n
                """);

            int choice = ViewUtil.readIntChoice();

            switch (choice) {
                case 1:
                    authService.update(id, "name");
                    break;
                case 2:
                    authService.update(id, "email");
                    break;
                case 3:
                    authService.update(id, "phone");
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
