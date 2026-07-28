package com.poz.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDemo3_Connection {
    public static void main(String[] args) {
        String url = "jdbc:sqlserver://;databaseName=jdbc;" + "trustServerCertificate=true;";
        String username = "root";
        String password = "1247";

        String nick = "UPDATE cash SET  deposit += 1000  where name='nick'";
        String year = "UPDATE cash SET  deposit += 1000 where name='year'";


        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            Statement stmt = conn.createStatement();
            conn.setAutoCommit(false);

            int countNick = stmt.executeUpdate(nick);
            int countYear = stmt.executeUpdate(year);

            if(countNick>0 && countYear>0){
                System.out.println("修改成功");
            }else {
                System.out.println("修改失敗");
            }

            conn.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
