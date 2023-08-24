package org.example;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class DatabaseInitService {
    public void initDb(Database database){

        try {
            String initDbSqlFileName = new Prefs().getString(Prefs.INIT_DB_SQL_FILE_PATH);

            String sql = String.join("\n", Files.readAllLines(Paths.get(initDbSqlFileName)));

            database.executeUpdate(sql);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
