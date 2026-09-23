package view.auth;

import exception.NullUserException;
import model.User;
import model.enums.UserRole;
import repository.JDBC.JdbcUserRepository;
import service.AuthService;
import util.InputUtil;
import util.PromptUtil;
import util.ViewUtil;

import java.util.Optional;
import java.util.UUID;

public class LoginView {
    private final static AuthService authService = new AuthService();

    public static void showMenu() {
        ViewUtil.printHeader();

        String email = InputUtil.readEmail(PromptUtil.emailPrompt());

        String password = InputUtil.readPassword(PromptUtil.passwordPrompt());

        UUID id = authService.login(email, password);

        Optional<User> user = JdbcUserRepository.getInstance().findById(id);

        if (user.isEmpty()) {
            throw new NullUserException();
        }

        if (user.map(u -> u.getRole().equals(UserRole.Admin)).orElse(false)) {
//        Client View
            System.out.println(111111);
        } else {
//        Admin View
            System.out.println(2222222);
        }
    }
}
