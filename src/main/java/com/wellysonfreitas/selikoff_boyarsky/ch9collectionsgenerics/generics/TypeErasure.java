package com.wellysonfreitas.selikoff_boyarsky.ch9collectionsgenerics.generics;

// After the code compiles, generics are just Object types:

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.emptyList;

class Crate2 {
    private Object contents;
    public Object lookInCrate() {
        return contents;
    }
    public void packCrate(Object contents) {
        this.contents = contents;
    }
}

// This means there is only one class file.
// The process of removing the generic syntax from your code is referred to as type erasure.
// Type erasure allows your code to be compatible with older versions of Java that do not contain generics.
// You type the following:
// Robot r = crate.lookInCrate();
// The compiler turns it into the following:
// Robot r = (Robot) crate.lookInCrate();

// OVERLOADING A GENERIC METHOD

class LongTailAnimal {
    protected void chew(List<Object> input) {}
//    protected void chew(List<Double> input) {} // DOES NOT COMPILE (because of type erasure)
}

@SuppressWarnings("RedundantMethodOverride")
class Anteater extends LongTailAnimal {
    //    protected void chew(List<Double> input) {} // DOES NOT COMPILE (because of type erasure)
    
    protected void chew(List<Object> input) {}
    protected void chew(ArrayList<Object> input) {} // overloaded method (List != ArrayList)
}

// RETURNING GENERIC TYPES
// The return values must be covariant.
// Meaning, the return type of the class or interface in the overriding method
// must be a subtype of the class defined in the parent class.
// The generic parameter type must match its parent's type exactly.

class Mammal {
    public List<CharSequence> play() { return emptyList(); }
    public CharSequence sleep() { return ""; }
}

class Monkey extends Mammal {
    public ArrayList<CharSequence> play() { return new ArrayList<>(); } // ArrayList is subtype of List
}

class Goat extends Mammal {
    //    public List<String> play() { return new ArrayList<>(); } // DOES NOT COMPILE
    public String sleep() { return ""; }
}
