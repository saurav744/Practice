package com.saurav.myblogapp.presentation;

import com.saurav.myblogapp.control.model.UserType;
import com.saurav.myblogapp.control.service.PublicationService;
import com.saurav.myblogapp.control.service.PublicationServiceFactory;
import com.saurav.myblogapp.control.service.UserService;
import com.saurav.myblogapp.control.service.UserServiceFactory;

import java.util.Scanner;

public class MyBlogAppClient {

    public void blogapp() {

        UserService usr = UserServiceFactory.getUserServiceInstance();
        PublicationService pub= PublicationServiceFactory.getPublicationServiceInstance();

        Scanner sc = new Scanner(System.in);

        int option;

        loginpage();

        option = sc.nextInt();

        do {

            switch(option) {


                case 1:
                    System.out.println("Enter first name, last name, email id and password for creating new user: ");
                    String first= scan();
                    String last = scan();
                    String email = scan();
                    String password = scan();

                    usr.signup(first, last, email, password);

                    break;



                case 2:

                    System.out.println("Enter email id and password for logging in: ");

                    String emailid = scan();
                    String usrpassword = scan();

                    UserType type= usr.login(emailid, usrpassword);

                    if(type == UserType.FAILED) {
                        System.out.println("Invalid credentials");
                        break;
                    }

                    else if (type == UserType.ADMIN)
                        start_admin_console();

                    else if(type == UserType.MODERATOR)
                        start_moderator_console();

                    else
                        start_blogger_console();

                    break;



                default:
                    System.out.println("enter correct menu options");


            }


            System.out.println("Enter options from menu:");

            option = sc.nextInt();



        } while (option != 3);


    }

    public void start_admin_console(){

        // give admin options here

    }


    public void start_moderator_console() {

        // give moderator options here



    }


    public void start_blogger_console() {


        // give normal blogger options here

    }




    public void loginpage() {

        System.out.println("Enter options from menu:");
        System.out.println("1. Sign Up ");
        System.out.println("2. Login existing user ");
        System.out.println("3. exit");
        
    }


    public static String scan() {
        Scanner s = new Scanner(System.in);
        String input;
        if (s.hasNextLine()) {
            input = s.nextLine();
        } else {
            input = "ERROR";
        }
        return input;
    }
}
