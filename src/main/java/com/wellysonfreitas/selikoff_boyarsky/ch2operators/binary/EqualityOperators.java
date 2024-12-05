package com.wellysonfreitas.selikoff_boyarsky.ch2operators.binary;

import java.io.File;

@SuppressWarnings({
        "ConstantValue",
        "UnnecessaryLocalVariable",
        "NewObjectEquality"
})
class EqualityOperators {
    public static void main(String[] args) {
        int a = 1, b = 2;
        System.out.println(a == b); // false
        System.out.println(a != b); // true
        
        // DOES NOT COMPILE
//        boolean monkey = true == 3;
//        boolean ape = false != "Grape";
//        boolean gorilla = 10.2 == "Koko";

        // Tricky code:
        boolean bear = false;
        boolean polar = (bear = true); // assignment as expression, returns value of assignment (in this case, true)
        System.out.println(polar); // true

        // in some languages, comparing null with any other value
        // is always false, although this is not the case in Java
        System.out.println(null == null); // true

        // OBJECT COMPARISON
        
        // For objects, equality occurs when two values reference the same object.
        // In other words, in object comparison, the equality operator is applied
        // to the references to the objects, not the objects they point to.
        
        var monday = new File("schedule.txt");
        var tuesday = new File("schedule.txt");
        var wednesday = tuesday;
        System.out.println(monday == tuesday); // false
        System.out.println(tuesday == wednesday); // true
    }
}
