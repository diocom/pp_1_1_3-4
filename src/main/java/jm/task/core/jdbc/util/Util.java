package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class Util {
    // реализуйте настройку соеденения с БД
    private static SessionFactory sf;
    private static String url = "jdbc:mysql://localhost:3306/test";
    private static String user = "root";
    private static String pass = "toor";
    private static Connection conn = null;

    public static Connection getConnection() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            conn = DriverManager.getConnection(url, user, pass);
            conn.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        return conn;
    }
    public static SessionFactory getSessionFactory() {
        if(sf == null) {
            try {
                Configuration conf = new Configuration();
                Properties settings = new Properties();
                settings.put(Environment.DRIVER,"com.mysql.cj.jdbc.Driver");
                settings.put(Environment.URL,"jdbc:mysql://localhost:3306/test?useSSL=false");
                settings.put(Environment.USER,"root");
                settings.put(Environment.PASS, "toor");
                settings.put(Environment.DIALECT,"org.hibernate,dialect.MySQL5Dialect");
                settings.put(Environment.SHOW_SQL, "true");
                settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
                settings.put(Environment.HBM2DDL_AUTO,"");
                conf.setProperties(settings);
                conf.addAnnotatedClass(User.class);
                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().
                        applySettings(conf.getProperties()).build();
                sf = conf.buildSessionFactory(serviceRegistry);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sf;
    }

}
