package com.saurav.myblogapp.control.service;

import com.saurav.myblogapp.control.model.User;
import com.saurav.myblogapp.control.model.UserType;

import java.util.Map;
import java.util.Set;

public interface UserService {

    public void signup(String firstname, String lastname, String email, String password);

    public UserType login(String email, String password);

    public void adduser(String firstname, String lastname, String email, String password, int type);

    public void deleteuser(long id);

    public void updateuser(long id, String firstname, String lastname, String password);

    public User getuser(String email);

    public User getuserbyid(long id);

    public void set_type(long id , UserType type);

    public String get_curr_useremail();

    public UserType get_curr_usertype();

    public Set<Map.Entry<Long, User>> getallusers();

}
