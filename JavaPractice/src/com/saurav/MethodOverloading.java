package com.saurav;

public class MethodOverloading {

    public static void main(String[] args) {

        double r = 4;
        double l = 3;
        int s = 4;

        System.out.println("Area of circle is: "+area(r));
        System.out.println("Area of Rectangle is: "+area(r,l));
        System.out.println("Area of square is: "+area(s));

    }

    public static double area (double a, double b) {
        return a*b; //area of rectangle
    }

    public static double area (double radius) {
        double pi= 3.142;
        return pi*radius*radius; //area of circle
    }

    public static int area (int side) {
        return (side * side); // area of square
    }

}