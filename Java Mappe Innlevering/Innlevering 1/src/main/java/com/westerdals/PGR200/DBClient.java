package com.westerdals.PGR200;

import java.util.HashMap;
import java.util.Scanner;


/**
 * Class DBClient
 * Client, runs the application
 */
public class DBClient {
    public static void main(String[] args) {
        HashMap<String, String> config = DBHandler.readProperties();
        DBService dbService;
        if (config != null) {
            String msg = "You can either choose to login by default or by providing login credentials: Press 1 for manual login, 2 for default or 3 to exit. ";
            Scanner scanner = new Scanner(System.in);
            System.out.println(msg);
            System.out.println("Choose your option: ");

            while (true) {
                int option = scanner.nextInt();
                try {
                    switch (option) {
                        case 1:
                            System.out.println("Username: ");
                            String username = scanner.next();
                            System.out.println("Password: ");
                            String password = scanner.next();
                            System.out.println("Checking credentials...");
                            dbService = DBHandler.dbLogin(password,
                                    username,
                                    config.get("hostname"),
                                    config.get("dbname"),
                                    config.get("port"));
                            DBHandler.doDatabaseWork(dbService,
                                    config.get("inputfilepath"),
                                    config.get("tablename"));
                            break;
                        case 2:
                            dbService = DBHandler.dbLogin(config.get("dbpassword"),
                                    config.get("dbuser"),
                                    config.get("hostname"),
                                    config.get("dbname"),
                                    config.get("port"));
                            DBHandler.doDatabaseWork(dbService,
                                    config.get("inputfilepath"),
                                    config.get("tablename"));
                            break;
                        case 3:
                            System.exit(0);
                            break;
                        default:
                            System.out.println(msg);
                            System.out.println("Try again");
                    }
                } catch (Exception exc) {
                    System.out.println(exc.getMessage());
                }
            }
        } else {
            System.out.println("Config file is missing");
        }
    }

}
