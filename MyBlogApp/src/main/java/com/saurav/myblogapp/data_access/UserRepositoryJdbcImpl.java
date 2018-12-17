package com.saurav.myblogapp.data_access;

import com.saurav.myblogapp.control.model.User;

import java.sql.*;

public class UserRepositoryJdbcImpl {

    static String DRIVER = "com.mysql.jdbc.Driver";
    static String CONNECTION_URL = "jdbc:mysql://localhost/blog";
    static String USERNAME = "root";
    static String PASSWORD = "root";

    public static int createUser(User user) {

        int result = 0;
        try {
            Connection connection=getConnection();
            PreparedStatement ps=connection.prepareStatement("INSERT INTO USERS (FIRST_NAME, LAST_NAME, EMAIL, ROLE, PASSWORD)\n" +
                    "VALUES (?, ?, ?, ?, ?);");
            ps.setString(1, user.getFirstName());
            ps.setString(2,user.getLastName());
            ps.setString(3,user.getEmail());
            ps.setString(4,user.getType().toString());
            ps.setString(5,user.getPassword());
            result = ps.executeUpdate();
        } catch (Exception e) {

        }
        return result;
    }
    public static User getUser(String email) {

        ResultSet rs = null;
        try {
            Statement stmt=null;
            Connection connection=getConnection();
            stmt = connection.createStatement();
            PreparedStatement ps=connection.prepareStatement("select * from USERS where EMAIL=?");
            ps.setString(1,email);
            rs = ps.executeQuery();
        } catch (Exception e) {

        }


        User user = new User(rs.getString(0), rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));


        return user;
    }
    public static int updateUser(long id, String firstname, String lastname, String password) {

        int result = 0;
        try {
            Connection connection=getConnection();
            PreparedStatement ps=connection.prepareStatement("UPDATE USERS SET FIRST_NAME = ?, LAST_NAME = ?, PASSWORD = ? WHERE id=?");
            ps.setString(1, firstname);
            ps.setString(2, lastname);
            ps.setString(3,password);
            ps.setString(4, id);
            result = ps.executeUpdate();
        } catch (Exception e) {

        }
        return result;
    }
    public static int deleteUser(long id) {

        int result = 0;
        try {
            Connection connection=getConnection();
            PreparedStatement ps=connection.prepareStatement("DELETE * FROM USERS WHERE id=?");
            ps.setString(1, id);
            result = ps.executeUpdate();
        } catch (Exception e) {

        }
        return result;
    }

    public static Connection getConnection() {
        Connection conn=null;
        try {
            Class.forName(DRIVER);

            //Create connection
            conn = DriverManager.getConnection(CONNECTION_URL, USERNAME, PASSWORD);
        }catch (ClassNotFoundException| SQLException e){
            e.printStackTrace();
        }
        return  conn;
    }
}
