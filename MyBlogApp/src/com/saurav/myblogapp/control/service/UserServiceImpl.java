package com.saurav.myblogapp.control.service;

import com.saurav.myblogapp.control.model.User;
import com.saurav.myblogapp.control.model.UserType;
import com.saurav.myblogapp.data_access.UserRepository;

import java.util.Map;
import java.util.Set;

public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private User curr_user ;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.curr_user = null;
    }

    @Override
    public int signup(String firstname, String lastname, String email, String password) {

        if(userRepository.hasuser(email))
            return -1;

        User user = new User(firstname, lastname, email, password);


        userRepository.adduser(user);
        return 0;

    }

    @Override
    public UserType login(String email, String password) {

        if(userRepository.hasuser(email)) {

            User user = userRepository.getuser(email);
            if(user.getPassword().equals(password)) {
                curr_user = user;
                return user.getType();
            }

            return UserType.FAILED;
        }

        return UserType.NOT_EXISTS;
    }

    @Override
    public void adduser(String firstname, String lastname, String email, String password, int type) {

        if(curr_user != null && curr_user.getType() == UserType.ADMIN) {

            UserType user_type = UserType.BLOGGER;

            if (type == 0)
                user_type = UserType.ADMIN;
            else if (type == 1)
                user_type = UserType.MODERATOR;

            User user = new User(firstname, lastname, email, password, user_type);
            userRepository.adduser(user);
        }
    }

    @Override
    public void deleteuser(long id) {

        User user = getuserbyid(id);
        if(curr_user != null && (curr_user.getType() == UserType.ADMIN || curr_user.getEmail().equalsIgnoreCase(user.getEmail()))) {

            userRepository.deleteuser(id);
        }

    }

    @Override
    public void updateuser(long id, String firstname, String lastname, String password) {

        User user = getuserbyid(id);
        if(curr_user.getType() == UserType.ADMIN || curr_user.getEmail().equalsIgnoreCase(user.getEmail())) {

            User newuser= new User(firstname, lastname, user.getEmail(), password, user.getType());

            userRepository.updateuser(id, newuser);
        }

    }

    @Override
    public User getuser(String email) {

        return userRepository.getuser(email);
    }

    @Override
    public User getuserbyid(long id) {

        return userRepository.getuserbyid(id);
    }

    @Override
    public void set_type(long id, UserType type) {

    }

    @Override
    public String get_curr_useremail() {
        return curr_user.getEmail();
    }

    @Override
    public UserType get_curr_usertype() {
        return curr_user.getType();
    }

    @Override
    public Set<Map.Entry<Long, User>> getallusers() {
        return userRepository.getallusers() ;
    }
}
