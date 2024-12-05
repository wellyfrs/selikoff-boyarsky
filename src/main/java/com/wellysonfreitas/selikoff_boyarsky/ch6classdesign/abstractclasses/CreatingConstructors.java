package com.wellysonfreitas.selikoff_boyarsky.ch6classdesign.abstractclasses;

/*

Abstract classes are initialized with constructors in the same way as non-abstract classes.

If an abstract class does not provide a constructor,
the compiler will automatically insert a default no-arg constructor.

*/

abstract class Mammal2 {
    abstract CharSequence chew();
    
    public Mammal2() {
        System.out.println(chew());
    }
}

class Platypus extends Mammal2 {
    String chew() { return "yummy!"; }

    public static void main(String[] args) {
        new Platypus();
    }
}

// prints: yummy!
