package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddEmployees {
    // JDBC URL, username, and password of HeidiSQL database
    private static final String JDBC_URL = "jdbc:mysql://localhost:3307/Assignment_3";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    public static void setUser(String first_name, String last_name, String email, String table_name) {
        try {
            // Load and register the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish a connection to the database
            try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
                // SQL query to insert records into the employees table
                String sql = "INSERT INTO "+table_name+"(first_name, last_name, email) VALUES (?, ?, ?)";

                // Prepare the SQL statement
                try (PreparedStatement statement = connection.prepareStatement(sql)) {
                    // Insert employee records into the employees table
                    statement.setString(1, first_name);  // first name
                    statement.setString(2, last_name);  // last name
                    statement.setString(3, email);  // email

                    statement.executeUpdate();

                    // Add more employee records as needed
                    // statement.setInt(...);
                    // statement.setString(...);
                    // statement.executeUpdate();

                    System.out.println("Records inserted successfully.");
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}