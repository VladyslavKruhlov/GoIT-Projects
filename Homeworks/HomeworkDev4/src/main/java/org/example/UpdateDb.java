package org.example;

import DTO.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class UpdateDb {


    public static void main(String[] args) throws SQLException, IOException {

        Database database = Database.getInstance();

//                       ADD TABLES
//        new DatabaseInitService().initDb(database);

//                       FILL TABLES
//        new DatabasePopulateService().populateDb(database);

//                       FIND_MAX_PROJECT_CLIENT
        List<MaxProjectClient> maxProjectClients = new DatabaseQueryService().queryMaxProjectClient(database);

//                       FIND_LONGEST_PROJECT
        List<LongestProject> longestProjects = new DatabaseQueryService().queryLongestProject(database);

//                       FIND_MAX_SALARY_WORKER
        List<MaxSalaryWorker> maxSalaryWorkers = new DatabaseQueryService().queryMaxSalaryWorker(database);

//                       FIND_YOUNGEST_ELDEST_WORKERS
        List<YoungestEldestWorkers> youngestEldestWorkers = new DatabaseQueryService().queryYoungestEldestWorkers(database);

//                       FIND_PROJECT_PRICE
        List<ProjectPrices> projectPrices = new DatabaseQueryService().queryProjectPrices(database);

//                       CREATE TABLE
//          database.executeUpdate("CREATE TABLE test_table (name VARCHAR(100))");

//                       DROP TABLE
//          database.executeUpdate("DROP TABLE test_table");
    }
}

