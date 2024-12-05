package com.wellysonfreitas.selikoff_boyarsky.ch6classdesign.initialization;

/*

CLASS INITIALIZATION

1. If there is a superclass Y of X, then initialize class Y first.
2. Process all static variable declarations in the order in which they appear in the class.
3. Process all static initializers in the order in which they appear in the class.

*/

class Animal {
    static { System.out.println("A"); }
}

class Hippo extends Animal {
    
    // The class containing the program entry point, aka the main() method,
    // is loaded before the main() method is executed.
    
    public static void main(String[] grass) {
        System.out.print("C");
        new Hippo();
        new Hippo();
        new Hippo();
    }
    
    static { System.out.print("B"); }
}

// prints ABC exactly once
// even though the main() method creates 3 instances, the class is loaded only once

class HippoFriend {
    public static void main(String[] args) {
        System.out.println("C");
        new Hippo();
    }
}

// in this case, prints "CAB"
