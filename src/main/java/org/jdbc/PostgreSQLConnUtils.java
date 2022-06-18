package org.jdbc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class PostgreSQLConnUtils {

    public static Connection getMySQLConnection() throws IOException {
        FileInputStream fis;
        Properties property = new Properties();

        fis = new FileInputStream("src/main/resources/config.properties");
        property.load(fis);

        Connection conn = null;
        try {
            conn = DriverManager.getConnection(property.getProperty("DB_HOST"), property.getProperty("DB_USER"), property.getProperty("DB_PASS"));

            if (conn != null) {
                System.out.println("Connected to the database!");
            } else {
                System.out.println("Failed to make connection!");
            }

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }
        return conn;
    }
}