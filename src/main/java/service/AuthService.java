package service;

import exception.EmailNotFoundException;
import exception.IncorrectPasswordException;
import exception.NullUserException;
import model.User;
import repository.JDBC.JdbcUserRepository;
import repository.UserRepository;
import util.PasswordUtil;

import java.util.UUID;

public class AuthService {
    private User currentUser;
    private final UserRepository userRepository;

    public AuthService() {
        this.userRepository = JdbcUserRepository.getInstance();
    }

    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void register(User user) {
        if (user == null) {
            throw new IllegalArgumentException("L'utilisateur ne peut pas être nul.");
        }

        if (userRepository.existsByEmail(user.getEmail())) {
            throw new IllegalArgumentException("An account with this email already exists.");
        }

        String hashPw = PasswordUtil.hashPassword(user.getPassword());
        user.setPassword(hashPw);

        userRepository.save(user);

        System.out.println("Inscription réussie ! Vous pouvez maintenant vous connecter.");
    }

    public UUID login(String email, String password) {
        if (!userRepository.existsByEmail(email)){
            throw new EmailNotFoundException();
        }

        User user = userRepository.findByEmail(email).orElse(null);

        if (user == null) {
            throw new NullUserException();
        }

        if (!PasswordUtil.checkPassword(password, user.getPassword())) {
            throw new IncorrectPasswordException();
        }

        return user.getId();
    }
}
