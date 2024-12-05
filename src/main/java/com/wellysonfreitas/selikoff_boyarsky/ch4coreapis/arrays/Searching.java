package com.wellysonfreitas.selikoff_boyarsky.ch4coreapis.arrays;

/*

To perform binary search, the array needs to be sorted.

*/

// import java.util.*; // includes Arrays
import java.util.Arrays; // just Arrays

class Searching {
    public static void main(String[] args) {
        int[] numbers = {2, 4, 6, 8}; // sorted
        
        System.out.println(Arrays.binarySearch(numbers, 2)); // 0
        System.out.println(Arrays.binarySearch(numbers, 4)); // 1
        
        // 1 not found, but would keep sorting at 0 ->  0 - 1 = -1
        System.out.println(Arrays.binarySearch(numbers, 1)); // -1

        // 3 not found, but would keep sorting at 1 -> -1 - 1 = -2
        System.out.println(Arrays.binarySearch(numbers, 3)); // -2
        
        // 9 not found, but would keep sorting at 4 -> -4 - 1 = -5
        System.out.println(Arrays.binarySearch(numbers, 9)); // -5
        
        int[] numbers2 = new int[] {3, 2, 1}; // not sorted
        
        System.out.println(Arrays.binarySearch(numbers, 2)); // 1
        System.out.println(Arrays.binarySearch(numbers, 3)); // unpredictable output, because array is not sorted
    }
}
