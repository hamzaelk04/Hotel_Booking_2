package strategy.profile;

import repository.UserRepository;
import strategy.ProfileUpdateStrategy;
import util.InputUtil;

import java.util.UUID;

public class UpdateEmailStrategy implements ProfileUpdateStrategy {
    private final UserRepository userRepository;

    public UpdateEmailStrategy(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void update(UUID id) {
        String newEmail = InputUtil.readEmail("Enter the new email: ");

        userRepository.update(id, "email", newEmail);
    }
}
