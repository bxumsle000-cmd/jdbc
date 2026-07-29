package com.poz.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;

public class JDBCDemo2_DriverManager {
    public static  void main(String[] args) throws SQLException {
        String url = "jdbc:sqlserver://;databaseName=jdbc;"
                + "trustServerCertificate=true;";
        String username = "root";
        String password = "1247";
        Connection conn = DriverManager.getConnection(url,username,password);

        String sql = "insert into cash (name,deposit) VALUES ('bin',413);" ;
        Statement stmt = conn.createStatement();


        int count = stmt.executeUpdate(sql);

        System.out.println(count);

    }
}
