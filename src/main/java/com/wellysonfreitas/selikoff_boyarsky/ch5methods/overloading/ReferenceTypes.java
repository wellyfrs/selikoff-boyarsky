package com.wellysonfreitas.selikoff_boyarsky.ch5methods.overloading;

import java.time.*;
import java.util.*;

class Pelican {
    public void fly(String s) {
        System.out.print("string");
    }
    
    public void fly(Object o) {
        System.out.print("object");
    }

    public static void main(String[] args) {
        var p = new Pelican();
        p.fly("test");
        System.out.print("-");
        p.fly(56); // autoboxes to Integer
        // prints string-object
    }
}

@SuppressWarnings("ArraysAsListWithZeroOrOneArgument")
class Parrot {
    public static void print(List<Integer> i) {
        System.out.print("I");
    }
    
    public static void print(CharSequence c) {
        System.out.print("C");
    }
    
    public static void print(Object o) {
        System.out.print("O");
    }

    public static void main(String[] args) {
        print("ABC"); // C (String and StringBuilder implement CharSequence)
        print(Arrays.asList(3)); // I
        print(LocalDate.of(2019, Month.JULY, 4)); // O
    }
}
