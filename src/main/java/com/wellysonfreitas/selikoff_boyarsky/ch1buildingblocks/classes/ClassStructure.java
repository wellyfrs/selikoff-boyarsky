package com.wellysonfreitas.selikoff_boyarsky.ch1buildingblocks.classes;

/**
 * Each file can contain only one public class.
 * The filename must match the class name, including case, and have a .java extension.
 * If the Java class is an entry point for the program, it must contain a valid main() method.
 */
public class ClassStructure {} // Top-level class
//public class ClassStructure2 {} // DOES NOT COMPILE

class Animal {
    // Field
    String name;

    // Method
    public String getName() {
        return name;
    }

    /**
     * Method signature is method name and parameter types.
     * In this case, the method signature is setName(String)
     */
    public void setName(String newName) {
        name = newName;
    }
}

class Animal2 {}

// OBJECT FIELDS

class Swan {
    int numberEggs; // instance variable

    public static void main(String[] args) {
        Swan mother = new Swan();
        mother.numberEggs = 1; // set variable
        System.out.println(mother.numberEggs); // read variable
    }
}

@SuppressWarnings("InnerClassMayBeStatic")
class Name {
    String first = "Theodore";
    String last = "Moose";
    String full = first + last;
}
