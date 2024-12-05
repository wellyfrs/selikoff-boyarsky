package com.wellysonfreitas.selikoff_boyarsky.ch1buildingblocks.variables;

/*

INITIALIZING VARIABLES

A variable needs a value before it can be used.
Some types of variables get this value set automatically,
and others require the programmer to specify it.

*/

import java.util.Random;

/*

LOCAL VARIABLES

A local variable is a variable defined within a constructor, method, or initializer block.

*/

@SuppressWarnings("MismatchedReadAndWriteOfArray")
class LocalVariables {
    public static void main(String[] args) {
        // FINAL LOCAL VARIABLES
        // Equivalent to declaring constants in other languages.
        
        final int y = 10;
        int x = 20;
//        y = x + 10; // DOES NOT COMPILE (final value cannot be modified)
        
        // Another example with local variable reference
        final int[] favoriteNumbers = new int[10];
        favoriteNumbers[0] = 10; // can modify the content, or data, in the array
        favoriteNumbers[1] = 20;
//        favoriteNumbers = null; // DOES NOT COMPILE (can't change the value of the reference)
        
        // UNINITIALIZED LOCAL VARIABLES
        // Local variables do not have a default value and must be initialized before use.
        
        int y2 = 10;
        int x2;
//        int reply = x2 + y2; // DOES NOT COMPILE (local variable `x2` was not initialized)
        
        // Another example
        int y3 = 10;
        int x3; // x3 is declared here
        x3 = 3;
        int z; // z is declared here but never initialized or used
        int reply = x3 + y3;
        
        // Another example of more complex initialization
        findAnswer(new Random().nextBoolean());
    }
    
    public static void findAnswer(boolean check) {
        int answer;
        int otherAnswer;
        int onlyOneBranch;
        if (check) {
            onlyOneBranch = 1;
            answer = 1;
        } else {
            answer = 2;
        }
        System.out.println(answer);
//        System.out.println(onlyOneBranch); // DOES NOT COMPILE (onlyOneBranch is initialized only if check = true)
    }
}

/*

PASSING CONSTRUCTOR AND METHOD PARAMETERS

Variables passed to a constructor or method are called constructor parameters or method parameters, respectively.
These parameters are like local variable that have been pre-initialized.

*/

class PassingConstructorAndMethodParameters {
    public void findAnswer(boolean check) {}
    
    public void checkAnswer() {
        boolean value;
//        findAnswer(value); // DOES NOT COMPILE (variable value is not initialized)
    }
}

/*

DEFINING INSTANCE AND CLASS VARIABLES

Variables that are not local variables are defined either as instance variables or as class variables.

An instance variable, often called a field, is a valued defined withing a specific instance of an object.

A class variable is one that is defined on the class level and shared among all instances of the class.
It can even be publicly accessible to classes outside the class and doesn't require an instance to use.
A variable is a class variable if it has the static keyword in its declaration.

Instance and class variables do not require you to initialize them.
As soon as you declare these variables, they are given a default value:
null for an object, zero for the numeric types, and false for a boolean (for char it is `\u0000` (NUL)).

*/

class InstanceAndClassVariables {
    // INSTANCE VARIABLES
    Object defaultReference; // null
    int defaultNumeric; // 0
    boolean defaultBoolean; // false
    char defaultChar; // \0000 (NUL)

    // CLASS VARIABLES
    static Object DEFAULT_REFERENCE; // null
    static int DEFAULT_NUMERIC; // 0
    static boolean DEFAULT_BOOLEAN; // false
    static char DEFAULT_CHAR; // \0000 (NUL)
}

/*

INFERRING THE TYPE WITH var

The formal name of this feature is Local Variable Type Inference (LVTI).
You can only use this feature for local variables.

A var cannot be used:
- as a constructor parameter
- as an instance variable
- in a multiple variable assignment statement

The type of a var is known at compile time, and cannot change at runtime.

*/

class Zoo {
    public void whatTypeAmI() {
        var name = "Hello";
        var size = 7;
    }
}

class VarKeyword {
//    var tricky = "Hello"; // DOES NOT COMPILE (`var` works with local variables and not instance variables)
}

class TypeInferenceOfVar {
    public void reassignment() {
        var number = 7;
        number = 4;
//        number = "five"; // DOES NOT COMPILE (equivalent to int number = "five")
    }
    
    // Variable declaration and initialization occurs on the same line
    public void breakingDeclaration() {
        var silly // declaration
                = 1; // and initialization on the same line
    }

    // Example (DOES NOT COMPILE)
    // This would compile for question if it were not using `var`,
    // but since declaration and initialization are not on the same line, it does not count for `var`.
    public void doesThisCompile(boolean check) {
//         var question;
//         question = 1;
//         var answer;
//         if (check) {
//             answer = 2;
//         } else {
//             answer = 3;
//         }
//         System.out.println(answer);
    }
    
    // Another example (DOES NOT COMPILE)
    // All the types declared on a single line must be the same type and share the same declaration.
    public void twoTypes() {
//        int a, var b = 3; // DOES NOT COMPILE
//        var n = null; // DOES NOT COMPILE
    }

    // Another example (DOES NOT COMPILE)
    // `var` is only used for local variable type inference
//    public int addition(var a, var b) { return a + b; } // DOES NOT COMPILE
}

// `var` is not a reserved word and is allowed to be used as an identifier
// including for a package named `var`
@SuppressWarnings("MethodNameSameAsClassName")
class Var {

    public void var() {
        var var = "var";
    }

    public void Var() {
        Var var = new Var();
    }
}
