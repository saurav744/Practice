package com.saurav;

public class MethodOverloading {

    public static void main(String[] args) {

        double r= 4;
        double l=3;

        System.out.println("Area of circle is: "+area(r));
        System.out.println("Area of Rectangle is: "+area(r,l));

    }

    public static double area (double a, double b) {
        return a*b; //area of rectangle
    }

    public static double area (double radius) {
        double pi= 3.142;
        return pi*radius*radius; //area of circle
    }

}