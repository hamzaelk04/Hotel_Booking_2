package repository;

import model.User;

import java.util.Optional;

public interface UserRepository {
    void save(User user);

//    Optional<User> findById(UUID id);

    Optional<User> findByEmail(String email);

    boolean existsByEmail(String email);

//    List<User> findAll();
}
