package com.saurav;

import java.util.Scanner;

public class UserInput {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your name: ");
        String name = scanner.nextLine();

        System.out.println("Enter your year of birth:");
        int year= scanner.nextInt();

        while(year > 2018) {
            System.out.println("Invalid year. Birth year cannot be greater than 2018. Please enter again: ");
            year= scanner.nextInt();
        }

        int age = 2018-year;

        System.out.println("Your name is "+name+", and you are "+age+" years old.");
        scanner.close();
    }

}
