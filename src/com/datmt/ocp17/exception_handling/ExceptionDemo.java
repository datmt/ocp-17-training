package com.datmt.ocp17.exception_handling;

import java.io.FileNotFoundException;
import java.io.IOException;

public class ExceptionDemo {

    public static void main(String[] args) {
        uncheckedNullPointer();
    }

    private static void uncheckedException() throws RuntimeException {
        throw new RuntimeException("Hello World");
    }

    private static void checkedException() throws Exception {
        throw new Exception("Hello World");
    }

    private static void error() throws Error {
        throw new Error("Hello World");
    }

    private static void uncheckedNullPointer() throws NullPointerException {
        throw new NullPointerException("Hello World");
    }

    //## Overriding Methods

    class A {
        public void method() throws Exception {
            throw new Exception("Hello World");
        }
    }

    class B extends A {
        @Override
        public void method() {
            throw new RuntimeException("Hello World");
        }
    }

    public void test() {
        A a = new B();
//        a.method(); //## This will not compile

        B b = new B();
        b.method(); // ## This will compile
    }

    public void classCastDemo() {
        Object invalidInteger = "Hello World";
        Integer x = (Integer) invalidInteger;
    }

    public void tryCatchFinally() {

        try {
            throw new Exception("Hello World");
        } catch (Exception e) {

        } finally {
            System.out.println("Finally");  //always execute
        }

        //Multicatch
        try {
            throw new Exception("Hello World");
        } catch (Exception | Error e) {
            //
        } finally {
            System.out.println("Finally");  //always execute
        }

        //Does not compile multicatch, FileNotFoundException is subclass of IOException
        /*
        try {

        } catch (IOException  | FileNotFoundException e) {

        }

         */

        //Order of catch blocks matter when the exceptions are hierarchical
        //The following will not compile because FileNotFoundException is subclass of IOException
        //More specific exception must be caught first
        /*
        try {
            throw new FileNotFoundException("Hello World");
        } catch (IOException e) {

        } catch (FileNotFoundException e) {

        }
        */
    }
}
