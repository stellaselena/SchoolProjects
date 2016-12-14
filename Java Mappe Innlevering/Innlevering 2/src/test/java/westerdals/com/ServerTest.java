package westerdals.com;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import westerdals.com.Server.Server;


public class ServerTest {


    Server server = null;

    @Before
    public void initialize() {
        server = new Server();
    }

    @Test
    public void ServerRunningTest() {
        try {
            server.serverConnect();
            assertEquals(server.getPort(), 2222);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            assertTrue(false);

        }
    }

    @Test
    public void clientConnectTest() {

    }

}
