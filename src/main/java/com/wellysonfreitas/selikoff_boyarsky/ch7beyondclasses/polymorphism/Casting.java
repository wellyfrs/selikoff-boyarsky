package com.wellysonfreitas.selikoff_boyarsky.ch7beyondclasses.polymorphism;

@SuppressWarnings({"UnnecessaryLocalVariable", "CastCanBeRemovedNarrowingVariableType"})
public class Casting {

    public static void main(String[] args) {
        // OBJECT vs. REFERENCE

        // 1. The type of the object determines
        // which properties exist within the object in memory.
        // 2. The type of the reference to the object determines
        // which methods and variables are accessible to the Java program.

        Lemur lemur = new Lemur();
        Object lemurAsObject = lemur; // this doesn't change object in memory

        // CASTING OBJECTS

        // 1. Casting a reference from a subtype to a supertype doesn't require an explicit cast.
        // 2. Casting a reference from a supertype requires an explicit cast.
        // 3. At runtime, an invalid cast of a reference to an incompatible type results in a ClassCastException being thrown.
        // 4. The compiler disallows casts to unrelated types.
        
        Primate primate = lemur; // Implicit Cast to supertype
        Lemur lemur2 = (Lemur)primate; // Explicit Cast to subtype
//        Lemur lemur3 = primate; // DOES NOT COMPILE (missing cast)
    }
}

// DISALLOWED CASTS

class Bird {}

@SuppressWarnings("InstantiationOfUtilityClass")
class Fish {
    public static void main(String[] args) {
        Fish fish = new Fish();
//        Bird bird = (Bird)fish; // DOES NOT COMPILE
    }
}

// CASTING INTERFACES

interface Canine {}
interface Dog {}

class Wolf implements Canine {}

@SuppressWarnings("DataFlowIssue")
class BadCasts {

    public static void main(String[] args) {
        Wolf wolfy = new Wolf();
        Dog badWolf = (Dog)wolfy; // Compiles, but throws a ClassCastException
    }
}

// THE INSTANCEOF OPERATOR

// The instanceof operator can be used to check whether an object belongs to a particular class
// or interface and to prevent a ClassCastException at runtime.

class Rodent {}

@SuppressWarnings({"StatementWithEmptyBody", "ConstantValue"})
class Capybara extends Rodent {

    public static void main(String[] args) {
        Rodent rodent = new Rodent();
//        var capybara = (Capybara)rodent; // ClassCastException
        if (rodent instanceof Capybara c) {
            // Do stuff
        }
    }
}

// Can't use instanceof with unrelated types

class Bird2 {}

@SuppressWarnings("InstantiationOfUtilityClass")
class Fish2 {

    public static void main(String[] args) {
        Fish fish = new Fish();
//        if (fish instanceof Bird b) { // DOES NOT COMPILE
//            // Do stuff
//        }
    }
}

// Other examples

@SuppressWarnings("ConstantValue")
class InstanceOf {

    public static void main(String[] args) {
//        System.out.println(obj instanceof null); // DOES NOT COMPILE

        Object obj = null;
        System.out.println(obj instanceof Object); // always false
    }
}
