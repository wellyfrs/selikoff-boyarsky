package com.wellysonfreitas.selikoff_boyarsky.ch6classdesign.overriding;

/*

OVERRIDING METHODS

In Java, overriding a method occurs when a subclass declares a new implementation
for an inherited method with the same signature and compatible return type.

Method signature is composed of the name of the method and method parameters.

Rules:

- same signature (method name and parameters)
- same access or wider
- same checked exception or narrower
- same return type or subtype (covariant)

*/

import java.io.FileNotFoundException;
import java.io.IOException;

class Marsupial {
    public double getAverageWeight() {
        return 50;
    }
}

class Kangaroo extends Marsupial {
    
    public double getAverageWeight() {
        return super.getAverageWeight() + 20;
    }

    public static void main(String[] args) {
        System.out.println(new Marsupial().getAverageWeight()); // 50.0
        System.out.println(new Kangaroo().getAverageWeight()); // 70.0
    }
    
    // public double getAverageWeight() {
    //     return getAverageWeight()+20; // StackOverflowError
    // }
}

// Rule 1: Method Signatures
// The method in the child class must have the same signature as the method in the parent class.

// Rule 2: Access Modifiers
// The method in the child class must be at least as accessible as the method in the parent class.

class Camel {
    public int getNumberOfHumps() {
        return 1;
    }
}

class BactrianCamel extends Camel {
    // private int getNumberOfHumps() { // DOES NOT COMPILE (access modifier more restrictive)
    //     return 2;
    // }
}

class Rider {
    // Let's say BactrianCamel was allowed to compile.
    public static void main(String[] args) {
        Camel c = new BactrianCamel();
        System.out.println(c.getNumberOfHumps()); // ???
    }
}

// Rule 3: Checked Exceptions
// The method in the child class may not declare a checked exception that is new or
// broader than the class of any exception declared in the parent class method.

class Reptile {
    protected void sleep() throws IOException {}
    
    protected void hide() {}
    
    protected void exitShell() throws FileNotFoundException {}
}

class GalapagosTortoise extends Reptile {
    public void sleep() throws FileNotFoundException {}
    
    // public void hide() throws FileNotFoundException {} // DOES NOT COMPILE (checked exception not present in parent)

    // public void exitShell() throws IOException {} // DOES NOT COMPILE (IOException is broader than FileNotFoundException)
}

// Rule 4: Covariant Return Types
// If the method returns a value, it must be the same or
// a subtype of the method in the parent class, known as covariant return types.

class Rhino {
    protected CharSequence getName() {
        return "rhino";
    }
    
    protected String getColor() {
        return "grey, black, or white";
    }
}

class JavanRhino extends Rhino {
    public String getName() { // String is covariant with CharSequence
        return "javan rhino";
    }
    
    // public CharSequence getColor() { // DOES NOT COMPILE (CharSequence is not a subtype of String)
    //     return "grey";
    // }
}
