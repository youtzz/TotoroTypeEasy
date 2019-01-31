package indi.dao;

import indi.model.daoModel.Registrar;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author JOJO 此类用于处理 RegisterInternalFrame 内联窗口类中， 将用户注册信息传增添至数据库的事务
 */
public class HandleInsertRegisterDate {

    private static final String USER = "root";
    private static final String PASSWORD = "6010";
    private static final String URL = "jdbc:mysql:"
            + "//localhost:3306/longmaodazitong?"
            + "useUnicode=true&characterEncoding=UTF-8&"
            + "useSSL=false&serverTimezone=Asia/Shanghai";
    Connection connection = null;
    PreparedStatement preSql;
    ResultSet rs;
    int userId = 0;

    public HandleInsertRegisterDate() {
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

    /*
     *  此方法用于将用户注册信息写入数据库
     *  返回值 registerSuccess 变量为 0 时代表用户名重复
     *  为 -1 时代表数据库写入出错
     *  为 1 时代表注册成功
     */
    public int writeRegisterModel(Registrar registrar) {
        int registerSuccess = 0;
        //  判断用户注册名是否已存在
        String sqlString = "select user_name from db_user";
        try {
            preSql = connection.prepareStatement(sqlString);
            rs = preSql.executeQuery(sqlString);
            //  当db_user表为空时,此处会有bug,用户将无法注册
            //  调用rs.next()方法后,指针向会向后移，代码无法进入while循环
            //  registeSuccess 值始终为 0
            //  使用下面代码可以让用户直接注册,但却逃避了 导致空表 的直接问题
            if (rs.next() == false) {
                registerSuccess = 1;
            }
            rs.previous();  //  让指针向前移动

            while (rs.next()) {
                if (rs.getString("user_name").equals(registrar.getUserName()) == true) {
                    registerSuccess = 0;
                    break;
                } else {
                    registerSuccess = 1;  //  用户名不重复，进行下一步
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        //  如果用户名不重复，则将注册数据写入数据库
        if (registerSuccess == 1) {

            sqlString = "insert into db_user "
                    + "(user_name, user_password, user_registerDate) "
                    + "values (?, ?, ?)";
            try {
                preSql = connection.prepareStatement(sqlString);
                preSql.setString(1, registrar.getUserName());
                preSql.setString(2, registrar.getPassWord());
                preSql.setString(3, registrar.getRegisterDate());

                //  如果写入 user_db 表写入成功，则插入关联表 db_result
                if (preSql.executeUpdate() != 0) {
                    //  获得 db_user 表的主键 user_id
                    sqlString = "select user_id from db_user where user_name = ?";
                    try {
                        preSql = connection.prepareStatement(sqlString);
                        preSql.setString(1, registrar.getUserName());
                        rs = preSql.executeQuery();

                        if (rs.next() != false) {
                            userId = rs.getInt("user_id");  //  得到主键
                            sqlString = "insert into db_result (user_id) values (?)";  //  插入数据
                            try {
                                preSql = connection.prepareStatement(sqlString);
                                preSql.setInt(1, userId);
                                preSql.executeUpdate();
                            } catch (Exception e) {
                                e.printStackTrace();
                                registerSuccess = -1;
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        registerSuccess = -1;
                    }
                }
                registerSuccess = 1;
            } catch (SQLException e) {
                e.printStackTrace();
                registerSuccess = -1;
            }

        }

        //  关闭数据库连接
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return registerSuccess;
    }

}
