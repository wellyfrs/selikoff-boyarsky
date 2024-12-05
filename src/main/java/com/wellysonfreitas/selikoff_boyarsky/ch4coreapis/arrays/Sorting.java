package com.wellysonfreitas.selikoff_boyarsky.ch4coreapis.arrays;

// import java.util.*; // includes Arrays
import java.util.Arrays; // just Arrays

/*

SORTING ARRAYS

You can pass almost any array to Arrays.sort().
Time complexity is O(n log n).

String sorting order:

1. numbers
2. uppercase
3. lowercase

*/

@SuppressWarnings({"ForLoopReplaceableByForEach", "ResultOfMethodCallIgnored"})
class Sorting {

    public static void main(String[] args) {
        int[] numbers = { 6, 9, 1 };
        Arrays.sort(numbers);
        
        for (int i = 0; i < numbers.length; i++)
            System.out.println(numbers[i] + " "); // 1 6 9
        
        // Alternative to print array
        Arrays.toString(numbers); // [1, 6, 9]
        
        String[] strings = {"10", "9", "100"};
        Arrays.sort(strings);
        for (String s: strings) // enhanced loop
            System.out.println(s + " "); // 10 100 9
    }
}
