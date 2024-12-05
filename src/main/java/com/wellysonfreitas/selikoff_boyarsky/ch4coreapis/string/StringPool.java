package com.wellysonfreitas.selikoff_boyarsky.ch4coreapis.string;

/*

STRING POOL

The string pool contains literal values and constants that appear in your program (in compile time).
For example, "name" is a literal and therefore goes into the string pool.

The myObject.toString() method returns a string but not a literal, so it does not go into the string pool.

*/

@SuppressWarnings({"StringEquality", "StringOperationCanBeSimplified", "NewObjectEquality"})
class StringPool {

    public static void main(String[] args) {
        String x = new String("Hello World");
        String y = new String("Hello World");
        System.out.println(x == y); // false
        
        var x2 = "Hello World";
        var y2 = "Hello World";
        System.out.println(x2 == y2); // true

        var x3 = "Hello World";
        var y3 = " Hello World".trim(); // string computed at runtime, not compile-time constant (not in string pool)
        System.out.println(x3 == y3); // false

        var singleString = "hello world";
        var concat = "hello ";
        concat += "world";
        System.out.println(singleString == concat); // false

        // Forcing Java to not use string pool with String constructor
        var x4 = "Hello World";
        var y4 = new String("Hello World");
        System.out.println(x4 == y4); // false

        // You can also tell Java to use the string pool with intern()
        var name2 = "Hello World";
        var name3 = new String("Hello World").intern();
        System.out.println(name2 == name3); // true

        var first = "rat" + 1; // compile-time constant -> rat1 in string pool
        var second = "r" + "a" + "t" + "1"; // compile-time constant -> rat1 already in string pool
        var third = "r" + "a" + "t" + new String("1"); // not compile-time constant
        System.out.println(first == second); // true
        System.out.println(first == second.intern()); // true
        System.out.println(first == third); // false
        System.out.println(first == third.intern()); // true
    }
}
