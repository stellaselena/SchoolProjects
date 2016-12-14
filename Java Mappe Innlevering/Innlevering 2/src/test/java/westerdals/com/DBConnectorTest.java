package westerdals.com;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import westerdals.com.Database.DBConnector;
import westerdals.com.Database.DBHandler;
import westerdals.com.Database.DBService;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DBConnectorTest {
    private DBConnector dbConnector;
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

    }

    @After
    public void tearDown() throws Exception {
        connection.close();

    }

    @Test

    public void getConnectionTest() throws SQLException {

        assertNotNull(connection);
        assertFalse(connection.isClosed());

    }

    @Test
    public void isConnectionClosing() throws Exception {

        connection.close();
        assertTrue(connection.isClosed());
    }


}
