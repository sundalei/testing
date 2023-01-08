package com.example.project.extension;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcConnectionUtil {
    
    private static Connection connection;

    public static Connection getConnection() {

        if (connection == null || isClosed(connection)) {
            Properties properties = new Properties();
            try {
                properties.load(JdbcConnectionUtil.class.getResourceAsStream("/jdbc.properties"));

                String jdbcUrl = properties.getProperty("jdbc.url");
                String driver = properties.getProperty("jdbc.driver");
                String username = properties.getProperty("jdbc.user");
                String password = properties.getProperty("jdbc.password");

                connection = getConnection(jdbcUrl, driver, username, password);
                return connection;
            } catch (IOException ex) {
                ex.printStackTrace();
                return null;
            }
        }
        return connection;
    }

    public static Connection getConnection(String jdbcUrl, String driver, String username, String password) {
        if (connection == null || isClosed(connection)) {
            try {
                Class.forName(driver);
                connection = DriverManager.getConnection(jdbcUrl, username, password);
                return connection;
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
                return null;
            }
        }

        return connection;
    }

    private static boolean isClosed(Connection connection) {
        try {
            return connection.isClosed();
        } catch (SQLException e) {
            return true;
        }
    }
}