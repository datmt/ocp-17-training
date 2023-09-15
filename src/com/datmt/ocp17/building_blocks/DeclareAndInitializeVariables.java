package com.datmt.ocp17.building_blocks;

public class DeclareAndInitializeVariables {
    public static void main(String[] args) {
        //# Declare and initialize variables
        //A variable can be declared without being initialized
        //Being initialized means that the variable has a value assigned to it
        int a2;//only declared
        a2 = 1;//initialized
        int a3 = 200;//declared and initialized


        //# Declare variables
        //##. Declare a variable
        int a1;

        //##. Declare and assign a value
        int b1 = 1;

        //## Declaring multiple variables
        //### Declare multiple variables of the same type
        int a, b, c1;

        //### Declare and assign values
        int d = 1, e = 2, f = 3;
        int a4, b4, c4 = 0;
//        System.out.println(a1); // this will not compile, a1 is not initialized

        //### Invalid multiple declarations
        //int a5; int b5; // this will not compile, cannot repeat type
        int a5, b5 = 0;
        String z; // this will not compile, cannot mix types
    }
}

class Example1 {
    private String name;
    private static int age;
}

class LocalVariableInitializationDemo {
    //# Types of variables
    //There are local variables, class variables, and instance variables
    //Local variables must be initialized before use
    //Instance variables and class variables are initialized to their default values

    //## Local variables
    //### Local variables are declared in methods, constructors, or blocks
    {
        //### Local variables must be initialized before use
        int a;
        //System.out.println(a); // this will not compile, a is not initialized
    }

    //### Local variable declared in method
    private static void method() {
        int a;
        int z = 0;
        //System.out.println(a); // this will not compile, a is not initialized
        //int y = a + 1; //also not compile

        int y = z + 1;//this is ok. a is not used
    }

    //### Local variable declared in constructor
    public LocalVariableInitializationDemo() {
        int a = 0;
        System.out.println(a); // this will not compile, a is not initialized
    }

    //### Final local variable
    //Final local variables must be initialized before use
    //Once initialized, the value cannot be changed
    public void finalLocalVariable() {
        final int a;
        //System.out.println(a); // this will not compile, a is not initialized
        a = 200;

        //a = 100; // this will not compile, a is final

        //It's ok to modify the content of a final variable (array, list...)
        final int[] arr = {1, 2, 3};
        arr[0] = 100;
    }

    public void conditionalInitialization() {
        int a;
        int b;

        if (true) {
            a = 1;
            //    b = 3;
            b = 100;
        } else {
            a = 3;
        }

        System.out.println(a);
        System.out.println(b); // this will not compile, b is not initialized
    }

}

class TypeInferenceWithVar {

    //# Cannot use var with instance variables or class variables
    //var x = 200;// this will not compile, var cannot be used for instance variables
    public static void main(String[] args) {
        var a = 1;


        //# Invalid examples
       // var b;  // this will not compile, var must be initialized

        //var c = 200, d = 100; // this will not compile, var cannot be used for multiple variables

        //var d = null;// this will not compile, var cannot be used with null
        //the compiler cannot infer the type of the variable

        //You can assign null to a var variable if you specify the type
        var e = (String) null;//This is ok
        var f = "";
        f = null; //Also OK to assign null to a var variable after initialization
    }
}
class Test1 {
    private String me;
    private static float c1;
    public static void main(String[] args) {
        System.out.println(Test1.c1);
    }
}
class LocalVariableScope {

    //Block 1
    {
        int x = 100;
    }

    //Block 2
    {
        // System.out.println(x);//Does not compile, x is not in scope
    }

    public static void main(String[] args) {
        int x = 100;

        while (x < 1_000) {
            x--;
            int y = 200;
            System.out.println(y);

            if (x == 100) {
                int z = 300;
                System.out.println(z);
            }
            //z is not in scope here
        }
        //y is not in scope here
    }

    private static void method(int x) {
        var y = 200;
        var z = y + x;
    }
}

class ClassAndInstanceVariableScope {
    public static int x = 100;//class variable
    public int y;//instance variable

    public ClassAndInstanceVariableScope() {
        this.y = 200;
    }

    public void someMethod() {
        int x = 300;//local variable
        System.out.println(x);
        System.out.println(this.y);
        System.out.println(ClassAndInstanceVariableScope.x);
    }
    public static void main(String[] args) {
        System.out.println(x);
        System.out.println(ClassAndInstanceVariableScope.x);

        var instance = new ClassAndInstanceVariableScope();
        System.out.println(instance.y);
    }
}

class GarbageCollectionDemo {
   //Garbage collection is the process of automatically freeing memory
   //It is not guaranteed that the garbage collector will run


   //A variable is eligible for garbage collection when
   //there are no more references to the variable

    static class Dog {
        private String name;
       public Dog(String name)  {
          this.name = name;
       }
    }

    public static void main(String[] args) {
        Dog dog = new Dog("joe");
        dog = null;
        //dog is eligible for garbage collection

        Dog dog2 = new Dog("jane");
        Dog dog3 = new Dog("jake");
        dog2 = dog3;
        //the instance created with new Dog("jane") is eligible for garbage collection
    }
}