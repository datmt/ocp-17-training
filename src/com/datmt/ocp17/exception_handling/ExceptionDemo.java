package com.datmt.ocp17.exception_handling;

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

}
