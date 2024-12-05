package com.wellysonfreitas.selikoff_boyarsky.ch1buildingblocks.classes;

public class Constructors {

    public static void main(String[] args) {
        // variable stores a reference to an instance of the class
        Park p = new Park();
    }
}

class Park {}

@SuppressWarnings("MethodNameSameAsClassName")
class Chick {
    public Chick() {
        System.out.println("in constructor");
    }

    public void Chick() {} // NOT A CONSTRUCTOR
}

class Chicken {
    int numEggs = 12; // initialize on line
    String name;

    public Chicken() {
        name = "Ducke"; // initialize in constructor
    }
}
