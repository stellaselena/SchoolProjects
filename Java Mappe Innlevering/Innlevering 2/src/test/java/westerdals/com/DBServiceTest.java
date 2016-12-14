package westerdals.com;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import westerdals.com.Database.DBHandler;
import westerdals.com.Database.DBService;
import westerdals.com.Quiz.MusicQuiz;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


public class DBServiceTest {
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
        statement = connection.createStatement();
    }

    @After
    public void tearDown() throws Exception {
        statement.close();
        connection.close();
    }

    @Test
    public void TableMusicQuizTest() throws Exception {

        try {
            rs = statement.executeQuery("SELECT * FROM musicquiz;");
            rs.next();
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals("Adele", rs.getString(1));
    }

    @Test
    public void createMusicQuizListTest() throws Exception {

        List<MusicQuiz> mql = dbService.createMusicQuizList("musicquiz");
        assertNotNull(mql);


    }
}
