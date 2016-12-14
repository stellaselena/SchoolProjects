package westerdals.com.Database;

import westerdals.com.Quiz.MusicQuiz;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

public class DBService {

    public DBConnector connector;
    private Connection connection;
    Statement statement = null;
    ResultSet resultSet = null;

    public DBService(String dbPassword,
                     String dbUser,
                     String hostName,
                     String dbName,
                     String port) throws Exception {

        connector = new DBConnector(dbName, hostName, dbUser, dbPassword, port);
        connection = connector.getConnection();
    }

    public void releaseConnection() {
        try {
            connector.closeConnection();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    public List<MusicQuiz> createMusicQuizList(String table) {
        ArrayList<MusicQuiz> musicQuizList = new ArrayList<>();
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM " + table + ";");
            while (resultSet.next()) {

                musicQuizList.add(new MusicQuiz(resultSet.getString("artist"),
                        resultSet.getString("song"),
                        resultSet.getInt("year")));
            }
            if ((statement.getWarnings() == null) && (resultSet.getWarnings() == null)) {
                System.out.println("Quiz list created from table " + table);
            } else {
                System.out.println(statement.getWarnings());
                System.out.println(resultSet.getWarnings());
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                statement.close();
                resultSet.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        return musicQuizList;
    }
}

