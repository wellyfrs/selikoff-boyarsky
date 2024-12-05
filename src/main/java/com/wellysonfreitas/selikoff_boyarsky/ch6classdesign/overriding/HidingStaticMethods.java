package com.wellysonfreitas.selikoff_boyarsky.ch6classdesign.overriding;

/*

The method defined in the child class must be marked as static if it is marked as static in a parent class.

*/

class Bear {
    public static void eat() {
        System.out.println("Bear is eating");
    }
}

class Panda extends Bear {
//    public void eat() {} // DOES NOT COMPILE (must be static as parent)
    
    public static void eat() { // This is not overriding, it's hiding
        System.out.println("Panda is chewing");
    }

    public static void main(String[] args) {
        eat(); // Panda is chewing
    }
}

// Another example

class Bear2 {
    public static void sneeze() {
        System.out.println("Bear is sneezing");
    }
    
    public void hibernate() {
        System.out.println("Bear is hibernating");
    }
    
    public static void laugh() {
        System.out.println("Bear is laughing");
    }
}

class SunBear extends Bear2 {
    // public void sneeze() { // DOES NOT COMPILE (must be static as parent)
    //     System.out.println("Sun Bear sneezes quietly");
    // }
    
    // public static void hibernate() { // DOES NOT COMPILE (parent method is not static)
    //     System.out.println("Sun Bear is going to sleep");
    // }
    
    // protected static void laugh() { // DOES NOT COMPILE (access is narrower)
    //     System.out.println("Sun Bear is laughing");
    // }
}
