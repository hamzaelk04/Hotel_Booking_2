package view.auth;

import service.AuthService;
import util.InputUtil;
import util.PromptUtil;
import util.ViewUtil;

public class LoginView {
    private final static AuthService authService = new AuthService();

    public static void loginMenuView() {
        ViewUtil.printHeader();

        String email = InputUtil.readEmail(PromptUtil.emailPrompt());

        String password = InputUtil.readPassword(PromptUtil.passwordPrompt());

        System.out.println(authService.login(email, password));
    }
}
