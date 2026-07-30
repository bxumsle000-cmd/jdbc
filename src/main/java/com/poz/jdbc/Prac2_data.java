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
    public static void main(String[] args)  {
        String sql = "select * from cash ; ";

        try {
            Connection conn = DataSourceUtil.getConnection();
            conn.setAutoCommit(false);
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            List<Account> accountList = new ArrayList<>();
            while (rs.next()) {
                String name = rs.getString("name");
                int deposit = rs.getInt("deposit");

                Account account = new Account(name, deposit);
                accountList.add(account);
                System.out.println(accountList);
                conn.commit();
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}