package view.auth;

import model.User;
import service.AuthService;
import util.InputUtil;
import util.PromptUtil;
import util.ViewUtil;

public class RegisterView {
    private final static AuthService authService = new AuthService();

    public static void showMenu() {
        ViewUtil.printHeader();

        String name = InputUtil.readName(PromptUtil.namePrompt());

        String email = InputUtil.readEmail(PromptUtil.emailPrompt());

        String phone = InputUtil.readPhone(PromptUtil.phonePrompt());

        String password = InputUtil.readPassword(PromptUtil.passwordPrompt());

        User user = new User(name, email, phone, password);

        try {
            authService.register(user);

            System.out.println("\n Compte créé avec succès !");

            InputUtil.emptyInput(PromptUtil.emptyPrompt());

            LoginView.showMenu();
        } catch (Exception e) {
            System.out.println("\n Erreur lors de l'inscription : " + e.getMessage());
        }
    }
}
