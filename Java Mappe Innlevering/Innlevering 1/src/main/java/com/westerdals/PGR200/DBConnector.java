package com.westerdals.PGR200;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.sql.*;

/**
 * Class DBConnector
 * Establishes a connection to a database
 */
public class DBConnector {

    private Connection connection;


    /**
     * Default constructor
     */
    public DBConnector(String dbName,
                       String hostName,
                       String userName,
                       String password,
                       String port) {

        MysqlDataSource ds = new MysqlDataSource();
        ds.setDatabaseName(dbName);
        ds.setServerName(hostName);
        ds.setUser(userName);
        ds.setPassword(password);
        ds.setPort(Integer.valueOf(port));
        try {
            connection = ds.getConnection();
            System.out.println("Connection established");
            System.out.println();
        } catch (SQLException exc) {
            System.out.println(exc.getMessage());
            System.exit(0);
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public boolean closeConnection() throws SQLException {
        getConnection().close();
        return getConnection().isClosed();
    }

}