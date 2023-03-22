package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class Util {
    // реализуйте настройку соеденения с БД
    private static String url = "jdbc:mysql://localhost:3306/test";
    private static String user = "root";
    private static String pass = "toor";
    private static Connection conn = null;

    public static Connection getConnection() {

        try {
            conn = DriverManager.getConnection(url, user, pass);
            conn.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
}
