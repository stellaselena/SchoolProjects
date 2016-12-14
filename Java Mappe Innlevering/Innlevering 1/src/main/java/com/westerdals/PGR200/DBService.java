package com.westerdals.PGR200;

import java.sql.*;
import java.util.HashMap;
import java.util.Vector;


/**
 * Class DBService
 * Offers methods copyFile, createTable and show table.
 */
public class DBService {

    public DBConnector connector;
    private Connection connection;


    public DBService(String dbPassword,
                     String dbUser,
                     String hostName,
                     String dbName,
                     String port) throws SQLException {

        connector = new DBConnector(dbName, hostName, dbUser, dbPassword, port);
        connection = connector.getConnection();
    }

    public void releaseConnection() {
        try {
            connector.closeConnection();
        } catch (SQLException exc) {
            System.out.println(exc.getMessage());
        }
    }


    /**
     * copyFile copies a fileName and creates a tableName with fileName's data and structure
     *
     * @param fileName
     * @param tableName
     * @throws Exception
     */
    public void copyFile(String fileName, String tableName) {

        FileIO.assertExists(fileName);
        PreparedStatement statement = null;
        Vector<HashMap<String, String>> data = null;
        if (tableName == null) {
            throw new NullPointerException("No values to read");
        }


        try {
            if (connection != null) {

                data = FileIO.readFile(fileName);
                Vector<String> sqlColumnOrder = new Vector<String>();
                String query = DBHandler.prepareForImport(tableName, data.get(0), sqlColumnOrder);
                createTable(tableName, FileIO.getTableHeader(fileName));
                statement = connection.prepareStatement(query);
                for (int i = 0; i < data.size(); i++) {
                    for (int j = 0; j < sqlColumnOrder.size(); j++) {
                        statement.setString(j + 1, data.get(i).get(sqlColumnOrder.get(j)));
                    }
                    statement.executeUpdate();
                }
            } else {
                System.out.println("Connection is not established");
            }

        } catch (Exception exc) {
            System.out.println(exc.getMessage());
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }

    }


    /**
     * createTable creates a table
     *
     * @param tableName
     * @param tableHeader
     * @throws SQLException
     */
    public void createTable(String tableName, String tableHeader)  {

        if (tableName == null || tableHeader == null) {
            throw new NullPointerException("No values to read");
        } else {
            Statement statement = null;
            try {
                System.out.println();
                System.out.println("Creating Table: " + tableName);
                String query = "CREATE TABLE IF NOT EXISTS " + tableName + " (" + tableHeader + ")";
                statement = connection.createStatement();
                statement.executeUpdate(query);
                if (statement.getWarnings() == null) {
                    System.out.println("Table " + tableName + " created");
                } else {
                    System.out.println(statement.getWarnings());
                    System.out.println("Table with a given name already exists. ");
                }
            } catch (Exception exc) {
                System.out.println(exc.getMessage());
            } finally {
                if (statement != null) {
                    try {
                        statement.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    /**
     * showTable shows table information in console
     *
     * @param tableName
     * @throws SQLException
     */
    public void showTable(String tableName)  {
        if (tableName == null) {
            throw new NullPointerException("No values to read");
        } else {
            Statement statement = null;
            ResultSet resultSet = null;
            Vector<String> columnNames = new Vector<String>();
            try {
                System.out.println("Table " + tableName + ":");
                System.out.println();
                statement = connection.createStatement();
                resultSet = statement.executeQuery("SELECT * FROM " + tableName + ";");
                if (resultSet != null) {
                    ResultSetMetaData columns = resultSet.getMetaData();
                    int i = 0;
                    while (i < columns.getColumnCount()) {
                        i++;
                        System.out.print(columns.getColumnName(i) + "\t");
                        columnNames.add(columns.getColumnName(i));
                    }
                    System.out.print("\n");

                    while (resultSet.next()) {
                        for (i = 0; i < columnNames.size(); i++) {
                            System.out.print(resultSet.getString(columnNames.get(i)) + "\t");


                        }
                        System.out.print("\n");
                    }

                }
            } catch (SQLException exc) {
                System.out.println(exc.getMessage());
            } finally {
                try {

                    if (resultSet != null) {
                        resultSet.close();
                    }
                    if (statement != null) {
                        statement.close();
                    }

                } catch (Exception exc) {
                    System.out.println(exc.toString());
                }
                System.out.println("Process finished.");
            }
        }


    }

    protected void dropTables(String tableName) throws Exception {
        Statement statement = connection.createStatement();
        String sql = "DROP TABLE " + tableName+";";
        statement.executeUpdate(sql);
        System.out.println("Table " + tableName + " deleted");
    }
}

