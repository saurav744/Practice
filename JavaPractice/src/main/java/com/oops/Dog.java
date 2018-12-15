package com.oops;

public class Dog extends Animal {

    private int eyes;
    private int legs;
    private int tail;
    private int teeth;

    public Dog(String name, int size, int weight, int eyes, int legs, int tail, int teeth) {
        super(name, 1, 1, size, weight);
        this.eyes = eyes;
        this.legs = legs;
        this.tail = tail;
        this.teeth = teeth;
    }

    private void chew() {
        System.out.println("Dog.chew() called");
    }

    public void eat() {
        System.out.println("Dog.eat() called");
        chew();
       // super.eat();
    }

    public void walk() {
        System.out.println("Dog.walk() called");
        move(5);
    }

    public void run() {
        System.out.println("Dog.run() called");
        move(10);
    }

    @Override
    public void move(int speed) {
        System.out.println("Dog.move() called, dog is moving at speed "+speed);

    }

}
