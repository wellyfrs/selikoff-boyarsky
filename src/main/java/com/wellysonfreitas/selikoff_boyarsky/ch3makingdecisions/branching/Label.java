package com.wellysonfreitas.selikoff_boyarsky.ch3makingdecisions.branching;

/*

LABEL

A label is an optional pointer to the head of a statement that
allows the application flow to jump to it or break from it.
When dealing with only one loop, labels do not add any value,
but they are extremely useful in nested structures.

*/

@SuppressWarnings("ForLoopReplaceableByForEach")
class Label {
    public static void main(String[] args) {
        // Nested loop without labels:
        int[][] myComplexArray = {{5, 2, 1, 3}, {3, 9, 8, 9}, {5, 7, 12, 7}};
        for (int[] mySimpleArray : myComplexArray) {
            for (int i = 0; i < mySimpleArray.length; i++) {
                System.out.print(mySimpleArray[i] + "\t");
            }
            System.out.println();
        }
        
        // Nested loops with labels:
        OUTER_LOOP: for (int[] mySimpleArray : myComplexArray) {
            INNER_LOOP: for (int i = 0; i < mySimpleArray.length; i++) {
                System.out.print(mySimpleArray[i] + "\t");
            }
            System.out.println();
        }
    }
}
