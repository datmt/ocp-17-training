package com.datmt.ocp17.building_blocks;

public class DeclaringVariables {
    public static void main(String[] args) {


        //# Rule of the identifiers' names
        //1. Must start with a letter, underscore, or currency signs. After the first character, may use numbers as well
        //2. No reserved keywords
        //Examples:
        int _a;
        int $b;
        int c;
        int d1;
        int e_;
        int f$;
        int €g1;

        //Valid identifier using var
//        int var;
//        var var = 100;

        //Invalid examples
        //int 1a; // cannot start with a number
        //int a-b; // cannot use hyphen
        //int a b; // cannot use space
        //int a#; // cannot use #
        //int _; // cannot use _ alone
        //int class; // cannot use reserved keywords

        //# Declare variables
        //1. Declare a variable
        int a1;
        //2. Declare and assign a value
        int b1 = 1;


        //# Declaring multiple variables
        //1. Declare multiple variables of the same type
        int a, b, c1;
        //2. Declare and assign values
        int d = 1, e = 2, f = 3;
        int a4, b4, c4 = 0;
        //System.out.println(a1); // this will not compile, a1 is not initialized

        //invalid multiple declarations
        //int a5, int b5; // this will not compile, cannot repeat type
        // int a5, b5 = 0, String z; // this will not compile, cannot mix types
    }
}
