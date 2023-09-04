package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static final Database INSTANCE = new Database();
    private Connection connection;
    private Database() {
        try {
            String connectionUrl = new Prefs().getString(Prefs.DB_JDBC_CONNECTION_URL);
            connection = DriverManager.getConnection(connectionUrl, "sa", "");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static Database getInstance() {return INSTANCE;}
    public Connection getConnection() {return connection;}

}