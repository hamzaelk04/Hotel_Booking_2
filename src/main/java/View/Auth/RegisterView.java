package View.Auth;

import Model.User;
import Service.AuthService;
import Util.InputUtil;
import Util.PromptUtil;
import Util.ViewUtil;

public class RegisterView {
    private final static AuthService authService = new AuthService();

    public static void registerMenuView() {
        ViewUtil.printHeader();

        String name = InputUtil.readName(PromptUtil.namePrompt());

        String email = InputUtil.readEmail(PromptUtil.emailPrompt());

        String phone = InputUtil.readPhone(PromptUtil.phonePrompt());

        String password = InputUtil.readPassword(PromptUtil.passwordPrompt());

        User user = new User(name, email, phone, password);

        try {
            authService.register(user);

            System.out.println("\n Compte créé avec succès !");
        } catch (Exception e) {
            System.out.println("\n Erreur lors de l'inscription : " + e.getMessage());
        }
    }
}
