package com.westerdals.PGR200;


import org.junit.Test;
import org.junit.After;
import org.junit.Before;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;


/**
 * Test of DBService functions.
 */
public class DBServiceTest {


    private DBService dbService;
    private Connection connection;
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
    }

    @After
    public void tearDown() throws Exception {


        connection.close();
        dbService = null;


    }

    /**
     * Checks if copyFile method fails when given parameters are wrong.
     */
    @Test
    public void copyFileFailTest() {
        boolean exc = false;
        try {
            dbService.copyFile("thishsouldfail", "thishsouldfail");
        } catch (Exception e) {
            exc = true;
        }
        assertTrue("An exception should be caught by copyFile()", exc);
    }

    /**
     * Checks if copyFile method is reading data and inserting it
     * into a database table correctly, by checking if
     * expected values are inserted.
     */
    @Test
    public void copyFileTest() throws Exception {
        dbService.copyFile("C:/Eksempelfil.txt", "test");
        String query = "select * from test";
        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet rs = statement.executeQuery();
        rs.next();
        assertEquals("Donald Duck", rs.getString(1));
        dbService.dropTables("test");


    }


}


