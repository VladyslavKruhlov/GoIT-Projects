package org.example;

import java.sql.*;

public class Database {
    private static final Database INSTANCE = new Database();
    private Connection connection;
    private Database(){
        try {
            String connectionUrl = new Prefs().getString(Prefs.DB_JDBC_CONNECTION_URL);

            connection = DriverManager.getConnection(connectionUrl, "sa", "");

        }catch (Exception ex){ex.printStackTrace();}
    }

    public static Database getInstance(){
        return INSTANCE;
    }

    public Connection getConnection(){
        return connection;
    }

    public void close(){
        try {connection.close();}
        catch (SQLException e) {throw new RuntimeException(e);}
    }

    public int executeUpdate(String sql){
        try(Statement statement = connection.createStatement()) {
            return statement.executeUpdate(sql);
        } catch (Exception ex) {
            ex.printStackTrace();
            return -1;
        }
    }
}