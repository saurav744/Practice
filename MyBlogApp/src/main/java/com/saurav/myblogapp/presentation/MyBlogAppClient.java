package com.saurav.myblogapp.presentation;

import com.saurav.myblogapp.control.model.*;
import com.saurav.myblogapp.control.service.PublicationService;
import com.saurav.myblogapp.control.service.PublicationServiceFactory;
import com.saurav.myblogapp.control.service.UserService;
import com.saurav.myblogapp.control.service.UserServiceFactory;
import com.saurav.myblogapp.exceptions.PublicationNotFoundException;
import com.saurav.myblogapp.exceptions.UserNotFoundException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class MyBlogAppClient {

    private UserService usr;
    private PublicationService pub;
    private Scanner scanner;

    public MyBlogAppClient() {

        this.usr = UserServiceFactory.getUserServiceInstance();
        this.pub = PublicationServiceFactory.getPublicationServiceInstance();
        this.scanner = new Scanner(System.in);
    }

    public void blogApp() {

        int option;

        loginpage();

        option = scanner.nextInt();

        do {

            switch(option) {

                case 1:
                    System.out.printf("%n Enter first name, last name, email id and password for creating new user: ");
                    String first= scanline();
                    String last = scanline();
                    String email = scanline();
                    String password = scanline();

                    int ret = usr.signup(first, last, email, password);

                    if(ret == 0)
                        System.out.println("User with email \""+email+"\" created succesfully");
                    else
                        System.out.println("User with same email already exists.");


                    break;

                case 2:
                    System.out.printf("%n Enter email id and password for logging in: ");

                    String emailid = scanline();
                    String usrpassword = scanline();

                    UserType type = usr.login(emailid, usrpassword);

                    if(type == UserType.FAILED) {
                        System.out.println("Invalid credentials");
                        break;
                    }

                    else if (type == UserType.NOT_EXISTS) {
                        System.out.println("User does not exist");
                    }

                    else if (type == UserType.ADMIN)
                        start_admin_console();

                    else if(type == UserType.MODERATOR)
                        start_moderator_console();

                    else
                        start_blogger_console();

                    break;

                case 3:
                    System.out.printf("%n Exiting.. %n%n");
                    break;

                default:
                    System.out.println("Enter correct menu options");

            }

            if(option != 3) {
                loginpage();
                option = scanner.nextInt();
                if(option == 3)
                    System.out.printf("Exiting.. %n%n");

            }

        } while (option != 3);

    }

    public void start_admin_console(){

        int option;

        adminOptions();

        option = scanner.nextInt();

        do {

            switch (option) {

                case 1:
                    viewMyProfile();
                    break;

                case 2:
                    viewMyPublications();

                case 3:
                    writePublication();

                case 4:
                    search();

                case 5:
                    approvePending();

                case 6:
                    viewPublicationsAdmin();

                case 7:
                    viewUsersAdmin();


                case 8:
                    usr.logout();
                    System.out.printf("Logged out succesfully %n%n");
                    break;

                default:
                    System.out.println("Enter correct menu option.");
            }

            if (option != 8) {

                bloggeroptions();
                option = scanner.nextInt();
                if(option == 6) {
                    usr.logout();
                    System.out.printf("Logged out succesfully %n%n");
                }
            }

        } while (option != 8);


    }


    public void start_moderator_console() {

        int option;

        adminOptions();

        option = scanner.nextInt();

        do {

            switch (option) {

                case 1:

                    viewMyProfile();
                    break;

                case 2:
                    viewMyPublications();

                case 3:
                    writePublication();

                case 4:
                    search();

                case 5:
                    approvePending();

                case 6:
                    viewPublicationsAdmin();

                case 7:
                    viewUsersModerator();


                case 8:
                    usr.logout();
                    System.out.printf("Logged out succesfully %n%n");
                    break;

                default:
                    System.out.println("Enter correct menu option.");
            }

            if (option != 8) {

                bloggeroptions();
                option = scanner.nextInt();
                if(option == 6) {
                    usr.logout();
                    System.out.printf("Logged out succesfully %n%n");
                }
            }

        } while (option != 8);

    }


    public void adminOptions() {
        System.out.println("Choose options :");
        System.out.println("1. View Profile");
        System.out.println("2. View publications");
        System.out.println("3. Write Publication");
        System.out.println("4. Search");
        System.out.println("5. Approve pending publications");
        System.out.println("6.View all publications");
        System.out.println("7.View all users");
        System.out.println("8. Logout");
    }



    public void approvePending() {

        System.out.println("List of pending publications: ");
        ArrayList<Publication> pb= pub.getPending();
        printPublicationsList(pb);
        approvePendingOptions();

        int option = scanner.nextInt();

        do {
            switch (option) {
                case 1:
                    System.out.println("Enter publication id from the list to approve: ");
                    long id = scanner.nextLong();
                    pub.approvePublication(id, usr.getCurrUser());
                    break;

                case 2:
                    break;

                default:
                    System.out.println("Enter correct menu option.");
            }
            if (option != 2) {
                approvePendingOptions();
                option = scanner.nextInt();
            }

        } while (option != 2);

    }

    public void approvePendingOptions() {
        System.out.println("Enter options: ");
        System.out.println("1. Enter id to approve");
        System.out.println("2. Return to Home");

    }

    public void viewPublicationsAdmin() {

        List<Publication> list = pub.getAllPublications();
        int option;

        printPublicationsList(list);
        publicationsListOptions();

        option = scanner.nextInt();

        do {
            switch (option) {
                case 1:
                    System.out.println("Enter publication id from the list: ");
                    long id = scanner.nextLong();
                    printPublication(pub.getPublicationById(id));
                    break;

                case 2:
                    break;

                default:
                    System.out.println("Enter correct menu option.");
            }
            if (option != 2) {
                publicationsListOptions();
                option = scanner.nextInt();
            }

        } while (option != 2);

    }

    public void viewUsersAdmin() {

        List<User> list = usr.getAllUsers();
        int option;
        long id;

        printUsersList(list);
        usersListOptions();

        option = scanner.nextInt();

        do {
            switch (option) {
                case 1:
                    System.out.println("Enter first name ");
                    String fname = scanline();

                    System.out.println("Enter last name ");
                    String lname= scanline();

                    System.out.println("Enter email ");
                    String email= scanline();

                    System.out.println("Enter password ");
                    String password= scanline();

                    System.out.println("Enter role id: 0: Admin, 1: Moderator, 2: Blogger");
                    int role= scanner.nextInt();

                    usr.addUser(fname, lname, email, password, role);
                    break;

                case 2:
                    System.out.println("Enter id of the user to be delete: ");
                    id= scanner.nextLong();
                    usr.deleteUser(id);
                    System.out.printf("%n%n User deleted succesfully");
                    break;

                case 3:
                    System.out.println("Enter user id");
                    id = scanner.nextLong();
                    int type;
                    System.out.println("Enter role type: 0 for Admin, 1 for Moderator, 2 for Blogger");
                    type = scanner.nextInt();
                    usr.setType(id, type);
                    System.out.println("Type changed succesfully");
                    break;

                case 4:
                    break;

                default:
                    System.out.println("Enter correct menu option.");
            }
            if (option != 4) {
                usersListOptions();
                option = scanner.nextInt();
            }

        } while (option != 4);

    }

    public void viewUsersModerator() {

        List<User> list = usr.getAllUsers();
        int option;
        long id;

        printUsersList(list);
        usersListOptionsModerator();

        option = scanner.nextInt();

        do {
            switch (option) {
                case 1:
                    System.out.println("Enter first name ");
                    String fname = scanline();

                    System.out.println("Enter last name ");
                    String lname= scanline();

                    System.out.println("Enter email ");
                    String email= scanline();

                    System.out.println("Enter password ");
                    String password= scanline();

                    usr.addUSer(fname, lname, email, password);
                    break;

                case 2:
                    System.out.println("Enter id of the user to be deleted: ");
                    id= scanner.nextLong();

                    usr.deleteUser(id);
                    break;

                case 3:
                    break;

                default:
                    System.out.println("Enter correct menu option.");
            }
            if (option != 3) {
                usersListOptionsModerator();
                option = scanner.nextInt();
            }

        } while (option != 3);

    }

    public void printUsersList(List<User> list) {

        System.out.printf("%n%n *********** Users: *************** %n%n");

        for(int i=0; i < list.size(); i++) {

            System.out.println("Id: "+list.get(i).getId()+" Email: "+list.get(i).getEmail());
        }
        System.out.println("");
    }

    public void usersListOptions() {
        System.out.println("Enter options: ");
        System.out.println("1. Add new user");
        System.out.println("2. Delete User");
        System.out.println("3. Change role");
        System.out.println("4. Return to Home");

    }

    public void usersListOptionsModerator() {
        System.out.println("Enter options: ");
        System.out.println("1. Add new user");
        System.out.println("2. Delete User");
        System.out.println("3. Return to Home");

    }


    public void start_blogger_console() {

        int option;

        bloggeroptions();

        option = scanner.nextInt();

        do {

            switch (option) {

                case 1:

                    viewMyProfile();
                    break;

                case 2:
                    viewMyPublications();

                case 3:
                    writePublication();

                case 4:
                    search();

                case 5:
                    viewAllPublications();


                case 6:
                    usr.logout();
                    System.out.printf("Logged out succesfully %n%n");
                    break;

                default:
                    System.out.println("Enter correct menu option.");
            }

            if (option != 6) {

                bloggeroptions();
                option = scanner.nextInt();
                if(option == 6) {
                    usr.logout();
                    System.out.printf("Logged out succesfully %n%n");
                }
            }

        } while (option != 6);

    }

    public void bloggeroptions() {

        System.out.printf("%n%n ************ Home ************** %n%n");
        System.out.println("Enter options from my menu: ");
        System.out.println("1. View My profile ");
        System.out.println("2. View My publications ");
        System.out.println("3. Write new publication ");
        System.out.println("4. Search ");
        System.out.println("5. View all publications ");
        System.out.printf("6. Logout %n%n");

    }

    public void viewMyProfile() {

        int option;

        myProfileOptions();

        option = scanner.nextInt();

        do {

            switch (option) {

                case 1:
                    System.out.println("Enter new password: ");
                    String pwd = scanline();
                    try {
                        usr.updateUser(usr.getCurrUser().getId(), usr.getCurrUser().getFirstName(), usr.getCurrUser().getLastName(), pwd);
                    }catch (UserNotFoundException e){
                        e.printStackTrace();
                    }
                    System.out.printf("Password updated succesfully %n%n");
                    break;

                case 2:
                    System.out.println("Enter new Firstname and Lastname: ");
                    String fname = scanline();
                    String lname = scanline();
                    try {
                        usr.updateUser(usr.getCurrUser().getId(), fname, lname, usr.getCurrUser().getPassword());
                    }catch (UserNotFoundException e){
                        e.printStackTrace();
                    }
                    System.out.printf("Name updated successfully %n%n");
                    break;

                case 3:
                    break;

                default:
                    System.out.println("Enter correct options.");

            }

            if (option != 3) {
                myProfileOptions();
                option = scanner.nextInt();
            }

        } while (option != 3);

    }

    public void myProfileOptions() {

        System.out.printf("%n%n ************** My Profile ****************** %n%n");

        System.out.println("First Name: "+usr.getCurrUser().getFirstName());
        System.out.println("Last Name: "+usr.getCurrUser().getLastName());
        System.out.printf("Email: "+usr.getCurrUser().getEmail()+"%n%n");

        System.out.println("Enter options: ");
        System.out.println("1. To Update Password ");
        System.out.println("2. To Update Name ");
        System.out.printf("3. To go to Home %n%n");
    }

    public void viewMyPublications() {

        List<Publication> list = usr.getCurrUser().getPublications(); //list contains all publications written by current user
        int option;

        printPublicationsList(list);
        publicationsListOptions();

        option = scanner.nextInt();

        do {
            switch (option) {
                case 1:
                    System.out.println("Enter publication id from the list: ");
                    long id = scanner.nextLong();
                    viewPublication(id);
                    break;

                case 2:
                    break;

                default:
                    System.out.println("Enter correct menu option.");
            }
            if (option != 2) {
                printPublicationsList(list);
                publicationsListOptions();
                option = scanner.nextInt();
            }

        } while (option != 2);

    }


    public void viewAllPublications() {

        List<Publication> list = pub.getAllPublications();
        int option;

        printPublicationsList(list);
        publicationsListOptions();

        option = scanner.nextInt();

        do {
            switch (option) {
                case 1:
                    System.out.println("Enter publication id from the list: ");
                    long id = scanner.nextLong();
                    viewPublicationAdmin(id);
                    break;

                case 2:
                    break;

                default:
                    System.out.println("Enter correct menu option.");
            }
            if (option != 2) {
                publicationsListOptions();
                option = scanner.nextInt();
            }

        } while (option != 2);

    }


    public void publicationsListOptions() {
        System.out.println("Enter options: ");
        System.out.println("1. View Publication by id");
        System.out.println("2. Return to Home");

    }

    public void printPublicationsList(List<Publication> list) {

        System.out.printf("%n%n *********** Publications: *************** %n%n");

        for(int i=0; i < list.size(); i++) {

            System.out.println("Id: "+list.get(i).getId()+" Title: "+list.get(i).getTitle());
        }
        System.out.println("");
    }


    public void viewPublicationAdmin(long id) {

        Publication publication = pub.getPublicationById(id);

        int option;

        printPublication(publication);

        printPublicationOptionsAdmin();

        option = scanner.nextInt();

        do {
            switch (option) {

                case 1:
                    //delete publication
                    System.out.printf("%nAre you sure you want to delete this? Enter (1) for Yes, (2) for No %n");
                    int choice = scanner.nextInt();

                    if(choice == 1) {
                        pub.deletePublication(id, usr.getCurrUser());
                        usr.getCurrUser().getPublications().remove(publication);
                        option = 4; // this publication is now deleted, return to previous menu
                    }
                    break;

                case 2:
                    // like publication
//                    if(usr.getCurrUser().getLikedPubs().contains(id)) {
//                        System.out.println("You have already liked this !");
//                    } else {
//                        publication.incrementLikes();
//                        usr.getCurrUser().addLiked_pubs(id);
//                        System.out.println("Publication liked !");
//                    }

                case 3:
                    // View comments;
                    viewComments(id);
                    printPublication(publication);


                case 4:
                    // return to prev menu
                    break;

                default:
                    System.out.printf("%nEnter correct menu option.%n");
            }
            if (option != 4) {
                printPublicationOptions();
                option = scanner.nextInt();
            }

        } while (option != 4);

    }

    public void viewPublication(long id) {

        Publication publication = pub.getPublicationById(id);

        int option;

        printPublication(publication);

        printPublicationOptions();

        option = scanner.nextInt();

        do {
            switch (option) {
                case 1:
                    //update publication
                    System.out.println("Want to change Title? Input (1) for Yes, (2) for No ");
                    int choice = scanner.nextInt();
                    String newTitle, newBody ;
                    if(choice == 1) {
                        System.out.println("Enter new title: ");
                         newTitle = scanline();
                    } else newTitle = publication.getTitle();

                    System.out.println("Want to change Body ? Input (1) for Yes, (2) for No ");
                    choice = scanner.nextInt();
                    if(choice == 1) {
                        System.out.println("Enter body text: ");
                        newBody = scanline();
                    } else newBody = publication.getBody();

                    try {
                        pub.updatePublication(id, newBody, newTitle, usr.getCurrUser());
                    } catch (PublicationNotFoundException e) {
                        e.printStackTrace();
                    }

                    printPublication(publication);
                    break;

                case 2:
                    //delete publication
                    System.out.printf("%nAre you sure you want to delete this? Enter (1) for Yes, (2) for No %n");
                    choice = scanner.nextInt();

                    if(choice == 1) {
                        pub.deletePublication(id, usr.getCurrUser());
                        usr.getCurrUser().getPublications().remove(publication);
                        option = 6; // this publication is now deleted, return to previous menu
                    }
                    break;

                case 3:
                    // like publication
//                    if(usr.getCurrUser().getLikedPubs().contains(id)) {
//                        System.out.println("You have already liked this !");
//                    } else {
//                        publication.incrementLikes();
//                        usr.getCurrUser().addLiked_pubs(id);
//                        System.out.println("Publication liked !");
//                    }

                case 4:
                    // View comments;
                    viewComments(id);
                    printPublication(publication);

                case 5:
                    // add co author
                    System.out.printf("%n Enter email id of user you want to add as co-author: %n");
                    String email= scanline();
                    if(usr.hasUser(email)) {
                        User user = usr.getUser(email);
                        publication.addAuthor(user); //
                    }

                case 6:
                    // return to prev menu
                    break;

                default:
                    System.out.printf("%nEnter correct menu option.%n");
            }
            if (option != 6) {
                printPublicationOptions();
                option = scanner.nextInt();
            }

        } while (option != 6);

    }


    public void printPublication(Publication publication) {

        System.out.printf("%n%n    ______________________ Title: "+publication.getTitle()+" __________________________%n%n");
        System.out.println("| Publication id:  "+publication.getId());
        System.out.println("| Type:  "+publication.getType());
        System.out.println("| Added date:  "+publication.getAddedDate());
        System.out.println("| State:  "+publication.getState());
        System.out.printf("| Likes:  "+publication.getLikes()+"%n|%n|");
        System.out.println("| Body:  "+publication.getBody());
        System.out.printf("|_______________________________________________________________________________________%n%n");

    }

    public void printPublicationOptionsAdmin() {

        System.out.printf("%n ________Enter options:_______ ");
        System.out.println("1. Delete Publication");
        System.out.println("2. Like Publication");
        System.out.println("3. View comments ");
        System.out.printf("4. Return to previous Menu %n");

    }

    public void printPublicationOptions() {

        System.out.printf("%n ________Enter options:_______ ");
        System.out.println("1. Update Publication");
        System.out.println("2. Delete Publication");
        System.out.println("3.. Like Publication");
        System.out.println("4. View comments ");
        System.out.println("5. Add co-author");
        System.out.printf("6. Return to previous Menu %n");

    }

    public void viewComments(long id) {

        List<UserComment> comments = pub.getComments(id);
        printComments(comments);
        printCommentsOptions();
        int option = scanner.nextInt();

        do {
            switch (option) {
                case 1:
                    //add comment
                    System.out.println("Enter comment:");
                    String body= scanline();
                    Date dt = new Date();
                    UserComment cmnt = new UserComment(body ,usr.getCurrUser(),dt);
                    pub.addComment(id, cmnt);
                    printComments(comments);

                    break;

                case 2:
                    //delete comment
                    System.out.println("Enter index of comment to be deleted: ");
                    int ind = scanner.nextInt();
                    if(ind < comments.size()) {
                        pub.deleteComment(id, ind);
                    }
                    printComments(comments);

                    break;

                case 3:
                    // update comment
                    System.out.println("Enter index of comment to be updated: ");
                    ind = scanner.nextInt();
                    if(ind < comments.size()) {
                        String newbody = scanline();
                        pub.editComment(id, ind, newbody);
                    }
                    printComments(comments);

                    break;

                case 4:
                    break;


                default:
                    System.out.printf("%nEnter correct menu option.%n");
            }
            if (option != 4) {
                printCommentsOptions();
                option = scanner.nextInt();
            }

        } while (option != 4);

    }

    public void printComments(List<UserComment> comments) {

        for(int i = 0; i< comments.size(); i++) {

            System.out.printf("%n_________________________________________");
            System.out.println("| Index: "+i);
            System.out.println("| Comment: "+comments.get(i).getBody());
            System.out.println("| Date: "+comments.get(i).getAddedDate());
            System.out.println("| User: "+comments.get(i).getUser().getEmail());
        }
        System.out.printf("|_________________________________________");

    }

    public void printCommentsOptions() {

        System.out.printf("%n ________Enter options:_______ ");
        System.out.println("1. Add new Comment");
        System.out.println("2. Delete comment");
        System.out.println("3. Update comment ");
        System.out.println("4. Return to previous menu");

    }


    public void writePublication() {
        System.out.printf("********************************** New Publication ******************************** %n%n");
        System.out.println("Enter title of the Publication:");
        String title = scanline();
        PublicationType type;
        int option;
        System.out.println("Specify Type:");
        for(int i=0; i < PublicationType.values().length; i++) {
            System.out.printf(" ("+i+") for "+PublicationType.values()[i]);
        }
        System.out.println("");
        option = scanner.nextInt();
        type = PublicationType.values()[option];
        System.out.println("Enter publication body: ");
        String body = scanline();
        Date dt = new Date();

        Publication publication = new Publication(title, body, usr.getCurrUser(), dt, type);
        pub.addPublication(publication);
        usr.getCurrUser().addPublications(publication);

    }

    public void search() {

        List<Publication> pubList;
        System.out.printf("%n Enter keyword to search: ");
        String key= scanline();
        System.out.println("Enter options: %n(1) to search from content, %n(2) to search from authors%n");

        int option = scanner.nextInt();


        if(option == 1)
           pubList = pub.searchContent(key);
        else
            pubList = pub.searchAuthor(key);

        printPublicationsList(pubList);
        publicationsListOptions();

        option = scanner.nextInt();

        do {
            switch (option) {
                case 1:
                    System.out.println("Enter publication id from the list: ");
                    long id = scanner.nextLong();
                    printPublication(pub.getPublicationById(id));
                    break;

                case 2:
                    break;

                default:
                    System.out.println("Enter correct menu option.");
            }
            if (option != 2) {
                publicationsListOptions();
                option = scanner.nextInt();
            }

        } while (option != 2);

    }


    public void loginpage() {

        System.out.printf("%n%n ************ Welcome to MyBlogApplication *********** %n%n");
        System.out.println("Enter options from menu:");
        System.out.println("1. Sign Up ");
        System.out.println("2. Login existing user ");
        System.out.println("3. Exit ");

    }


    public static String scanline() {
        String input;
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextLine()) {
            input = scanner.nextLine();
        }
        else {
            input = "!ERROR_NO_INPUT!";
        }
        return input;
    }
}
