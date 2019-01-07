package com.saurav.myblogapp.control.service;

import com.saurav.myblogapp.control.model.User;
import com.saurav.myblogapp.exceptions.UserNotFoundException;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserServiceImplTest {
//
//    private static UserService userService;
//
//    @BeforeClass
//    public static void setUp() {
//
//        userService = UserServiceFactory.getUserServiceInstance();
//        userService.login("admin@test.com","Admin");
//
//    }
//
//    @Test
//    public void testAddUser_001() {
//
//        userService.addUser("Simbha", "Singh", "Simbha@lion.king","hakoonaMatata", 2);
//        User myUser = userService.getUser("Simbha@lion.king");
//        assertNotNull("User not added",myUser);
//        assertEquals("Incorrect value","Simbha",myUser.getFirstName());
//
//    }
//
//
//    @Test
//    public void testUpdateUser_002() {
//
//        long id = userService.getUser("Simbha@lion.king").getId();
//
//        try {
//            userService.updateUser(id, "Pumba", "Singh", "abrakadabra");
//            User myUser = userService.getUser("Simbha@lion.king");
//            assertEquals("User not updated","Pumba",myUser.getFirstName());
//        }catch (UserNotFoundException e){
//            e.printStackTrace();
//        }
//    }
//
//    @Test(expected = UserNotFoundException.class)
//    public void testUpdateUser_003() throws UserNotFoundException {
//
//        userService.updateUser(100000, "Pumba", "Singh", "abrakadabra");
//
//    }
//
//    @Test
//    public void testDeleteUser_004() {
//
//        long id = userService.getUser("Simbha@lion.king").getId();
//        userService.deleteUser(id);
//
//        assertNull("User Not deleted", userService.getUserById(id));
//    }


}
