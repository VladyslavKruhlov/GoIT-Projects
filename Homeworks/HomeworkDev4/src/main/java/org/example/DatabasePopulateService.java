package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DatabasePopulateService {
    public void populateDb(Database database){

        try {
            String initDbSqlFileName = new Prefs().getString(Prefs.POPULATE_DB);

            String sql = String.join("\n", Files.readAllLines(Paths.get(initDbSqlFileName)));

            database.executeUpdate(sql);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}