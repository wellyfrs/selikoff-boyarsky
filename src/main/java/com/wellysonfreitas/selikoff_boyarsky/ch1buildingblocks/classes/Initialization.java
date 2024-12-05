package com.wellysonfreitas.selikoff_boyarsky.ch1buildingblocks.classes;

// INSTANCE INITIALIZER

@SuppressWarnings({"ClassInitializerMayBeStatic", "InnerClassMayBeStatic", "InstantiationOfUtilityClass"})
class Bird {

    public static void main(String[] args) {
        { System.out.println("Feathers"); }

        Bird bird = new Bird();
    }

    { System.out.println("Snowy"); } // instance initializer
}

/*

INITIALIZATION ORDER

1. Fields and instance initializer blocks are run in the order in which they appear in the file.
2. The constructor runs AFTER all fields and instance initializer blocks have run.

*/

@SuppressWarnings("ClassInitializerMayBeStatic")
class Chick2 {
//    { System.out.println(name); } // DOES NOT COMPILE (can't refer to undefined variable)

    private String name = "Fluffy";
    { System.out.println("setting field"); }

    public Chick2() {
        name = "Tiny";
        System.out.println("setting constructor");
    }

    public static void main(String[] args) {
        Chick2 chick = new Chick2(); // prints: setting field \ setting constructor
        System.out.println(chick.name); // Tiny
    }
}

// Another example
class Egg {
    public Egg() {
        number = 5;
    } // 3rd

    public static void main(String[] args) {
        Egg egg = new Egg();
        System.out.println(egg.number); // prints 5
    }

    private int number = 3; // 1st
    { number = 4; } // 2nd
}

// [Another example]
class Salmon {
    int count;
    { System.out.print(count+"-"); } // 2nd (count = 0)
    { count++; }
    public Salmon() {
        count = 4;
        System.out.print(2+"-"); // 3rd
    }

    public static void main(String[] args) {
        System.out.print(7+"-"); // 1st
        var s = new Salmon();
        System.out.print(s.count+"-"); // 4th (count = 4)
    }
    // prints: 7-0-2-4-
}
