package org.example;

import DTO.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DatabaseQueryService {

    public List<LongestProject> queryLongestProject(Database database) throws IOException, SQLException {

        String queryPath = new Prefs().getString(Prefs.QUERY_SERVICE_LONGEST_PROJ);
        String sql = String.join("\n", Files.readAllLines(Paths.get(queryPath)));

        List<LongestProject> result = new ArrayList<>();

        Statement st = database.getConnection().createStatement();
        ResultSet rs = st.executeQuery(sql);
        System.out.println("\n" +"FIND_LONGEST_PROJECT");

        while(rs.next()) {
            String name = rs.getString("NAME");
            int monthCount = rs.getInt("MONTH_COUNT");

            LongestProject longestProject = new LongestProject(name,monthCount);
            result.add(longestProject);
            System.out.println("NAME: " + name + ", MONTH_COUNT: " + monthCount);
        }

    return result;
    }
    public List<MaxProjectClient> queryMaxProjectClient(Database database) throws IOException, SQLException {

        List<MaxProjectClient> result = new ArrayList<>();
        String queryPath = new Prefs().getString(Prefs.QUERY_MAX_PROJ_CLIENT);
        String sql = String.join("\n", Files.readAllLines(Paths.get(queryPath)));


        Statement st = database.getConnection().createStatement();
        ResultSet rs = st.executeQuery(sql);
        System.out.println("\n" +"FIND_MAX_PROJECT_CLIENT");

        while(rs.next()) {
            String name = rs.getString("NAME");
            int projectCount = rs.getInt("PROJECT_COUNT");

            MaxProjectClient maxProjectClient = new MaxProjectClient(name,projectCount);
            result.add(maxProjectClient);
            System.out.println("NAME: " + name + ", PROJECT_COUNT: " + projectCount);
        }
        return result;
    }
    public List<MaxSalaryWorker> queryMaxSalaryWorker(Database database) throws IOException, SQLException {

        List<MaxSalaryWorker> result = new ArrayList<>();
        String queryPath = new Prefs().getString(Prefs.QUERY_MAX_SALARY_WORKER);
        String sql = String.join("\n", Files.readAllLines(Paths.get(queryPath)));


        Statement st = database.getConnection().createStatement();
        ResultSet rs = st.executeQuery(sql);
        System.out.println("\n" +"FIND_MAX_SALARY_WORKER");

        while(rs.next()) {
            String name = rs.getString("NAME");
            int salary = rs.getInt("SALARY");

            MaxSalaryWorker maxSalaryWorker = new MaxSalaryWorker(name,salary);
            result.add(maxSalaryWorker);
            System.out.println("NAME: " + name + ", SALARY: " + salary);
        }
        return result;
    }
    public List<YoungestEldestWorkers> queryYoungestEldestWorkers(Database database) throws IOException, SQLException {

        List<YoungestEldestWorkers> result = new ArrayList<>();
        String queryPath = new Prefs().getString(Prefs.QUERY_YOUNGEST_ELDEST);
        String sql = String.join("\n", Files.readAllLines(Paths.get(queryPath)));


        Statement st = database.getConnection().createStatement();
        ResultSet rs = st.executeQuery(sql);
        System.out.println("\n" +"FIND_YOUNGEST_ELDEST_WORKERS");

        while(rs.next()) {
            String type = rs.getString("TYPE");
            String name = rs.getString("NAME");
            String birthday = rs.getString("BIRTHDAY");

            YoungestEldestWorkers youngestEldestWorkers = new YoungestEldestWorkers(type, name, birthday);
            result.add(youngestEldestWorkers);
            System.out.println("TYPE: " + type +", NAME: " + name + ", BIRTHDAY: " + birthday);
        }
        return result;
    }
    public List<ProjectPrices> queryProjectPrices(Database database) throws IOException, SQLException {

        List<ProjectPrices> result = new ArrayList<>();
        String queryPath = new Prefs().getString(Prefs.QUERY_PRINT_PROJ_PRICES);
        String sql = String.join("\n", Files.readAllLines(Paths.get(queryPath)));


        Statement st = database.getConnection().createStatement();
        ResultSet rs = st.executeQuery(sql);
        System.out.println("\n" +"FIND_PROJECT_PRICE");

        while(rs.next()) {
            String name = rs.getString("NAME");
            int price = rs.getInt("PRICE");

            ProjectPrices projectPrices = new ProjectPrices(name, price);
            result.add(projectPrices);
            System.out.println("NAME: " + name + ", PRICE: " + price);
        }
        return result;
    }
}
