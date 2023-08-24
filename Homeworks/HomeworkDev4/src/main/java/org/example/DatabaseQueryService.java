package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseQueryService {
    public void queryLongestProj(Database database) throws SQLException, IOException {

        String queryPath = new Prefs().getString(Prefs.QUERY_SERVICE_LONGEST_PROJ);
        String sql = String.join("\n", Files.readAllLines(Paths.get(queryPath)));

        Statement st = database.getConnection().createStatement();
        ResultSet rs = st.executeQuery(sql);

        while(rs.next()) {
            String name = rs.getString("NAME");
            int monthCount = rs.getInt("MONTH_COUNT");


            System.out.println("NAME: " + name);
            System.out.println("MONTH_COUNT: " + monthCount +"\n");
        }
    }
    public void queryMaxProjClient(Database database) throws SQLException, IOException {

        String queryPath = new Prefs().getString(Prefs.QUERY_MAX_PROJ_CLIENT);
        String sql = String.join("\n", Files.readAllLines(Paths.get(queryPath)));

        Statement st = database.getConnection().createStatement();
        ResultSet rs = st.executeQuery(sql);

        while(rs.next()) {
            String name = rs.getString("NAME");
            int projectCount = rs.getInt("PROJECT_COUNT");


            System.out.println("NAME: " + name);
            System.out.println("PROJECT_COUNT: " + projectCount+"\n");
        }
    }
    public void queryMaxSalaryWorker(Database database) throws SQLException, IOException {

        String queryPath = new Prefs().getString(Prefs.QUERY_MAX_SALARY_WORKER);
        String sql = String.join("\n", Files.readAllLines(Paths.get(queryPath)));

        Statement st = database.getConnection().createStatement();
        ResultSet rs = st.executeQuery(sql);

        while(rs.next()) {
            String name = rs.getString("NAME");
            int salary = rs.getInt("SALARY");

            System.out.println("NAME: " + name);
            System.out.println("SALARY: " + salary+"\n");
        }
    }
    public void queryYoungestEldestWorkers(Database database) throws SQLException, IOException {

        String queryPath = new Prefs().getString(Prefs.QUERY_YOUNGEST_ELDEST);
        String sql = String.join("\n", Files.readAllLines(Paths.get(queryPath)));

        Statement st = database.getConnection().createStatement();
        ResultSet rs = st.executeQuery(sql);

        while(rs.next()) {
            String type = rs.getString("TYPE");
            String name = rs.getString("NAME");
            String birthday = rs.getString("BIRTHDAY");

            System.out.println("TYPE: " + type);
            System.out.println("NAME: " + name);
            System.out.println("BIRTHDAY: " + birthday +"\n");
        }
    }
    public void queryProjectPrices(Database database) throws SQLException, IOException {

        String queryPath = new Prefs().getString(Prefs.QUERY_PRINT_PROJ_PRICES);
        String sql = String.join("\n", Files.readAllLines(Paths.get(queryPath)));

        Statement st = database.getConnection().createStatement();
        ResultSet rs = st.executeQuery(sql);

        while(rs.next()) {
            String name = rs.getString("NAME");
            int price = rs.getInt("PRICE");

            System.out.println("NAME: " + name);
            System.out.println("PRICE: " + price+"\n");
        }
    }
}
