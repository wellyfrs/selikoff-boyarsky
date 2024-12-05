package com.wellysonfreitas.selikoff_boyarsky.ch2operators.unary;

/*

PRIMITIVE CASTING

Casting is a unary operation
where one data type is explicitly interpreted as another data type.

Java will automatically promote smaller to larger data types, but
it will throw a compiler exception if it detects that
you are trying to convert from larger to smaller data types
without [explicit] casting.

*/

@SuppressWarnings({"UnnecessaryLocalVariable", "RedundantCast", "ConstantValue", "lossy-conversions"})
class PrimitiveCasting {
    public static void main(String[] args) {
        int fur = (int)5; // unnecessary
        String type = (String) "Bird"; // unnecessary
        
        boolean car = true;
        boolean truck = (boolean)car;
        
        short tail = (short)(4 + 10);
        
        // AUTOMATIC CASTING
        
        // The compiler automatically casts smaller data types to larger ones,
        // in this case, after we cast int to short, compiler casts short to int again
        int hair = (short) 2;
        
        // CASTING REQUIRED TO CONVERT FLOAT-POINTING TO INTEGRAL
        
//        int mammal = 9f; // DOES NOT COMPILE
        int mammal = (int)9f;
        
//        int fish = 1.0; // DOES NOT COMPILE
        int fish = (int)1.0;
        
        // CASTING REQUIRED TO CONVERT TO SMALLER NUMERICAL DATA TYPE

        // 2.0 is double by default, 9 is promoted to double,
        // result is double, which is larger than float egg
//        float egg = 2.0 / 9; // DOES NOT COMPILE

        // 5 is promoted to long,
        // result is long, and variable int is smaller than long
//        int tadpole = (int)5 * 2L; // DOES NOT COMPILE

        // 3 is int by default, 2.0 is double by default, 3 is promoted to double,
        // result is double, and variable short is smaller than double
//        short frog = 3 - 2.0; // DOES NOT COMPILE
        
//        short bird = 1921222; // DOES NOT COMPILE
        short bird = (short) 1921222; // stored as 20678 because of numeric overflow

        short mouse = 10;
        short hamster = 3;
        
//        short capybara1 = mouse * hamster; // DOES NOT COMPILE
//        short capybara2 = (short) mouse * hamster; // DOES NOT COMPILE
        short capybara3 = (short) (mouse * hamster);
        
        // short is promoted to int in binary arithmetic operator
        // short capybara4 = 1 + (short) (mouse * hamster); // DOES NOT COMPILE
        
        // IMPLICIT CASTING IN COMPOUND ASSIGNMENT
        
        long goat = 10;
        int sheep = 5;
        
//        sheep = sheep * goat; // DOES NOT COMPILE

        sheep *= goat; // implicit casting
        
        // [Other examples]
        System.out.println((long)(int)(short) 2); // 2 (multiple casting is allowed)
        System.out.println((byte)(Byte.MAX_VALUE + 1)); // -128 (max value is 127, due to overflow it's negative)
    }
    
//    static long addCandy(double fruit, float vegetables) {
//        return (int) fruit + vegetables; // DOES NOT COMPILE
//    }
}
