package org.smart4j.chapter1.service;

import Database.DatabaseHelper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Administrator on 2018/1/2.
 */
public class QueryCustomer {
    static String sql,sq2 = null;
    static DatabaseHelper db = new DatabaseHelper();//创建DBHelper对象
    static ResultSet ret1,ret2 = null;

    static PreparedStatement ps1,ps2 =null;
    public void queryCustomer(){


            sql = "select *from customer";//SQL语句
                try {
                ps1 = db.conn.prepareStatement(sql);
                ret1 =ps1.executeQuery(sql);//执行语句，得到结果集
                while (ret1.next()) {
                    String uid = ret1.getString(1);
                    String ufname = ret1.getString(2);
                    String ulname = ret1.getString(3);
                    String udate = ret1.getString(4);
                    System.out.println(uid + "\t" + ufname + "\t" + ulname + "\t" + udate );
                }
                ret1.close();
                ps1.close();
                db.close();//关闭连接
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }
}
