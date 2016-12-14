package com.westerdals.PGR200;

import java.io.*;
import java.util.HashMap;
import java.util.Vector;

/**
 * Class FileIO
 * Reads files.
 */
public class FileIO {
    private FileIO() {
        throw new AssertionError("Class cannot be instantiated");
    }

    /**
     * readFile reads a fileName from 3rd line and returns file data values
     *
     * @param fileName
     * @return data
     * @throws Exception
     */
    protected static Vector<HashMap<String, String>> readFile(String fileName) {
        if (fileName == null) {
            throw new NullPointerException("No values to read");
        }
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(fileName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Vector<HashMap<String, String>> data = new Vector<HashMap<String, String>>();
        int columnCount = 0;
        try {
            String line = bufferedReader.readLine();

            String[] columns = null;

            int count = 0;
            while (line != null) {
                if (count > 2) {
                    String[] tokens = line.split("/");

                    HashMap<String, String> record = new HashMap<String, String>();
                    for (int i = 0; i < tokens.length; i++) {
                        System.out.println("token[" + i + "]" + tokens[i]);
                        record.put(columns[i], tokens[i]);
                    }
                    data.add(record);

                }

                if (count == 0) {
                    columns = line.split("/");

                }
                line = bufferedReader.readLine();
                count++;
            }

        } catch (Exception exc) {
            System.out.println(exc.getMessage());
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return data;
    }


    /**
     * getTableHeader reads first 3 lines from a text file and separates them into ColumnNames, dataType and dataSize
     *
     * @param fileName
     * @return TableHeader with ColumnName, DataType and DataSize info to be passed to CreateTable method
     * @throws IOException
     */
    protected static String getTableHeader(String fileName) {
        if (fileName == null) {
            throw new NullPointerException("No values to read");
        }
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(fileName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String tableHeader = "";

        try {

            String[] columnNames = null;
            String[] dataType = null;
            String[] dataSize = null;

            int count = 2;
            for (int i = 0; i <= count; i++) {
                String line = bufferedReader.readLine();
                if (i == 0) {
                    columnNames = line.split("/");
                }
                if (i == 1) {
                    dataType = line.split("/");
                }
                if (i == 2) {
                    dataSize = line.split("/");
                }
            }


            for (int i = 0; i < columnNames.length; i++) {
                tableHeader += columnNames[i];
                tableHeader += " " + dataType[i];
                tableHeader += "(" + dataSize[i] + "), ";
            }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return tableHeader.substring(0, tableHeader.length() - 2);
    }

    public static void assertExists(String filename) {
        File file = new File(filename);
        if (!file.exists()) {
            throw new RuntimeException("Specified file not found!");
        }
    }
}



