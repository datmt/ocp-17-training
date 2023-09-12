package com.datmt.ocp17.building_blocks;

public class VariableNamesRule {
    public static void main(String[] args) {

        //# Rule of the identifiers' names
        //1. Must start with a letter, underscore, or currency signs (dollars, euro, .
        // After the first character, may use numbers as well @ * # % & etc.
        //2. No reserved keywords //https://docs.oracle.com/javase/specs/jls/se17/jls17.pdf
        //Examples:
        int _a;
        int $b;
        int c;
        int d1;
        int e_;
        int f$;
        int €g1;
        int ₹;
        int £;

        //Valid identifier using var
//        int var;
//        var var = 100;

        //Invalid examples
        //int 1a; // cannot start with a number
        //int a-b; // cannot use hyphen
        //int a b; // cannot use space
        //int a#; // cannot use #
        //int _; // cannot use _ alone
        // int class; // cannot use reserved keywords

    }
}
