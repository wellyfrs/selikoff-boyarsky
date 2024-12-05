package com.wellysonfreitas.selikoff_boyarsky.ch8lambdasfunctionalinterfaces.functionalinterface.builtins;

/*

A Supplier is used when you want to generate or supply values without taking any input.

Defined as follows:

@FunctionalInterface
public interface Supplier<T> {
    T get();
}

*/

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.function.Supplier;

@SuppressWarnings("Convert2MethodRef")
class ImplementingSupplier {

    public static void main(String[] args) {
        Supplier<LocalDate> s1 = LocalDate::now;
        Supplier<LocalDate> s2 = () -> LocalDate.now();
        
        LocalDate d1 = s1.get();
        LocalDate d2 = s2.get();

        System.out.println(d1); // 2022-02-20
        System.out.println(d2); // 2022-02-20
        
        // Another example
        Supplier<StringBuilder> s3 = StringBuilder::new;
        Supplier<StringBuilder> s4 = () -> new StringBuilder();

        System.out.println(s3.get()); // Empty string
        System.out.println(s4.get()); // Empty string
        
        // Shorter example
        Supplier<ArrayList<String>> s5 = ArrayList::new;
        ArrayList<String> a1 = s5.get();
        System.out.println(a1); // []

        System.out.println(s5); // packages...ImplementingSupplier$$Lambda$21/0x00000008000c1c40@2c6a3f77
    }
}
