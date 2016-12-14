package com.westerdals.PGR200;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.*;

/**
 * Class DBHandler
 * Contains help methods
 */
public class DBHandler {
    protected static DBService dbLogin(String password, String username, String hostName, String dbName, String port) throws SQLException {
        return new DBService(password, username, hostName, dbName, port);
    }

    protected static void doDatabaseWork(DBService dbServiceManual, String filePath, String tableName) {
        if (dbServiceManual == null ||filePath == null || tableName == null ) {
            throw new NullPointerException("No values to read");
        }
        try {
            dbServiceManual.copyFile(filePath, tableName);
            System.out.println();
            dbServiceManual.showTable(tableName);
        } catch (Exception exc) {
            System.out.println(exc.getMessage());

        } finally {

            dbServiceManual.releaseConnection();
        }
        System.exit(0);
    }


    protected static HashMap<String, String> readProperties() {

        Properties prop = new Properties();
        InputStream input = null;
        HashMap<String, String> config = new HashMap<String, String>();
        try {

            input = new FileInputStream("C:/dbinfo.properties");

            // load properties file
            prop.load(input);

            // get the property value and print it out
            config.put("dbpassword", prop.getProperty("dbpassword"));
            config.put("hostname", prop.getProperty("hostname"));
            config.put("dbuser", prop.getProperty("dbuser"));
            config.put("dbname", prop.getProperty("dbname"));
            config.put("port", prop.getProperty("port"));
            config.put("inputfilepath", prop.getProperty("inputfilepath"));
            config.put("tablename", prop.getProperty("tablename"));

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return config;
    }

    protected static String prepareForImport(String tableName, HashMap<String, String> record, Vector<String> sqlColumnOrder) throws Exception {
        if (tableName == null ||record == null || sqlColumnOrder == null ) {
            throw new NullPointerException("No values to read");
        }
        String query = null;
        StringBuilder queryBuilder = new StringBuilder("INSERT INTO ");
        queryBuilder.append(tableName);
        queryBuilder.append(" (");
        StringBuilder querySuffix = new StringBuilder("VALUES (");
        Iterator it = record.entrySet().iterator();
        while (it.hasNext()) {

            Map.Entry pair = (Map.Entry) it.next();
            //System.out.println(pair.getKey() + " = " + pair.getValue());
            queryBuilder.append(pair.getKey());
            sqlColumnOrder.add((String) pair.getKey());
            querySuffix.append("?");
            if (it.hasNext()) {
                queryBuilder.append(", ");
                querySuffix.append(", ");
            } else {
                queryBuilder.append(") ");
                querySuffix.append(") ");
            }

        }
        queryBuilder.append(querySuffix);

        query = queryBuilder.toString();
        return query;
    }




}
