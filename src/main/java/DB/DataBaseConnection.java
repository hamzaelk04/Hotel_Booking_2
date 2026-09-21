package DB;

import Config.DatabaseConfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {
    private static DataBaseConnection instance;
    private Connection connection;

    private DataBaseConnection() {
        try {
            Class.forName(DatabaseConfig.getDbDriver());

            this.connection = DriverManager.getConnection(
                    DatabaseConfig.getUrl(),
                    DatabaseConfig.getUser(),
                    DatabaseConfig.getPassword()
            );
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Driver JDBC introuvable : " + e.getMessage(), e);
        } catch (SQLException e) {
            throw new RuntimeException("Échec de connexion à la base de données : " + e.getMessage(), e);
        }
    }

    private static synchronized DataBaseConnection getInstance() {
        try {
            if (instance == null || instance.getConnection().isClosed()) {
                instance = new DataBaseConnection();
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erreur lors de la vérification de l'état de la connexion", e);
        }

        return instance;
    }

    public Connection getConnection() {
        return connection;
    }

    public void closeConnection() {
        if (connection != null) {
            try {
                if (!connection.isClosed()) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.err.println("Erreur lors de la fermeture de la connexion : " + e.getMessage());
            }
        }
    }
}
