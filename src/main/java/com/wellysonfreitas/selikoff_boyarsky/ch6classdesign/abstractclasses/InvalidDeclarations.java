package com.wellysonfreitas.selikoff_boyarsky.ch6classdesign.abstractclasses;

abstract class Turtle {
    // public abstract long eat() // DOES NOT COMPILE (no semicolon)
    // public abstract void swim() {}; // DOES NOT COMPILE (provides body)
    // public abstract int getAge() { // DOES NOT COMPILE (provides body)
    //     return 10;
    // }
    // public abstract void sleep; // DOES NOT COMPILE (missing parenthesis)
    // public void goInShell(); // DOES NOT COMPILE (not abstract; missing body)
}

// abstract and final modifiers

// abstract final Tortoise { // DOES NOT COMPILE
//     public abstract final void walk(); // DOES NOT COMPILE
// }

// abstract and private modifiers

abstract class Whale {
    // private abstract void sing(); // DOES NOT COMPILE (private & abstract)
    
    private final void sing() {} // private and final is legal, but redundant
}

class HumpbackWhale extends Whale {
    private void sing() {
        System.out.println("Humpback whale is singing");
    }
}

// abstract and static modifiers

abstract class Hippopotamus {
    // abstract static void swim(); // DOES NOT COMPILE
}
