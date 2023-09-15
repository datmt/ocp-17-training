package com.datmt.ocp17.class_and_interfaces;

public class InterfaceDemo {


}

interface Animal {
}

//abstract is optional for interface
abstract interface Dog extends Animal {

}


//You cannot use final for interface
//final interface Bird {
//
//}

//Methods in interface
interface Phone {

    //Implicit modifiers
    public void call();

    public abstract void sms();

    public static final int MAX_VOLUME = 100;

    //You cannot use private or protected for interface abstract methods and default methods
    //private void privateMethod();
    //protected void protectedMethod();

    //Methods with body
    default void IMEI() {
        System.out.println("IMEI");
    }

    static void simSlots() {
        System.out.println("2 sim slots");
    }

    //Default methods
    //Some rules
    //1. Default methods are implicitly public
    //2. Default methods must have a body
    //3. Default methods cannot be private or protected
    //4. Default methods can be overridden in the implementing class
    //5. Default methods cannot be used with abstract, static, final
    //6. If a class implements two interfaces with identical default methods, the class must override the default method
    //7. If a class implements two interfaces with identical default methods, the return type of the default method must be compatible
    public default void die() {
        System.out.println("phone die");
    }

    //this will not compile
//    private default void privateDefaultMethod() {
//        System.out.println("Private default method");
//    }

}

interface Fruit {
    default void die() {
        System.out.println("fruit die");
    }
}

class FruitPhone implements Fruit, Phone {

        @Override
        public void call() {
            System.out.println("Call");
        }

        @Override
        public void sms() {
            System.out.println("SMS");
        }

        @Override
        public void die() {
            //You can call the default method of Fruit
            Fruit.super.die();
            //You can call the default method of Phone
            Phone.super.die();
            System.out.println("Fruit phone die");
        }
}
