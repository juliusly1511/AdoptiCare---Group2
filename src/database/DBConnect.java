package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class DBConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/adopticaredb";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            throw new SQLException("MySQL JDBC driver not found. Make sure the connector is available.", ex);
        }

        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
