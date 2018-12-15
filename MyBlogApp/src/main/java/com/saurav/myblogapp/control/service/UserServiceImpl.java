package com.saurav.myblogapp.control.service;

import com.saurav.myblogapp.control.model.User;
import com.saurav.myblogapp.control.model.UserType;
import com.saurav.myblogapp.data_access.UserRepository;
import com.saurav.myblogapp.exceptions.UserNotFoundException;

import java.util.Map;
import java.util.Set;

public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private User currUser;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.currUser = null;
    }

@Override
    public int signup(String firstname, String lastname, String email, String password) {

        if(userRepository.hasUser(email))
            return -1;

        User user = new User(firstname, lastname, email, password);


        userRepository.addUser(user);
        return 0;

    }

    @Override
    public UserType login(String email, String password) {

        if(userRepository.hasUser(email)) {

            User user = userRepository.getUser(email);
            if(user.getPassword().equals(password)) {
                currUser = user;
                return user.getType();
            }

            return UserType.FAILED;
        }

        return UserType.NOT_EXISTS;
    }

    @Override
    public void logout() {

        currUser = null;
    }

    @Override
    public void addUser(String firstname, String lastname, String email, String password, int type) {

        if(currUser != null && currUser.getType() == UserType.ADMIN) {
            UserType user_type;

            if (type == 0) {
                user_type = UserType.ADMIN;
            }
            else if (type == 1) {
                user_type = UserType.MODERATOR;
            }
            else {
                user_type = UserType.BLOGGER;
            }

            User user = new User(firstname, lastname, email, password, user_type);
            userRepository.addUser(user);
        }
    }

    @Override
    public void deleteUser(long id) {

        User user = getUserById(id);
        if(currUser != null && (currUser.getType() == UserType.ADMIN || currUser.getEmail().equalsIgnoreCase(user.getEmail()))) {

            userRepository.deleteUser(id);
        }

    }

    @Override
    public boolean hasUser(String email) {
        return userRepository.hasUser(email);
    }

    @Override
    public void updateUser(long id, String firstname, String lastname, String password)  throws UserNotFoundException{

        User user = getUserById(id);
        if(currUser.getType() == UserType.ADMIN || currUser.getEmail().equalsIgnoreCase(user.getEmail())) {

//            User newuser= new User(firstname, lastname, user.getEmail(), password, user.getType());

            userRepository.updateUser(id, firstname, lastname, password);
        }

    }

    @Override
    public User getUser(String email) {

        return userRepository.getUser(email);
    }
    @Override

    public User getUserById(long id) {

        return userRepository.getUserById(id);
    }

    @Override
    public void setType(long id, UserType type) {

    }

    @Override
    public String getCurrUserEmail() {
        return currUser.getEmail();
    }

    @Override
    public UserType getCurrUserType() {
        return currUser.getType();
    }

    @Override
    public User getCurrUser() {
        return currUser;
    }

    @Override
    public Set<Map.Entry<Long, User>> getAllUsers() {
        return userRepository.getAllUsers() ;
    }
}
