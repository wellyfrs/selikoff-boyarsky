package com.wellysonfreitas.selikoff_boyarsky.ch2operators.unary;

/*

INCREMENT AND DECREMENT OPERATORS

Pre-increment: ++w (increases the value by 1 and returns the new value)
Pre-decrement: --x (decreases the value by 1 and returns the new value)
Post-increment: y++ (increases the value by 1 and returns the original value)
Post-decrement: z-- (decreases the value by 1 and returns the original value)

*/

class IncrementDecrementOperators {
    public static void main(String[] args) {
        int parkAttendance = 0;
        System.out.println(parkAttendance); // 0
        System.out.println(++parkAttendance); // 1
        System.out.println(parkAttendance); // 1
        System.out.println(parkAttendance--); // 1
        System.out.println(parkAttendance); // 0
        
        // [Other examples]
        int pig = 4;
        pig = pig++; // post-increment returns the original value 4
        System.out.println(pig); // 4

        int snake = 1;
        System.out.println(snake++ + " ");
    }
}
