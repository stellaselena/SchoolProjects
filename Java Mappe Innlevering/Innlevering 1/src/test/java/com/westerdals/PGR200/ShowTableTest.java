package com.westerdals.PGR200;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;


import static org.junit.Assert.assertEquals;

/**
 * Created by Stella on 06.11.2016.
 */
public class ShowTableTest {
    private DBService dbService;
    private Connection connection;
    private Statement statement;
    private ResultSet rs;
    private HashMap<String, String> config;



    @Before
    public void setUp() throws Exception {
        config = DBHandler.readProperties();
        dbService = DBHandler.dbLogin(config.get("dbpassword"),
                config.get("dbuser"),
                config.get("hostname"),
                config.get("dbname"),
                config.get("port"));
        connection = dbService.connector.getConnection();
        dbService.copyFile("C:/Eksempelfil.txt", "test");
        statement = connection.createStatement();
        rs = statement.executeQuery("SELECT * FROM test;");
    }

    @After
    public void tearDown() throws Exception {
        rs.close();
        statement.close();
        dbService.dropTables("test");
        connection.close();

    }

    /**
     * Checks if showTable is working as intended, by comparing the first value in table
     * with the expected one.
     */
    @Test
    public void showTableTest() throws Exception {

        try {
            dbService.showTable("test");
            rs.next();
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals("Donald Duck", rs.getString(1));
    }
}