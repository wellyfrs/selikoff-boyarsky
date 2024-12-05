package com.wellysonfreitas.selikoff_boyarsky.ch2operators.binary;

class ArithmeticOperators {
    public static void main(String[] args) {
        // 2 * 5 and 3 * 4 is evaluated first, reducing expression to 10 + 12 - 8
        int price = 2 * 5 + 3 * 4 - 8;
        System.out.println(price); // 14
        
        // Changing the order of operation
        price = 2 * ((5 + 3) * 4 - 8);
        System.out.println(price); // 48
        
        // DOES NOT COMPILE because of unbalanced parentheses:
        // long pigeon = 1 + ((3 * 5) / 3;
        // int blueJay = (9 + 2) + 3) / (2 * 4;
        // short robin = 3 + [(4 * 2) + 4];
        
        // DIVISION AND MODULUS OPERATORS
        
        // For a given divisor y, the modulus operation results in
        // a value between 0 and (y - 1) for positive dividends

        System.out.println(9 / 3); // 3
        System.out.println(9 % 3); // 0

        System.out.println(10 / 3); // 3
        System.out.println(10 % 3); // 1

        System.out.println(11 / 3); // 3
        System.out.println(11 % 3); // 2

        System.out.println(12 / 3); // 4
        System.out.println(12 % 3); // 0
    }
}
