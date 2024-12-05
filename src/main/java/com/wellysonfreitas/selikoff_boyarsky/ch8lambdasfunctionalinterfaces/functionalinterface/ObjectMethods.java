package com.wellysonfreitas.selikoff_boyarsky.ch8lambdasfunctionalinterfaces.functionalinterface;

/*

If a functional interface includes an abstract method
with the same signature as a public method found in Object,
those methods do not count toward the single abstract method test.

*/

interface Soar { // not a functional interface
    abstract String toString(); // it does not count toward the single abstract method test
}

interface Dive { // is functional interface
    String toString();
    public boolean equals(Object o);
    public abstract int hashCode();
    public void dive(); // single abstract method that doesn't inherit from Object
}

// Tricky code
interface Hibernate { // not a functional interface (two abstract methods)
    String toString();
    public boolean equals(Hibernate o); // just looks like the equals(Object o), but it's not the same
    public abstract int hashCode();
    public void rest();
}
