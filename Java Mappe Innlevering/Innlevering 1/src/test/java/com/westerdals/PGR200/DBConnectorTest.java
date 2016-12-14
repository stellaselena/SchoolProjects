package com.westerdals.PGR200;


import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import org.junit.Test;
import org.junit.After;
import org.junit.Before;
import java.sql.SQLException;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Test of DBConnector functions.
 */
public class DBConnectorTest {

    private DBConnector dbConnector;
    private  DBHandler handler;


    @Before
    public void setUp() throws Exception {
        dbConnector = new DBConnector("world", "localhost", "root", "stella1234", "3306");
    }

    @After
    public void tearDown() throws Exception {
        dbConnector.getConnection().close();

    }

    @Test
    /**
     * Checks if connector establishes a connection when called
     *
     */
    public void getConnectionTest() throws SQLException {

        assertNotNull(dbConnector.getConnection());
        assertFalse(dbConnector.getConnection().isClosed());

    }

    @Test
    /**
     * Checks if connection is closing when method close is called
     *
     * @throws Exception
     */
    public void isConnectionClosing() throws Exception {

        dbConnector.getConnection().close();
        assertTrue(dbConnector.getConnection().isClosed());
        System.out.println("Connection closed");
    }

    @Test
    /**
     * Checks if connector constructor with parameters is working,
     * and if username is passed as expected
     *
     */
    public void getManualConnectionTest() throws Exception {
        MysqlDataSource ds = new MysqlDataSource();
        ds.setUser("stella");
        ds.setPassword("stella1234");
        assertEquals("stella", ds.getUser());

    }


}
