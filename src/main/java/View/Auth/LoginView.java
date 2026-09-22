package View.Auth;

import Service.AuthService;
import Util.InputUtil;
import Util.PromptUtil;
import Util.ViewUtil;

import java.util.UUID;

public class LoginView {
    private final static AuthService authService = new AuthService();

    public static void loginMenuView() {
        ViewUtil.printHeader();

        String email = InputUtil.readEmail(PromptUtil.emailPrompt());

        String password = InputUtil.readPassword(PromptUtil.passwordPrompt());

        System.out.println(authService.login(email, password));
    }
}
