package com.saurav.myblogapp.presentation;

import com.saurav.myblogapp.control.model.UserType;
import com.saurav.myblogapp.control.service.PublicationService;
import com.saurav.myblogapp.control.service.PublicationServiceFactory;
import com.saurav.myblogapp.control.service.UserService;
import com.saurav.myblogapp.control.service.UserServiceFactory;

import java.util.Scanner;

public class MyBlogAppClient {

    public void blogApp() {

        UserService usr = UserServiceFactory.getUserServiceInstance();
        PublicationService pub = PublicationServiceFactory.getPublicationServiceInstance();

        Scanner scanner = new Scanner(System.in);

        int option;

        loginpage();

        option = scanner.nextInt();

        do {
            switch(option) {

                case 1:
                    System.out.println("Enter first name, last name, email id and password for creating new user: ");
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
                    System.out.println("Enter email id and password for logging in: ");

                    String emailid = scanline();
                    String usrpassword = scanline();

                    UserType type = usr.login(emailid, usrpassword);

                    if(type == UserType.FAILED) {
                        System.out.println("Invalid credentials");
                        break;
                    }

                    else if (type == UserType.NOT_EXISTS) {
                        System.out.println("User does not exists");
                    }

                    else if (type == UserType.ADMIN)
                        start_admin_console();

                    else if(type == UserType.MODERATOR)
                        start_moderator_console();

                    else
                        start_blogger_console();

                    break;

                default:
                    System.out.println("Enter correct menu options");

            }

            System.out.println("Enter options from menu:");

            option = scanner.nextInt();

        } while (option != 3);


    }

    public void start_admin_console(){

        // give admin options here

        System.out.println("Admin console started.");

    }


    public void start_moderator_console() {

        // give moderator options here

        System.out.println("Moderator console started.");

    }


    public void start_blogger_console() {

        // give normal blogger options here

        System.out.println("Blogger console started.");

    }


    public void loginpage() {

        System.out.println("Enter options from menu:");
        System.out.println("1. Sign Up ");
        System.out.println("2. Login existing user ");
        System.out.println("3. Exit ");

    }


    public static String scanline() {
        Scanner scanner = new Scanner(System.in);
        String input;
        if (scanner.hasNextLine()) {
            input = scanner.nextLine();
        }
        else {
            input = "!ERROR_NO_INPUT!";
        }
        return input;
    }
}
