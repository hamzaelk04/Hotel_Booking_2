package Config;

import  org.flywaydb.core.Flyway;

public class DatabaseInitializer {
    public static void initializeSchema() {
        Flyway flyway = Flyway.configure()
                .dataSource(
                      DatabaseConfig.getUrl(),
                      DatabaseConfig.getUser(),
                      DatabaseConfig.getPassword()
                )
                .load();
        flyway.migrate();
    }
}
