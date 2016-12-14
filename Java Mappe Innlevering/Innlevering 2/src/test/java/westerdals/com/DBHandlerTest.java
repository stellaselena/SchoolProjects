package westerdals.com;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.IOException;
import static junit.framework.TestCase.assertNotNull;
import westerdals.com.Database.DBHandler;

public class DBHandlerTest {
    private DBHandler dbHandler;


    @Before
    public void setUp() throws Exception {
        dbHandler = new DBHandler();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void readPropertiesTest() throws IOException {
        try {
            dbHandler.readProperties();

        } catch (Exception e) {
            e.printStackTrace();
        }
        assertNotNull(dbHandler.readProperties());
    }
}
