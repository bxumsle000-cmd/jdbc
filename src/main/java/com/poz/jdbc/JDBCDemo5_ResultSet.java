package com.poz.jdbc;

import com.poz.model.*;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class JDBCDemo5_ResultSet {
    public static  void main(String[] args) throws SQLException {
        String url = "jdbc:sqlserver://;databaseName=jdbc;"
                + "trustServerCertificate=true;";
        String username = "root";
        String password = "1247";
        Connection conn = DriverManager.getConnection(url,username,password);

        String sql = "SELECT * from cash" ;
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        List<Account> actList = new ArrayList<>();
        while (rs.next()){
            String name = rs.getString("name");
            int deposit = rs.getInt("deposit");

            Account account = new Account(name,deposit);
            actList.add(account);
        }

        System.out.println(actList);
        stmt.close();
        conn.close();
    }
}
