package com.saurav.myblogapp.control.service;

import com.saurav.myblogapp.control.model.Publication;
import com.saurav.myblogapp.control.model.PublicationType;
import com.saurav.myblogapp.control.model.User;
import com.saurav.myblogapp.exceptions.PublicationNotFoundException;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class PublicationServiceImplTest {

//
//
//    private static PublicationService publicationService;
//    private static UserService userService;
//
//    @BeforeClass
//    public static void setUp() {
//
//        publicationService = PublicationServiceFactory.getPublicationServiceInstance();
//        userService = UserServiceFactory.getUserServiceInstance();
//        userService.login("admin@test.com","Admin");
//
//    }
//
//    @Test
//    public void testAddPublication_001() {
//
//        Date date = new Date();
//        User user = new User("Simbha", "Singh", "Simbha@lion.king","hakoonaMatata");
//        Publication publication = new Publication("Title","Body",user, date, PublicationType.ARTICLE);
//
//        publicationService.addPublication(publication);
//        long id = publication.getId();
//
//        Publication pubGet = publicationService.getPublicationById(id);
//        assertNotNull("Publication was not added",pubGet);
//        assertEquals("Incorrect value",publication , pubGet);
//
//    }
//
//
//    @Test
//    public void testUpdatePublication_002() {
//
//        long id = 1;
//
//        try {
//            publicationService.updatePublication(id,"New Body","New Title", userService.getCurrUser());
//            Publication publication = publicationService.getPublicationById(id);
//            assertEquals("Publication not updated","New Body",publication.getBody());
//            assertEquals("Publication not updated","New Title",publication.getTitle());
//        }catch (PublicationNotFoundException e){
//            e.printStackTrace();
//        }
//    }
//
//    @Test(expected = PublicationNotFoundException.class)
//    public void testUpdateUser_003() throws PublicationNotFoundException {
//        publicationService.updatePublication(100000, "New Body","New Title", userService.getCurrUser());
//
//    }
//
//    @Test
//    public void testDeletePulication_004() {
//
//        long id = 1;
//        publicationService.deletePublication(id, userService.getCurrUser());
//
//        assertNull("User Not deleted", publicationService.getPublicationById(id));
//    }
}
