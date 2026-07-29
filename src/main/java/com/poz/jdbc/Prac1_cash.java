package com.poz.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Prac1_cash  {
    public static void main(String[] args) {
        String username = "root";
        String password = "1247";
        String url = "jdbc:sqlserver://;databaseName=jdbc;" + "trustServerCertificate=true";
        String sql = "Update cash set deposit+=1000 where name = 'year' ";
        try{
        Connection conn = DriverManager.getConnection(url,username,password);
        conn.setAutoCommit(false);
        Statement stmt = conn.createStatement();
        int count = stmt.executeUpdate(sql);
        if(count>0){
            System.out.println("修改成功");
        }else{
            System.out.println("修改失敗");
        }
        conn.commit();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
