package Config;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConfig {
    private static String url;
    private static String user;
    private static String password;

    static {
        try (InputStream input = DatabaseConfig.class.getClassLoader()
                .getResourceAsStream("application.properties")) {
            Properties properties = new Properties();

            if (input != null) {
                properties.load(input);

                url = properties.getProperty("db.url");
                user = properties.getProperty("db.user");
                password = properties.getProperty("db.password");
            } else {
                url = "jdbc:postgresql://localhost:5432/Hotel_Booking_DB";
                user = "postgres";
                password = "t7)rpjDb";
            }

            Class.forName("org.postgresql.Driver");

        } catch (Exception e) {
            System.err.println("❌ Failed to load database configuration. \n" + e );
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }
}
