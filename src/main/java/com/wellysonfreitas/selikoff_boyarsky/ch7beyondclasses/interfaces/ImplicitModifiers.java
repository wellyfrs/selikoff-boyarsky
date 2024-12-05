package com.wellysonfreitas.selikoff_boyarsky.ch7beyondclasses.interfaces;

/*

IMPLICIT MODIFIERS FOR INTERFACES

- Interfaces are implicitly abstract.
- Interface variables are implicitly public, static, and final.
- Interface methods WITHOUT A BODY are implicitly abstract (cannot have static abstract methods).
- Interface methods without the private modifier are implicitly public.

*/

interface Soar {
    int MAX_HEIGHT = 10;
    final static boolean UNDERWATER = true;
    void fly(int speed);
    abstract void takeoff();
    abstract double dive();
}

// is equivalent to

abstract interface Soar2 {
    public static final int MAX_HEIGHT = 10;
    public final static boolean UNDERWATER = true;
    public abstract void fly(int speed);
    public abstract void takeoff();
    public abstract double dive();
}

// CONFLICTING MODIFIERS

interface Dance {
//    private int count = 4; // DOES NOT COMPILE
//    protected void step(); // DOES NOT COMPILE
}

// DIFFERENCES BETWEEN INTERFACES AND ABSTRACT CLASSES

abstract class Husky { // abstract required in class declaration
    abstract void play(); // abstract required in method declaration
}

interface Poodle { // abstract optional in interface declaration
    void play(); // abstract optional in method declaration (this method is also implicitly public)
}

class Webby extends Husky {
    void play() {} // OK - play() is declared with package access in Husky
}

//class Georgette implements Poodle {
//    void play() {} // DOES NOT COMPILE - play() is public in Poodle
//}
