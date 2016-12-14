package com.westerdals.PGR200;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

import static junit.framework.TestCase.assertNotNull;


/**
 * Created by Stella on 06.11.2016.
 */
public class DBHandlerTest {
    private DBHandler dbHandler;


    @Before
    public void setUp() throws Exception {
        dbHandler = new DBHandler();
    }

    @After
    public void tearDown() throws Exception {

    }

    /**
     * Checks if readProperties method is reading the property file as intended.
     */
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