package com.datmt.ocp17.building_blocks;

public class TheMainMethod {
}
















class A    {
    public static void main(String[] args) {
        System.out.println("This is valid main method");
    }
}
















class B {
    public final static void main(final String[] args) {
        System.out.println("This is also a valid main method with final modifier");
    }
}
















class C {
    public final static void main(String [] args) {
        System.out.println("This is also a valid main method with final modifier");
        System.out.println("You can put final modifier before or after static keyword");
        System.out.println("The array sign could be put after String or before args. Space is not required");
    }
}
















class D {
    public static void main(String... args) {
        System.out.println("This is also a valid main method with varargs");
    }
}


class E {
    public static void main(String[] args) {
        System.out.println("THank you for watching");
    }
}