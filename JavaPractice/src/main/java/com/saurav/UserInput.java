package com.saurav;

import java.util.Scanner;

public class UserInput {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your name: ");
        String name = scanner.nextLine();

        System.out.println("Enter your year of birth:");

        boolean hasnextInt= scanner.hasNextInt();
        int year = 0;

        if(hasnextInt)
            year= scanner.nextInt();

        while (hasnextInt == false || year > 2018 || year < 0) {

            if(hasnextInt == false)
            {
                scanner.nextLine();
                System.out.println("Please enter an integer value:");
            } else {
                scanner.nextLine();
                System.out.println("Invalid year. Birth year cannot be negative or greater than 2018. Please enter again: ");
            }

            hasnextInt= scanner.hasNextInt();
            if(hasnextInt)
                year = scanner.nextInt();
        }

        int age = 2018-year;

        System.out.println("Your name is "+name+", and you are "+age+" years old.");
        scanner.close();
    }

}
