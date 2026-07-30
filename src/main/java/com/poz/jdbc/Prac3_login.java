package com.poz.jdbc;
import com.poz.model.*;
import com.poz.util.DataSourceUtil;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Prac3_login {
    public static void main(String[] args) {
        String sql = "SELECT * FROM Users where username=? and password=?";
        String username = "alice";
        String password = "alice123";

        try {
            Connection conn = DataSourceUtil.getConnection();
            conn.setAutoCommit(false);
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,username);
            pstmt.setString(2,password);

            ResultSet rs = pstmt.executeQuery();

            if(rs.next()){
                System.out.println("登入成功");
            }else {
                System.out.println("登入失敗");
            }
            conn.commit();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
