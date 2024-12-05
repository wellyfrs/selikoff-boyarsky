package com.wellysonfreitas.selikoff_boyarsky.ch4coreapis.string;

/*

STRING CONCATENATION

Rules:

1. If both operands are numeric, + means numeric addition.
2. If either operand is a String, + means concatenation.
3. The expression is evaluated left to right.

Summary: use numeric addition if two numbers are involved; use concatenation otherwise; evaluate from left to right.

*/

class Concatenation {
    public static void main(String[] args) {
        System.out.println(1 + 2); // 3
        System.out.println("a" + "b"); // ab
        System.out.println("a" + "b" + 3); // ab3
        System.out.println(1 + 2 + "c"); // 3c
        System.out.println("c" + 1 + 2); // c12
        System.out.println("c" + null); // cnull
        String d = null;
        System.out.println("d" + d); // dnull

        int three = 3;
        String four = "4";
        System.out.println(1 + 2 + three + four); // 64

        var s = "1"; // s currently holds "1"
        s += "s"; // s currently holds "12"
        s += 3; // s currently holds "123"
        System.out.println(s); // 123
    }
}
