package one;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MariaDbConnection {
    private MariaDbConnection() {
        /* This utility class should not be instantiated */
    }


    private static Connection connection;

    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            try {
                String user = System.getenv("DB_USER");
                String password = System.getenv("DB_PASSWORD");
                connection = DriverManager.getConnection(
                        "jdbc:mariadb://localhost:3306/shopping_cart_localization?user=" + user + "&password=" + password);
            } catch (SQLException e) {
                System.out.println("Connection failed: " + e);
            }
        }
        return connection;
    }
}