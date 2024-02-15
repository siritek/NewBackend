package com.example.withoutdb.service;

import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;
@Service
public class DBConn {
    public static Connection getMyConnection() {

        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/nxtbase_db", "root", "root");
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
        return conn;
    }
}
