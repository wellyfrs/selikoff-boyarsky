package com.wellysonfreitas.selikoff_boyarsky.ch8lambdasfunctionalinterfaces.lambda;

/*

A lambda can access an instance variable, method parameter, or local variable under certain conditions.
Instance variables (and class variables) are always allowed.

*/

import java.util.function.Consumer;

class Crow {
    private String color;
    private void caw(String name) {
        String volume = "loudly";
        Consumer<String> consumer = s ->
                System.out.println(name + " says "
                + volume + " that she is " + color);
    }
}

// The only thing lambdas cannot access are variables that are not final or effectively final.

@SuppressWarnings("FieldCanBeLocal")
class Crow2 {
    private String color;
    public void caw(String name) {
        String volume = "loudly";
        name = "Caty";
        color = "black";
//        Consumer<String> consumer = s ->
//                System.out.println(name + " says " // DOES NOT COMPILE (name is not final)
//                + volume + " that she is " + color); // DOES NOT COMPILE (volume is not effectively final)
        volume = "softly";
    }
}
