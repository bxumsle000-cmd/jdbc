package com.poz.jdbc;


import java.sql.*;

public class JDBCDemo7_PreparedStatement {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:sqlserver://;databaseName=jdbc;"
                + "trustServerCertificate=true;";
        String username = "root";
        String password = "1247";
        Connection conn = DriverManager.getConnection(url, username, password);

        String user =  "alice";
        String hash = "alice123";

        String sqlQuery = "SELECT * FROM Users WHERE username=? and password=?" ;
        PreparedStatement pstmt = conn.prepareStatement(sqlQuery);
        pstmt.setString(1,user);
        pstmt.setString(2,hash);

        ResultSet rs = pstmt.executeQuery();
        if (rs.next()){
            System.out.println("登入成功");
        }else {
            System.out.println("登入失敗");
        }
        pstmt.close();
        conn.close();
    }
}
