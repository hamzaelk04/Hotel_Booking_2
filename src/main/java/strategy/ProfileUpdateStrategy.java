package strategy;

import model.User;

import java.util.UUID;

public interface ProfileUpdateStrategy {
    void update (UUID id);
}
