package com.goIt.Homework;

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
//java -jar h2-2.2.220.jar