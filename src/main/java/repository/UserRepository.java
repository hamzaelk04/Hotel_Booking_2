package repository;

import model.User;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository {
    void save(User user);

    void update(UUID id, String column, String newValue);

    Optional<User> findById(UUID id);

    Optional<User> findByEmail(String email);

    boolean existsByEmail(String email);

//    List<User> findAll();
}
