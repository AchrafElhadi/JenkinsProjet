package com.example.javafxdatabasemaven;

import java.sql.Connection;
import java.sql.DriverManager;

public class dd {
    private static Connection connection;

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/commerce","root","");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection()
    {
        return connection;
    }
}



