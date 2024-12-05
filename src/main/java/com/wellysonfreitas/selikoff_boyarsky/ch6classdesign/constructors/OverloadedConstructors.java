package com.wellysonfreitas.selikoff_boyarsky.ch6classdesign.constructors;

/*

`this` refers to an instance of the class, while
`this()` refers to a constructor call within the class.

*/

@SuppressWarnings({"FieldMayBeFinal", "FieldCanBeLocal"})
class Hamster {
    private String color;
    private int weight;
    
    public Hamster(int weight, String color) { // First constructor
        this.weight = weight;
        this.color = color;
    }
    
    public Hamster(int weight) { // Second constructor
        // this.weight = weight;
        // color = "brown";
        
        // new Hamster(weight, "brown"); // Compiles, but creates an extra object

        // Hamster(weight, "brown"); // DOES NOT COMPILE
        
        this(weight, "brown");
    }
}

// Rule: if a constructor calls this(), then it must be the first statement of the constructor.

class Hamster2 {
    public Hamster2(int weight, String color) {}
    
    public Hamster2(int weight) {
        System.out.println("chew");
        // Set weight and default color
        // this(weight, "brown"); // DOES NOT COMPILE (not the first statement)
    }
}

// Rule: Java does not allow cyclic constructor calls.

@SuppressWarnings("unused")
class Gopher {
    public Gopher(int dugHoles) {
        // this(5); // DOES NOT COMPILE
    }
}

// Cycle (constructors calling each other)
class Gopher2 {
    public Gopher2() {
        // this(5); // DOES NOT COMPILE with the other constructor
    }
    
    public Gopher2(int dugHoles) {
        // this(); // DOES NOT COMPILE with the other constructor
    }
}
