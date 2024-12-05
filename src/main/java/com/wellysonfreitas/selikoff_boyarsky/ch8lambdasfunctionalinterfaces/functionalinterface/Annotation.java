package com.wellysonfreitas.selikoff_boyarsky.ch8lambdasfunctionalinterfaces.functionalinterface;

/*

@FunctionalInterface annotation tells the compiler that you intend for the code to be a functional interface.
If the interface does not follow the rules for a functional interface, the compiler give you an error.
Just because you don't see the annotation doesn't mean it's not a functional interface.
Remember that having exactly one abstract method is what makes it a functional interface, not the annotation.

*/

@FunctionalInterface
interface Dance {
    void move();
}

//@FunctionalInterface
//interface Dance { // DOES NOT COMPILE
//    void move();
//    void rest();
//}
