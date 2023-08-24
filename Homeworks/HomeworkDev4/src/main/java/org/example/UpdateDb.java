package org.example;

import java.io.IOException;
import java.sql.SQLException;

public class UpdateDb {


    public static void main(String[] args) throws SQLException, IOException {

        Database database = Database.getInstance();

//                       ADD TABLES
        new DatabaseInitService().initDb(database);

//                       FILL TABLES
        new DatabasePopulateService().populateDb(database);

//                       FIND_MAX_PROJECT_CLIENT
        new DatabaseQueryService().queryMaxProjClient(database);
        System.out.println("****************************************************");

//                       FIND_LONGEST_PROJECT
        new DatabaseQueryService().queryLongestProj(database);
        System.out.println("****************************************************");

//                       FIND_MAX_SALARY_WORKER
        new DatabaseQueryService().queryMaxSalaryWorker(database);
        System.out.println("****************************************************");

//                       FIND_YOUNGEST_ELDEST_WORKERS
        new DatabaseQueryService().queryYoungestEldestWorkers(database);
        System.out.println("****************************************************");

//                       FIND_PROJECT_PRICE
        new DatabaseQueryService().queryProjectPrices(database);
        System.out.println("****************************************************");

//                       CREATE TABLE
//          database.executeUpdate("CREATE TABLE test_table (name VARCHAR(100))");

//                       DROP TABLE
//          database.executeUpdate("DROP TABLE test_table");
    }
}

