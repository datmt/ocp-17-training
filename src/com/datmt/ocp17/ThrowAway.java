package com.datmt.ocp17;

public class ThrowAway {
    private static String name1 = "ThrowAway first";
    static {
        System.out.println("ThrowAway static block");
        System.out.println(name1);
    }
    private static String name2 = "ThrowAway first";


    public static void main(String[] args) {
    }
}
