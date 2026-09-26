package view.auth;

import exception.IncorrectPasswordException;
import exception.NullUserException;
import model.User;
import repository.JDBC.JdbcUserRepository;
import repository.UserRepository;
import service.AuthService;
import util.InputUtil;
import util.PasswordUtil;
import util.ViewUtil;

import java.util.UUID;

public class ChangePasswordView {
    private static AuthService authService = new AuthService();

    public static void changePasswordView(UUID id) {
        ViewUtil.printHeader();


        boolean running = true;

        while (running) {
            String oldPassword = InputUtil.readPassword("Enter the old password: \n");

            running = authService.changePassword(id, oldPassword);

            if (running) System.out.println("The password is incorrect");
        }


    }
}
