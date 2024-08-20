package com.example.demowebapp.utils;

import java.sql.*;

public class DBUtils {
    private static final String URL = "jdbc:mysql://localhost:3306/j1023_db";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    public static Connection getConnection(){
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e){
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }

    public static void close(Connection connection, Statement stmt, PreparedStatement pstmt, ResultSet rs){
        try {
            if (connection != null){
                connection.close();
            }
            if (stmt != null){
                stmt.close();
            }

            if (pstmt != null){
                pstmt.close();
            }
            if (rs != null){
                rs.close();
            }
        }  catch (SQLException e){
        System.out.println(e);
    }
    }
}
