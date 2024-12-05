package com.wellysonfreitas.selikoff_boyarsky.ch7beyondclasses.polymorphism;

/*

In Java, polymorphism states that when you override a method,
you replace all calls to it, even those defined in the parent class.

Polymorphism's ability to replace methods at runtime via overriding
is one of the most important properties of Java.

*/

class Penguin {
    public int getHeight() { return 3; } // not called
    public void printInfo() {
        System.out.println(this.getHeight());
    }
}

class EmperorPenguin extends Penguin {
    public int getHeight() { return 8; }

    public static void main(String[] fish) {
        new EmperorPenguin().printInfo(); // 8
        
        Penguin penguin = new EmperorPenguin();
        penguin.printInfo(); // 8
    }
}

// CALLING THE PARENT VERSION OF AN OVERRIDDEN METHOD

class Penguin2 {
    public int getHeight() { return 3; }
    public void printInfo() {
//        System.out.println(super.getHeight()); // DOES NOT COMPILE
    }
}

class EmperorPenguin2 extends Penguin2 {
    public int getHeight() { return 8; }
    public void printInfo() {
        System.out.println(super.getHeight());
    }

    public static void main(String[] fish) {
        new EmperorPenguin().printInfo(); // 3
    }
}

/*
 
OVERRIDING VS. HIDING MEMBERS

While method overriding replaces the method EVERYWHERE it is called,
static method and variable hiding do not.

Hiding members is not a form of polymorphism since the methods and variables
maintain their individual properties.

*/

@SuppressWarnings("AccessStaticViaInstance")
class Penguin3 {
    public static int getHeight() { return 3; } // hidden, not overridden
    public void printInfo() {
        System.out.println(this.getHeight());
    }
}

class CrestedPenguin extends Penguin3 {
//    public int getHeight() { return 8; } // DOES NOT COMPILE
    public static int getHeight() { return 8; }

    public static void main(String... fish) {
        new CrestedPenguin().printInfo(); // 3
    }
}

// Another example

class Marsupial {
    protected int age = 2;
    public static boolean isBiped() {
        return false;
    }
}

@SuppressWarnings({"UnnecessaryLocalVariable", "AccessStaticViaInstance"})
class Kangaroo extends Marsupial {
    protected int age = 6;
    public static boolean isBiped() {
        return true;
    }

    public static void main(String[] args) {
        Kangaroo joey = new Kangaroo(); // only Kangaroo object is created and stored in memory
        Marsupial moey = joey;
        System.out.println(joey.isBiped());
        System.out.println(moey.isBiped());
        System.out.println(joey.age);
        System.out.println(moey.age);
        // prints:
        // true
        // false
        // 6
        // 2
    }
}
