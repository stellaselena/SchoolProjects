package westerdals.com.Database;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.*;

public class DBHandler {
    public static DBService dbLogin(String password, String username, String hostName, String dbName, String port) throws Exception {
        return new DBService(password, username, hostName, dbName, port);
    }

    public static HashMap<String, String> readProperties() {

        Properties prop = new Properties();
        InputStream input = null;
        HashMap<String, String> config = new HashMap<String, String>();
        try {

            input = new FileInputStream("dbinfo.properties");
            prop.load(input);
            config.put("dbpassword", prop.getProperty("dbpassword"));
            config.put("hostname", prop.getProperty("hostname"));
            config.put("dbuser", prop.getProperty("dbuser"));
            config.put("dbname", prop.getProperty("dbname"));
            config.put("port", prop.getProperty("port"));

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.getMessage();
                }
            }
        }
        return config;
    }
}
