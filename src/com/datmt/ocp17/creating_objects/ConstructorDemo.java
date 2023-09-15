package com.datmt.ocp17.creating_objects;

public class ConstructorDemo {

    public static void main(String[] args) {
        //Dog has a default no-args constructor
        var dog = new Dog();

        //Cat doesn't have a default no-args constructor
        //var cat = new Cat();//this will not compile

    }
}

class Dog {

}

class Cat {
    public Cat(String name) {

    }
}


class Bird {
    //constructor calling other constructor
    public Bird() {
        this("default");
    }

    public Bird(String name) {
        System.out.println("Bird constructor with name" + name);
    }

    public Bird(String name, String breed) {
        System.out.println("Bird constructor with name" + name + " and breed " + breed);
        //this(name); //Does not compile, must be the first statement
    }
}

class Vehicle {
    public Vehicle(String brand) {
        System.out.println("Vehicle constructor with brand " + brand);
    }
}

class Car extends Vehicle {
    public Car() {
        super("default");
    }

}

class Animal {
    public static void eat() {
        System.out.println("Animal is eating");
    }

    static {
        System.out.print("A");
    }

    {
        System.out.print("a");
    }

    public void eating() {
        System.out.println("Animal is eating");
    }
    protected String breed = "animal";
}

class Hippo extends Animal {
    {
        System.out.print("hippo");
    }

    protected String breed = "hippo";
    public void eating() {
        System.out.println("Hippo is eating");
    }

    public static void eat() {
        System.out.println("Hippo is eating");
    }

    public Hippo() {
        System.out.print("Hippo");
    }

    public static void main(String[] grass) {
        var x   = new Hippo();
        Animal a = x;

        System.out.println(x.breed);
        System.out.println(a.breed);
    }

    static {
        System.out.print("B");
    }
}

class AnimalFinal {
    static final String breed;

    static {
        breed = "Dog";
    }

    public AnimalFinal() {
        //breed = "Cat"; //Does not compile
    }
}