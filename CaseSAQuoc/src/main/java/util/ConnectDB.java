package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
    private static String jdbcURL =
            "jdbc:mysql://localhost:3306/product?useSSL=false";
    private static String jdbcUsername = "root";
    private static String jdbcPassword = "26032000";

    public static Connection getConnection() throws SQLException {
        Connection connection = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return connection = DriverManager.getConnection(jdbcURL,
                jdbcUsername, jdbcPassword);

    }
}
