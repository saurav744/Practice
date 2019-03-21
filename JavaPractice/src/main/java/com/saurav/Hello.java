package com.saurav;

public class Hello {

    public static void main(String[] args) {

        int a = 2;
        byte b = 3;
        short c = 12345;
        long d =  50000 + 10*b + a + c;

        double f = 5.4;
        char ch = 'A';
        //System.out.println("Result: "+ch);

        System.out.println("a is: "+a+" and b is: "+b);
        swap_numbers(a,b); // this wont work since in java method params are passed by values not reference.
        System.out.println("a is: "+a+" and b is: "+b);

        //printMegaBytesAndKiloBytes(1024);


        boolean bool;

        bool = areEqualByThreeDecimalPlaces(a, b);

        bool = Palindrome.isPalindrome(121);

        if(bool)
            System.out.println("This is true.");
        else
            System.out.println("This is false.");
    }


    public static boolean areEqualByThreeDecimalPlaces(double a, double b) {

        boolean result = false;

        int c = (int)(a * 1000d);
        int d = (int)(b * 1000d);

        if (c == d) result = true;

        return result;
    }

    public static void printMegaBytesAndKiloBytes(int KiloByte) {

        if (KiloByte < 0)
            System.out.print("Invalid Value");
        else {
            System.out.print(KiloByte+" KB = "+KiloByte/1024+" MB and "+KiloByte%1024+" KB");
        }
    }

    public static void swap_numbers(int a, int b) {
        // System.out.println("a is: "+a+" and b is: "+b);
        a= a+b;
        b= a-b;
        a= a-b;
        //  System.out.println("a is: "+a+" and b is: "+b);
    }

}