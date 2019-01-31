package indi.dao;

import indi.model.daoModel.Loginer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author JOJO
 * 此类用于处理登陆窗口中用户的登陆事务 (与数据库连接)
 */
public class HandleLoginDate {
    private static final String USER = "root";
    private static final String PASSWORD = "6010";
    private static final String URL = "jdbc:mysql:"
                + "//localhost:3306/longmaodazitong?"
                + "useUnicode=true&characterEncoding=UTF-8&"
                + "useSSL=false&serverTimezone=Asia/Shanghai";
    Connection connection = null;
    PreparedStatement preSql;
    
    public  HandleLoginDate () {

        //  注册数据库的驱动,使用反射注册驱动
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        
        //  获得数据库的连接访问权限
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * 
     *  此方法用于将用户登陆的信息与数据库信息匹配
     *  接受一个Loginer参数(Model), 返回一个 int 值参数 loginSuccess
     *  其中的 loginSuccess 变量有三个返回值，默认值 0 代表用户名不存在
     *  返回值 1 代表用户名存在，且密码输入正确
     *  返回值 -1 代表用户名存在，但密码输入错误
     */
    // <editor-fold defaultstate="collapsed" desc="public int checkLoginModel (Loginer loginer) 方法 Code">
    public int checkLoginDate (Loginer loginer) {
        
        int loginSuccess = 0;
        
        final String userName = loginer.getUserName();
        final String userPassword = loginer.getPassWord();
        final String sqlString = "select user_password, user_id "  //  要注意这后面的空格
                + "from db_user "
                + "where user_name = ?";
        
        try {
            preSql = connection.prepareStatement(sqlString);
            preSql.setString(1, userName);
            ResultSet rs = preSql.executeQuery();
            //  若rs集为空，则证明该用户名数据库中不存在
            if (rs.next() != false) {
                //  将用户输入的密码与数据库中查询的密码进行匹配
                if ( userPassword.equals(rs.getString("user_password")) ) {
                    
                    loginSuccess = 1;  //  登陆成功
                    //  写入Loginer对象的user_id
                    loginer.setUserId(rs.getInt("user_id"));
                    /**
                     * 更新用户的登陆日期 CODE  // 待写
                     */
                } else
                    loginSuccess = -1; //  密码不正确
            }
             
        } catch (Exception e) {
            e.printStackTrace();
            }
        
        //  关闭数据库连接
        try {
            connection.close();
	} catch (SQLException e) {
            e.printStackTrace();
            }
        
        return loginSuccess;
    } // </editor-fold>
    
}