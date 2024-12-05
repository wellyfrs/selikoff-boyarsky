package com.wellysonfreitas.selikoff_boyarsky.ch6classdesign.initialization;

/*

INSTANCE INITIALIZATION

1. Initialize class X if it has not been previously initialized.
2. If there is a superclass Y of X, then initialize the instance of Y first.
3. Process all instance variable declarations in the order in which they appear in the class.
4. Process all instance initializers in the order in which they appear in the class.
5. Initialize the constructor, including any overloaded constructors referenced with this().

*/

@SuppressWarnings({"FieldCanBeLocal", "FieldMayBeFinal"})
class ZooTickets {
    private String name = "BestZoo"; // 4
    { System.out.print(name + "-"); } // 5
    private static int COUNT = 0; // 1
    static { System.out.print(COUNT + "-"); } // 2
    static { COUNT += 10; System.out.print(COUNT + "-"); } // 3
    
    public ZooTickets() {
        System.out.print("z-"); // 6
    }

    public static void main(String... patrons) {
        new ZooTickets();
    } }

// prints: 0-10-BestZoo-z-

// Another example with inheritance

class Primate {
    public Primate() {
        System.out.print("Primate-");
    }
}

class Ape extends Primate {
    public Ape(int fur) {
        System.out.print("Ape1-");
    }
    
    public Ape() {
        System.out.print("Ape2-");
    }
}

class Chimpanzee extends Ape {
    public Chimpanzee() {
        super(2);
        System.out.print("Chimpanzee-");
    }

    public static void main(String[] args) {
        new Chimpanzee();
    }
}

// prints: Primate-Ape1-Chimpanzee-

// Another example

@SuppressWarnings({"FieldCanBeLocal", "FieldMayBeFinal", "ClassInitializerMayBeStatic"})
class Cuttlefish {
    private String name = "swimmy"; // 3
    { System.out.println(name); } // 4
    private static int COUNT = 0; // 1
    static { System.out.println(COUNT); } // 2
    { COUNT++; System.out.println(COUNT); } // 5
    
    public Cuttlefish() {
        System.out.println("Constructor"); // 7
    }

    public static void main(String[] args) {
        System.out.println("Ready"); // 6
        new Cuttlefish();
    }
}

// prints:
// 0
// Ready
// swimmy
// 1
// Constructor

// Another example:

@SuppressWarnings("ClassInitializerMayBeStatic")
class GiraffeFamily {
    static { System.out.print("A"); }
    { System.out.print("B"); }
    
    public GiraffeFamily(String name) {
        this(1);
        System.out.print("C");
    }
    
    public GiraffeFamily() {
        System.out.print("D");
    }
    
    public GiraffeFamily(int stripes) {
        System.out.print("E");
    }
}

@SuppressWarnings("ClassInitializerMayBeStatic")
class Okapi extends GiraffeFamily {
    static { System.out.print("F"); }
    
    public Okapi(int stripes) {
        super("sugar");
        System.out.print("G");
    }

    { System.out.print("H"); }

    public static void main(String[] grass) {
        new Okapi(1);
        System.out.println();
        new Okapi(2);
    }
}

// prints:
// AFBECHG
// BECHG
