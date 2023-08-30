package org.example;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class Prefs {
    public static final String DEFAULT_PREFS_FILENAME = "prefs.json";
    public static final String DB_JDBC_CONNECTION_URL = "dbUrl";
    public  static  final  String INIT_DB_SQL_FILE_PATH = "initDbSql";
    public static final String POPULATE_DB = "populateDb";

    public static final String POPULATE_DB_WORKER = "populateDbWorker";
    public static final String POPULATE_DB_CLIENT = "populateDbClient";
    public static final String POPULATE_DB_PROJECT = "populateDbProject";
    public static final String POPULATE_DB_PROJECT_WORKER = "populateDbProjectWorker";

    public static final String QUERY_SERVICE_LONGEST_PROJ = "databaseQueryServiceLongestProj";
    public static final String QUERY_MAX_PROJ_CLIENT = "databaseQueryMaxProjClient";
    public static final String QUERY_MAX_SALARY_WORKER = "databaseQueryMaxSalaryWorker";
    public static final String QUERY_YOUNGEST_ELDEST = "databaseQueryYoungestEldest";
    public static final String QUERY_PRINT_PROJ_PRICES = "databaseQueryPrintProjPrices";


    private Map<String, Object> prefs = new HashMap<>();

    public Prefs(){
        this(DEFAULT_PREFS_FILENAME);
    }
    public Prefs(String filename){
        try {
            String json = String.join("\n", Files.readAllLines(Paths.get(filename)));

            TypeToken<?> typeToken = TypeToken.getParameterized(Map.class, String.class, Object.class);

            prefs = new Gson().fromJson(json, typeToken.getType());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public String getString(String key){
        return getPref(key).toString();
    }
    public Object getPref(String key){
        return prefs.get(key);
    }

}
