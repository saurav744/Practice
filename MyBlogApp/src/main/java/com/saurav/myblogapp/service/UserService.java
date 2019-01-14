package com.saurav.myblogapp.service;

import com.saurav.myblogapp.model.User;
import com.saurav.myblogapp.model.UserType;

import java.util.List;

public interface UserService {

    public void addUser(String firstName, String lastName, String email, String password, UserType type);

    public void addUSer(String firstName, String lastName, String email, String password);

    public void deleteUser(long id);

    public void updateUser(long id, User user);

    public User getUser(String email);

    public User getUserById(long id);

    public boolean hasUser(String email);

    public List<User> getAllUsers();

}
