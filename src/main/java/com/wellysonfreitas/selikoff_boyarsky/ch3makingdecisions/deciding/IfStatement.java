package com.wellysonfreitas.selikoff_boyarsky.ch3makingdecisions.deciding;

import com.wellysonfreitas.selikoff_boyarsky.Utils;

@SuppressWarnings({"SuspiciousIndentAfterControlStatement", "ConstantValue"})
public class IfStatement {
    public static void main(String[] args) {
        int hourOfDay = Utils.randomInt(1, 24), morningGreetingCount = 0;

        // Single statement (optional braces)
        if (hourOfDay < 11)
            System.out.println("Good Morning");

        // Block (required braces)
        if (hourOfDay < 11) {
            System.out.println("Good Morning");
            morningGreetingCount++;
        }

        // Trick code: single statement confused with block
        if (hourOfDay < 11)
        System.out.println("Good Morning");
        morningGreetingCount++;
        
        // Trick code
//        if (hourOfDay) {} // DOES NOT COMPILE (0 and 1 are not considered boolean values in Java)
        
        // [Other examples]
        int temperature = 4;
        long humidity = -temperature + temperature * 3;
        if (temperature >= 4)
        if (humidity < 6) System.out.println("Too Low");
        else System.out.println("Just Right"); // <---
        else System.out.println("Too High");
    }    
}
