package com.jobinterviewer.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Utility class to manage database connections.
 * This class provides a method to establish a connection
 * to the MySQL database for the Virtual Interviewer application.
 */
public class DatabaseConnection {
    
    // Database connection URL (points to schema "Virtual_Interviewer" on localhost)
    private static final String URL = "jdbc:mysql://localhost:3306/Virtual_Interviewer";
    
    // Database username (default: root)
    private static final String USER = "root";
    
    // Database password (default: root)
    private static final String PASS = "root";

    /**
     * Establishes and returns a connection to the database.
     * 
     * @return Connection object to interact with the database
     * @throws SQLException if a database access error occurs
     */
    public static Connection getConnection() throws SQLException {
        // DriverManager is responsible for managing JDBC drivers.
        // Here, it creates and returns a new database connection.
        return DriverManager.getConnection(URL, USER, PASS);
    }
}
