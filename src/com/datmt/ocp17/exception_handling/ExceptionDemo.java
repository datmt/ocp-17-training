package com.datmt.ocp17.exception_handling;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;

public class ExceptionDemo {

    public static void main(String[] args) {
        throwNull();
    }

    private static void throwChain() {
        try {
            throw new Exception("Hello World");
        } catch (Exception e) {
            System.out.println("Caught Exception");
            throw new RuntimeException(e);
        } finally {
            throw new RuntimeException("Hello World in finally");
        }
    }

    private static void throwNull() {
        try {
            RuntimeException e = null;
            throw e;
        } catch (Exception e) {
            System.out.println(e);
        }
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

    public void tryWithResources() throws IOException {
        try (var reader = new FileReader("file.txt")) {
            //do something
        }

        try (Reader reader = new FileReader("file.txt")) {
            //do something
        } catch (IOException e) {
            //do something
        }

        //Declare multiple resources
        try (Reader reader = new FileReader("file.txt");
             Reader reader2 = new FileReader("file2.txt")) {
            //do something
        } catch (IOException e) {
            //do something
        }

    }
}

abstract class A {
    public abstract void method() throws SQLException;

    public static void main(String[] args) {
        for (; ; ) ;
    }
}

class SomeExamples {
    static class MyResource implements AutoCloseable {
        private String resourceName;
        public MyResource(String resourceName) {
            this.resourceName = resourceName;
        }
        @Override
        public void close() throws Exception {
            System.out.println("Closing " + resourceName);
        }
    }

    public static void main(String[] args) {
        try (MyResource myResource1 = new MyResource("First");
             MyResource myresource2 = new MyResource("Second")) {
            System.out.println("In Try Block");
            throw new RuntimeException();
        } catch (Exception e) {
            System.out.println("In Catch Block");
        } finally {
            System.out.println("In Finally Block");
        }
    }

    //The order of output when running main:
    //In Try Block
    //Closing Second
    //Closing First
    //In Catch Block
    //In Finally Block

}


class SuppressedExceptionDemo {

    static class MyProblematicResource implements AutoCloseable {
        private String resourceName;
        public MyProblematicResource(String resourceName) {
            this.resourceName = resourceName;
        }
        @Override
        public void close() throws Exception {
            System.out.println("Closing " + resourceName);
            throw new Exception("Exception in close method");
        }
    }

    public static void main(String[] args) {
        try (var resource = new MyProblematicResource("First")) {
            System.out.println("In Try Block");
            throw new RuntimeException("Exception in try block");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Exception in catch block");
            for (Throwable t : e.getSuppressed()) {
                System.out.println(t.getMessage());
            }
        } finally {
            System.out.println("In Finally Block");
        }
    }
}
