package com.wellysonfreitas.selikoff_boyarsky.ch7beyondclasses.records;

// LONG CONSTRUCTOR

@SuppressWarnings("RedundantRecordConstructor")
record Crane5(int numberOfEggs, String name) {
    public Crane5(int numberOfEggs, String name) {
        if (numberOfEggs < 0) throw new IllegalArgumentException();
        this.numberOfEggs = numberOfEggs;
        this.name = name;
    }
}

//record Crane6(int numberOfEggs, String name) {
//    public Crane6(int numberOfEggs, String name) {} // DOES NOT COMPILE (final fields need to be initialized)
//}

// COMPACT/SHORT CONSTRUCTOR

record Crane6(int numberOfEggs, String name) {
    public Crane6 { // no parenthesis or constructor parameters
        if (numberOfEggs < 0) throw new IllegalArgumentException();
        name = name.toUpperCase(); // name refers to input parameters (not instance members)
        // long constructor is implicitly called at the end of compact constructor
    }
}

// TRANSFORMING PARAMETERS

@SuppressWarnings("SizeReplaceableByIsEmpty")
record Crane7(int numberOfEggs, String name) {
    public Crane7 {
        if (name == null || name.length() < 1)
            throw new IllegalArgumentException();
        name = name.substring(0, 1).toUpperCase() 
                + name.substring(1).toLowerCase(); // modifiers name parameter
        // then, call the long constructor with modified parameter
    }
}

// Compact constructors can modify the constructor parameters,
// but they cannot modify the fields of the record.
record Crane8(int numberOfEggs, String name) {
    public Crane8 {
//        this.numberOfEggs = 10; // DOES NOT COMPILE
    }
}

// OVERLOADED CONSTRUCTORS

record Crane9(int numberOfEggs, String name) {
    public Crane9(String firstName, String lastName) {
        this(0, firstName + " " + lastName);
    }
}

// The first line of an overloaded constructor must be an explicit call to another constructor via `this()`.
record Crane10(int numberOfEggs, String name) {
    public Crane10(int numberOfEggs, String firstName, String lastName) {
        this(numberOfEggs + 1, firstName + " " + lastName);
        numberOfEggs = 10; // NO EFFECT (applies to parameter, not instance field)
//        this.numberOfEggs = 20; // DOES NOT COMPILE
    }
}

// Can't have cycles
record Crane11(int numberOfEggs, String name) {
//    public Crane11(String name) {
//        this(1); // DOES NOT COMPILE
//    }
//    
//    public Crane11(int numberOfEggs) {
//        this(""); // DOES NOT COMPILE
//    }
}

// [Other examples]
// Access modifier of constructor is more restrictive
record Crane12(int numberOfEggs, String name) {
    // DOES NOT COMPILE 
//    private Crane12 {
//        numberOfEggs = numberOfEggs;
//        name = name;
//    }

    // DOES NOT COMPILE
//    private Crane12(int numberOfEggs, String name) {
//        this.numberOfEggs = numberOfEggs;
//        this.name = name;
//    }
}
