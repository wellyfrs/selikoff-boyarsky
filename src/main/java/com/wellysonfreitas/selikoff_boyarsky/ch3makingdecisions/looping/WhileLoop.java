package com.wellysonfreitas.selikoff_boyarsky.ch3makingdecisions.looping;

import com.wellysonfreitas.selikoff_boyarsky.Utils;

@SuppressWarnings({"ConstantValue", "LoopConditionNotUpdatedInsideLoop"})
class WhileLoop {
    public static void main(String[] args) {
        int roomInBelly = 5, bitesOfCheese = Utils.randomInt(0, 100);

        // Single statement (optional braces):
        while (bitesOfCheese > 0)
            bitesOfCheese--;

        bitesOfCheese = Utils.randomInt(0, 100);

        // Block (required braces):
        while (bitesOfCheese > 0 && roomInBelly > 0) {
            bitesOfCheese--;
            roomInBelly--;
        }
        System.out.println(bitesOfCheese + " pieces of cheese left"); // 56 pieces of cheese left

        // Loop may not execute at all:
        int full = 5;
        while (full < 5) {
            System.out.println("Not full!");
            full++;
        }

        // INFINITE LOOPS

        int pen = 2;
        int pigs = 5;
        while (pen < 10) // always true
            pigs++;
        
        // [Other examples]
        int sing = 8, squawk = 2, notes = 0;
        while (sing > squawk) {
            sing--;
            squawk += 2;
            notes += sing + squawk;
        }
        System.out.println(notes); // 23
    }
}
