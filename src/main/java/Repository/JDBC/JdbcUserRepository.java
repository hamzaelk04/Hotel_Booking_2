package Repository.JDBC;

import DB.DataBaseConnection;
import Model.Enum.UserRole;
import Model.User;
import Repository.UserRepository;

import java.sql.*;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class JdbcUserRepository implements UserRepository {

    @Override
    public void save(User user) {
        String sql = """
                INSERT INTO users (name, email, phone, password)
                VALUES (?, ?, ?, ?)
                """;
        try (Connection connection = DataBaseConnection.getInstance().getConnection();
        PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            statement.setString(1, user.getName());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getPhone());
            statement.setString(4, user.getPassword());

            int affectedRows = statement.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Creating user failed, no rows affected.");
            }

            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    UUID generatedId = generatedKeys.getObject(1, UUID.class);
                    user.setId(generatedId);

                } else {
                    throw new SQLException("Creating user failed, no ID obtained.");
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Database error while saving user: " + e.getMessage(), e);
        }
    }

    @Override
    public Optional<User> findByEmail(String email) {
        String sql = """
                    SELECT id, name, email, phone, password, role FROM users
                    WHERE email = ?
                """;

        try (Connection connection = DataBaseConnection.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, email);

            try (ResultSet resultSet = statement.executeQuery()){
                if (resultSet.next()) {
                    User user = new User(resultSet.getString("name"),
                            resultSet.getString("email"),
                            resultSet.getString("phone"),
                            resultSet.getString("password"));
                    user.setId(resultSet.getObject("id", UUID.class));
                    user.setRole(UserRole.valueOf(resultSet.getString("role")));

                    return Optional.of(user);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Database error while fetching user by email: " + e.getMessage(), e);
        }

        return Optional.empty();
    }

}
