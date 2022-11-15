package kg.megacom.sts.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DbHelper {
    private final String url = "jdbc:postgresql://Localhost/miniTinder";
    private final String user = "postgres";
    private final String password = "postgres";

    public Connection connection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
          //  System.out.println("Connection to the PostgresSQL server successfully");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

}
