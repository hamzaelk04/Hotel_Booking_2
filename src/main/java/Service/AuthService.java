package Service;

import Model.User;
import Repository.JDBC.JdbcUserRepository;
import Repository.UserRepository;
import Util.PasswordUtil;

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

        String hashPw = PasswordUtil.hashPassword(user.getPassword());
        user.setPassword(hashPw);

        userRepository.save(user);

        System.out.println("Inscription réussie ! Vous pouvez maintenant vous connecter.");
    }
}
