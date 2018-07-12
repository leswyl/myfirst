package test;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Properties;

import Database.DatabaseHelper;

/**
 * Created by Administrator on 2018/1/2.
 */
public class DatabaseTest {
    static String sql,sq2 = null;
    static DatabaseHelper db = new DatabaseHelper();//创建DBHelper对象
    static ResultSet ret1,ret2 = null;

    static PreparedStatement ps1,ps2 =null;


    public static void main(String[] args) {
        sql = "select *from customer";//SQL语句

        sq2 = "select *from customer";//SQL语句
        try {
            ps1 = db.conn.prepareStatement(sql);
            ret1 =ps1.executeQuery(sql);//执行语句，得到结果集
            while (ret1.next()) {
                String uid = ret1.getString(1);
                String ufname = ret1.getString(2);
                String ulname = ret1.getString(3);
                String udate = ret1.getString(4);
                System.out.println(uid + "\t" + ufname + "\t" + ulname + "\t" + udate );
            }//显示数据
            ps2 = db.conn.prepareStatement(sq2);
            ret2 = ps2.executeQuery(sq2);//执行语句，得到结果集
            while (ret2.next()) {
                String uid = ret2.getString(1);
                String ufname = ret2.getString(2);
                String ulname = ret2.getString(3);
                String udate = ret2.getString(4);
                System.out.println(uid + "\t" + ufname + "\t" + ulname + "\t" + udate );
            }//显示数据

            ps1.close();ps2.close();
            ret1.close();ret2.close();
            db.close();//关闭连接
        } catch (SQLException e) {
            e.printStackTrace();
        }


//        Properties prop = new Properties();
//        try{
//            //读取属性文件a.properties
//           InputStream in = DatabaseTest.class.getClassLoader().getResourceAsStream("database.properties");
//            prop.load(in);     ///加载属性列表
//            in.close();
//        }
//        catch(Exception e){
//            System.out.println(e);
//        }
    }

}