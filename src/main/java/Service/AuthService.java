package Service;

import Model.User;
import Repository.JDBC.JdbcUserRepository;
import Repository.UserRepository;
import Util.PasswordUtil;

import java.util.UUID;

public class AuthService {
    private User currentUser;
    private final UserRepository userRepository;

    public AuthService() {
        this.userRepository = new JdbcUserRepository();
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
//            Throw Email not found exception
        }

        User user = userRepository.findByEmail(email).orElse(null);

        if (user == null) {
//            Throw null User exception
        }

        if (!PasswordUtil.checkPassword(password, user.getPassword())) {
//            Throw incorrect password exception
        }

        return user.getId();
    }
}
