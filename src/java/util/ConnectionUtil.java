package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author vishnu-pt517
 */
public class ConnectionUtil {

    /**
     *
     * @return
     */
    public static Connection getConnection() {
        return CreateConnection(DB.getDomain(), DB.getDb(), DB.getUsername(), DB.getPassword());
    }

    private static Connection CreateConnection(String host, String db, String username, String password) {
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            String str = "jdbc:mysql://" + host + "/" + db;
            con = DriverManager.getConnection(str, username, password);
        } catch (ClassNotFoundException cnf) {
            System.out.println(cnf);
        } catch (SQLException ex) {
            System.out.println(ex);
        } catch (InstantiationException ex) {
            System.out.println(ex);
        } catch (IllegalAccessException ex) {
            System.out.println(ex);
        } finally {
            return con;
        }
    }
}
