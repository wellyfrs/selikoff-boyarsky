package com.wellysonfreitas.selikoff_boyarsky.ch2operators.unary;

/*

BITWISE COMPLEMENT OPERATOR

The bitwise complement operator (~) flips all of the 0s and 1s in a number.
It can only be applied to integer numeric types such as byte, short, char, int, and long.

*/
class BitwiseComplementOperator {

    public static void main(String[] args) {
        int value = 3; // stored as 0011
        int complement = ~value; // stored as 1100
        System.out.println(value); // 3
        System.out.println(complement); // -4
        
        // To find the bitwise complement of a number,
        // multiply it by -1 and then subtract 1:
        // c = (-1 * n) - 1
        System.out.println(-1*value - 1); // 4
        System.out.println(-1*complement - 1); // 3
    }
}
