package com.oops;

import java.util.HashMap;
import java.util.Map;

public class Main extends Object{

    public static void main(String[] args){
        Animal animal = new Animal("Animal", 1, 1, 5, 5);
        animal.move(5);
        Animal animal2 = null;
        String s= "bunny";

        Map hmap = new HashMap<>();

        System.out.println("value are : "+animal.getName()+"  and ");

        Dog dog = new Dog("Bulldog", 8, 20, 2, 4, 1, 20);
        dog.eat();
        dog.run();
        dog.walk();

        iTelephone Phone;
        Phone = new DeskPhone(123456);
        Phone.powerOn();
        Phone.callPhone(123456);
        Phone.answer();

    }
}
