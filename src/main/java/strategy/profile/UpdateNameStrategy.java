package strategy.profile;

import repository.UserRepository;
import strategy.ProfileUpdateStrategy;
import util.InputUtil;

import java.util.UUID;

public class UpdateNameStrategy implements ProfileUpdateStrategy {
    private final UserRepository userRepository;

    public UpdateNameStrategy(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void update(UUID id) {
        String newName = InputUtil.readName("Enter the new name");

        userRepository.update(id, "name", newName);
    }
}
