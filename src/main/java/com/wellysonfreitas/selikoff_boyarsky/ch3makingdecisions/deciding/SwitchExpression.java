package com.wellysonfreitas.selikoff_boyarsky.ch3makingdecisions.deciding;

import com.wellysonfreitas.selikoff_boyarsky.Utils;

/*

SWITCH EXPRESSION (>= Java 14)

A compact form of a switch statement, with some differences:
- can return a value (in that case, needs semicolon at the end)
- no need for break statements (it executes only one branch)
- can handle null

The switch expression supports two types of branches:
- expression
- block (can be used with `yield`)

Allowed types:
- integers (int, short, byte, char, and their wrappers) - not boolean, float, or double
- strings
- enum values
- var (provided the compiler determines that the type is compatible with the statements)

Rules:

1. All branches that don't throw an exception must return a consistent data type (if switch returns a value).
2. If the switch expression returns a value, then every branch that isn't an expression must YIELD a value.
3. A default branch is required unless all cases are covered or no value is returned.

*/

@SuppressWarnings({"SwitchStatementWithTooFewBranches", "DataFlowIssue"})
class SwitchExpression {
    public static void main(String[] args) {
        // Break statements are not needed, since only one branch is executed.
        int day = 2;
        var result = switch (day) {
            case 0 -> "Sunday";
            case 2 -> "Monday";
            case 3 -> "Tuesday";
            case 4 -> "Wednesday";
            // ...
            default -> "Invalid value";
        }; // <--------------------------- semicolon
        System.out.println(result); // "Monday"

        // Semicolon is required after each switch expression
        int bear = Utils.randomInt(0, 100);
        // DOES NOT COMPILE
//        result = switch (bear) {
//            case 30 -> "Grizzly" // <--- missing semicolon
//            default -> "Panda" // <----- missing semicolon
//        } // <-------------------------- missing semicolon

        result = switch (bear) {
            case 30 -> "Grizzly"; // <---- semicolon
            default -> "Panda"; // <------ semicolon
        }; // <--------------------------- semicolon

        // Switch expression with case statements with multiples values
        int month = 4;
        switch (month) {
            case 1, 2, 3 -> System.out.println("Winter");
            case 4, 5, 6 -> System.out.println("Spring");
            case 7, 8, 9 -> System.out.println("Summer");
            case 10, 11, 12 -> System.out.println("Fall");
        }

        // BRANCH RULES FOR SWITCH EXPRESSION

        // Rule 1 for switch expressions:
        // if the switch expression returns a value,
        // all branches that don't throw an exception must return a consistent data type.

        int measurement = 10;
        int size = switch (measurement) {
            case 5 -> 1;
            case 10 -> (short) 2; // short is implicitly cast to an int
            default -> 5;
            // DOES NOT COMPILE
//            case 20 -> "3";
//            case 40 -> 4L;
//            case 50 -> null;
        };

        // CASE BLOCK

        int fish = 5;
        int length = 12;
        var name = switch (fish) {
            case 1 -> "Goldfish";
            case 2 -> {yield "Trout";}
            case 3 -> {
                if (length > 10) yield "Blobfish";
                else yield "Green";
            }
            default -> "Swordfish";
        };

        // Rule 2 for switch expressions:
        // if the switch expression returns a value,
        // then every branch that isn't an expression must yield a value.

        name = switch (fish) {
            case 1 -> "Goldfish";
//            case 2 -> {} // DOES NOT COMPILE
            
            // DOES NOT COMPILE
//            case 3 -> {
//                if (length > 10) yield "Blobfish";
//            }
            
            default -> "Swordfish";
        };

        // Semicolons cannot be used with the case blocks
        // DOES NOT COMPILE
//        name = switch (fish) {
//            case 1 -> "Goldfish" // <---------- missing semicolon
//            case 2 -> {yield "Trout";}; // <--- extra semicolon
//        } // <-------------------------------- missing semicolon

        // Rule 3 for switch expressions:
        // if the switch expression returns a value,
        // a default branch is required
        // unless all cases are covered or no value is returned.
        
        int canis = Utils.randomInt(0, 10);
        // DOES NOT COMPILE (no case branch to cover all cases)
//        String type = switch (canis) {
//            case 1 -> "dog";
//            case 2 -> "wolf";
//            case 3 -> "coyote";
//        };
        
        // Solutions: default branch,
        // or, in case of enum, a case branch for every possible enum value
        
        enum Season { WINTER, SPRING, SUMMER, FALL }
        var season = Season.FALL;
        
        // Since all possible permutations of Season are covered,
        // a default branch is not required in this switch expression (it's optional):
        String weather = switch (season) {
            case WINTER -> "Cold";
            case SPRING -> "Rainy";
            case SUMMER -> "Hot";
            case FALL -> "Warm";
        };
        
        // [Other examples]
        String text = null;
        String result2 = switch (text) {
            case "test" -> "test";
//            case null -> "null"; // DOES NOT COMPILE 
            default -> "default";
        };
        
        class Zoo {
            enum Animal {BIRD, FISH, MAMMAL}
            void printLocation(Animal a) {
                long type = switch (a) {
                    case BIRD -> 1;
                    case FISH -> 2;
                    case MAMMAL -> 3;
                    default -> 4; // unnecessary, but does compile
                };
            }
        }
    }
}
