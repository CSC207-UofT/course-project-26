package main.flyway;

import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * Configure a flyway instance to load data after hibernate created schema from entities
 */
@Configuration
public class FlywayConfiguration {

    @Autowired
    public FlywayConfiguration(DataSource dataSource) {
        Flyway.configure().baselineOnMigrate(true).baselineVersion("0.0").dataSource(dataSource).load().migrate();
    }
}
