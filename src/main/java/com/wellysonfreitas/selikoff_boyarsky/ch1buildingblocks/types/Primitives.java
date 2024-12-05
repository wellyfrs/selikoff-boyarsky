package com.wellysonfreitas.selikoff_boyarsky.ch1buildingblocks.types;

/*

PRIMITIVE TYPES

There are 8 primitive types:

- boolean
- byte
- short
- int (default for integral literals)
- long
- float
- double (default for floating-point literals)
- char

String is not a primitive, although Java includes built-in support for String literals and operators.

Key points:

- The byte, short, int, and longs types are used for integer values without decimal points.
- Each numeric type uses twice as many bits as the smaller similar type.
- All of the numeric types are signed and reserve one of their bits to cover a negative range.
- A float requires the letter f o F following the number so Java knows it is a float.
- A long requires the letter l or L following the number so Java knows it is a long. Without an l or L,

short vs. char
- Both has 16-bit length
- short is signed, char is unsigned

*/

@SuppressWarnings("OctalInteger")
public class Primitives {
//    long max = 3123456789; // DOES NOT COMPILE (exceed maximum value for an int)
    long max2 = 3123456789L; // Now Java knows it is a long [because of the L]
    
    // DECIMAL NUMBER SYSTEMS
    // - Octal (digits 0-7) uses the number 0 as a prefix.
    // - Hexadecimal (digits 0-9 and letters A-F/a-f) uses 0x or 0X as a prefix. It's case-insensitive.
    // - Binary (digits 0-1) uses 0b or 0B as a prefix.
    
    int octal = 017; // = 15
    int hexadecimal = 0xFF; // = 0; 0x and OX are valid prefixes
    int binary = 0b10; // = 3; 0b and 0B are valid prefixes
    
    // LITERALS AND THE UNDERSCORE CHARACTER
    
    int million1 = 1000000;
    int million2 = 1_000_000;
    
//    double notAtStart = _1000.00; // DOES NOT COMPILE
//    double notAtEnd = 1000.00_; // DOES NOT COMPILE
//    double notByDecimal = 1000_.00; // DOES NOT COMPILE
    double annoyingButLegal = 1_00_0.0_0; // Ugly, but compiles
    double reallyUgly = 1________2; // Also compiles

    // [More examples]
    
    float x = 2; // automatically casting from int to float
//    float x = 2.1; // DOES NOT COMPILE (floating-point literals are Double by default)
    double y = 0; // automatically casting from int to double
    
//    short numPets = 5L; // DOES NOT COMPILE
    long numPets = (short) 5;
    
//    int numGrains = 2.0; // DOES NOT COMPILE
    double numGrains = (int) 2.0;

    static float floatVar = 0.0f;
    
    public static void main(String[] args) {
        System.out.println(floatVar); // float values are not printed with an f suffix: 0.0
    }
}
