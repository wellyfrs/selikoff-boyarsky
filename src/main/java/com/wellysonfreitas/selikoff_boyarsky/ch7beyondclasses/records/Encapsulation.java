package com.wellysonfreitas.selikoff_boyarsky.ch7beyondclasses.records;

/*

ENCAPSULATION

Encapsulation is a way to protect class members by restricting access to them.
In Java, it is commonly implemented by declaring all instance variables private.
Callers are required to use methods to retrieve or modify instance variables.

A POJO, which stands for Plain Old Java Object, is a class used to model and pass data around,
often with few or no complex methods (hence the "plain" part of the definition).

JavaBean is a POJO that has some additional rules applied.

*/

class Crane {
    int numberEggs;
    String name;
    
    public Crane(int numberEggs, String name) {
        this.numberEggs = numberEggs;
        this.name = name;
    }
}

@SuppressWarnings("WriteOnlyObject")
class Poacher {
    public void badActor() {
        var mother = new Crane(5, "Cathy");
        mother.numberEggs = -100; // can be modified to invalid value
    }
}

// Example of encapsulated (and immutable) class:

final class Crane2 {
    private final int numberOfEggs;
    private final String name;
    
    public Crane2(int numberOfEggs, String name) {
        if (numberOfEggs >= 0) this.numberOfEggs = numberOfEggs; // guard condition
        else throw new IllegalArgumentException();
        this.name = name;
    }
    
    // Accessor methods, or getters
    
    public int getNumberOfEggs() { // getter
        return numberOfEggs;
    }
    
    public String getName() { // getter
        return name;
    }
    
    // No mutator methods, or setters, because of immutability.
    // You must omit the setters for a class to be immutable.
}

// Example of another well encapsulated class, although not that useful
@SuppressWarnings("FieldMayBeFinal")
class Vet {
    private String name = "Dr Rogers";
    private int yearsExperience = 25;
}
