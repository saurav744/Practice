package com.saurav.myblogapp.data_access;

import java.sql.*;

public class UserManager {

    static String DRIVER = "com.mysql.jdbc.Driver";
    static String CONNECTION_URL = "jdbc:mysql://localhost/blog";
    static String USERNAME = "root";
    static String PASSWORD = "root";

    public static int createUser(String username, String detail, String update) {

        int result = 0;
        try {
            Connection connection=getConnection();
            PreparedStatement ps=connection.prepareStatement("INSERT INTO table_name (column1, column2, column3, ...)\n" +
                    "VALUES (?, ?, ?, ?, ?);");
            ps.setString(1,update);
            ps.setString(2,username);
            result = ps.executeUpdate();
        } catch (Exception e) {

        }
        return result;
    }
    public static ResultSet getUser(String username) {

        ResultSet rs = null;
        try {
            Statement stmt=null;
            Connection connection=getConnection();
            stmt = connection.createStatement();
            PreparedStatement ps=connection.prepareStatement("select * from REGISTERED_USERS where USERNAME=?");
            ps.setString(1,username);
            rs = ps.executeQuery();
        } catch (Exception e) {

        }
        return rs;
    }
    public static int updateUser(String username, String detail, String update) {

        int result = 0;
        try {
            Connection connection=getConnection();
            PreparedStatement ps=connection.prepareStatement("UPDATE REGISTERED_USERS SET " +detail+"=? WHERE USERNAME=?");
            ps.setString(1,update);
            ps.setString(2,username);
            result = ps.executeUpdate();
        } catch (Exception e) {

        }
        return result;
    }
    public static int deleteUser(String username, String detail, String update) {

        int result = 0;
        try {
            Connection connection=getConnection();
            PreparedStatement ps=connection.prepareStatement("DELETE * FROM REGISTERED_USERS WHERE USERNAME=?");
            ps.setString(1,update);
            ps.setString(2,username);
            result = ps.executeUpdate();
        } catch (Exception e) {

        }
        return result;
    }
    public static Connection getConnection() {
        Connection conn=null;
        try {
            //Register driver
            Class.forName(DRIVER);

            //Create connection
            conn = DriverManager.getConnection(CONNECTION_URL, USERNAME, PASSWORD);
        }catch (ClassNotFoundException| SQLException e){
            e.printStackTrace();
        }
        return  conn;
    }
}
