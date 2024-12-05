package com.wellysonfreitas.selikoff_boyarsky.ch7beyondclasses.interfaces;

abstract interface WalksOnTwoLegs {} // implicitly abstract and package access

// public or package access
public abstract interface Interfaces {} // top-level interface (file must have the same name)


interface CanBurrow {
    public abstract Float getSpeed(int age); // Abstract interface method; (public abstract) is implicit
    public static final int MININUM_DEPTH = 2; // Constact variable; (public static final) is implicit
}

class Biped {
    public static void main(String[] args) {
//        var e = new WalksOnTwoLegs(); // DOES NOT COMPILE
    }
}

// interfaces cannot be marked as final (like abstract classes)
//final interface WalksOnEightLegs {} // DOES NOT COMPILE

interface Climb {
    Number getSpeed(int age);
}

// IMPLEMENTING AN INTERFACE

class FieldMouse implements Climb, CanBurrow {
    public Float getSpeed(int age) { // (public is required)
        return 11f;
    }
}
