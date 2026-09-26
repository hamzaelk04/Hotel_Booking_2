package strategy.profile;

import repository.UserRepository;
import strategy.ProfileUpdateStrategy;
import util.InputUtil;
import util.PasswordUtil;
import util.PromptUtil;

import java.util.UUID;

public class UpdatePasswordStrategy implements ProfileUpdateStrategy {
    private final UserRepository userRepository;

    public UpdatePasswordStrategy(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void update(UUID id) {
        String newPassword = InputUtil.readPassword("Enter the new Password: ");

        String hashPw = PasswordUtil.hashPassword(newPassword);

        try {
            userRepository.update(id, "password", hashPw);

            System.out.println("The password updated successfully!");

            InputUtil.emptyInput(PromptUtil.emptyPrompt());
        } catch (Exception e) {
            throw new RuntimeException(e);
//            Add update exception;
        }
    }
}
