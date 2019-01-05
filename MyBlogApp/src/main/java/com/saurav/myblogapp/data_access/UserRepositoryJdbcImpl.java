package com.saurav.myblogapp.data_access;

import com.saurav.myblogapp.control.model.User;
import com.saurav.myblogapp.control.model.UserType;
import com.saurav.myblogapp.exceptions.UserNotFoundException;

import java.sql.*;
import java.util.ArrayList;

public class UserRepositoryJdbcImpl implements UserRepository {

    static String DRIVER = "com.mysql.jdbc.Driver";
    static String CONNECTION_URL = "jdbc:mysql://localhost/blog";
    static String USERNAME = "root";
    static String PASSWORD = "root";

    @Override
    public void addUser(User user) {

        try {
            Connection connection=getConnection();
            PreparedStatement ps=connection.prepareStatement("INSERT INTO USERS (FIRST_NAME, LAST_NAME, EMAIL, ROLE, PASSWORD)\n" +
                    "VALUES (?, ?, ?, ?, ?);");
            ps.setString(1, user.getFirstName());
            ps.setString(2,user.getLastName());
            ps.setString(3,user.getEmail());
            ps.setString(4,user.getType().toString());
            ps.setString(5,user.getPassword());
            ps.executeUpdate();
        } catch (SQLException e) {

        }
    }

    @Override
    public User getUser(String email) {

        ResultSet rs = null;
        User user = null;
        try {
            Statement stmt=null;
            Connection connection=getConnection();
            stmt = connection.createStatement();
            PreparedStatement ps=connection.prepareStatement("select * from USERS where EMAIL=?");
            ps.setString(1,email);
            rs = ps.executeQuery();

            user = new User(rs.getString(0), rs.getString(1), rs.getString(2), rs.getString(3), UserType.valueOf(rs.getString(4)));

        } catch (SQLException e) {

        }

        return user;
    }

    @Override
    public void updateUser(long id, String firstname, String lastname, String password) throws UserNotFoundException {

        try {
            Connection connection=getConnection();
            PreparedStatement ps=connection.prepareStatement("UPDATE USERS SET FIRST_NAME = ?, LAST_NAME = ?, PASSWORD = ? WHERE id=?");
            ps.setString(1, firstname);
            ps.setString(2, lastname);
            ps.setString(3, password);
            ps.setString(4, Long.toString(id));
            ps.executeUpdate();
        } catch (SQLException e) {

        }
    }

    @Override
    public void deleteUser(long id) {

        try {
            Connection connection=getConnection();
            PreparedStatement ps=connection.prepareStatement("DELETE * FROM USERS WHERE id=?");
            ps.setString(1, Long.toString(id));
            ps.executeUpdate();
        } catch (SQLException e) {
        }
    }

    @Override
    public User getUserById(long id) {

        ResultSet rs = null;
        User user = null;
        try {
            Statement stmt=null;
            Connection connection=getConnection();
            stmt = connection.createStatement();
            PreparedStatement ps=connection.prepareStatement("select * from USERS where ID=?");
            ps.setString(1, Long.toString(id));
            rs = ps.executeQuery();

            user = new User(rs.getString(0), rs.getString(1), rs.getString(2), rs.getString(3), UserType.valueOf(rs.getString(4)));

        } catch (SQLException e) {

        }

        return user;
    }

    @Override
    public void setType(long id, UserType type) {

    }

    @Override
    public boolean hasUser(String email) {
        return false;
    }

    @Override
    public boolean hasUserId(long id) {
        return false;
    }

    @Override
    public ArrayList<User> getAllUsers() {
        return null;
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
