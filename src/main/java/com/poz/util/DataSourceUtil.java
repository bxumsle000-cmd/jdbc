package com.poz.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.sql.*;
import java.io.FileInputStream;
import java.util.Properties;


public class DataSourceUtil {
    private static DataSource dataSource;

    static {
        try {
            Properties prop = new Properties();
            prop.load(new FileInputStream("src/main/resources/druid.properties"));
            dataSource = DruidDataSourceFactory.createDataSource(prop);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

}
