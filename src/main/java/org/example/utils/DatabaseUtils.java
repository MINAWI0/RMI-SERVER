package org.example.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtils {

    private static final String URL = "jdbc:mysql://localhost:3306/RMI";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public static Connection getConnection() throws SQLException {
        System.out.println("inside the connection");
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
