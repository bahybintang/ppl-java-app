package Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    public static Connection getConnection() {
        Connection conn = null;
        String url = "jdbc:mysql://localhost:32000/ecommerce?autoReconnect=true&useSSL=false";
        String user = "root";
        String password = "root";
        try {
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.out.println(e);
        }
        System.out.println("Connection to database established!");
        return conn;
    }
}
