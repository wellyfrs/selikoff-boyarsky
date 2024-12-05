package com.wellysonfreitas.selikoff_boyarsky.ch2operators.ternary;

@SuppressWarnings({"ConstantValue", "DataFlowIssue"})
class TernaryOperator {
    public static void main(String[] args) {
        int owl = 5;
        int food;
        
        // With if/else statements
        if (owl < 2) {
            food = 3;
        } else {
            food = 4;
        }
        System.out.println(food); // 4
        
        // With ternary operator
        food = owl < 2 ? 3 : 4;
        System.out.println(food); // 4
        
        // Parentheses for readability
        int food1 = owl < 4 ? owl > 2 ? 3 : 4 : 5;
        int food2 = (owl < 4 ? ((owl > 2) ? 3 : 4) : 5);
        
        // Trick code (mixing data types):
        int stripes = 7;
        // System.out.println can convert both int and String to Object values and call toString() on them:
        System.out.println((stripes > 5) ? 21 : "Zebra");
//        int animal = (stripes < 9) ? 3 : "Horse"; // DOES NOT COMPILE
        
        // Unperformed side effects
        int sheep = 1;
        int zzz = 1;
        int sleep = zzz < 10 ? sheep++ : zzz++; // zzz++ is never reached
        System.out.println(sheep + "," + zzz); // 2,1
        
        sleep = sheep >= 10 ? sheep++ : zzz++; // sheep++ is never reached
        System.out.println(sheep + "," + zzz); // 1,2
    }
}
