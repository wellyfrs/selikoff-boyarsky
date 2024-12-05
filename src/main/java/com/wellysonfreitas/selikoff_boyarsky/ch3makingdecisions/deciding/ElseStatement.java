package com.wellysonfreitas.selikoff_boyarsky.ch3makingdecisions.deciding;

import com.wellysonfreitas.selikoff_boyarsky.Utils;

class ElseStatement {
    public static void main(String[] args) {
        int hourOfDay = Utils.randomInt(1, 24);
        
        if (hourOfDay < 11) {
            System.out.println("Good Morning");
        }
        if (hourOfDay >= 11) {
            System.out.println("Good Afternoon");
        }

        // Single statement (optional braces)
        if (hourOfDay < 11) {
            System.out.println("Good Morning");
        } else System.out.println("Good Afternoon");

        // Block (required braces)
        if (hourOfDay < 11) {
            System.out.println("Good Morning");
        } else if (hourOfDay < 15) {
            System.out.println("Good Afternoon");
        } else {
            System.out.println("Good Evening");
        }
    }
}
