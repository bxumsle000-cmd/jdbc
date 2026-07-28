package com.poz.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;

public class Cash {
    public static  void main(String[] args) throws SQLException {
        String url = "jdbc:sqlserver://localhost:1433;databaseName=jdbc;"
                + "user=root;password=1247;"
                + "trustServerCertificate=true;";
        Connection conn = DriverManager.getConnection(url);

        String sql = "insert into cash (name,deposit) VALUES ('nick',1000);" ;
        Statement stmt = conn.createStatement();

        int count = stmt.executeUpdate(sql);

        System.out.println(count);

        stmt.close();
        conn.close();
    }
}
