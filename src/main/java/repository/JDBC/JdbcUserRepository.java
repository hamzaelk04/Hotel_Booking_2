package repository.JDBC;

import DB.DataBaseConnection;
import model.enums.UserRole;
import model.User;
import repository.UserRepository;

import java.sql.*;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

public class JdbcUserRepository implements UserRepository {

    private JdbcUserRepository() {}

    private static class SingletonHolder {
        private static final JdbcUserRepository INSTANCE = new JdbcUserRepository();
    }

    public static JdbcUserRepository getInstance() {
        return SingletonHolder.INSTANCE;
    }

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
    public void update(UUID id, String column, String newValue) {
        Set<String> allowedColumns = Set.of("name", "email", "phone", "password");

        if (!allowedColumns.contains(column)) {
            throw new IllegalArgumentException("Invalid column name: " + column);
        }

        String sql = String.format("""
                UPDATE users
                SET %s = ? WHERE id = ?
                """, column);


        try (Connection connection = DataBaseConnection.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, newValue);
            statement.setObject(2, id);

            int affectedRows = statement.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Updating user failed, no rows affected.");
            }

        } catch (SQLException e) {
            throw new RuntimeException("Database error while updating user: " + e.getMessage(), e);
        }
    }

    @Override
    public Optional<User> findById(UUID id) {
        String sql = """
                SELECT name, email, phone, password, role FROM users
                WHERE id = ?
                """;
        try (Connection connection = DataBaseConnection.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setObject(1, id);

            try (ResultSet resultSet = statement.executeQuery()){
                if (resultSet.next()) {
                    User user = new User(resultSet.getString("name"),
                            resultSet.getString("email"),
                            resultSet.getString("phone"),
                            resultSet.getString("password"));
                    user.setId(id);
                    user.setRole(UserRole.valueOf(resultSet.getString("role")));

                    return Optional.of(user);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Database error while fetching user by email: " + e.getMessage(), e);
        }

        return Optional.empty();
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

    @Override
    public boolean existsByEmail(String email) {
        String sql = """
                SELECT 1 FROM users WHERE email = ?
                LIMIT 1
                """;

        try (Connection connection = DataBaseConnection.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, email);

            try (ResultSet resultSet = statement.executeQuery()) {
                return resultSet.next();
            }
        } catch (SQLException e) {
            throw new RuntimeException("Database error while checking email existence: " + e.getMessage(), e);
        }
    }
}
