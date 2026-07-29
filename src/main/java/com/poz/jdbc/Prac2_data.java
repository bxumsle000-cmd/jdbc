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

public class Prac2_data {
    public static void main(String[] args) throws Exception {
        String sql = "select * from cash ; ";

        try {
            Connection conn = DataSourceUtil.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            List<Account> accountList = new ArrayList<>();
            while (rs.next()) {
                String name = rs.getString("name");
                int deposit = rs.getInt("deposit");

                Account account = new Account(name, deposit);
                accountList.add(account);
                System.out.println(accountList);
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}