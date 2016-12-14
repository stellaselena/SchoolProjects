package com.westerdals.PGR200;


import org.junit.Test;
import org.junit.After;
import org.junit.Before;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Vector;

import static org.hamcrest.core.IsNull.notNullValue;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertFalse;

import static org.junit.Assert.*;


/**
 * Test of FileIO functions.
 */
public class FileIOTest {
    private FileIO fIO;
    private DBService dbService;

    @Before
    public void setUp() throws Exception {
        dbService = new DBService("stella1234", "root", "localhost", "world", "3306");
    }

    @After
    public void tearDown() throws Exception {

    }

    /**
     * Checks if readFile method reads a file by asserting
     * that the values read are not of null value.
     */
    @Test
    public void readFileTest() throws Exception {

        Vector<HashMap<String, String>> lines = fIO.readFile("C:/Eksempelfil.txt");

        assertThat(lines, notNullValue());
    }

    /**
     * Checks if getTableHeader method catches an exception
     * when a non existing file name is provided.
     */
    @Test
    public void getTableHeaderTest() {
        boolean exceptionCaught = false;
        try {
            fIO.getTableHeader("C:/Eksempelfil.txt");
        } catch (NullPointerException e) {
            exceptionCaught = true;
            System.out.println("Not found");
        }
        assertFalse("An exception should be thrown/caught", exceptionCaught);
    }

    /**
     * Checks if getTableHeader correctly reads lines of a file in
     * order to pass them as column names.
     *
     * @throws Exception
     */
    @Test
    public void getTableHeaderColumnCountTest() throws Exception {

        try {
            fIO.getTableHeader("C:/Eksempelfil.txt");
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals("Navn VARCHAR(128), Adresse VARCHAR(128), Alder INT(3), Mail VARCHAR(128)",
                fIO.getTableHeader("C:/Eksempelfil.txt"));
    }


}


