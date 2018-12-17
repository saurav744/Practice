package com.saurav.myblogapp.data_access;

import com.saurav.myblogapp.control.model.User;
import com.saurav.myblogapp.control.model.UserType;
import com.saurav.myblogapp.exceptions.UserNotFoundException;

import java.util.ArrayList;

public interface UserRepository {

    public void addUser(User user);

    public void deleteUser(long id);

//    public void updateUser(long id, User user) throws UserNotFoundException;
    public void updateUser(long id, String firstName, String lastName, String password) throws UserNotFoundException;

    public User getUser(String email);

    public User getUserById(long id);

    public void setType(long id, UserType type);

    public boolean hasUser(String email);

    public boolean hasUserId(long id);

    public ArrayList<User> getAllUsers();

}
