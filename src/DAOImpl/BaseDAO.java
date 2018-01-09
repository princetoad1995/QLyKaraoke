package DAOImpl;

import Database.DBConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class BaseDAO {

    protected Connection conn ;
    protected Statement stmt;
    protected ResultSet rs;

    public BaseDAO() {
        try {
            conn = DBConnection.getConnection();
            stmt = conn.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(BaseDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
