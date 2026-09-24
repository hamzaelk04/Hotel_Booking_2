package strategy.profile;

import repository.UserRepository;
import strategy.ProfileUpdateStrategy;
import util.InputUtil;
import util.PromptUtil;

import java.util.UUID;

public class UpdatePhoneStrategy implements ProfileUpdateStrategy {
    private final UserRepository userRepository;

    public UpdatePhoneStrategy(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void update(UUID id) {
        String newPhone = InputUtil.readPhone("Enter the new phone: ");

        try {
            userRepository.update(id, "phone", newPhone);

            System.out.println("The number phone updated successfully!");

            InputUtil.emptyInput(PromptUtil.emptyPrompt());
        } catch (Exception e) {
            throw new RuntimeException(e);
//            Add update exception;
        }

    }
}
