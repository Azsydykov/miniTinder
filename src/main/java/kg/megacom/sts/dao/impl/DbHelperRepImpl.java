package kg.megacom.sts.dao.impl;
import kg.megacom.sts.dao.DbHelperRep;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbHelperRepImpl implements DbHelperRep {
    private final String url = "jdbc:postgresql://Localhost/miniTinder";
    private final String user = "postgres";
    private final String password = "postgres";


    @Override
    public Connection connect() throws SQLException {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connection to the PostgresSQL server successfully");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
}
