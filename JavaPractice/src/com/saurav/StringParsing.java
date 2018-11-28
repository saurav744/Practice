package com.saurav;

public class StringParsing {

    public static void main (String[] args) {

        int a = 744;
        double b = 6.25;
        float c = 4.0f;

        String s_int= Integer.toString(a);
        String s_doub= Double.toString(b);
        String s_flo= Float.toString(c);

        System.out.println("String from int : "+s_int);
        System.out.println("String from double : "+s_doub);
        System.out.println("String from float : "+s_flo);

        String integer = "123";
        String duble = "100.123";
        System.out.println(integer+duble); // '+' operator will concatenate since these are strings.

        a = Integer.parseInt(integer);
        b = Double.parseDouble(duble);

        System.out.println(a+b); // But here '+' operator will do arithmetic addition

        String s= "This is a string.";
        char ch= s.charAt(3); //char at index 3

        System.out.println(ch);

    }
}