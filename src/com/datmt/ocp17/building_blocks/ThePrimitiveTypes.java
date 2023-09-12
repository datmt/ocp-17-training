package com.datmt.ocp17.building_blocks;

public class ThePrimitiveTypes {

    public static void main(String[] args) {
        //# Primitive data types

        //1. Boolean
        boolean b = true;
        boolean f_boolean1 = false;

        //2. Byte
        byte by = 1;//8 bits, min: -128, max: 127

        //3. Short
        short s = 2;//16 bits, min: -32,768, max: 32,767

        //4. Int
        int i = 3;//32 bits, min: -2,147,483,648, max: 2,147,483,647

        //5. Long
        long l = 4;//64 bits, min: -9,223,372,036,854,775,808, max: 9,223,372,036,854,775,807
        long veryLong = 100_000_000_000L;//This will not compile, the compiler will think it's an int


        //6. Float
        float f = 5.0f;//32 bits, min: 1.4E-45, max: 3.4028235E38
        float f9 = 5f;//32 bits, min: 1.4E-45, max: 3.4028235E38
        float f1 = 44444444444444444444.0f;// this will not compile, the compiler will think it's a double
        float f2 = 44444444444444444444f;// this will not compile, the compiler will think it's an int
        float f3 = 44444444444444444444f;
        float f4 = 44444444444444444444.0f;

        //7. Double
        double d = 6.0;//64 bits, min: 4.9E-324, max: 1.7976931348623157E308

        //8. Char
        char c = 'a';//16 bits Unicode value, min: 0, max: 65,535, 16-bit
        char c1 = 97;//16 bits Unicode value, min: 0, max: 65,535, 16-bit

        System.out.println(c == c1);

        //9. Declare numbers in bases other than 10
        int base2 = 0b1100100;//base 2, 0 to 1, prefixed by 0b
        int base8 = 0144;//base 8, 0 to 7, prefixed by 0
        int base16 = 0x64;//base 16, 0 to 9 and A to F (case insensitive), prefixed by 0x


        //# Casting
        // Implicit casting (from smaller to larger)
        int i1 = 1;
        long l1 = i1;

        System.out.println("Implicit casting: " + l1);


        // Explicit casting (from larger to smaller)
        long l2 = 2;

        int i2 = (int) l2;


        // Overflow
        byte seed = 20; //max value of byte is 127
        byte result = (byte) (seed * 20);

        System.out.println("out of bound casting: " + result);


        //# Working with char
//        char c1 = 'a';
//        char c2 = 97;

//        System.out.println(c1 == c2);

    }
}

class PrimitiveWrapper {
    public static void main(String[] args) {
        //* Primitive cannot be null
        //int i = null;//this will not compile
        //if you need to assign null to a primitive(technically not possible),
        // use wrapper classes

        //# Wrapper classes
        //1. Boolean
        Boolean b = true;
        Boolean b1 = null;
        Boolean b2 = Boolean.valueOf("true");
        Boolean b3 = Boolean.valueOf(false);
        Boolean b4 = Boolean.valueOf("false");

        System.out.println("value of false" + b4);
        //2. Byte
        Byte by = 1;//8 bits, min: -128, max: 127
        Byte by2 = Byte.valueOf("1");


        //3. Short
        Short s = 2;//16 bits, min: -32,768, max: 32,767
        Short s2 = Short.valueOf("2");
        //4. Int
        Integer i = 3;//32 bits, min: -2,147,483,648, max: 2,147,483,647
        Integer i2 = Integer.valueOf("3");
        Integer i3 = Integer.parseInt("44");
        //5. Long
        Long l = 4L;//64 bits, min: -9,223,372,036,854,775,808, max: 9,223,372,036,854,775,807

        //6. Float
        Float f = 5.0f;//32 bits, min: 1.4E-45, max: 3.4028235E38

        //7. Double
        Double d = 6.0;//64 bits, min: 4.9E-324, max: 1.7976931348623157E308

        //8. Char
        Character c = 'a';//16 bits Unicode value, min: 0, max: 65,535, 16-bit
    }
}