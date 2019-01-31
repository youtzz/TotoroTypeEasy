/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package indi.dao;

import indi.model.daoModel.LoginSuccess;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author JOJO 此类用于设置 LoginSuccess 类对象的各种成员变量值
 */
public class HandleLoginSuccess {

    private static final String USER = "root";
    private static final String PASSWORD = "6010";
    private static final String URL = "jdbc:mysql:"
            + "//localhost:3306/longmaodazitong?"
            + "useUnicode=true&characterEncoding=UTF-8&"
            + "useSSL=false&serverTimezone=Asia/Shanghai";
    Connection connection = null;
    PreparedStatement preSql;

    public HandleLoginSuccess() {
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

    public void setLoginSuccessDate(LoginSuccess loginSuccess) {
        final String sqlString = "select result_best, result_average, user_lastLoginDate "
                + "from db_result, db_user "
                + "where db_result.user_id = ? and db_user.user_id = ?";
        try {
            preSql = connection.prepareStatement(sqlString);
            preSql.setInt(1, loginSuccess.getUserId());
            preSql.setInt(2, loginSuccess.getUserId());
            ResultSet rs = preSql.executeQuery();
            System.out.println(loginSuccess.getUserId());
            if (rs.next() != false) {
                loginSuccess.setBestResult(rs.getInt("result_best"));
                loginSuccess.setAverageResult(rs.getInt("result_average"));
                loginSuccess.setLastLoginDate(rs.getString("user_lastLoginDate"));
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
        
    }
}
