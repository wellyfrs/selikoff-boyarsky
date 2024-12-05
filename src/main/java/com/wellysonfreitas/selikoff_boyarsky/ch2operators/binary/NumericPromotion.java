package com.wellysonfreitas.selikoff_boyarsky.ch2operators.binary;

/* 

NUMERIC PROMOTION

- Promotes the smallest type to the larger type
- Promotes integral value to floating-point value
- `byte`, `short`, and `char` are converted to `int` in binary arithmetic operations with a variable

*/

@SuppressWarnings("ConstantValue")
class NumericPromotion {
    public static void main(String[] args) {
        // If two values have different data types,
        // Java will automatically promote one of the values to the larger of the two data types.
        int x = 1;
        long y = 33;
        var z = x * y; // x is promoted to long, so z is long
//        int intZ = x + y; // DOES NOT COMPILE

        // If one of the values is integral and the other is floating-point,
        // Java will automatically promote the integral value to the floating-point value's data type.
        double x2 = 39.21;
        float y2 = 2.1f;
        var z2 = x2 + y2; // y2 is promoted to double, so z2 is double

//        float floatZ = x2 + y2; // DOES NOT COMPILE

        // Smaller data types, namely, byte, short, and char, are first promoted to int
        // any time they're used with a Java binary arithmetic operator with a variable
        // (as opposed to a value), even if neither of the operands is int.
        // Conditions: (1) byte/short/char; (2) binary arithmetic operation; (3) variable
        short x3 = 10;
        short y3 = 3;
        var z3 = x3 * y3; // x3 and y3 are promoted to int, so z3 is int
//        short shortZ = x3 * y3; // DOES NOT COMPILE

        // Rule does not apply in unary operators
        // x and z are NOT promoted to int in this case
        x++;
        z--;

        // Rule does not apply for values (as opposed to a variables)
        // 2 and 1 are not promoted to int in this case
        short boots = 2 + 1;
    
        // After all promotion has occurred and the operands have the same data type,
        // the resulting value will have the same data type as its promoted operands.
        short w = 14;
        float x4 = 13;
        double y4 = 30;

        // w (short) is promoted to int, then it is promoted to float because of x4 (float),
        // then result of w * x4 is promoted to double because of y4 (double),
        // so z4 is double
        var z4 = w * x4 / y4;
//        short shortZ = w * x4 / y4; // DOES NOT COMPILE
//        float floatZ = w * x4 / y4; // DOES NOT COMPILE
        
        // [Other examples]
        short height = 1, weight = 3;
//        short zebra = (byte) weight * (byte) height; // DOES NOT COMPILE

        boolean symphony = 1.0 == 1_000f; // 1_000f is promoted to double
        System.out.println(symphony); // false
    }
}
