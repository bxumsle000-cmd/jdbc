package com.poz.jdbc;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.sql.*;
import java.io.FileInputStream;
import java.util.Properties;

public class JDBCDemo8_DruidDemo {
    public static void main(String[] args) throws Exception {
        // 讀 resources 底下的 druid.properties
        Properties prop = new Properties();
        prop.load(new FileInputStream("src/main/resources/druid.properties"));
        // 工廠幫你根據設定檔造出一個池子
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);

        Connection conn = dataSource.getConnection();
        String user = "alice";
        String hash = "alice123";

        String sqlQuery = "SELECT * FROM Users WHERE username=? and password=?";
        PreparedStatement pstmt = conn.prepareStatement(sqlQuery);
        pstmt.setString(1, user);
        pstmt.setString(2, hash);

        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            System.out.println("登入成功");
        } else {
            System.out.println("登入失敗");
        }
        pstmt.close();
        conn.close();
    }
}
