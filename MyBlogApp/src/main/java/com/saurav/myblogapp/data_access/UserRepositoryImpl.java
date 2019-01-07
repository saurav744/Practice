package com.saurav.myblogapp.data_access;

import com.saurav.myblogapp.control.model.User;
import com.saurav.myblogapp.control.model.UserType;
import com.saurav.myblogapp.exceptions.UserNotFoundException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class UserRepositoryImpl implements UserRepositoryold {

    private Map<Long, User> usersId = new HashMap<>();
    private Map<String, User> usersEmail = new HashMap<>();
    private long next_id =1;

    public UserRepositoryImpl() {
        createAdmin();
    }

    private void createAdmin(){
        User user = new User("Admin","Admin","admin@test.com","Admin" );
        user.setId(next_id);
        user.setType(UserType.ADMIN);
        usersId.put(next_id,user);
        usersEmail.put(user.getEmail(),user);
        next_id++;
    }

   
    public void addUser(User user) {

        user.setId(next_id);
        usersId.put(next_id,user);
        usersEmail.put(user.getEmail(),user);
        next_id++;
    }

   
    public void deleteUser(long id) {

        User user= getUserById(id);
        usersEmail.remove(user.getEmail());
        usersId.remove(id);
    }


    public void updateUser(long id, String firstName, String lastName, String password) throws UserNotFoundException {

        User user_old= getUserById(id);
        if(user_old != null) {
            user_old.setFirstName(firstName);
            user_old.setLastName(lastName);
            user_old.setPassword(password);
        }else {
            throw new UserNotFoundException();
        }
    }

   
    public User getUser(String email) {

        return usersEmail.get(email);
    }

    
    public User getUserById(long id) {

        return usersId.get(id);
    }

   
    public void setType(long id, UserType type) {
        User user= getUserById(id);
        user.setType(type);
    }

   
    public boolean hasUser(String email) {

        return usersEmail.containsKey(email);
    }

   
    public boolean hasUserId(long id) {
        return usersId.containsKey(id);
    }

    
    public ArrayList<User> getAllUsers() {
        ArrayList<User> usersList = new ArrayList<>(usersId.values());
        return usersList;
    }

}
