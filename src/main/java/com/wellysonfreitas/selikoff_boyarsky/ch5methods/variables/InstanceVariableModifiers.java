package com.wellysonfreitas.selikoff_boyarsky.ch5methods.variables;

/*

final: instance variable must be initialized with each instance of the class exactly once.
volatile: the value in this variable may be modified by other threads.
transient: used to indicate that an instance variable should not be serialized with the class.

*/

class PolarBear {
    final int age = 10;
    final int fishEaten;
    final String name;

    { fishEaten = 10; }

    public PolarBear() {
        name = "Robert";
    }
}
