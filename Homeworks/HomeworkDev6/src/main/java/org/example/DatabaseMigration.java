package org.example;

import org.flywaydb.core.Flyway;

public class DatabaseMigration {

    public static void main(String[] args) {
        Flyway flyway = Flyway
                .configure()
                .dataSource("jdbc:h2:./test",
                        "sa",
                        "")
                .load();
        flyway.migrate();
    }
}