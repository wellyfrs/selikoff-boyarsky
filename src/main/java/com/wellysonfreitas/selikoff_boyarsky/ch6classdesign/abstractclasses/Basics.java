package com.wellysonfreitas.selikoff_boyarsky.ch6classdesign.abstractclasses;

/*

ABSTRACT CLASS

An abstract class is a class declared with the abstract modifier
that cannot be instantiated directly and may contain abstract methods.

An abstract method is a method declare with the abstract modifier that does not define a body.
Put another way, an abstract method forces subclasses to override the method.
 
Rules:
- Only instance methods can be marked abstract within a class, not variables, not constructors, NOT STATIC METHODS.
- An abstract method can only be declared in an abstract class.
- A non-abstract class that extends an abstract class must implement all inherited abstract methods.
- Overriding an abstract method follows the existing rules for overriding methods.

*/

abstract class Canine {
    public abstract String getSound();
    public void bark() { System.out.println(getSound()); }

    public static void main(String[] args) {
        Canine w = new Fox();
        w.bark(); // Squeak!
    }
}

class Wolf extends Canine {
    public String getSound() {
        return "Wooooooof!";
    }
}

class Fox extends Canine {
    public String getSound() {
        return "Squeak!";
    }
}

class Coyote extends Canine {
    public String getSound() {
        return "Roar!";
    }
}

// class FennecFox extends Canine {
//     public int getSound() { // DOES NOT COMPILE
//         return 10;
//     }
// }

// class ArcticFox extends Canine {}

class Direwolf extends Canine {
    // public abstract rest(); // DOES NOT COMPILE
    public String getSound() {
        return "Roof!";
    }
}

class Jackal extends Canine {
    // public abstract String name; // DOES NOT COMPILE
    public String getSound() {
        return "Laugh";
    }
}

abstract class Alligator {

    public static void main(String... food) {
        // var a = new Alligator(); // DOES NOT COMPILE
    }
}
