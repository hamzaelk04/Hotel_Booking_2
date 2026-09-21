package Config;

import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.FlywayException;

public class DatabaseInitializer {
    public static void initializeSchema() {
        Flyway flyway = Flyway.configure()
                .dataSource(
                        DatabaseConfig.getUrl(),
                        DatabaseConfig.getUser(),
                        DatabaseConfig.getPassword()
                )
                .load();

        try {
            flyway.migrate();
        } catch (FlywayException e) {
            System.out.println("The migration doesn't work");
            throw new RuntimeException(e);
        }
    }
}
