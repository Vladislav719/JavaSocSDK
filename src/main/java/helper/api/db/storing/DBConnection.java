package helper.api.db.storing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by vladislav on 15.08.14.
 */
public class DBConnection {
    private volatile static Connection connection = null;

    static final String JDBC_DRIVER="com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://mysql40.h234.ru.";
    static final String USER = "h";
    static final String PASS = "p";

    public static Connection getDBConnection(){
        if ( connection == null ) {
            synchronized (DBConnection.class){
                if (connection == null){
                    try {
                        Class.forName(JDBC_DRIVER).newInstance();
                        connection = DriverManager.getConnection(DB_URL, USER, PASS);
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    } catch (InstantiationException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return connection;
    }
}
