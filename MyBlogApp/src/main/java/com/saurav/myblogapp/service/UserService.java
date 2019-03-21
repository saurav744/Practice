package com.saurav.myblogapp.service;

import com.saurav.myblogapp.exceptions.UserNotFoundException;
import com.saurav.myblogapp.model.User;
import com.saurav.myblogapp.model.UserType;

import java.util.List;

public interface UserService {

    public void addUser(String firstName, String lastName, String email, String password, UserType type);

    public void addUser(String firstName, String lastName, String email, String password);

    public void deleteUser(long id) throws UserNotFoundException;

    public void updateUser(long id, User user) throws UserNotFoundException;

    public User getUser(String email) throws UserNotFoundException;
    
    public User getUserById(long id) throws UserNotFoundException;

    public boolean hasUser(String email);
    
    public boolean hasUser(long id);

    public List<User> getAllUsers();

}
