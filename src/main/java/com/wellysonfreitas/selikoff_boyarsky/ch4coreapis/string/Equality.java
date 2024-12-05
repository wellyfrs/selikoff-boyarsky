package com.wellysonfreitas.selikoff_boyarsky.ch4coreapis.string;

@SuppressWarnings({
        "NewObjectEquality",
        "ConstantValue",
        "unused",
        "MismatchedQueryAndUpdateOfStringBuilder",
        "StringEquality",
        "StringOperationCanBeSimplified"
})
class Equality {
    public static void main(String[] args) {
        // COMPARING equals() AND ==
        
        var one = new StringBuilder();
        var two = new StringBuilder();
        var three = one.append("a");
        System.out.println(one == two); // false
        System.out.println(one == three); // true
        
        // comparing literals with == (String pool)
        var x = "Hello World";
        var y = "Hello World";
        System.out.println(x == y); // true
        
        // comparing objects with ==
        var x2 = new String("Hello World");
        var y2 = new String("Hello World");
        System.out.println(x2 == y2); // false

        // comparing strings changed at runtime with ==
        var x3 = "Hello World";
        var z3 = " Hello World".trim();
        System.out.println(x3.equals(z3)); // false
        
        // equals() uses logical equality rather than object equality for String objects
        var x4 = "Hello World";
        var z4 = " Hello World".trim();
        System.out.println(x4.equals(z4)); // true
        
        // comparing incompatible types with ==
        var name = "a";
        var builder = new StringBuilder("a");
        // System.out.println(name == builder); // DOES NOT COMPILE
    }
}
