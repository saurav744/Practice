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
            String sql = "CREATE TABLE USERS "
                    + "(ID INT NOT NULL AUTO_INCREMENT"
                    + "FIRST_NAME VARCHAR(255), "
                    + "LAST_NAME VARCHAR(255), "
                    + "EMAIL VARCHAR(255), "
                    + " ROLE VARCHAR(255), "
                    + " PASSWORD VARCHAR(255), "
                    + " PRIMARY KEY ( ID ))";
            //Execute sql
            stmt.executeUpdate(sql);
            
            //SQL to create admin
            sql = "Insert into REGISTERED_USERS (FIRST_NAME, LAST_NAME, EMAIL, ROLE, PASSWORD) VALUES ('Saurav', 'Sharma', 'saurav61289@gmail.com','admin', 'admin')";
            //Execute sql
            stmt.executeUpdate(sql);

            sql = "CREATE TABLE PUBLICATIONS"
                    +"(ID INT NOT NULL AUTO_INCREMENT"
                    +"TITLE VARCHAR(255),"
                    +"BODY VARCHAR(4096),"
                    +"TYPE VARCHAR(255),"
                    +"STATE VARCHAR(255),"
                    +"AUTHORID INT NOT NULL,"
                    +"CREATED DATE,"
                    +"PRIMARY KEY (ID))";
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
