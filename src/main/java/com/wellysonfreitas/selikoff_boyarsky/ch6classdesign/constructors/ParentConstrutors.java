package com.wellysonfreitas.selikoff_boyarsky.ch6classdesign.constructors;

/*

`super` is used to reference members of the parent class, while
`super()` calls a parent constructor.

The first statement of every constructor is a call to a parent constructor using `super()`
or another constructor in the class using `this()`.

*/

@SuppressWarnings({"FieldCanBeLocal", "FieldMayBeFinal"})
class Animal {
    private int age;
    private String name;
    
    public Animal(int age, String name) {
        super(); // Refers to constructor in java.lang.Object
        this.age = age;
        this.name = name;
    }
    
    public Animal(int age) {
        super(); // Refers to constructor in java.lang.Object
        this.age = age;
        this.name = null;
    }
}

class Zebra extends Animal {
    public Zebra(int age) {
        super(age); // Refers to constructor in Animal
    }
    
    public Zebra() {
        this(4); // Refers to constructor in Zebra with int argument
    }
}

// Rule: if a constructor calls super(), then it must be the first statement of the constructor.

class Zoo {
    public Zoo() {
        System.out.println("Zoo created");
        // super(); // DOES NOT COMPILE (not the first statement)
    }
}

class Zoo2 {
    public Zoo2() {
        super();
        System.out.println("Zoo created");
        // super(); // DOES NOT COMPILE (not the first statement)
    }
}

// Child may use any valid parent constructor

class Gorilla extends Animal {
    public Gorilla(int age) {
        super(age, "Gorilla"); // Calls the first Animal constructor
    }
    
    public Gorilla() {
        super(5); // Calls the second Animal constructor
    }
}

// Rule: Java compiler automatically inserts a call to the no-argument constructor super()
// if you do not explicitly call this() or super() on the first line of a constructor

// The following classes are equivalent

class Donkey1 {}

class Donkey2 {
    public Donkey2() {}
}

class Donkey3 {
    public Donkey3() {
        super();
    }
}

class Mammal {
    public Mammal(int age) {} // user-defined constructor
    // Compiler does not insert a default no-argument constructor here
}

// Compiler inserts a default no-argument constructor here,
// but it calls a nonexistent parent default contructor
// class Seal extends Mammal {} // DOES NOT COMPILE
// class Seal extends Mammal {
//     public Seal() {
//         super(); // DOES NOT COMPILE
//     }
// }

// Compiler doesn't see a call to super() or this() as the first line of the constructor
// so it inserts a call to a nonexistent no-argument super() automatically
// class Elephant extends Mammal {
//     public Elephant() {} // DOES NOT COMPILE
// }
// class Elephant extends Mammal {
//     public Elephant() {
//         super(); // DOES NOT COMPILE
//     }
// }

class Seal extends Mammal {
    public Seal() {
        super(6); // Explicit call to parent constructor
    }
}

class Elephant extends Mammal {
    public Elephant() {
        super(4); // Explicit call to parent constructor
    }
}

// Subclasses may include no-argument constructors even if their parent classes do not
class AfricanElephant extends Elephant {}
