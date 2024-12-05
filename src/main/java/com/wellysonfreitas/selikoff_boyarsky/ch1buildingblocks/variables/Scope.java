package com.wellysonfreitas.selikoff_boyarsky.ch1buildingblocks.variables;

/*

MANAGING VARIABLE SCOPE

Rules on scope:

- Local variables: in scope from declaration to the end of the block.
- Method parameters: in scope for the duration of the method.
- Instance variables: in scope from declaration until the object is eligible for garbage collection.
- Class variables: in scope from declaration until the program ends.

*/

class ManagingVariableScope {
    
    // Example of two variables with local scope (method parameter and local variable)
    public void eat(int piecesOfCheese) {
        int bitesOfCheese = 1;
    }
    
    // LIMITING SCOPE
    // Local variables can never have a scope larger than the method they are defined in.
    // However, they can have a smaller scope.
    public void eatIfHungry(boolean hungry) {
        if (hungry) { // {} means a new block of code, and blocks of code have its own scope
            int bitesOfCheese = 1;
        } // bitesOfCheese goes out of score here
        
//        System.out.println(bitesOfCheese); // DOES NOT COMPILE
    }
    
    // Blocks can contain other blocks.
    // These smaller blocks can reference variables
    // defined in the larger scoped blocks, but not vice-versa.
    public void eatIfHungry2(boolean hungry) {
        if (hungry) {
            int bitesOfCheese = 1;
            {
                var teenyBit = true;
                System.out.println(bitesOfCheese);
            }
        }
        
//        System.out.println(teenyBit); // DOES NOT COMPILE
    }
    
    // TRACING SCOPE

    public void eatMore(boolean hungry, int amountOfFood) { // scope: method
        int roomInBelly = 5; // scope: rest of the method
        if (hungry) {
            var timeToEat = true; // scope: if
            while (amountOfFood > 0) {
                int amountEaten = 2; // scope: while
                roomInBelly = roomInBelly - amountEaten;
                amountOfFood = amountOfFood - amountEaten;
            }
        }
        System.out.println(amountOfFood);
    }
    
    // APPLYING SCOPE TO CLASSES
    // The rule for instance variables is easier: they are available as soon as they are defined
    // and last for the entire lifecycle of the object itself.
    
    // The rule for class, aka static, variables is even easier: they go into scope when declared
    // like the other variable types. However, they stay in scope for the entire life of the program.
    
    @SuppressWarnings("UnnecessaryLocalVariable")
    static class Mouse {
        final static int MAX_LENGTH = 5; // class variable, stays in scope until the program ends
        int length; // instance variable, stays in scope as long as this Mouse object exists
        
        public void grow(int inches) { // inches goes into scope here, and does out at the end of this method
            if (length < MAX_LENGTH) {
                int newSize = length + inches; // newSize goes out of scope when the if block ends
                length = newSize;
            }
        }
    }
}
