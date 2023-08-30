package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabasePopulateServiceWithPS {
    public static void main(String[] args) {
        try {
            Database database = Database.getInstance();
            Connection connection = database.getConnection();

            insertIntoWorkerTable(connection);
            insertIntoClientTable(connection);
            insertIntoProjectTable(connection);
            insertIntoProjectWorkerTable(connection);

            database.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void insertIntoWorkerTable(Connection connection) throws IOException, SQLException {
        String workerSql = "INSERT INTO worker (ID, NAME, BIRTHDAY, LEVEL, SALARY) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(workerSql)) {
            BufferedReader reader = new BufferedReader(new FileReader(new Prefs().getString(Prefs.POPULATE_DB_WORKER)));
            String line;

            while ((line = reader.readLine()) != null) {
                String[] params = line.replace(";", "").replace("'","").split(",");

                int id = Integer.parseInt(params[0].trim());
                String name = params[1].trim();
                Date birthday = Date.valueOf(params[2].trim());
                String level = params[3].trim();
                int salary = Integer.parseInt(params[4].trim());

                preparedStatement.setInt(1, id);
                preparedStatement.setString(2, name);
                preparedStatement.setDate(3, birthday);
                preparedStatement.setString(4, level);
                preparedStatement.setInt(5, salary);

                preparedStatement.addBatch();
            }
            preparedStatement.executeBatch();
            System.out.println("Update worker table successfully!");
        }
    }

    private static void insertIntoClientTable(Connection connection) throws IOException, SQLException {
        String clientSql = "INSERT INTO client (ID, NAME) VALUES (?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(clientSql)) {
            BufferedReader reader = new BufferedReader(new FileReader(new Prefs().getString(Prefs.POPULATE_DB_CLIENT)));
            String line;

            while ((line = reader.readLine()) != null) {

                String[] params = line.replace("'", "").replace(";", "").split(",");
                int id = Integer.parseInt(params[0].trim());
                String name = params[1].trim();

                preparedStatement.setInt(1, id);
                preparedStatement.setString(2, name);

                preparedStatement.addBatch();
            }
            preparedStatement.executeBatch();
            System.out.println("Update client table successfully!");
        }
    }

    private static void insertIntoProjectTable(Connection connection) throws SQLException, IOException {
        String projectSql = "INSERT INTO project (ID , CLIENT_ID, START_DATE, FINISH_DATE) VALUES (?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(projectSql)){
            BufferedReader reader = new BufferedReader(new FileReader(new Prefs().getString(Prefs.POPULATE_DB_PROJECT)));
            String line;

            while ((line = reader.readLine())!= null){
                String [] params = line.replace("'", "").replace(";","").split(",");

                int id = Integer.parseInt(params[0].trim());
                int clientId = Integer.parseInt(params[1].trim());
                Date startDate = Date.valueOf(params[2].trim());
                Date finishDate = Date.valueOf(params[3].trim());

                preparedStatement.setInt(1, id);
                preparedStatement.setInt(2, clientId);
                preparedStatement.setDate(3, startDate);
                preparedStatement.setDate(4, finishDate);
                preparedStatement.addBatch();
            }
            preparedStatement.executeBatch();
            System.out.println("Update project table successfully!");
        }
    }
    private static void insertIntoProjectWorkerTable(Connection connection) throws SQLException, IOException  {
        String projectWorkerSql = "INSERT INTO project_worker (PROJECT_ID, WORKER_ID) VALUES (?, ?)";
        try(PreparedStatement preparedStatement = connection.prepareStatement(projectWorkerSql)){
            String line;
            BufferedReader bufferedReader = new BufferedReader(new FileReader(new Prefs().getString(Prefs.POPULATE_DB_PROJECT_WORKER)));

            while ((line = bufferedReader.readLine())!=null){
                String[] params = line.replace(";","").split(",");

                int projectId = Integer.parseInt(params[0].trim());
                int workerId = Integer.parseInt(params[1].trim());

                preparedStatement.setInt(1, projectId);
                preparedStatement.setInt(2, workerId);
                preparedStatement.addBatch();
            }
            preparedStatement.executeBatch();
            System.out.println("Update project_worker table successfully!");
        }
    }
}
