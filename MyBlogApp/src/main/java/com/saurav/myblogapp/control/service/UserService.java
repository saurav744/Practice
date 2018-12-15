package com.saurav.myblogapp.control.service;

import com.saurav.myblogapp.control.model.User;
import com.saurav.myblogapp.control.model.UserType;
import com.saurav.myblogapp.exceptions.UserNotFoundException;

import java.util.Map;
import java.util.Set;

public interface UserService {

    public int signup(String firstname, String lastname, String email, String password);

    public UserType login(String email, String password);

    public void logout();

    public void addUser(String firstname, String lastname, String email, String password, int type);

    public void deleteUser(long id);

    public void updateUser(long id, String firstname, String lastname, String password)  throws UserNotFoundException;

    public User getUser(String email);

    public User getUserById(long id);

    public void setType(long id , UserType type);

    public String getCurrUserEmail();

    public UserType getCurrUserType();

    public User getCurrUser();

    public boolean hasUser(String email);

    public Set<Map.Entry<Long, User>> getAllUsers();

}
