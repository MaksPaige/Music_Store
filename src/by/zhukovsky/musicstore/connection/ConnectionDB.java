package by.zhukovsky.musicstore.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * Created by Maksim Zhukovsky on 25.03.2018.
 */

public class ConnectionDB {

    private static ResourceBundle resourceBundle = ResourceBundle.getBundle("resources.database");
    private static String url = resourceBundle.getString("db.url");
    private static String user = resourceBundle.getString("db.user");
    private static String pass = resourceBundle.getString("db.password");

    public static Connection createConnection() throws SQLException {
        System.out.println("BlaBlaBla");
        return DriverManager.getConnection(url, user, pass);
    }

}
