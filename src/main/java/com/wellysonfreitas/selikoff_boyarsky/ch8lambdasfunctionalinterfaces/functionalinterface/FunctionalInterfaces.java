package com.wellysonfreitas.selikoff_boyarsky.ch8lambdasfunctionalinterfaces.functionalinterface;

/*

FUNCTIONAL INTERFACE

A functional interface is an interface that contains a single abstract method.
It's officially known as a single abstract method (SAM) rule.

*/

@FunctionalInterface
interface Sprint {
    void sprint(int speed);
}

class Tiger implements Sprint {
    public void sprint(int speed) {
        System.out.println("Animal is sprinting fast! " + speed);
    }
}

// Another example

interface Dash extends Sprint {} // is functional interface (single inherited method)

interface Skip extends Sprint { // not a functional interface (2 methods)
    void skip();
}

interface Sleep { // not a functional interface
    private void snore() {}
    default int getZzz() { return 1; }
}

interface Climb { // is functional interface
    void reach();
    default void fall() {}
    static int getBackUp() { return 100; }
    private static boolean checkHeight() { return true; }
}
