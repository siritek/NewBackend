package com.example.withoutdb.service;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConn {
    public static Connection getMyConnection() {

        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sample_db", "root", "root");
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
        return conn;
    }
}
