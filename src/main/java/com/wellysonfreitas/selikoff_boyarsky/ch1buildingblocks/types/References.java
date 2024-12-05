package com.wellysonfreitas.selikoff_boyarsky.ch1buildingblocks.types;

/*

REFERENCE TYPES

A reference type refers to an object (an instance of a class).
It "points" to an object by storing the memory address where the object is located (pointer).

Unlike other languages [like C], Java doesn't allow you to learn what the physical memory address is.
 
You can only use the reference to refer to the object.

*/

@SuppressWarnings({"StringOperationCanBeSimplified", "WrapperTypeMayBePrimitive"})
public class References {

    public static void main(String[] args) {
        String greeting;
        
        // A reference can be assigned to another object of the same or compatible type;
        // A reference can be assigned to a new object using the new keyword.
        greeting = new String("How are you?");
        
        // DISTINGUISHING BETWEEN PRIMITIVES AND REFERENCE TYPES
        
        String reference = "hello";
        int len = reference.length();
//        int bad = len.length(); // DOES NOT COMPILE (primitive doesn't have methods)

        // Reference types can be assigned null
//        int value = null; // DOES NOT COMPILE (you can use a wrapper in this case)
        String name = null;
        
        // WRAPPER CLASSES
        // Each primitive type has a wrapper class, an object that corresponds to the primitive
        
        var booleanWrapper = Boolean.valueOf(true);
        var byteWrapper = Byte.valueOf((byte) 1);
        var shortWarapper = Short.valueOf((short) 1);
        var integerWrapper = Integer.valueOf(1);
        var longWrapper = Long.valueOf(1);
        var floatWrapper = Float.valueOf((float) 1.0); // or 1.0f
        var dollarWrapper = Double.valueOf(1.0);
        var characterWrapper = Character.valueOf('c'); // or casting, e.g. (char) 1
        
        // valueOf(String) vs. parseType(String)
        
        int primitive = Integer.parseInt("123"); // returns primitive
        Integer wrapper = Integer.valueOf("123"); // returns wrapper

        // [Another example]
        var num1 = Long.parseLong("100"); // returns primitive long
        var num2 = Long.valueOf("100"); // returns wrapper Long
        System.out.println(Long.max(num1, num2)); // 100 (unboxes wrapper to primitive long)
        
        // Numeric classes extend the Number class with helper methods:
        // byteValue(), shortValue(), intValue(), longValue(), floatValue(), doubleValue().
        // Boolean and Character also have booleanValue() and charValue(), respectively.
        
        Double apple = Double.valueOf("200.99");
        System.out.println(apple.byteValue()); // -56 (there is no 200 in byte, Java does its best to convert)
        System.out.println(apple.intValue()); // 200 (value is truncated)
        System.out.println(apple.doubleValue()); // 200.99
        
        // Other helper methods
        // max(int num1, int num2) returns the largest of the two numbers
        // min(int num1, int num2) returns the smallest of the two numbers
        // sum(int num1, int num2) adds the two numbers
    }
}
