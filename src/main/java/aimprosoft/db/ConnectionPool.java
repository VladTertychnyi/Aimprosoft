package aimprosoft.db;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class ConnectionPool {
    private static final String USER_NAME = "root";
    private static final String USER_PASS = "qwerty";
    private static DataSource dataSource;

    public ConnectionPool(DataSource dataSource) {
        ConnectionPool.dataSource = dataSource;
    }

    static synchronized Connection getConnection() throws SQLException {
        Connection con = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/aimprosofttask?serverTimezone=UTC",
                    USER_NAME, USER_PASS);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return con;
    }
}


