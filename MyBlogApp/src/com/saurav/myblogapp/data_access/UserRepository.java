package com.saurav.myblogapp.data_access;

import com.saurav.myblogapp.control.model.User;
import com.saurav.myblogapp.control.model.UserType;

import java.util.Map;
import java.util.Set;

public interface UserRepository {

    public void adduser(User user);

    public void deleteuser(long id);

    public void updateuser(long id, User user);

    public User getuser(String email);

    public User getuserbyid(long id);

    public void settype(long id, UserType type);

    public boolean hasuser(String email);

    public boolean hasuserid(long id);

    public Set<Map.Entry<Long, User>> getallusers();

}
