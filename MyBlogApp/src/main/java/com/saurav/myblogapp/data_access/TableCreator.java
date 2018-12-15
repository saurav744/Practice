package com.saurav.myblogapp.data_access;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TableCreator {
    static String DRIVER = "com.mysql.jdbc.Driver";
    static String CONNECTION_URL = "jdbc:mysql://localhost/blog";
    static String USERNAME = "root";
    static String PASSWORD = "root";

    public static void main(String args[]) {
        Statement stmt=null;
        Connection conn=null;
        try    {

            //Register driver
            Class.forName(DRIVER);

            //Create connection
            conn = DriverManager.getConnection(CONNECTION_URL, USERNAME, PASSWORD);

            //Create statement
            stmt = conn.createStatement();

            //SQL for creating table
            String sql = "CREATE TABLE REGISTERED_USERS " + "( FIRST_NAME VARCHAR(255), " + " LAST_NAME VARCHAR(255), " + " DOB DATE, " + " AGE INTEGER, "
                    + " ADDRESS VARCHAR(255), " + " PHONE VARCHAR(12), " + " EMAIL VARCHAR(255), "
                    + " ROLE VARCHAR(255), " + " USERNAME VARCHAR(255), " + " PASSWORD VARCHAR(255), "
                    + " PRIMARY KEY ( USERNAME ))";
            //Execute sql
            stmt.executeUpdate(sql);
            
            //SQL to create admin
            sql = "Insert into REGISTERED_USERS (FIRST_NAME, LAST_NAME, DOB, AGE, ADDRESS, PHONE, EMAIL, ROLE, "
                    + "USERNAME, PASSWORD) VALUES ('Shveta', 'Patyal', '1992-07-25', 25, 'abc',"
                    + " '9999999999', 'shveta625@gmail.com','admin', 'admin', 'admin')";
            //Execute sql
            stmt.executeUpdate(sql);
        }catch(ClassNotFoundException | SQLException e)    {
            e.printStackTrace();
        }finally {
            try {
                if (stmt != null)
                    conn.close();
            } catch (SQLException se) {
        }
        try {
            if (conn != null)
                conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        }
    }
}
}
