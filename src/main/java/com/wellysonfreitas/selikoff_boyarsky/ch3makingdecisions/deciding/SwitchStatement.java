package com.wellysonfreitas.selikoff_boyarsky.ch3makingdecisions.deciding;

import com.wellysonfreitas.selikoff_boyarsky.Utils;

/*

SWITCH STATEMENT

Data types supported by switch statements:

- integers (int, byte, short, char, and their wrappers)
- strings
- enum values
- var (if the type resolves to one of the preceding types)

Data types NOT supported by switch statements:

- boolean/Boolean
- long/Long
- float/Float and double/Double

Cases need to be compile-time constants:
- literals
- enum constants
- final constant variables of the same data type

*/

@SuppressWarnings({
        "StatementWithEmptyBody",
        "DataFlowIssue"
})
class SwitchStatement {
    public static void main(String[] args) {
        int day = Utils.randomInt(0, 6);
        
        if (day == 0)
            System.out.println("Sunday");
        else if (day == 1)
            System.out.println("Monday");
        else if (day == 2)
            System.out.println("Tuesday");
        else if (day == 3)
            System.out.println("Wednesday");
        // ...
        
        switch (day) {
            case 0:
                System.out.println("Sunday");
                break;
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("Wednesday");
                break;
            // ...
            
            // optional default
            // may appear anywhere within switch statement
            default:
                System.out.println("Invalid value");
                break;
        }
        
        // COMBINING CASE VALUES
        
        // Starting with Java 14, case values can now be combined:
        int animal = Utils.randomInt(1, 3);
        switch (animal) {
            case 1,2: System.out.println("Lion");
            case 3: System.out.println("Tiger");
        }
        
        // Before Java 14:
        switch (animal) {
            case 1: case 2: System.out.println("Lion");
            case 3: System.out.println("Tiger");
        }
        
        // SYNTAX ERRORS
        
        int month = Utils.randomInt(1, 12);
        
        // DOES NOT COMPILE (missing parenthesis)
//        switch month {
//            case 1: System.out.println("January");
//        }

        // DOES NOT COMPILE (missing braces)
//        switch (month)
//            case 1: System.out.println("January");

        // DOES NOT COMPILE (missing case keyword)
//        switch (month)
//            case 1: 2: System.out.println("January");

        // A switch statement is not required to contain any case statements
        switch (month) {}
        
        // BREAK STATEMENT
        
        // The break statements are optional,
        // but without them the code will execute every branch
        // following a matching case statement,
        // including any default statements it finds.
        
        // Without break statements in each branch,
        // the order of case and default statements is now extremely important.
        
        switch (month) { // prints: WinterSpringUnknownSummerFall
            case 1, 2, 3: System.out.println("Winter");
            case 4, 5, 6: System.out.println("Spring");
            default: System.out.println("Unknown");
            case 7, 8, 9: System.out.println("Summer");
            case 10, 11, 12: System.out.println("Fall");
        }
        
        // ACCEPTABLE CASE VALUES
        
        // Values in each case statement must be compile-time constant values
        // of the same data type as the switch value.
        // This means you can use only:
        // 1. literals
        // 2. enum constants, or
        // 3. final constant variables of the same data type.

        int numberOfAnimals = 3;

        int apples = 2; // not final
        final int cookies = getCookies(); // methods are not evaluated until runtime
        final int bananas = 1; // final and evaluated in compile time
        
        switch (numberOfAnimals) {
            case bananas:
            // DOES NOT COMPILE
            // case apples:
            // case getCookies():
            // case cookies:
            case 3 * 5:
        }
    }
    
    private static int getCookies() {
        return 4;
    }
}
