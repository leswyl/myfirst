package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import Properties.PropertiesUtil;

/**
 * Created by Administrator on 2018/1/2.
 */
public class DatabaseHelper {

    static  Properties pro =  PropertiesUtil.loadPros("database.properties");
    public static final String url = pro.getProperty("jdbc.url");
    public static final String name =pro.getProperty("jdbc.driver");
    public static final String user = pro.getProperty("jdbc.username");
    public static final String password = pro.getProperty("jdbc.password");


    public Connection conn = null;

    public DatabaseHelper() {
        try {
            Class.forName(name);//指定连接类型
            conn = DriverManager.getConnection(url, user, password);//获取连接

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void close() {
        try {
            this.conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}