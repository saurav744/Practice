package com.saurav.myblogapp.data_access;

import com.saurav.myblogapp.control.model.User;
import com.saurav.myblogapp.control.model.UserType;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class UserRepositoryImpl implements UserRepository {

    private Map<Long, User> users_id = new HashMap<>();
    private Map<String, User> users_email = new HashMap<>();
    private long next_id =1;

    @Override
    public  void adduser(User user) {

        user.setId(next_id);
        users_id.put(next_id,user);
        users_email.put(user.getEmail(),user);
        next_id++;
    }

    @Override
    public void deleteuser(long id) {

        User user= getuserbyid(id);
        users_email.remove(user.getEmail());
        users_id.remove(id);
    }

    @Override
    public void updateuser(long id, User user) {

        User user_old= getuserbyid(id);
        user_old.setFirst_name(user.getFirst_name());
        user_old.setLast_name(user.getLast_name());
        user_old.setPassword(user.getPassword());
    }

    @Override
    public User getuser(String email) {

        return users_email.get(email);
    }

    @Override
    public User getuserbyid(long id) {

        return users_id.get(id);
    }

    @Override
    public void settype(long id, UserType type) {
        User user= getuserbyid(id);
        user.setType(type);
    }

    @Override
    public boolean hasuser(String email) {

        return users_email.containsKey(email);
    }

    @Override
    public boolean hasuserid(long id) {
        return users_id.containsKey(id);
    }

    @Override
    public Set<Map.Entry<Long, User>> getallusers() {
        return users_id.entrySet();
    }

}
