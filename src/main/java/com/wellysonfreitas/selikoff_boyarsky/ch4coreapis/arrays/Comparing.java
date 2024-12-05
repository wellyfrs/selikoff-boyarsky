package com.wellysonfreitas.selikoff_boyarsky.ch4coreapis.arrays;

import java.util.Arrays; // just Arrays

class Comparing {
    public static void main(String[] args) {
        // COMPARE
        System.out.println(Arrays.compare(new int[] {1}, new int[] {2})); // prints negative numbers
        System.out.println(Arrays.compare(new int[] {1}, new int[] {1})); // prints 0
        
        // System.out.println(Arrays.compare(new int[] {1}, new String[] {"a"})); // DOES NOT COMPILE
        
        // MISMATCH
        // If the arrays are equal, mismatch() returns -1.
        // Otherwise, it returns the first index where they differ.
        System.out.println(Arrays.mismatch(new int[] {1}, new int[] {1}));
        System.out.println(Arrays.mismatch(new String[] {"a"}, new String[] {"A"}));
        System.out.println(Arrays.mismatch(new int[] {1, 2}, new int[] {1}));
    }
}
