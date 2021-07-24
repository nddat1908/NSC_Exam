package com.demo.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtils {
    private static Connection connection;

    public static synchronized Connection getConnection(){
        String url = "jdbc:mysql://localhost:3306/nsc_practice";
        String user = "root";
        String pass = "";
        if (connection == null){
            try{
                Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection(url, user, pass);
            }catch (SQLException | ClassNotFoundException throwables){
                throwables.printStackTrace();
            }
        }
        return connection;
    }

    public static void closeConnection(){
        try {
            connection.close();
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }finally {
            connection = null;
        }
    }
}
