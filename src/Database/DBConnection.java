package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBConnection {

    public static Connection getConnection(String databaseName, String username,
            String password) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String connectionURL = "jdbc:sqlserver://localhost:1433"
             + ";instance=SQLEXPRESS;databaseName=" + databaseName;
            Connection conn = DriverManager.getConnection(connectionURL, username, password);

            return conn;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static Connection getConnection() {
        String username = "sa";
        String password = "thangpro";
        String databaseName = "QLKARAOKE";

        return getConnection(databaseName, username, password);
    }

}
