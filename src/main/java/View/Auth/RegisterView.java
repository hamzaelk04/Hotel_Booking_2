package View.Auth;

import Model.User;
import Util.InputUtil;
import Util.PromptUtil;
import Util.ViewUtil;

import java.util.Scanner;

public class RegisterView {
    public static void registerMenuView() {
        ViewUtil.printHeader();

        String name = InputUtil.readName(PromptUtil.namePrompt());

        String email = InputUtil.readEmail(PromptUtil.emailPrompt());

        String phone = InputUtil.readPhone(PromptUtil.phonePrompt());

        String password = InputUtil.readPassword(PromptUtil.passwordPrompt());

        User user = new User(name, email, phone, password);
    }
}
